package com.yoxnet.gps.bean;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yoxnet.common.GeneratorKey;
import com.yoxnet.common.utils.DateUtiler;
import com.yoxnet.locationInfo.bean.DataLocationInfo;

import net.sf.json.JSONArray;

import net.sf.json.JSONObject;
public class GpsHttp{
   
	private static Logger logger = LoggerFactory.getLogger(GpsHttp.class);    //日志记录
    
	  /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    
	public static JSONArray httpGetUtils(String deviceId,String deviceCode){
		String url = "http://123.56.96.23:89/gpsonline/GPSAPI?version=1&method=loadLocation&vid="+deviceId+"&vKey="+deviceCode;
		Object obj =  httpGetInfo(url);
		JSONObject json = JSONObject.fromObject(obj);
		JSONArray gpsInfo = (JSONArray) json.get("locs");
		return gpsInfo;
    }
	
    public static String httpGetInfo(String url){
	
	    String jsonResult = null;
	    HttpGet request = new HttpGet(url);
	
    	try {
			HttpResponse response = HttpClients.createDefault().execute(request);

			if(response.getStatusLine().getStatusCode()==200){
				jsonResult = EntityUtils.toString(response.getEntity());
			}
		} catch (ClientProtocolException e) {
			 logger.error("请求提交失败:" + url, e);
		} catch (ParseException e) {
			 logger.error("请求提交失败:" + url, e);
		} catch (java.io.IOException e) {
			 logger.error("请求提交失败:" + url, e);
		}
    	return jsonResult;
	}
    
    public static List<GpsInfo> getBeanList(JSONArray gpsJson){
    	Iterator<Object> gpsJsonList = gpsJson.iterator();
    	List<GpsInfo> list = new ArrayList<GpsInfo>();
    	while (gpsJsonList.hasNext()) {
	        JSONObject gpsObj = (JSONObject) gpsJsonList.next();
	        GpsInfo gpsInfo = new GpsInfo();
	     
	        if(gpsObj.getString("id")!=null){
	        	gpsInfo.setId(gpsObj.getString("id")); //车辆ID
	        }
	        if(gpsObj.getString("name")!=null){
	        	gpsInfo.setName(gpsObj.getString("name"));   //车辆号码
	        }
	        if(gpsObj.getString("recvtime")!=null){
	        	gpsInfo.setRecvtime(gpsObj.getString("recvtime"));   //服务器时间（毫秒）
	        }
	        if(gpsObj.getString("gpstime")!=null){
	        	gpsInfo.setGpstime(gpsObj.getString("gpstime"));   //GPS时间（毫秒）
	        }
	        if(gpsObj.getString("lat")!=null){
	        	gpsInfo.setLat(BigDecimal.valueOf(gpsObj.getDouble("lat")));    //纬度
	        }
	        if(gpsObj.getString("lng")!=null){
	        	gpsInfo.setLng(BigDecimal.valueOf(gpsObj.getDouble("lng")));    //纬度
	        }
	        if(gpsObj.getString("lat_xz")!=null){
	        	gpsInfo.setLat_xz(BigDecimal.valueOf(gpsObj.getDouble("lat_xz")));    //纬度
	        }
	        if(gpsObj.getString("lng_xz")!=null){
	        	gpsInfo.setLng_xz(BigDecimal.valueOf(gpsObj.getDouble("lng_xz")));    //纬度
	        }
	        
	        if(gpsInfo!=null){
	            list.add(gpsInfo);
	        }
    	}
    	return list;
    }
    
}
