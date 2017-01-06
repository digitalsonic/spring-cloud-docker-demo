package demo.server.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SpringCloudDemoZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDemoZipkinServerApplication.class, args);
	}
}
