package com.yoxnet.common.jpush;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.api.util.PropsUtil;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.PushPayload.Builder;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import cn.jpush.api.push.model.notification.PlatformNotification;

/**
 * <strong>Title : PushSender </strong>. <br>
 * <strong>Description : 推送工具.</strong> <br>
 * <strong>Create on : Mar 18, 2016 12:04:55 PM </strong>. <br>
 * <p>
 * <strong>Copyright (C) YOX Internet Technology Co.,Ltd.</strong> <br>
 * </p>
 * @author k2 <br>
 * @version <strong>base-platform-0.1.0</strong> <br>
 * <br>
 * @see
 * <br>
 */
public class PushSender {
	
	private static final Logger logger = LoggerFactory.getLogger(PushSender.class);
	
	private static Properties props = PropsUtil.loadProps("jpush.properties");
	
	/**
	 * appk
	 */
	private static String appKey = props.getProperty("jpush.key");
	/**
	 * 安全密钥
	 **/
	private static String masterSecret = props.getProperty("jpush.secret");
	
	//private static Long timeToLive = Long.valueOf(PropertiesHolder.getNullIfBlank("jpush.timeToLive"));
	
	//private static boolean apnsProduction = Boolean.valueOf(PropertiesHolder.getNullIfBlank("jpush.apnsProduction"));
	/**
	 * 推送渠道 JPUSH 极光推送 OTHER
	 **/
	private static String accessWay = "JPUSH";
	
	static int PLATFORM_ANDROID=0;
	
	static int PLATFORM_iOS=1;
	
	
	/**
	 * 重连时间
	 */
//	private static int retryTimes = 3;

