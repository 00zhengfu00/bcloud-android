package com.bcloud.utils;

import android.text.TextUtils;

public class StringUtils {
	
	public static String join(String[] strArray) {
		StringBuffer sb = new StringBuffer();
		for (String s : strArray) {
			if (!TextUtils.isEmpty(s))
				sb.append(s);
		}
		return sb.toString();
	}

}
