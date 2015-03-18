package com.bcloud.utils;

import java.io.File;

import android.text.TextUtils;

public class Config {
	private static final String NAME = "bcloud";
	private static final String HOME_DIR = getExpanduser();
	private static final String CACHE_DIR = PathUtils.join(HOME_DIR, ".cache" , NAME);
	private static final String CONF_DIR = PathUtils.join(HOME_DIR, ".config", NAME);
	
	/**
	 * ��ȡϵͳ��SD������Ŀ¼.
	 */
	public static String getExpanduser() {
		return "";
	}
	
	/**
	 * ��ȡ����ʻ��Ļ���Ŀ¼, ���������, �ʹ�����
	 */
	public static String getCachePath() {
		return "";
	}
	
	/**
	 * ��ȡ����ʻ�����ʱ�ļ�Ŀ¼, ���Դ����֤��ͼƬ, �ϴ�ʱ���ļ���Ƭ��
	 */
	public static String getTmpPath() {
		return "";
	}
	
	/**
	 * ����, Ҫ����������Ŀ¼�ṹ
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
