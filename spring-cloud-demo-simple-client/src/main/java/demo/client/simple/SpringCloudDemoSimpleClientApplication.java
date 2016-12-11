package demo.client.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Client
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
	public String sayHi() {
		return restTemplate.getForObject("http://" + remote + "/hi/{name}",
				String.class, "digitalsonic");
	}

	@RequestMapping("/greeting")
	public String greeting() {
		return restTemplate.getForObject("http://" + remote + "/greeting/{name}",
				String.class, "digitalsonic");
	}

	@LoadBalanced
	@Bean
	public static OAuth2RestTemplate oauth2RestTemplate(ClientCredentialsResourceDetails details,
														OAuth2ClientContext oauth2ClientContext) {
		return new OAuth2RestTemplate(details, oauth2ClientContext);
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
