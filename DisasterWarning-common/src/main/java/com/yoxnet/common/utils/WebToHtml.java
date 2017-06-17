package com.yoxnet.common.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-31
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class WebToHtml {
    private static long star = 0;
    private static long end = 0;
    private static long ttime = 0;

    // 返回html代码
    public static String getHtmlCode( String httpUrl,HttpServletRequest request) {
        Date before = new Date();
        star = before.getTime();

        String htmlCode = "";
        try {
            InputStream in;
            URL url = new java.net.URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
       //     connection.setRequestProperty("User-Agent", "Mozilla/4.0");
            Cookie[] cookie=request.getCookies();
            String cookieValue="";
            for(Cookie c:cookie){
            	cookieValue=c.getName()+"="+c.getValue()+";";
            }
            connection.setRequestProperty("Cookie", cookieValue);
            connection.connect();
            in = connection.getInputStream();
            java.io.BufferedReader breader = new BufferedReader(
                    new InputStreamReader(in, "UTF-8"));
            String currentLine;
            while ((currentLine = breader.readLine()) != null) {
                htmlCode += currentLine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Date after = new Date();
            end = after.getTime();
            ttime = end - star;
            System.out.println("执行时间:" + ttime + "秒");
        }
        return htmlCode;
    }
/*
    // 存储文件
    public static synchronized void writeHtml(String filePath, String from) {
        String info = getHtmlCode(from);
        PrintWriter pw = null;
        try {
            File writeFile = new File(filePath);
            boolean isExit = writeFile.exists();
            if (isExit != true) {
                File file = new File(writeFile.getParent());
                if (!file.exists())
                    file.mkdirs();
                writeFile.createNewFile();
            } else {
                writeFile.delete();
                writeFile.createNewFile();
            }
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"));
            pw.println(info);
            pw.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            pw.close();
        }
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        writeHtml("c:/demo.html", url);
    }
*/
}
