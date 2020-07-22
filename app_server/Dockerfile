# we are extending everything from tomcat:8.0 image ...
FROM tomcat:9.0-jdk12-openjdk-oracle
MAINTAINER Tom Batchelor
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY target/Cars_Sample_App.war /usr/local/tomcat/webapps/

# Added to support Redisson, it can't pull these from WEB-APP/lib for some reason
COPY target/Cars_Sample_App/WEB-INF/lib/jackson-core-2.9.10.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/jackson-dataformat-yaml-2.9.10.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/jackson-annotations-2.9.9.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/jackson-databind-2.9.9.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/redisson-3.11.5.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/redisson-tomcat-8-3.11.5.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/snakeyaml-1.23.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-buffer-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-codec-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-codec-dns-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-common-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-handler-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-resolver-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-resolver-dns-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/netty-transport-4.1.42.Final.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/slf4j-api-1.7.25.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/fst-2.57.jar /usr/local/tomcat/lib/
COPY target/Cars_Sample_App/WEB-INF/lib/objenesis-2.5.1.jar /usr/local/tomcat/lib/

COPY opentelemetry-javaagent-all.jar /usr/local/tomcat/

# This set if the leak short circuits to no-op or not
ENV LEAKING=FALSE

# Added for OpenTelemetry testing
ENV OTA_EXPORTER=zipkin
ENV OTEL_ZIPKIN_ENDPOINT="http://proxy.observe.svc.cluster.local:9411/api/v2/spans"
ENV OTEL_ZIPKIN_SERVICE_NAME=tomcatOpenTelemetry

# Java Opts for DB Connection
COPY setenv.sh /usr/local/tomcat/bin