package com.zoran.eventlog.EventLog.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

public class DBEventController implements IEventController {

	public void log(EventType event) {
		writeToDB(event);

	}

	public void log(Timestamp time, String eventName, String actionDescription, String username) {
		EventType event = new EventType(time, eventName, actionDescription, username);
		writeToDB(event);
	}

	private void writeToDB(EventType event) {
		Connection connection = getConnection();

		PreparedStatement eventDB;
		try {

			connection.setAutoCommit(false);
			eventDB = connection.prepareStatement(
					"insert into event (time, eventName, actionDescription, username) values (?, ?, ?, ?)");

			eventDB.setTimestamp(1, event.getTime());
			eventDB.setString(2, event.getEventName());
			eventDB.setString(3, event.getActionDescription());
			eventDB.setString(4, event.getUsername());

			eventDB.executeUpdate();
			eventDB.close();
			connection.commit();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? " + "Include in your library path!");
			e.printStackTrace();
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/EventLog", "postgres",
					"postgre");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;

	}

}
