package com.yoxnet.api.download;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yoxnet.common.action.BaseAction;


/**   
* @Title: DownLoadController.java 
* @Description: 下载页面
* @author : Aaron
* @date: 2017年2月21日 下午4:56:59 
* @version:V1.0 
* Modification  History:
* Version       Date          Author          Description
* ----------------------------------------------------------------------------
*  1.0         2017年2月21日        Aaron              TODO
*/
@Controller
@RequestMapping(value = "/web")
public class DownLoadController extends BaseAction {

	@RequestMapping(value = "/download",method=RequestMethod.GET)
	public String download(Model model){
		return "download/download";
	}
	@RequestMapping(value = "/downloadIos",method=RequestMethod.GET)
	public String downloadIos(Model model){
		return "download/downloadIos";
	}
}
