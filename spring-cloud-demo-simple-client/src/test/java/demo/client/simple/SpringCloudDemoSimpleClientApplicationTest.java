package demo.client.simple;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.Runner.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.Runner;

@RunWith(SpringRunner.class)
@SpringBootTest("remote.server=localhost:12345")
public class SpringCloudDemoSimpleClientApplicationTest {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private SpringCloudDemoSimpleClientApplication app;

    private Runner runner;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        HttpServer server = httpServer(12345);
        server.response("Hi digitalsonic");
        runner = runner(server);
        runner.start();

        app.setRestTemplate(new RestTemplate()); // Bypass the @LoadBalanced one
    }

    @After
    public void tearDown() throws Exception {
        runner.stop();
    }

    @Test
    public void testRemoteGreeting() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi digitalsonic"));
    }
}