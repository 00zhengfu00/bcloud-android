package com.bcloud.network;

import java.util.HashMap;
import java.util.List;

/**
 * ΪSimpleCookie()�������һ���µķ���, �������cookieֵ���Ϊhttp <br>
 * request header������ֶ�. <br>
 * cookie : <name>=<value>[;<name>=<value>]... ...
 */
public class RequestCookie extends HashMap<String, String>{
	
	
	public RequestCookie() {
	}
	
	/**
	 * ֻ���cookie��key-value�ִ�. <br>
     * ����: HISTORY=21341; PHPSESSION=3289012u39jsdijf28; token=233129 <br>
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
	 * ��ȡһ����cookie, ���������Ϊ�ַ���
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
