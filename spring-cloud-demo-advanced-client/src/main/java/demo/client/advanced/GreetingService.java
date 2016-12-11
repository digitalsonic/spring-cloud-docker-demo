package demo.client.advanced;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GreetingService {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private DemoClient demoClient;

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    public String sayHi() {
        return demoClient.hi("digitalsonic");
    }

    @HystrixCommand(fallbackMethod = "getDefaultGreeting")
    public String greeting() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
        return demoClient.greeting(instance.getServiceId());
    }

    public String getDefaultGreeting() {
        return "Fallback";
    }
}
