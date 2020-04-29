#! /bin/sh
### BEGIN INIT INFO
# Provides: Java
# Required-Start: $syslog
# Required-Stop: $syslog
# Default-Start: 2 3 4 5
# Default-Stop: 0 1 6
# Short-Description: Java server
# Description: Start server for controling relays.
### END INIT INFO
 
case "$1" in
    start)
        echo "Java is starting"
        # Starting Programm
        /usr/bin/java -version &> /home/pi/startlog
	    /usr/bin/java -jar /home/pi/solar-parent-1.0-SNAPSHOT.jar &>/home/pi/startlog &
        ;;
    stop)
        echo "Java is ending"
        # Ending Programm
        killall java
        ;;
    *)
        echo "Use: /etc/init.d/start.sh {start|stop}"
        exit 1
        ;;
esac

exit 0
