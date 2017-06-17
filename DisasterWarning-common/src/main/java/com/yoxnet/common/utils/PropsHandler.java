package com.yoxnet.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 
 * <strong>Title : PropsHandler </strong>. <br>
 * <strong>Description : Properties文件处理类.</strong> <br>
 * <strong>Create on : Mar 13, 2015 5:25:27 PM </strong>. <br>
 * <p>
 * <strong>Copyright (C) AlexHo Co.,Ltd.</strong> <br>
 * </p>
 * @author k2 hechs@yoxnet.com <br>
 * @version <strong>zhpgo-0.0.1</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public final class PropsHandler {
	
	private static Locale defaultLocale = Locale.getDefault();

	private static HashMap<String, String> formats = new HashMap<String, String>();

	// 加载class根目录下的application.properties
	private static Properties props = null;
	static {
		try {
			if(null == props){
				props = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream("/config/application.properties");
			props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/**
	 * @author by k2 Jan 22, 2015
	 *
	 * @desc 方法描述.获得key的对应值
	 * @param key
	 * @return
	 */
	public final static String getProperty(String key) {
		return props.getProperty(key);
	}

	/**
	 * @author by k2 Jan 22, 2015
	 *
	 * @desc 方法描述.获得默认值
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public final static String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
	/**
	 * @author by k2 Jan 22, 2015
	 *
	 * @desc 方法描述.获得key的对应值，并对参数格式化，e.g {0}{1}...
	 * @param key
	 * @param array
	 * @return
	 */
	public final static String getProperty(String key, Object[] array) {
		String msg = props.getProperty(key);
		msg = MessageFormat.format(msg, array);
		return msg;
	}
	
	/**
	 * @author by k2 Jan 22, 2015
	 *
	 * @desc 方法描述.根据指定资源，获得key的对应值，并对参数格式化，e.g {0}{1}...
	 * @param key
	 * @param array
	 * @param srcPath 
	 * @return
	 */
	public final static String getProperty(String srcPath, String key, Object[] array) {
		Properties props1 = null;
		try {
			if(null == props1){
				props1 = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream(srcPath);
			props1.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
		String msg = props1.getProperty(key);
		msg = MessageFormat.format(msg, array);
		return msg;
	}
	
	public final static String getPropertyAzure(String srcPath, String key) {
		Properties props1 = null;
		try {
			if(null == props1){
				props1 = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream(srcPath);
			props1.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
		String msg = props1.getProperty(key);
		return msg;
	}
	
	public final static String getPropertyOpc(String key) {
		Properties props1 = null;
		try {
			if(null == props1){
				props1 = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream("opc.properties");
			props1.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
		String msg = props1.getProperty(key);
		return msg;
	}
	
	
	
	/**
	 * @author by k2 Apr 21, 2015
	 *
	 * @desc 消息资源处理.
	 * @param locale
	 * @param key
	 * @return
	 */
	public static String getMessage(Locale locale, String key) {
		if (locale == null) {
			locale = defaultLocale;
		}
		String msg = null;
		String formatKey = messageKey(locale, key);
		synchronized (formats) {
			msg = (String) formats.get(formatKey);
			if (msg == null) {
				ResourceBundle myResources = ResourceBundle.getBundle("config/messages/messages", locale);
				msg = myResources.getString(key);
				formats.put(formatKey, msg);
			}
		}
		return msg;
	}

	public static String getMessage(String key, String arg0) {
		return getMessage(defaultLocale, key, arg0);
	}

	public static String getMessage(Locale locale, String key, Object args[]) {
		MessageFormat format = new MessageFormat(getMessage(locale, key));
		return format.format(args);
	}

	public static String getMessage(Locale locale, String key, Object arg0) {
		Object args[] = new Object[1];
		args[0] = arg0;
		return (getMessage(locale, key, args));
	}

	protected static String localeKey(Locale locale) {
		if (locale == null) {
			return ("");
		} else {
			return (locale.toString());
		}
	}

	protected static String messageKey(Locale locale, String key) {
		return (localeKey(locale) + "." + key);
	}

	public static String getMessage(String key) {
		return getMessage(defaultLocale, key);
	}

}
