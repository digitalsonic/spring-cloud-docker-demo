package demo.client.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SpringCloudDemoSimpleClientApplication {
	@Autowired
	private RestTemplate restTemplate;
	@Value("${remote.server:spring-cloud-demo-server}")
	private String remote;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDemoSimpleClientApplication.class, args);
	}

	@RequestMapping("/")
	public String remoteGreeting() {
		return restTemplate.getForObject("http://" + remote + "/hi/{name}",
				String.class, "digitalsonic");
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
