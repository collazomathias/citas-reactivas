package com.springBajo8.springBajo8;

import java.util.ArrayList;
import java.util.List;

import com.springBajo8.springBajo8.models.CitasReactivasModel;
import com.springBajo8.springBajo8.models.PadecimientosModel;
import com.springBajo8.springBajo8.services.CitasReactivasService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CitasReactivasControllerTest {
    
    @Autowired
    private CitasReactivasService citasReactivasService;
 
    @Test
    @DisplayName("Add new appointment")
    void AddNewCita() {
        CitasReactivasModel new_cita = new CitasReactivasModel("10", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-03-30", "0:24:50", "Normal", null);
        Mono<CitasReactivasModel> cita = citasReactivasService.save(new_cita);
        StepVerifier.create(cita).expectNext(new_cita);
    }

    @Test
    @DisplayName("Edit appointment status")
    void updateStatusById() {
        CitasReactivasModel new_cita = new CitasReactivasModel("6f16a794-2","1", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-03-30", "0:24:50", "Cancelada", null);
        Mono<CitasReactivasModel> cancelled_cita = citasReactivasService.updateStatusById("6f16a794-2");
        StepVerifier.create(cancelled_cita).expectNext(new_cita);
    }

    @Test
    @DisplayName("Get appointment by date and time")
    void getByDateTime() {
        CitasReactivasModel new_cita = new CitasReactivasModel("1", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-02-22", "0:24:50", "Reservada", null);
        Flux<CitasReactivasModel> cita = citasReactivasService.getByDateTime("2022-03-30", "0:24:50");
        StepVerifier.create(cita).expectNext(new_cita);
    }

    @Test
    @DisplayName("Get doctor by id")
    void getDoctorById() {
        CitasReactivasModel new_cita = new CitasReactivasModel("1", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-02-22", "0:24:50", "Reservada", null);
        Mono<CitasReactivasModel> doctor = citasReactivasService.getDoctorById("1");
        StepVerifier.create(doctor).expectNext(new_cita);
    }

    @Test
    @DisplayName("Get treatment by id")
    void getPadecimientoById() {
        List<PadecimientosModel> lista_padecimientos = new ArrayList<PadecimientosModel>(){
            { add(new PadecimientosModel("Estrés", "Mindfulness")); }
        };
        CitasReactivasModel new_cita = new CitasReactivasModel("1", "Emérito", "Fernández", "Pablo", "Gonzáles", "2022-02-22", "0:24:50", "Reservada", lista_padecimientos);
        Mono<List<PadecimientosModel>> padecimiento_obtained = citasReactivasService.getPadecimientoById("1");
        StepVerifier.create(padecimiento_obtained).expectNext(new_cita.getPadecimientos());
    }
    
}
