package com.keluo.jsonUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Distinct {
	public static void main(String[] args) {
		String json_str = "[{ \"name\": \"张三\", \"serial\": \"0001\" }, \r\n" + 
				" { \"name\": \"李四\", \"serial\": \"0002\" },\r\n" + 
				" { \"name\": \"王五\", \"serial\": \"0003\" },\r\n" + 
				" { \"name\": \"王五2\", \"serial\": \"0003\" },\r\n" + 
				" { \"name\": \"赵四\", \"serial\": \"0004\" },\r\n" + 
				" { \"name\": \"小明\", \"serial\": \"005\" },\r\n" + 
				" { \"name\": \"小张\", \"serial\": \"006\" },\r\n" + 
				" { \"name\": \"小李\", \"serial\": \"006\" }, \r\n" + 
				" { \"name\": \"小李2\", \"serial\": \"006\" },\r\n" + 
				" { \"name\": \"赵四2\", \"serial\": \"0004\" }]";
		JSONArray json = JSONArray.parseArray(json_str);
		System.out.println("去重前: " + json.toJSONString());
		System.out.println("去重后: " + distinct(json, "serial").toJSONString());
		
		//----------------------------------------------------------------
		
		String str_json2 = "[{\"id\": \"1\", \"name\": \"中国\", \"code\": \"110\", \"parent\": \"\"},\r\n" + 
				"		    { \"id\": \"2\", \"name\": \"北京市\", \"code\": \"110000\", \"parent\": \"110\" },\r\n" + 
				"		    { \"id\": \"3\", \"name\": \"河北省\", \"code\": \"130000\", \"parent\": \"110\" },\r\n" + 
				"		    { \"id\": \"4\", \"name\": \"四川省\", \"code\": \"510000\", \"parent\": \"110\" },\r\n" + 
				"		    { \"id\": \"5\", \"name\": \"石家庄市\", \"code\": \"130001\", \"parent\": \"130000\" },\r\n" + 
				"		    { \"id\": \"6\",  \"name\": \"唐山市\", \"code\": \"130002\", \"parent\": \"130000\" },\r\n" + 
				"		    { \"id\": \"7\", \"name\": \"邢台市\", \"code\": \"130003\", \"parent\": \"130000\" },\r\n" + 
				"		    { \"id\": \"8\", \"name\": \"成都市\", \"code\": \"510001\", \"parent\": \"510000\" },\r\n" + 
				"		    { \"id\": \"9\", \"name\": \"简阳市\", \"code\": \"510002\", \"parent\": \"510000\" },\r\n" + 
				"		    { \"id\": \"10\", \"name\": \"武侯区\", \"code\": \"51000101\", \"parent\": \"510001\" },\r\n" + 
				"		    { \"id\": \"11\", \"name\": \"金牛区\", \"code\": \"51000102\", \"parent\": \"510001\" } ]";
		JSONArray json2 = JSONArray.parseArray(str_json2);
		System.out.println("构造前:"+ json2.toJSONString());
		System.out.println("构造后:"+ structure(json2, "code", "parent", "children").toJSONString());
		
	}

	private static JSONObject structure(JSONArray array, String code, String parent, String children) {
		JSONObject currentObj = null;
		if(array.size() > 1) {
			//找到array中的根节点,移除，再找array中对应的子节点
			for(int i = 0 ;i < array.size(); i++) {
				currentObj = array.getJSONObject(i);
				if(currentObj.get(parent) == null || "".equals(currentObj.get(parent))) {
					array.remove(currentObj);
					setChildren(array, currentObj, code, parent, children);
					break;
				}
			}
		}
		
		return currentObj;
	}
	//找到当前节点的在array中的子节点,然后移除这些子节点,最后遍历子节点，在array中找子节点是否还有子节点
	private static void setChildren(JSONArray array,JSONObject currentParentObj, String code, String parent, String children) {
		if(array.size() >= 1) {
			for(int i = 0 ;i < array.size(); i++) {
				JSONObject currentObj = array.getJSONObject(i);
				if(currentObj.get(parent).equals(currentParentObj.get(code))) {
					//array.remove(currentObj); //执行当前移除后，会导致索引的元素少遍历一个，因为移除后索引会立即发生变化，导致for的i索引不到所有元素
					JSONArray childrenArr = currentParentObj.getJSONArray(children);
					if(childrenArr == null) {
						childrenArr = new JSONArray();
						currentParentObj.put(children, childrenArr);
					}
					childrenArr.add(currentObj);
				}
			}
			JSONArray currentChildrens = currentParentObj.getJSONArray(children);
			if(currentChildrens == null) return;
			//移除元素
			array.removeAll(currentChildrens);
			for(int i = 0 ;i < currentChildrens.size(); i++) {
				setChildren(array, currentChildrens.getJSONObject(i), code, parent, children);
			}
		}
		
	}
	
	private static JSONArray distinct(JSONArray array,String distinctKey) {
		JSONArray arrayTemp = new JSONArray();
		ArrayList<String> list_key_value = new ArrayList<String>();
		int num = 0;
		for(int i = 0; i< array.size(); i++) {
			JSONObject object = array.getJSONObject(i);
			if(!list_key_value.contains((String)object.get(distinctKey))) {
				list_key_value.add((String)object.get(distinctKey));
				arrayTemp.add(object);
			}
		}
		return arrayTemp;
	}
}
