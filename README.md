
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
     EventType event = new EventType(timestamp, "EventName" + i, "action", "username");
	 eventLoggerFile.log(event);
   ```
   




##Download
* [eventlog.jar](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog.jar)
* [eventlog-sources](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog-sources.jar)
* [eventlog-jar-with-dependencies](https://github.com/ZJovevski/Event-log/blob/master/jars/eventlog-jar-with-dependencies.jar)




