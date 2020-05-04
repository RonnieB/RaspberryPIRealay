How to Install

You will need this HAT
https://keyestudio.com/keyestudio-4-channel-5v-relay-shield-module-for-arduino-uno-r3-p0140.html

1. install a new Rasbian OS
2. Install corect Country settings and connect to WiFi. User: pi Password: pi
3. Update Software
4. Run in terminal
    wget https://github.com/bell-sw/Liberica/releases/download/11.0.2/bellsoft-jdk11.0.2-linux-arm32-vfp-hflt.deb
5.  Install Java
    sudo apt-get install ./bellsoft-jdk11.0.2-linux-arm32-vfp-hflt.deb
6.  Set the defaults
    sudo update-alternatives --config javac
    sudo update-alternatives --config java
7.  Rasperry Configuration: Enable SSH
8.  run java -jar solar-parent-1.0-SNAPSHOT.jar &
    OR
    Create a script in /etc/init.d/start.sh that starts the sercvice
    chmod 775 start.sh
9.  sudo update-rc.d start.sh defaults

Connect a webbrowser to: http://"host":8080




