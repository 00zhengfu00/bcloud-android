package com.bcloud.utils;

import java.util.Random;

/**
 * һЩ���ú���.
 * 
 * @author hailongqiu 356752238@qq.comm
 *
 */
public class Utils {

	/**
	 * ��RSA�����ַ���.
	 * --------------------------------
	 * @param pubKey - ��Կ
	 * @param pass - Ҫ���ܵ���Ϣ, ʹ��UTF-8������ַ���
	 * @return - ʹ��base64������ַ���
	 */
	public static String rsa2encrypt(String pubKey, String pass) {
		String p = "";
		return p;
	}
	
	/**
	 * @return - ���ص�ǰ��ʱ����, �Ժ���Ϊ��λ
	 */
	public static String getTimeStamp() {
		return Long.toString(System.currentTimeMillis());
	}
	
	private static final int MAX_RANDOM_NUM = 58535;
	private static final int MIN_RANDOM_NUM =  52000;
	
	/**
	 * ppui_ligintime ����ֶ�, ��һ�������.
	 */
	public static String getPpuiLogintime() {
		return String.valueOf(Math.random()*(MAX_RANDOM_NUM - MIN_RANDOM_NUM) + MIN_RANDOM_NUM);
	}
}
