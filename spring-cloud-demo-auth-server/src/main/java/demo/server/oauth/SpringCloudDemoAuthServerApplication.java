package demo.server.oauth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudDemoAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoAuthServerApplication.class, args);
    }

    @RequestMapping(value = "/user")
    public Principal principal(Principal p) {
        return p;
    }
}
