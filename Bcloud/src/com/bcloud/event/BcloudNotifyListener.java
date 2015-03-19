package com.bcloud.event;

/**
 * 百度网盘事件监听器
 * 
 * @author hailongqiu 356752238@qq.com
 *
 */
public interface BcloudNotifyListener {
	public void onNotifyEvent(BcloudNotifyEvent event);
}
