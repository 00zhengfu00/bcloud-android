package com.bcloud.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncoderHelper {

	
	public static String encodeUriComponent(String s) {
		return URLEncoder.encode(s);
	}
	
}
