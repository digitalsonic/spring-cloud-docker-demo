FROM java:8
VOLUME /tmp
ADD target/spring-cloud-demo-simple-client-0.0.1-SNAPSHOT.jar simple-client.jar
EXPOSE 8081
RUN bash -c 'touch /simple-client.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/simple-client.jar"]
