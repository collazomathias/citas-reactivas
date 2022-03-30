package com.springBajo8.springBajo8;

import com.springBajo8.springBajo8.models.CitasReactivasModel;
import com.springBajo8.springBajo8.services.CitasReactivasService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CitasReactivasControllerTest {
    
    @Autowired
    private CitasReactivasService citasReactivasService;
 
    @Test
    @DisplayName("Add new cita")
    void AddNewCita() {
        CitasReactivasModel cita = new CitasReactivasModel("10", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-03-30", "0:24:50", "Normal", null);
        Mono<CitasReactivasModel> citas = citasReactivasService.save(cita);
        StepVerifier.create(citas).expectNext(cita);
    }
    
}
