package com.yoxnet.common.file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.star.io.IOException;

public class DocumentTool {
	/**
	 * ftl模板转pdf
	 * @param dataMap 模板数据
	 * @param ftlName 模板名称
	 * @throws IOException
	 */
	public static void ftltoPdf(Map<String, Object> dataMap,String ftlName) throws IOException{
		try {
			String rootPath = (FtlToWordUtil.class.getClassLoader().getResource("").getPath().toString()).replace("target/classes/", "");
			FtlToWordUtil.createDoc(dataMap,ftlName);
			String sourceFile=rootPath+ "src/main/webapp/tempword/"+ftlName.replace("ftl", "doc");
			String destFile=rootPath+ "src/main/webapp/temppdf/"+ftlName.replace("ftl", "pdf");
			OfficetoPdfUtil.createPDF("C:/aa/b.doc",destFile);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
     * 调用例子
     * @param args
     * 需要启动 openoffic 服务 进入 C:\Program Files (x86)\OpenOffice 4\program
	       命令：soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard
     */
	public static void main(String[] args) {
		Map root=new HashMap();
		List reportresult =new ArrayList();
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("str", "易人众筹（北京）科技有限公司 ");
		data.put("address", "北京市密云县东邵渠镇政府办公楼210室-543");
		data.put("name", "万敏");
		data.put("str111", "北京知果科技有限公司");
		data.put("address111", "北京市密云县东邵渠镇政府办公楼210室-543");
		data.put("lxr", "万敏");
		data.put("tel", "18510882083");
		data.put("zw", "工程师");
		String img =FtlToWordUtil.getImageStr("c:/aa/aa.png");
		data.put("image", img);
		reportresult.add(data);
		root.put("reportresult", reportresult);
		try {
			ftltoPdf(root,"proxy.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
