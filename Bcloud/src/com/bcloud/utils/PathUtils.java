package com.bcloud.utils;

import android.text.TextUtils;

public class PathUtils {
	/**
	 * 将目录名或者文件名连接起来.
	 * 
	 * @return - 返回 p1 + p2 + p3 连接起来的字符串.
	 */
	public static String join(String p1, String p2, String p3) {
		StringBuffer sb = new StringBuffer();
		if (TextUtils.isEmpty(p1))
			p1 = "";
		if (TextUtils.isEmpty(p2))
			p2 = "";
		if (TextUtils.isEmpty(p3))
			p3 = "";
		sb.append(p1);
		if (!(p1.endsWith("/") && p2.startsWith("/")))
			sb.append("/");
		sb.append(p2);
		if (!(p2.endsWith("/") && p3.startsWith("/")))
			sb.append("/");
		sb.append(p3);
		return sb.toString();
	}

	public static String join(String p1, String p2) {
		return join(p1, p2, null);
	}
}
