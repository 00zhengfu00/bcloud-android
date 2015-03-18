package com.bcloud.network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

/**
 * 这个模块主要是用于从百度服务器取得cookie/token授权.
 */
public class BcloundAuth {
	
	private static final String COOKIE_STR = "UBI=fi_PncwhpxZ%7ETaJc-94JnnEMVWsfG3c92yd; PANWEB=1; BAIDUID=44F532807CEEC06FC27DBE5CD8132BE3:FG=1; PASSID=BBfIjO; cflag=65535%3A1; HOSUPPORT=1";
	
	public static void checkLogin(String userName) {
		String url = BcloudConstant.PASSPORT_LOGIN;
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("logincheck", ""));
		params.add(new BasicNameValuePair("token", "" + "c95118f8871d467ba76f3ffda0d16daa"));
		params.add(new BasicNameValuePair("tpl", "mm"));
		params.add(new BasicNameValuePair("apiver", "v3"));
		params.add(new BasicNameValuePair("tt", "" + "1426467373003"));
		try {
			params.add(new BasicNameValuePair("username", "" + URLDecoder.decode("loveparadise80", "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		params.add(new BasicNameValuePair("isphone", "false"));
		Hashtable<String, String> headers = new Hashtable<String, String>();
		headers.put("Cookie", "" + COOKIE_STR);
		headers.put("Referer", "" + BcloudConstant.REFERER);
		BcloudNetWork.doPost(url, headers, params);
	}
	
	public static void getToken() {
		
	}
	
	private static final String STATICPAGE_URL = "https://passport.baidu.com/static/passpc-account/html/v3Jump.html";
	
	/**
	 * 登陆验证.
	 * 
	 * @param user - 登陆用户名
	 * @param pass - 使用RSA加密后的base64字符串
	 */
	public static void postLogin(String user, String pass) {
		String url = BcloudConstant.PASSPORT_LOGIN;
		url += "staticpage=" + STATICPAGE_URL ;
//		url 
	}
	
	
	public static void getPublicKey() {
//		BcloudNetWork.doPost(url, headers, params);
	}
}
