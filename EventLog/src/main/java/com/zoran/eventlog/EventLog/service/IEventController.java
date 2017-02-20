package com.zoran.eventlog.EventLog.service;

import java.sql.Timestamp;

import com.zoran.eventlog.EventLog.model.EventType;

public interface IEventController {

	public void log(EventType event);
	
	public void log (Timestamp time, String eventName, String actionDescription, String username);
}
