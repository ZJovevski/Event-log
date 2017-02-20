
##Description

This is simple event logger library. Can be used for writing in files and postgresql database.


* [How to use](#how to use)
* [Download](#download)
* [Developer Instructions](#developer instructions)


##How to use
 1. add eventlog.jar into your project (as maven dependency or as external jar)
 2. create EventType object and populate all fields with values
 3. create eventlogservice from the IEventController
 4. you can use two implementations for logging
 
    ``` 
    IEventController eventLogger = new FileEventController(); 
    ```
    
	 or
   
   ```
 	 IEventController eventLogger = new DBEventController();
   ```
 5. call log method from the eventLogger controller with EventType object as parameter 
 
 ```
	Timestamp timestamp = Timestamp.valueOf("2027-02-20 10:10:10.0");
	EventType event = new EventType(timestamp, "EventName" + i, "action", "username");
	eventLogger.log(event);
   ```
   




##Download
* [eventlog.jar](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog.jar)
* [eventlog-sources](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog-sources.jar)
* [eventlog-jar-with-dependencies](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog-jar-with-dependencies.jar)








##Developers Instructions

 * Import EventLog project as existing maven project
 * Right click on the project Run As > Maven Build 
 * In goals add **package** and press run button
 * Into target folder will be created all needed jars




