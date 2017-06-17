package com.yoxnet.common.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.CollectionUtils;

import com.yoxnet.common.utils.PropertyGetter;

/**
 */
public class EmailUtil {
	
	private static Logger logger = Logger.getLogger(EmailUtil.class);
	
    private static final String SENDER1 = PropertyGetter.getString("mail.sender1");
    private static final String SENDER2 = PropertyGetter.getString("mail.sender2");
    private static final String SENDER3 = PropertyGetter.getString("mail.sender3");
	private static final String EMAILHOST = PropertyGetter.getString("mail.host");
    private static final String SENDPWD = PropertyGetter.getString("mail.sendpwd");
    private static final String VALIDATESUBJECT = PropertyGetter.getString("mail.subject");
    private static final String AUTH = PropertyGetter.getString("mail.smtp.auth");
    private static final String TIMEOUT = PropertyGetter.getString("mail.smtp.timeout");
    
    private static List<String> emailSeq = null;

    private static void initEmailSeq(){
    	
    	if(emailSeq == null){
    		emailSeq = new ArrayList<String>();
    	}
    	
    	if(CollectionUtils.isEmpty(emailSeq)){
        	emailSeq.add(SENDER1);
        	emailSeq.add(SENDER2);
        	emailSeq.add(SENDER3);
    	}
    }
    
    private static String getMailSenderByRandom(){
    	
    	initEmailSeq();
    	
    	if(CollectionUtils.isEmpty(emailSeq)){
    		return SENDER1;
    	}
    	
    	Random random = new Random();
    	
    	String selectedSender = SENDER1;
    	
    	while(true){
    		 
        	int index = random.nextInt(emailSeq.size());	
    		
        	try {
        		selectedSender = emailSeq.get(index);
        		
        		if(selectedSender != null){
        			logger.debug("/**********************************/");
        			logger.debug("发送邮件服务器为：" + selectedSender);
        			logger.debug("/**********************************/");
        			break;
        		}
        		
			} catch (Exception e) {
				logger.debug("/**********************************/");
				logger.debug("获取邮件发送服务器异常!");
				logger.debug("/**********************************/");
				System.out.println(e.getStackTrace());
			}
    	}
    	
    	return selectedSender;
    }
    
    /**
     * 随机调用邮件服务器发送系统邮件
     * @param receiver 收件人邮箱地址
     * @param content  邮件内容
     * @param title    邮件标题
     * @return
     */
    public static int sendMail(String receiver, String content, String title) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(EMAILHOST);

        MimeMessage mailMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = null;
        try {
        	//获取随机邮箱服务器地址
        	String senderAddr = getMailSenderByRandom();
        	
            messageHelper = new MimeMessageHelper(mailMessage, true, "UTF-8");
            messageHelper.setFrom(senderAddr);

            messageHelper.setTo(receiver);  //收件人
            messageHelper.setSubject(VALIDATESUBJECT + title);
            messageHelper.setText(getHtmlContent(content), true);
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", AUTH); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
            prop.put("mail.smtp.timeout", TIMEOUT);
            // 添加验证
            MailAuthenticator auth = new MailAuthenticator(senderAddr, SENDPWD);

            Session session = Session.getInstance(prop, auth);
            mailSender.setSession(session);

            mailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.debug("/**********************************/");
            logger.debug("邮件发送异常：【to:】" + receiver + "【title：】" + title + "【content：】" + content);
            logger.debug("/**********************************/");
			System.out.println(e.getStackTrace());
            return -1;
        }catch (Exception e) {
        	logger.debug("/**********************************/");
        	logger.debug("获取邮件发送服务器异常!");
        	logger.debug("/**********************************/");
			System.out.println(e.getStackTrace());
		}
        return 1;
    }

    /**
     * 随机调用邮件服务器批量发送系统邮件
     * @param receiver 收件人邮箱地址支持多邮箱，邮箱以“,”号分割
     * @param content  邮件内容
     * @param title    邮件标题
     * @return
     */
    public static int sendMails(String receivers, String content, String title) {
    	
    	if(receivers != null){
    		String[] toMails = receivers.split(",");
    		
    		for (String toMail : toMails) {
    			sendMail(toMail,content,title);
			}
    		
    	}else{
    		logger.debug("/**********************************/");
        	logger.debug("请输入接收人邮件地址!");
        	logger.debug("/**********************************/");
        	return -1;
    	}
    	
    	return 1;
    }
    
    public static String getHtmlContent(String content) {
    	
    	String html = "<div>&nbsp;尊敬的用户：</div>" +
    	              "<div><br/><div>" +
    			      "<div>&nbsp;&nbsp;&nbsp;&nbsp;"+content+"</div>"+
    			      "<div><br/><div>"+
    			      "<div>&nbsp;<a href='http://www.zhiguoguo.com'>知果果竭诚为您服务！</a></div>";
    	
		return html;
    	
    }
}
