echo STARTING SERVER
export JAVA_HOME=/opt/devenv/java/jdk7/jdk1.7.0_75
echo $JAVA_HOME
nohup  $JAVA_HOME/bin/java -jar hcRestWebSB.jar >  /opt/logs/hc-rest-web.log & echo $!

echo SERVER STARTED