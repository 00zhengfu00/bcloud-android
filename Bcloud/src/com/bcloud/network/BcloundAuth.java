package com.bcloud.network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import com.bcloud.utils.EncoderHelper;
import com.bcloud.utils.Utils;

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
	
	/**
	 * 登陆验证.
	 * 
	 * @param user - 登陆用户名
	 * @param pass - 使用RSA加密后的base64字符串
	 */
	public static void postLogin(String user, String pass) {
		/* 初始化请求地址 */
		String token = "token!!"	;
		String codestring = "";
		String verifycode = "";
		String rsakey = "";
		String url = BcloudConstant.PASSPORT_LOGIN;
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("staticpage", "https%3A%2F%2Fpassport.baidu.com%2Fstatic%2Fpasspc-account%2Fhtml%2Fv3Jump.html"));
		params.add(new BasicNameValuePair("charset", "UTF-8"));
		params.add(new BasicNameValuePair("token", token));
		params.add(new BasicNameValuePair("tpl", "pp"));
		params.add(new BasicNameValuePair("subpro", ""));
		params.add(new BasicNameValuePair("apiver", "v3"));
		params.add(new BasicNameValuePair("tt", Utils.getTimeStamp()));
		params.add(new BasicNameValuePair("codestring", codestring));
		params.add(new BasicNameValuePair("safeflg", "0"));
		params.add(new BasicNameValuePair("u", "http%3A%2F%2Fpassport.baidu.com%2F"));
		params.add(new BasicNameValuePair("isPhone", ""));
		params.add(new BasicNameValuePair("quick_user", "0"));
		params.add(new BasicNameValuePair("logintype", "basicLogin"));
		params.add(new BasicNameValuePair("logLoginType", "pc_loginBasic"));
		params.add(new BasicNameValuePair("idc", ""));
		params.add(new BasicNameValuePair("loginmerge", "true"));
		params.add(new BasicNameValuePair("username", EncoderHelper.encodeUriComponent(user)));
		params.add(new BasicNameValuePair("password", EncoderHelper.encodeUriComponent(pass)));
		params.add(new BasicNameValuePair("verifycode", verifycode));
		params.add(new BasicNameValuePair("mem_pass", verifycode));
		params.add(new BasicNameValuePair("rsakey", rsakey));
		params.add(new BasicNameValuePair("crypttype", "12"));
		params.add(new BasicNameValuePair("ppui_logintime", Utils.getPpuiLogintime()));
		params.add(new BasicNameValuePair("callback", "parent.bd__pcbs__28g1kg"));
		/* 初始化头 */
		Hashtable<String, String> headers = new Hashtable<String, String>();
		headers.put("Accept", BcloudConstant.ACCEPT_JSON);
		headers.put("Cookie", "" + COOKIE_STR);
		headers.put("Referer", "" + BcloudConstant.REFERER);
		/* post */
		BcloudNetWork.doPost(url, headers, params);
	}
	
	
	public static void getPublicKey() {
//		BcloudNetWork.doPost(url, headers, params);
	}
}
