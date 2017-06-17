package com.yoxnet.common.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;

public class JsonToMap {

	public static Map<String, Object> jsonToMap(String str){
		//将json转成Map
		Map<String, Object> params = new HashMap<String, Object>();
		JSONArray jsonArray = JSONArray.fromObject("["+str+"]");
		
		try {
			List<Map<String,Object>> mapListJson = (List)jsonArray;  
			for (int i = 0; i < mapListJson.size(); i++) {  
				Map<String,Object> obj=mapListJson.get(i);  

				for(Entry<String,Object> entry : obj.entrySet()){  
					params.put(entry.getKey(), entry.getValue());
				}  
			}  
			return params;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return params=null;
		}

	}
	
	
	public static void main(String[] args) {
		
		Map map = jsonToMap("{\"payNo\":\"123456789\",\"notifyTime\":1438876569806,\"tradeStatus\":\"SUCCESS\"}");
		
		System.out.println(map);
		
		Map map1 = jsonToMap("{\"payNo\":\"123456789\",\"notifyTime\":1438876569806,\"tradeStatus\":\"SUCCESS\"}");
		
		System.out.println(map1);
	}
}
