#!/bin/bash

APP=HelloWorld-1.0-SNAPSHOT-jar-with-dependencies.jar
LOG=/appl/HelloWorld/logs/console_HelloWorld_`date +%Y%m%d`.txt
ERROR_LOG=/appl/HelloWorld/logs/error_HelloWorld_`date +%Y%m%d`.txt

start()
{
	java -jar $APP >> $LOG 2>>$ERROR_LOG || exit 1
}

startWithArgs()
{
	java -jar $APP || exit 1
}


start