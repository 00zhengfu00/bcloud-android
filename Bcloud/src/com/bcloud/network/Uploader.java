package com.bcloud.network;


/**
 * 上传 - 普通上传，快速上传，分片上传 <br>
 * 	 event - 'uploaded' , 'network-error'，'disk-error'，'merge-files'，'slice-sent' <br>
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
	 * 一般上传模式. <br>
	 * 使用这种方式上传, 不可以中断上传过程, 但因为只用它来上传小的文件, 所以 最终的影响不会很大. <br>
	 */
	public void upload() {
		if (true) {
			this.mUploaderHandler .onUploaded();
		} else {
			this.mUploaderHandler.onNetWorkError();
		}
	}

	/**
	 * 快速上传 <br>
	 * 如果失败, 就自动调用分片上传. <br>
	 */
	public void rapidUpload() {

	}

	/**
	 * 分片上传 <br>
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
