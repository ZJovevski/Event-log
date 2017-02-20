package com.zoran.eventlog.EventLog.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.zoran.eventlog.EventLog.model.EventType;
import com.zoran.eventlog.EventLog.service.IEventController;

public class FileEventController implements IEventController {

	private String FILE_NAME = "log.txt";
	private long SIZE = 1024;

	public void log(EventType event) {
		writeToFile(event);

	}

	public void log(Timestamp time, String eventName, String actionDescription, String username) {
		EventType event = new EventType(time, eventName, actionDescription, username);
		writeToFile(event);
	}

	private void writeToFile(EventType event) {

		manageFiles();

		PrintWriter out = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILE_NAME, true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			out.println(event.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close(); // Will close bw and fw too
				} else if (bw != null) {
					bw.close(); // Will close fw too
				} else if (fw != null) {
					fw.close();
				} else {
					// Oh boy did it fail hard! :3
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * create files or backup files
	 */
	private void manageFiles() {
		try {
			File file = new File(FILE_NAME);
			if (!file.exists()) {
				file.createNewFile();
			}

			if (file.length() >= SIZE) {
				String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
				file.renameTo(new File(timeStamp + "_" + FILE_NAME));
				file.delete();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
