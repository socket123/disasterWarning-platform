package com.yoxnet.common.utils;
import java.math.BigDecimal;  
import java.text.DecimalFormat;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

/**
 * 精度数值运算工具类
 *
 */
public class NumberUtil {  
    public static void main(String[] args) {  
        System.out.println(add(0.06000, 0.00000001));  
        System.out.println(sub(1.0, 0.422));
        System.out.println(1.0-0.422);
        System.out.println(mul(1.5438298238974,1000.0));
        
        System.out.println(div(10,0.3,2));
        System.out.println(div(20,3,2,BigDecimal.ROUND_FLOOR));
        System.out.println(defaultDiv(20,3));
//        如果不像银行那样算利息，需要厘这样的单位的话，使用Long进行运算已足够，当然，你的货币单位是：分。
//        Long num = 1234567890L; // 单位是分
//        BigDecimal oneNum = BigDecimal.valueOf(num);
//        oneNum = oneNum.movePointLeft(2); // 此时oneNum单位为元
//        oneNum.divide(BigDecimal.valueOf(1000), RoundingMode.HALF_UP);// 除以1000，4舍5入。
        // BigDecimal 的运算不会丢失精度。 
    }  

    /**
     * 加法 运算
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) { 
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.add(b2).doubleValue();  
    }  

    /**
     * 减法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double sub(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.subtract(b2).doubleValue();  
    }  
    
    /**
     * 减法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double subScale2(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        BigDecimal result= b1.subtract(b2);
        result=result.setScale(2,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();  
    }
    
    /**
     * 乘法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double mul(double v1, double v2) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2)); 
        return b1.multiply(b2).doubleValue();  
    }  

    /**
     * 乘法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double mulScale2(double v1, double v2) {  
        return mul(v1,v2,2);  
    }
    
    /**
     * 乘法运算
     * @param v1
     * @param v2
     * @param scale 保留小数位数
     * @return
     */
    public static double mul(double v1, double v2,int scale) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2)); 
        BigDecimal result=b1.multiply(b2);
        result=result.setScale(scale,BigDecimal.ROUND_HALF_UP);
        return result.doubleValue();  
    }  
    
    /**
     * 除法运算，保留2位小数，多余位四舍五入
     * @param v1
     * @param v2
     * @return
     */
    public static double divScale2(double v1, double v2) {  
        return div(v1,v2, 2);  
    } 
    
    /**
     * 除法运算
     * @param v1
     * @param v2
     * @param scale:保留小数部分位数，多余位四舍五入
     * @return
     */
    public static double div(double v1, double v2, int scale) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
    }  
    
    /**
     * 除法运算
     * @param v1
     * @param v2
     * @param scale:保留小数部分位数
     * @return
     */
    public static double div(double v1, double v2, int scale,int round) {  
        BigDecimal b1 = new BigDecimal(Double.toString(v1));  
        BigDecimal b2 = new BigDecimal(Double.toString(v2));  
        return b1.divide(b2, scale, round).doubleValue();  
    }  
    
    /**
     * 除法运算
     * @param v1
     * @param v2
     * @param scale:保留小数部分位数,多余位舍去
     * @return
     */
    public static double defaultDiv(double v1, double v2) {  
       return div(v1, v2, 2,BigDecimal.ROUND_FLOOR);
    } 
   
    
   

    /**
     * 截取3位 
     * @param v
     * @return
     */
    public static double round(double v) {
    	return round(v ,2);
    }  

    /**
     * 截取指定位数
     * @param v
     * @return
     */
    public static double round(double v, int scale) {
        BigDecimal b = new BigDecimal(Double.toString(v));  
        BigDecimal one = new BigDecimal("1");  
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();  
    } 
    
    public static String decimalFormat(String pattern, double value) {  
        return new DecimalFormat(pattern).format(value);  
    }  

    public static String decimalFormat(double value) {  
        return new DecimalFormat("0.00").format(value);  
    }  

    public static String decimalFormat(double value, String pattern) {  
        return new DecimalFormat(pattern).format(value);  
    }  

    public static String decimalBlankFormat(double value) {  
        return new DecimalFormat("0").format(value);  
    }  

    /**
     * 检查是否是数字 
     * @param value
     * @return
     */
    public static boolean isNumber(String value) {
        String patternStr = "^\\d+$";  
        Pattern p = Pattern.compile(patternStr, Pattern.CASE_INSENSITIVE); // 忽略大小写;  
        Matcher m = p.matcher(value);  
        return m.find();  
    }  

}  