	private static JPushClient jpushClient=new JPushClient(masterSecret, appKey,null, ClientConfig.getInstance());

	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc .
	 * @param message
	 * @return
	 */
	public static PushResult sendMessage(String message) {
		if (accessWay.equals("JPUSH")) {
			PushPayload pushPayLoad = buildPushObject_all_all_alert(message);
			return send(pushPayLoad);
		}
		return null;
	}
	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc 所有平台，所有设备.
	 * @param message
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String message) {
		return PushPayload.alertAll(message);
	}
	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc 创建所有平台的信息通知.
	 * @param alias
	 * @param title
	 * @param message
	 * @return
	 */
	public static PushPayload buildPushObject_all_all_alert(String alias, String title, String message) {
		Builder builder = PushPayload.newBuilder();
		builder.setPlatform(Platform.all());
		builder.setAudience(Audience.alias(alias));
		builder.setNotification(Notification.android(title, message, null));
		return builder.build();

	}
	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc 所有平台别名为 alias 的设备.
	 * @param alias 别名
	 * @param message 信息内容
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert(String alias, String message) {

		Options options = Options.newBuilder().setApnsProduction(true).build();
		return PushPayload.newBuilder().setPlatform(Platform.all()).setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(message)).setOptions(options).build();
	}

	
	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc IOS 平台别名为 alias 的设备.
	 * @param alias 别名
	 * @param message 信息内容
	 * @return
	 */
	public static PushPayload buildPushObject_IOS_alias_alert(String alias, String message) {
		Options options = Options.newBuilder().setApnsProduction(true).build();
		return PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(message)).setOptions(options).build();
	}

	
	/**
	 * @author by K2 Mar 18, 2016
	 *
	 * @desc ANDROID 平台别名为 alias 的设备.
	 * @param alias 别名
	 * @param message 信息内容
	 * @return
	 */
	public static PushPayload buildPushObject_ANDORID_alias_alert(String alias, String message) {
		Options options = Options.newBuilder().setApnsProduction(true).build();
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(message)).setOptions(options).build();
	}

	/**
	 * 发送推送(自定义消息)
	 * @param receivers
	 * @param title
	 * @param extra
	 * @return
	 */
	public static PushResult sendMessage(List<String> receivers,String title, Map<String, String> extra) {
        PushPayload payload = buildPushObject_all_alias_alert_new(receivers,title,extra);

        return send(payload);
	}

	/**
	 * 发送推送(通知)
	 * @param receivers
	 * @param title 标题
	 * @param alert
	 * @param extra
	 * @return
	 */
	public static PushResult sendMessageNotice(List<String> receivers,String title,String alert, Map<String, String> extra) {
        PushPayload payload = buildPushObject_all_alias_alert_new_notification(receivers,title,alert,extra);

        return send(payload);
	}
	
	
	public static PushResult sendAllMessageNotice(String title,String alert, Map<String, String> extra) {
		
//		logger.debug("========="+masterSecret+"======+++++"+appKey);
//		return null;
		
        PushPayload payload = buildPushObject_all_all_alert_new_notification(title,alert, extra);

        return send(payload);
	}
	
	
	/**
	 * 组合PushPayload 自定义消息
	 * @param receivers
	 * @param alert
	 * @param extra
	 * @return
	 */
	public static PushPayload buildPushObject_all_alias_alert_new(List<String> receivers,String alert,Map<String, String> extra) {
		return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(receivers))
                .setNotification(Notification.alert(alert))
                .setMessage(Message.newBuilder().setMsgContent(alert).addExtras(extra).build())
                .build();
    }
	/**
	 * * 组合PushPayload 通知
	* @Description: TODO
	* @param receivers 接收别名
	* @param title	标题
	* @param alert	通知
	* @param extra
	* @return
	* @author: Storydo
	* @date: 2017年4月6日 上午11:46:27
	 */
	 
	public static PushPayload buildPushObject_all_alias_alert_new_notification(List<String> receivers,String title,
			String alert,Map<String, String> extra) {
     
		return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(receivers))
                .setNotification(Notification.newBuilder()
                		.addPlatformNotification(buildPushPlatformNotification(title, alert, PLATFORM_iOS))
                		.addPlatformNotification(buildPushPlatformNotification(title, alert, PLATFORM_ANDROID))
                		.build())
                .setOptions(Options.newBuilder().setApnsProduction(true).build())
                .setMessage(Message.newBuilder().setMsgContent(alert).addExtras(extra).build())
                .build();
    }
	
	/**
	 * 
	* @Description: 所有平台 所有设备
	* @param alert
	* @param extra
	* @return
	* @author: Storydo
	* @date: 2017年3月14日 下午2:08:52
	 */
	public static PushPayload buildPushObject_all_all_alert_new_notification(String title,String alert,Map<String, String> extra) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.all())
                .setNotification(Notification.newBuilder()
                		.addPlatformNotification(buildPushPlatformNotification(title, alert, PLATFORM_iOS))
                		.addPlatformNotification(buildPushPlatformNotification(title, alert, PLATFORM_ANDROID))
                		.build())
                .setMessage(Message.newBuilder().setMsgContent(alert).addExtras(extra).build())
                .build();
    }
	
	
	public static PlatformNotification buildPushPlatformNotification(String title,String alert,int platform){
		
		if(platform==PLATFORM_ANDROID){
			if(title==null||title.equals("")){
				return AndroidNotification.newBuilder().setAlert(alert).build();
			}
			return AndroidNotification.newBuilder().setTitle(title).setAlert(alert).build();
		}
		
		String content;
		
		if(title==null||title.equals("")){
			content = alert;
		}else{
			content = title+"["+alert+"]";
		}

		return IosNotification.newBuilder().setAlert(content).setContentAvailable(true).setSound("default").incrBadge(1).build();
	}
	
	
	/**
	 * 返回结果
	 */
	private static PushResult send(PushPayload payload) {
		try {
            PushResult result = jpushClient.sendPush(payload);
            logger.info("Got result - " + result);
            return result;
        } catch (APIConnectionException e) {
            // Connection error, should retry later
        	logger.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
        	logger.error("Should review the error, and fix the request", e);
        	logger.info("HTTP Status: " + e.getStatus());
        	logger.info("Error Code: " + e.getErrorCode());
        	logger.info("Error Message: " + e.getErrorMessage());
        }
		return null;
	}
}