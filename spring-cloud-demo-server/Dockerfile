FROM java:8
VOLUME /tmp
ADD target/spring-cloud-demo-server-0.0.1-SNAPSHOT.jar server.jar
EXPOSE 8080
RUN bash -c 'touch /server.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/server.jar"]
