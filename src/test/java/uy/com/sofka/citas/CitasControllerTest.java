package uy.com.sofka.citas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import uy.com.sofka.citas.models.CitasModel;
import uy.com.sofka.citas.services.CitasService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CitasControllerTest {
    
    @Autowired
    private CitasService service;
 
    @Test
    @DisplayName("Add new cita")
    void AddNewCita() {
        CitasModel cita = new CitasModel("10", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-03-30", "0:24:50", "Normal", null);
        Mono<CitasModel> citas = service.save(cita);
        StepVerifier.create(citas).expectNext(cita);
    }

}
