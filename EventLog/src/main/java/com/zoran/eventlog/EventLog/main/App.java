package com.zoran.eventlog.EventLog.main;

import java.sql.Timestamp;

import com.zoran.eventlog.EventLog.impl.DBEventController;
import com.zoran.eventlog.EventLog.impl.MailEventController;
import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		LogInFile();

	}

	private static void LogInDB() {
		for (int i = 1; i < 20; i++) {
			IEventController eventService = new DBEventController();
			Timestamp timestamp = Timestamp.valueOf("2017-02-20 10:10:10.0");
			EventType event = new EventType(timestamp, "EventName", "action", "username");
			eventService.log(event);
		}
	}

	private static void LogInFile() {
		for (int i = 1; i < 20; i++) {
			IEventController eventService = new DBEventController();
			Timestamp timestamp = Timestamp.valueOf("2017-02-20 10:10:10.0");
			EventType event = new EventType(timestamp, "EventName", "action", "username");
			eventService.log(event);
		}
	}

	public static void sendMail() {
		IEventController eventService = new MailEventController();
		Timestamp timestamp = Timestamp.valueOf("2017-02-20 10:10:10.0");
		EventType event = new EventType(timestamp, "EventName", "action", "username");
		eventService.log(event);
	}
}
