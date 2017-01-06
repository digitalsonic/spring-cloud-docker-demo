package demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingServicesController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingServicesController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        logger.info("Someone is calling /hi/{}.", name);
        return "Hi " + name;
    }

    @RequestMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        logger.info("Someone is calling /greeting/{}.", name);
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return String.format("Hello %s from %s(%s:%s)", name,
                instance.getServiceId(), instance.getHost(),instance.getPort());
    }
}
