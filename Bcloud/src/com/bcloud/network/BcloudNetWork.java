package com.bcloud.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.List;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

public class BcloudNetWork {

	/**
	 * 默认请求头信息.
	 */
	public static final Hashtable<String, String> DEFAULT_HEADERS = new Hashtable<String, String>() {
		{
			put("User-agent", "" + BcloudConstant.USER_AGENT);
			put("Referer", BcloudConstant.PAN_REFERER);
			// 'x-requested-with': 'XMLHttpRequest',
			put("'Accept", BcloudConstant.ACCEPT_JSON);
			put("Accept-language", "zh-cn, zh;q=0.5");
			put("Accept-encoding", "gzip, deflate");
			put("'Pragma", "no-cache");
			put("Cache-control", "no-cache");
		}
	};
	
	/**
	 * http get 请求.
	 */
	public static void doGet() {
		
	}
	
	/**
	 * http post 请求.
	 */
	public static void doPost(String url, Hashtable<String, String> headers, List<BasicNameValuePair> params) {
		Log.w(">><>>>>>", ">>><<<<<url:" + url + " params" + params);
		try {
			Hashtable<String, String> headersMerged = new Hashtable<String, String>(DEFAULT_HEADERS);
			/* 添加新的 headers 参数 */
			for(String key : headers.keySet()) {
				headersMerged.put(key, headers.get(key));
			}
			/* 初始化 httppost 的 header头信息 */
			HttpPost httpPost = new HttpPost(url);
			for (String key : headersMerged.keySet()) {
				httpPost.setHeader(key, headersMerged.get(key));
			}
			/* 初始化httpPost 请求 */         
			DefaultHttpClient httpClient = new DefaultHttpClient();
			/* 初始化 httppost 的 参数 */
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf-8");
			httpPost.setEntity(formEntity);
			/* 开始执行httpclient!! */
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode(); // 返回状态码.
			Log.w(">><>>>>>", ">>><<<<<statusCode:" + statusCode + "  " +  httpPost.getURI());
			HttpEntity responseEntity = httpResponse.getEntity();  
			Header encodingHeader = responseEntity.getContentEncoding();
			/* 处理返回数据 */
			if (encodingHeader != null) {
				String encoding = encodingHeader.getValue();
				HttpEntity responseHttpEntity = httpResponse.getEntity();
				InputStream instreams =responseHttpEntity.getContent();
				Log.w(">>>>>", "<<<<<<encoding:" + encoding);
				if (encoding.equalsIgnoreCase("gzip")) { // gzip格式.
					Log.w(">>>>>>>", "<<<<<<" + "out.toString();::::1111111111");
					ByteArrayOutputStream out= new ByteArrayOutputStream();
					GZIPInputStream gzipInput = new GZIPInputStream(instreams);
					byte[] buffer = new byte[1024];
					int offset = -1;
					while ((offset = gzipInput.read(buffer)) != -1) {
						out.write(buffer, 0, offset);
					}
					Log.w(">>>>>>>", "<<<<<<" + "out.toString();:::22222222:" + out.toString());
				} else if (encoding.equals("deflate")) { // 默认格式.
					new DeflaterInputStream(instreams);
				}
				return;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			Log.e(">>", "<<<<<clientprotocalExcetion:" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			Log.e(">>", "<<<<<IOexcetiopn: " + e.getMessage());
		} finally {
		}
	}
	
}

