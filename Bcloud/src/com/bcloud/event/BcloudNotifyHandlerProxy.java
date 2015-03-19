package com.bcloud.event;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.bcloud.event.BcloudNotifyEvent.Type;

/**
 * 代理模式
 * 
 * @author hailongqiu 356752238@qq.com
 *
 */
public class BcloudNotifyHandlerProxy implements BcloudNotifyListener {

	private Object proxyObject;
	private Map<BcloudNotifyEvent.Type, Method> methodMap;

	public BcloudNotifyHandlerProxy(Object proxyObject) {
		this.proxyObject = proxyObject;
		this.methodMap = new HashMap<BcloudNotifyEvent.Type, Method>();
		for (Method m : proxyObject.getClass().getDeclaredMethods()) {
			if (m.isAnnotationPresent(BcloudNotifyHandler.class)) {
				BcloudNotifyHandler handler = m
						.getAnnotation(BcloudNotifyHandler.class);
				this.methodMap.put(handler.value(), m);
				if (!m.isAccessible()) {
					m.setAccessible(true);
				}
			}
		}
	}

	@Override
	public void onNotifyEvent(BcloudNotifyEvent event) {
		Method m = methodMap.get(event.getType());
		if (m != null) {
			try {
				m.invoke(proxyObject, event);
			} catch (Throwable e) {
//				LOG.warn("invoke QQNotifyHandler Error!!", e);
			}
		} else {
//			LOG.warn("Not found QQNotifyHandler for QQNotifyEvent = " + event);
		}

	}

}
