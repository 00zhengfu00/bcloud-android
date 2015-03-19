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
