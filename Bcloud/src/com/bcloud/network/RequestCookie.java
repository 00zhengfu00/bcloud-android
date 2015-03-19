package com.bcloud.network;

import java.util.HashMap;
import java.util.List;

/**
 * 为SimpleCookie()类加入了一个新的方法, 将里面的cookie值输出为http <br>
 * request header里面的字段. <br>
 * cookie : <name>=<value>[;<name>=<value>]... ...
 */
public class RequestCookie extends HashMap<String, String>{
	
	
	public RequestCookie() {
	}
	
	/**
	 * 只输出cookie的key-value字串. <br>
     * 比如: HISTORY=21341; PHPSESSION=3289012u39jsdijf28; token=233129 <br>
	 */
	public String headerOutput() {
		StringBuffer resultBuffer = new StringBuffer();
		for (String key : this.keySet()) {
			String r = "; ";
			resultBuffer.append(key + "=" + this.get(key) + r);
		}
		String resultStr = resultBuffer.toString();
		return resultStr.substring(0, resultStr.length() - 2);
	}
	
	/**
	 * 获取一部分cookie, 并将它输出为字符串
	 */
	public void subOutPut() {
		
	}
	
	public void loadList(List<String> rawItems) {
		if (rawItems == null)
			return;
		for (String item : rawItems) {
			
		}
	}
	
	@Override
	public String toString() {
		return headerOutput();
	}
	
}
