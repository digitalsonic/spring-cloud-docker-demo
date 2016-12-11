package demo.server.oauth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountInitializer implements CommandLineRunner {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void run(String... strings) throws Exception {
        accountRepository.save(new Account("digitalsonic", "password"));
    }
}
