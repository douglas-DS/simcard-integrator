package br.com.techis.simcardintegrator.service;

import br.com.techis.simcardintegrator.model.SIMCard;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Douglas Souza on 05/04/2019
 */

@Service
@Slf4j
public class SIMService {

    private static final String URL = "http://rtp.sosway.net.br:8080/api/v1/integration/simcard";
    private static final String filePath = "src/main/resources/static/SIMControl-OI.csv";

    public ResponseEntity<List<SIMCard>> getAllSIMCard() {
        log.info("Listing all numbers and iccid");
        return ResponseEntity.ok(this.returnFileAsList());
    }

    public void sendSimCardToRestService() {
        RestTemplate restTemplate = new RestTemplate();
        List<SIMCard> list = this.returnFileAsList();
        
        if (!list.isEmpty()) {
            list.forEach((card) -> {
                try {
                    restTemplate.postForObject(URL, card, SIMCard.class);
                    log.info("Inserting SIM card..: " + card);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        }
        log.info("List is empty!");
    }

    private List<SIMCard> returnFileAsList() {
        String divisor = ";";
        List<SIMCard> simCardList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;
            
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(divisor);
                
                String number = data[data.length - 2];
                String iccid = data[data.length - 1];
                
                if (number != null && iccid != null) {
                    simCardList.add(new SIMCard(number, iccid));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return simCardList;
    }
}
