package br.com.techis.simcardintegrator.controller;

import br.com.techis.simcardintegrator.service.SIMService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Douglas Souza on 05/04/2019
 */

@RestController
@Slf4j
@RequestMapping({"simcard"})
public class SIMController {
    private SIMService simService;

    @Autowired
    public SIMController(final SIMService simService) {
        this.simService = simService;
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        return this.simService.getAllSIMCard();
    }

}
