package com.bcloud.utils;

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
}
