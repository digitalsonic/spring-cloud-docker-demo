package demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SpringCloudDemoServerApplication {
    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoServerApplication.class, args);
    }

    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return String.format("Hello %s from %s(%s:%s)", name,
                instance.getServiceId(), instance.getHost(),instance.getPort());
    }
}
