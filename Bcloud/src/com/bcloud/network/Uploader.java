package com.bcloud.network;


/**
 * �ϴ� - ��ͨ�ϴ��������ϴ�����Ƭ�ϴ� <br>
 * 	 event - 'uploaded' , 'network-error'��'disk-error'��'merge-files'��'slice-sent' <br>
 */
public class Uploader extends Thread {

	UploaderHandler mUploaderHandler;
	
	public Uploader() {
	}

	@Override
	public void run() {
		super.run();
	}

	public void pause() {
	}

	public void checkExists() {

	}

	/**
	 * һ���ϴ�ģʽ. <br>
	 * ʹ�����ַ�ʽ�ϴ�, �������ж��ϴ�����, ����Ϊֻ�������ϴ�С���ļ�, ���� ���յ�Ӱ�첻��ܴ�. <br>
	 */
	public void upload() {
		if (true) {
			this.mUploaderHandler .onUploaded();
		} else {
			this.mUploaderHandler.onNetWorkError();
		}
	}

	/**
	 * �����ϴ� <br>
	 * ���ʧ��, ���Զ����÷�Ƭ�ϴ�. <br>
	 */
	public void rapidUpload() {

	}

	/**
	 * ��Ƭ�ϴ� <br>
	 */
	public void sliceUpload() {

	}
	
	public void setOnUploaderListener(UploaderHandler uploaderHandler) {
		this.mUploaderHandler = uploaderHandler;
	}
	
	public static interface UploaderHandler {
		public void onUploaded();
		public void onMergeFiles();
		public void onSliceSent();
		public void onDiskError();
		public void onNetWorkError();
	}
	
	public static class UploaderListener implements UploaderHandler {

		@Override
		public void onUploaded() {
		}

		@Override
		public void onMergeFiles() {
		}

		@Override
		public void onSliceSent() {
		}

		@Override
		public void onDiskError() {
		}

		@Override
		public void onNetWorkError() {
		}
	}
	
}
