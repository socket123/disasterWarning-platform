package com.yoxnet.api.update;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoxnet.common.ErrCodeEWeb;
import com.yoxnet.common.action.BaseAction;
import com.yoxnet.common.json.JsonResult;

/**   
* @Title: SoftUpdateController.java 
* @Description: 版本更新
* @author : Aaron
* @date: 2016年12月26日 下午4:10:28 
* @version:V1.0 
* Copyright 世纪衑钶 2016 All right reserved.
* Modification  History:
* Version       Date          Author          Description
* ----------------------------------------------------------------------------
*  1.0         2016年12月26日        Aaron              版本更新
*/
@RestController
@RequestMapping("/api/softUpdate/{platformType}")
public class SoftUpdateController extends BaseAction {

	@RequestMapping(value="/getLatestVersion",method=RequestMethod.GET)
	public JsonResult<Object> getLatestVersion(@PathVariable String platformType){
		try {
			String release_file_path = "/softupdate/" + platformType + "/release.xml";

			Document document = new SAXReader().read(
					new FileInputStream(request.getSession().getServletContext().getRealPath("/") + release_file_path));

			Element rootElement = document.getRootElement();

			String isMust = rootElement.element("ISMUST").getText().trim();
			String upVersion = rootElement.element("UPVERSION").getText().trim();

			String upHttpUrl = rootElement.element("UPHTTPURL").getText().trim();

			String isUpdate = rootElement.element("ISUPDATE").getText().trim();

			String upItems = rootElement.element("UPITEMS").getText();

			Map<String,Object> params = new HashMap<String,Object>();
			params.put("UPVERSION", upVersion);
			params.put("ISMUST", isMust);
			params.put("UPHTTPURL", upHttpUrl);
			params.put("UPITEMS", upItems);
			params.put("ISUPDATE", isUpdate);
			// params.put("DICTLIST", new ArrayList());
			return buildJsonResult(params);
		} catch (Exception e) {
			return buildFailJsonResult(false, ErrCodeEWeb.NONE.getCode(), ErrCodeEWeb.NONE.getName());
		}
	}
}
