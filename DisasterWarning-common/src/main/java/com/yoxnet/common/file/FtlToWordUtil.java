package com.yoxnet.common.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import sun.misc.BASE64Encoder;
import java.util.List;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FtlToWordUtil {
	/**
	 * ftl转word
	 * @param dataMap 模板数据
	 * @param ftlName 模板名称
	 * @return 返回生产word路径
	 * @throws IOException
	 */
	public static void createDoc(Map<String, Object> dataMap,String ftlName) throws IOException {
		// 获取web应用的绝对路径
		String rootPath = (FtlToWordUtil.class.getClassLoader().getResource("").getPath().toString()).replace("target/classes/", "");
		try {
			Configuration configuration=new Configuration();
			configuration.setDefaultEncoding("UTF-8");
			// ftl文件存放路径
			configuration.setDirectoryForTemplateLoading(new File(rootPath+ "src/main/webapp/tempftl/"));
			Template t = null;
			// test.ftl为要装载的模板
			t = configuration.getTemplate(ftlName);
			t.setEncoding("utf-8");
			File outFile = new File(rootPath+ "src/main/webapp/tempword/proxy.doc");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"));
			t.process(dataMap, out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 图片转码
	 * @param imgFile 图片路径
	 * @return
	 */
	public static String getImageStr(String imgFile) {
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
    
}
