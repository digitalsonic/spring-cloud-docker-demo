FROM java:8
VOLUME /tmp
ADD target/spring-cloud-demo-advanced-client-0.0.1-SNAPSHOT.jar advanced-client.jar
EXPOSE 8082
RUN bash -c 'touch /advanced-client.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/advanced-client.jar"]
