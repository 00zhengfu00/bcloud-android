package com.bcloud;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.bcloud.event.BcloudNotifyEvent;
import com.bcloud.event.BcloudNotifyHandler;
import com.bcloud.event.BcloudNotifyHandlerProxy;
import com.bcloud.network.BcloudConstant;
import com.bcloud.network.BcloundAuth;
import com.bcloud.network.ErrorMsg;
import com.bcloud.network.RequestCookie;
import com.loopj.android.http.AsyncHttpClient;

public class MainActivity extends Activity {
	
	BcloudNotifyHandlerProxy mBcloudNotifyHandlerProxy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.button1);
		mBcloudNotifyHandlerProxy = new BcloudNotifyHandlerProxy(this);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new LoginAsyncTask().execute(BcloudConstant.REFERER);
				Log.e(">>>>", ">>>.cookie: " + new RequestCookie().headerOutput());
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@BcloudNotifyHandler(BcloudNotifyEvent.Type.LOGIN_SUCCESS)
	public void loginSuccess(BcloudNotifyEvent event) {
		Log.e(">>>>>>", ">>>>>>type:" + event.getType() + "登陆成功了！！畜生!!");
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	class LoginAsyncTask extends AsyncTask<String, String, String> {
		
		@Override
		protected String doInBackground(String... params) {
			BcloundAuth.postLogin("hailongqiu", "123456");
			
//			try {
//				HttpClient client = new DefaultHttpClient();
//				HttpPost get = new HttpPost(params[0]);
//				HttpResponse response = client.execute(get);
//				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//					HttpEntity entity = response.getEntity();
//					InputStream is = entity.getContent();
//					long total = entity.getContentLength();
//					ByteArrayOutputStream baos = new ByteArrayOutputStream();
//					byte[] buf = new byte[1024];
//					int count = 0;
//					int length = -1;
//					while ((length = is.read(buf)) != -1) {
//						baos.write(buf, 0, length);
//						count += length;
//						// 调用publishProgress公布进度,最后onProgressUpdate方法将被执行
//						publishProgress(String
//								.valueOf((int) ((count / (float) total) * 100)));
//						// 为了演示进度,休眠500毫秒
//						Thread.sleep(500);
//					}
//					return new String(baos.toByteArray(), "gb2312");
//				}
//			} catch (Exception e) {
//				Log.e(">>>>", e.getMessage());
//			}

			return null;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			Log.i(">>>>>>>", "onPreExecute() called" + values[0]);
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(String result) {
			mBcloudNotifyHandlerProxy.onNotifyEvent(new BcloudNotifyEvent(BcloudNotifyEvent.Type.LOGIN_SUCCESS, "登陆成功!!"));
			Log.i(">>>>>>>", "onPreExecute() called" + result);
		}
	}

}
