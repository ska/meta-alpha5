#! /bin/sh

### BEGIN INIT INFO
# Provides:        domoticz
# Required-Start:  $network
# Required-Stop:   $network
# Default-Start:   2 3 4 5
# Default-Stop:
# Short-Description: Start DOMOTICZ daemon
### END INIT INFO

DAEMON=/home/domoticz/domoticz
PIDFILE=/var/run/domoticz.pid

test -x $DAEMON || exit 0

startdaemon(){
	echo -n "Starting domoticz "
	start-stop-daemon --start --quiet --oknodo --pidfile $PIDFILE --startas $DAEMON -- -u domoticz:domoticz "$@" &
	echo "done"
}
stopdaemon(){
	echo -n "Stopping domoticz "
	kill $(pidof domoticz)
	echo "done"
}

case "$1" in
  start)
	startdaemon
	;;
  stop)
  	stopdaemon
	;;
  force-reload)
  	stopdaemon
	startdaemon
	;;
  restart)
	stopdaemon
	startdaemon
	;;
  reload)
	stopdaemon
	startdaemon
	;;
  status)
	status $DAEMON;
	exit $?
	;;
  *)
	echo "Usage: ntpd { start | stop | status | restart | reload }" >&2
	exit 1
	;;
esac

exit 0
