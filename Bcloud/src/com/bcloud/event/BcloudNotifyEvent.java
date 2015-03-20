package com.bcloud.event;

public class BcloudNotifyEvent extends BcloudEvent {
	private Type type;
	private Object target;

	public BcloudNotifyEvent(Type type, Object target) {
		this.type = type;
		this.target = target;
	}

	public Type getType() {
		return type;
	}

	public Object getTarget() {
		return target;
	}

	public enum Type {
		REQUEST_COOKIE,
		GET_BAIDUID,
		GET_TOKEN,
		GET_UBI,
		CHECK_LOGIN,
		PUBLIC_KEY,
		POST_LOGIN,
		/* µÇÂ½³É¹¦ */
		LOGIN_SUCCESS,
		/* ÍøÂç´íÎó */
		NET_ERROR;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "" + "[type=" + this.type
				+ " , target=" + this.target + "]";
	}

}
