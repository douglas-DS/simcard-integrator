package br.com.techis.simcardintegrator;

import br.com.techis.simcardintegrator.service.SIMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SimcardIntegratorApplication implements CommandLineRunner {
    @Autowired
    private SIMService simService;

    public static void main(String[] args) {
        SpringApplication.run(SimcardIntegratorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        simService.sendSimCardToRestService();
        log.info("Response: All SIM card posted");
    }
}
