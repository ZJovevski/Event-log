package com.zoran.eventlog.EventLog.main;

import java.sql.Timestamp;

import com.zoran.eventlog.EventLog.impl.DBEventController;
import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		for (int i = 1; i < 20; i++) {
			IEventController eventService = new DBEventController();
			Timestamp timestamp = Timestamp.valueOf("2027-02-20 10:10:10.0");
			EventType event = new EventType(timestamp, "EventName" + i, "action", "username");
			eventService.log(event);
		}

	}
}
