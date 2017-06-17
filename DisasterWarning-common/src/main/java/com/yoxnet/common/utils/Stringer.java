
package com.yoxnet.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.servlet.http.HttpServletRequest;


/**
 * <strong>Title : Stringer </strong>. <br>
 * <strong>Description : 字符串处理工具类.</strong> <br>
 * <strong>Create on : May 20, 2015 5:32:38 PM </strong>. <br>
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
public class Stringer {
	
	
	public static final String SPECIAL_CHAR = "[\\\\`~!@#$%^&*+=|{}',:;\"[url=file://\\[\\].<]\\[\\].<>/[/url]?～！＠＃￥％……＆×（）——＋｜｛｝【】［］‘；：＂。，、．＜＞／？]";
	
	public Stringer() {
	}
	
	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 判断某字符串是否为空，如果为空，则返回一个空串.
	 * @param string
	 * @return
	 */
	public static String nullToEmpty(String string) {
		return isNullOrEmpty(string) ? "" : string;
	}

	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 判断某字符串是否为空，如果为空，则返回一个null空对象.
	 * @param string
	 * @return
	 */
	public static String emptyToNull(String string) {
		return isNullOrEmpty(string) ? null : string;
	}

	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 判断某对象是否为空.
	 * @param obj
	 * @return
	 */
	public static boolean isNullOrEmpty(Object obj) {

		boolean result = true;
		if (obj == null) {
			return true;
		}
		if (obj instanceof String) {
			result = (obj.toString().trim().length() == 0) || obj.toString().trim().equals("null");
		} else if (obj instanceof Collection) {
			result = ((Collection<?>) obj).size() == 0;
		} else if (obj instanceof Map) {
			result = ((java.util.Map<?,?>) obj).isEmpty();
		}else {
			result = ((obj == null) || (obj.toString().trim().length() < 1)) ? true : false;
		}
		return result;
	}
	
	
	/**
     * 通过反射的方式遍历对象的属性和属性值，方便调试
     *
     * @param o 要遍历的对象
     * @throws Exception
     */
    public static void reflect(Object o) throws Exception {
        Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
        }
    }

    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc 处理读取InputStream数据流.
     * @param in
     * @return 输出二进制数据
     * @throws IOException
     */
    public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }
    
    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc InputStream数据流转换成字符串.
     * @param is
     * @return
     * @throws IOException
     */
    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }
    
    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc 将字符串转成InputStream流.
     * @param sInputString
     * @return
     */
    public static InputStream getStringStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }
    
    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc 从数据map中获取某个key的字符串值.
     * @param map
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if (key == "" || key == null) {
            return defaultValue;
        }
        String result = (String) map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    /**
     * @author by K2 Aug 21, 2015
     *
     * @desc 从数据map中获取某个key的int类型值.
     * @param map
     * @param key
     * @return
     */
    public static int getIntFromMap(Map<String, Object> map, String key) {
        if (key == "" || key == null) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt((String) map.get(key));
    }
    
	/**
	 * @author by k2 Jun 18, 2015
	 *
	 * @desc 获得客户端真实IP地址.
	 * @param request
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	/**
	 * @author by k2 Jun 18, 2015
	 *
	 * @desc 获取本机名称.
	 * @return
	 */
	public static String getLocalHostName() {
		String hostName;
		try {
			InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (Exception ex) {
			hostName = "";
		}
		return hostName;
	}
	
	/**
	 * @author by k2 Jun 18, 2015
	 *
	 * @desc 获取本机IP，默认取出第一个有效的网卡ip（单网卡）.
	 * @return
	 */
	public static String getLocalIP() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		byte[] ipAddr = addr.getAddress();
		String ipAddrStr = "";
		for (int i = 0; i < ipAddr.length; i++) {
			if (i > 0) {
				ipAddrStr += ".";
			}
			ipAddrStr += ipAddr[i] & 0xFF;
		}
		return ipAddrStr;
	}

	/**
	 * 
	 * @author by k2 Jun 18, 2015
	 * 
	 * @desc 获取本机所有IP（多网卡）.
	 * @return
	 */
	public static String[] getAllLocalHostIP() {
		String[] ret = null;
		try {
			String hostName = getLocalHostName();
			if (hostName.length() > 0) {
				InetAddress[] addrs = InetAddress.getAllByName(hostName);
				if (addrs.length > 0) {
					ret = new String[addrs.length];
					for (int i = 0; i < addrs.length; i++) {
						ret[i] = addrs[i].getHostAddress();
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			ret = null;
		}
		return ret;
	}
	
	/**
	 * @author by k2 Jun 18, 2015
	 *
	 * @desc 获取所有网卡ip信息.
	 * @return
	 */
	public static List<String> getAllNetIP() {
		List<String> ips = new ArrayList<String>();
		try {
			Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
			for (NetworkInterface netint : Collections.list(nets))
				if (null != netint.getHardwareAddress()) {
					List<InterfaceAddress> list = netint.getInterfaceAddresses();
					for (InterfaceAddress interfaceAddress : list) {
						String localip = interfaceAddress.getAddress().toString();
						ips.add(localip);
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ips;
	}
	
	
	/**
	 * @author by K2 Aug 18, 2015
	 *
	 * @desc 小数点数据字符串转成保留两位小数的float数据类型.
	 * @param f
	 * @return
	 */
	public static float stringToFloat(String string) {
		float f = Float.parseFloat(string);
		BigDecimal b = new BigDecimal(f);
		float f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}
	
	/**
	 * @author by K2 Aug 18, 2015
	 *
	 * @desc 浮点型数据转换成两位小数点的字符串.
	 * @param f
	 * @return
	 */
	public static String floatToString(float f) {
		DecimalFormat decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
		String p = decimalFormat.format(f);// format 返回的是字符串
		return p;
	}
	
	
	/**
	 * @author by K2 Aug 19, 2015
	 *
	 * @desc 双精度数据转换成两位小数点的字符串.
	 * @param string
	 * @return
	 */
	public static Double stringToDouble(String string) {
		float f = Float.parseFloat(string);
		BigDecimal b = new BigDecimal(f);
		Double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}
	
	/**
	 * @author by K2 Aug 19, 2015
	 *
	 * @desc 双精度数据转换成两位小数点的字符串.
	 * @param string
	 * @return
	 */
	public static String stringToDouble(Double dd) {
		return String.format("%.2f", dd);
	}
	
	
	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 替换特殊字符(全角&半角)..
	 * @param srcString 原字符串
	 * @param regEx 替换的正则表达式，如果为空则使用默认的正则表达式，变量=SPECIAL_CHAR
	 * @return 
	 * @throws PatternSyntaxException
	 */
	public static String StringFilter(String srcString, String regEx) throws PatternSyntaxException {
		if(Stringer.isNullOrEmpty(srcString)){
			return "";
		}
		if(isNullOrEmpty(regEx)){
			regEx = SPECIAL_CHAR;
		}
		return Pattern.compile(regEx).matcher(srcString).replaceAll("").replaceAll("[url=]\\\\[/url]", "").trim();
	}

	/**
	 * @author by K2 Aug 21, 2015
	 * 
	 * @desc 检查指定字符串中是否包含特殊字符
	 * 
	 * @param srcString 原字符串
	 * @param regEx 替换的正则表达式，如果为空则使用默认的正则表达式，变量=SPECIAL_CHAR
	 * @return 如果有返回true
	 */
	public static boolean existSpecialChar(String srcString, String regEx) {
		if(isNullOrEmpty(regEx)){
			regEx = SPECIAL_CHAR;
		}
		Matcher m = Pattern.compile(regEx).matcher(srcString);
		return m.find();
	}
	
	
	
	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 验证标识符必须由字母、数字、下划线组成.
	 * @return
	 */
	public static boolean chkIsStr1(String chkStr) {
		Pattern p = Pattern.compile("[a-z0-9A-Z_]+");
		Matcher m = p.matcher(chkStr);
		return  m.matches();
	}

	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 匹配标识符必须由字母、数字、下划线组成，且开头和结尾不能有下划线,且中间的字符至少1个不能超过5个.
	 * @param str
	 * @return
	 */
	public static boolean chkIsStr2(String str) {
		// 匹配标识符必须由字母、数字、下划线组成，且开头和结尾不能有下划线
		// String regex = "(^[a-z0-9A-Z])[a-z0-9A-Z_]+([a-z0-9-A-Z])";
		String regex = "(^[a-z0-9A-Z])[a-z0-9A-Z_]{1,5}([a-z0-9-A-Z])";
		return Pattern.matches(regex, str);
	}

	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 验证邮箱格式.
	 * @param str
	 * @return
	 */
	public static boolean chkIsEmail(String str) {
		String regex = "^[\\w-]+(\\.[\\w-]+)*\\@([\\.\\w-]+)+$";
		boolean flg = Pattern.matches(regex, str);
		return flg;
	}

	/**
	 * @author by K2 Aug 21, 2015
	 *
	 * @desc 验证电话号码.
	 * @param str
	 * @return
	 */
	public static boolean chkIsPhone(String str) {
		// "(d+-)?(d{4}-?d{7}|d{3}-?d{8}|^d{7,8})(-d+)?" //电话号码
		// String regex = "\\d{3}-\\d{4}-\\d{7,8}-\\d{3}";
		String regex = "(\\d+-)?(\\d{4}-\\d{7,8})(-\\d+)";
		return Pattern.matches(regex, str);
	}
	
}


