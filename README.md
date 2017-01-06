# spring-cloud-docker-demo

This is a small demo developed with ___Spring Boot & Spring Cloud___.

It will be deployed in some docker containers. The service discovery mechanism is providered by Consul.

The main technologies used by this demo:

* Spring Boot
* Spring Cloud
* Docker
* Consul
* OAuth 2.0

You will need a Consul server while running the demo. eg.

```
docker run -d -p 8500:8500 -P progrium/consul -server -bootstrap -ui-dir /ui
```