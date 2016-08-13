package demo.client.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@RestController
public class SpringCloudDemoAdvancedClientApplication {
    @Autowired
    private GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoAdvancedClientApplication.class, args);
    }

    @RequestMapping("/")
    public String remoteGreeting() {
        return greetingService.getGreeting();
    }
}
