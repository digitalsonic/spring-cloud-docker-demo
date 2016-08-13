package demo.client.advanced;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient("spring-cloud-demo-server")
public interface DemoClient {

    @RequestMapping("/greeting/{name}")
    @ResponseBody
    String greeting(@PathVariable("name") String name);
}
