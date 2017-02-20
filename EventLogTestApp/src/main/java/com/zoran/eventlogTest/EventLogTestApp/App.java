package com.zoran.eventlogTest.EventLogTestApp;

import java.sql.Timestamp;

import com.zoran.eventlog.EventLog.impl.FileEventController;
import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

public class App {
	public static void main(String[] args) {
		for (int i = 1; i < 20; i++) {
			IEventController eventLoggerFile = new FileEventController();
			Timestamp timestamp = Timestamp.valueOf("2027-02-20 10:10:10.0");
			EventType event = new EventType(timestamp, "EventName" + i, "action", "username");
			eventLoggerFile.log(event);
		}

	}
}
