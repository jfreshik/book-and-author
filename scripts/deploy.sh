#!/bin/bash

DEPLOY_DIR=/home/ec2-user/app/deploy
APP_NAME=book-and-author

CURRENT_PID=$(pgrep -f ${APP_NAME}*.jar)

echo "> CURRENT PID: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
        echo "> not running"
else
        echo "> kill -15 $CURRENT_ID"
        kill -15 $CURRENT_PID
        sleep 5
fi

echo "> Deploy App"

cd $DEPLOY_DIR
unzip ${APP_NAME}.zip
nohup java -jar $APP_NAME.jar > /dev/null 2> /dev/null < /dev/null &
