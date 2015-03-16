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
	 * Ĭ������ͷ��Ϣ.
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
	 * http get ����.
	 */
	public static void doGet() {
		
	}
	
	/**
	 * http post ����.
	 */
	public static void doPost(String url, Hashtable<String, String> headers, List<BasicNameValuePair> params) {
		Log.w(">><>>>>>", ">>><<<<<url:" + url + " params" + params);
		try {
			Hashtable<String, String> headersMerged = new Hashtable<String, String>(DEFAULT_HEADERS);
			/* ����µ� headers ���� */
			for(String key : headers.keySet()) {
				headersMerged.put(key, headers.get(key));
			}
			/* ��ʼ�� httppost �� headerͷ��Ϣ */
			HttpPost httpPost = new HttpPost(url);
			for (String key : headersMerged.keySet()) {
				httpPost.setHeader(key, headersMerged.get(key));
			}
			/* ��ʼ��httpPost ���� */         
			DefaultHttpClient httpClient = new DefaultHttpClient();
			/* ��ʼ�� httppost �� ���� */
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf-8");
			httpPost.setEntity(formEntity);
			/* ��ʼִ��httpclient!! */
			HttpResponse httpResponse = httpClient.execute(httpPost);
			int statusCode = httpResponse.getStatusLine().getStatusCode(); // ����״̬��.
			Log.w(">><>>>>>", ">>><<<<<statusCode:" + statusCode + "  " +  httpPost.getURI());
			HttpEntity responseEntity = httpResponse.getEntity();  
			Header encodingHeader = responseEntity.getContentEncoding();
			/* ���������� */
			if (encodingHeader != null) {
				String encoding = encodingHeader.getValue();
				HttpEntity responseHttpEntity = httpResponse.getEntity();
				InputStream instreams =responseHttpEntity.getContent();
				Log.w(">>>>>", "<<<<<<encoding:" + encoding);
				if (encoding.equalsIgnoreCase("gzip")) { // gzip��ʽ.
					Log.w(">>>>>>>", "<<<<<<" + "out.toString();::::1111111111");
					ByteArrayOutputStream out= new ByteArrayOutputStream();
					GZIPInputStream gzipInput = new GZIPInputStream(instreams);
					byte[] buffer = new byte[1024];
					int offset = -1;
					while ((offset = gzipInput.read(buffer)) != -1) {
						out.write(buffer, 0, offset);
					}
					Log.w(">>>>>>>", "<<<<<<" + "out.toString();:::22222222:" + out.toString());
				} else if (encoding.equals("deflate")) { // Ĭ�ϸ�ʽ.
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

