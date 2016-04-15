@echo off
rem
rem javac -g -Xlint -Xmaxerrs 2 -sourcepath src -classpath build;lib\servlet-api.jar
rem      -d C:\Archivos de programa\jakarta-tomcat-5.0.28\webapps\rvhotels\WEB-INF\classes
rem      src\app\%1.java
rem
rem @echo on
rem javac -g -Xlint -Xmaxerrs 2 -sourcepath src -classpath build;lib\servlet-api.jar -d C:\Archiv~1\jakarta-tomcat-5.0.28\webapps\testing\WEB-INF\classes src\app\%1.java
@echo on
javac -g -Xmaxerrs 3 -sourcepath src -classpath C:\Archiv~1\jakart~1.28\common\lib\servlet-api.jar -d C:\Archiv~1\jakarta-tomcat-5.0.28\webapps\sales_register\WEB-INF\classes src\%1.java
