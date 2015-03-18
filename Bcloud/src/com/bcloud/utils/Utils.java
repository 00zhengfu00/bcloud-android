package com.bcloud.utils;

import java.util.Random;

/**
 * 一些常用函数.
 * 
 * @author hailongqiu 356752238@qq.comm
 *
 */
public class Utils {

	/**
	 * 用RSA加密字符串.
	 * --------------------------------
	 * @param pubKey - 公钥
	 * @param pass - 要加密的信息, 使用UTF-8编码的字符串
	 * @return - 使用base64编码的字符串
	 */
	public static String rsa2encrypt(String pubKey, String pass) {
		String p = "";
		return p;
	}
	
	/**
	 * @return - 返回当前的时间标记, 以毫秒为单位
	 */
	public static String getTimeStamp() {
		return Long.toString(System.currentTimeMillis());
	}
	
	private static final int MAX_RANDOM_NUM = 58535;
	private static final int MIN_RANDOM_NUM =  52000;
	
	/**
	 * ppui_ligintime 这个字段, 是一个随机数.
	 */
	public static String getPpuiLogintime() {
		return String.valueOf(Math.random()*(MAX_RANDOM_NUM - MIN_RANDOM_NUM) + MIN_RANDOM_NUM);
	}
}
