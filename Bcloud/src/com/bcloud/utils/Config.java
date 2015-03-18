package com.bcloud.utils;

import java.io.File;

import android.text.TextUtils;

public class Config {
	private static final String NAME = "bcloud";
	private static final String HOME_DIR = getExpanduser();
	private static final String CACHE_DIR = PathUtils.join(HOME_DIR, ".cache" , NAME);
	private static final String CONF_DIR = PathUtils.join(HOME_DIR, ".config", NAME);
	
	/**
	 * 获取系统的SD卡的主目录.
	 */
	public static String getExpanduser() {
		return "";
	}
	
	/**
	 * 获取这个帐户的缓存目录, 如果不存在, 就创建它
	 */
	public static String getCachePath() {
		return "";
	}
	
	/**
	 * 获取这个帐户的临时文件目录, 可以存放验证码图片, 上传时的文件分片等
	 */
	public static String getTmpPath() {
		return "";
	}
	
	/**
	 * 这里, 要创建基本的目录结构
	 */
	public static void checkFirstInitDir() {
		File confFile = new File(CONF_DIR);
		if (!confFile.exists()) {
			confFile.mkdirs();
		}
		File cacheFile = new File(CACHE_DIR);
		if (!cacheFile.exists()) {
			cacheFile.mkdirs();
		}
	}
	
}
