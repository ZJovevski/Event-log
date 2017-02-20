package com.zoran.eventlog.EventLog.model;

import java.sql.Timestamp;

public class EventType {
	private Timestamp time;
	private String eventName;
	private String actionDescription;
	private String username;

	public EventType(Timestamp time, String eventName, String actionDescription, String username) {
		this.time = time;
		this.eventName = eventName;
		this.actionDescription = actionDescription;
		this.username = username;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return time + "," + eventName + "," + actionDescription + "," + username;
	}

}
