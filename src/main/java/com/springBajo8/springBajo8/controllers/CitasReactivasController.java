package com.springBajo8.springBajo8.controllers;


import java.util.List;

import com.springBajo8.springBajo8.models.CitasReactivasModel;
import com.springBajo8.springBajo8.models.PadecimientosModel;
import com.springBajo8.springBajo8.services.CitasReactivasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CitasReactivasController {

    @Autowired
    private CitasReactivasService citasReactivasService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<CitasReactivasModel> save(@RequestBody CitasReactivasModel citasDTOReactiva) {
        return this.citasReactivasService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasReactivasModel>> delete(@PathVariable("id") String id) {
        return this.citasReactivasService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasReactivasModel>> update(@PathVariable("id") String id, @RequestBody CitasReactivasModel citasDTOReactiva) {
        return this.citasReactivasService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<CitasReactivasModel> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.citasReactivasService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<CitasReactivasModel> findAll() {
        return this.citasReactivasService.findAll();
    }

    @PutMapping("/updateStatus/{id}")
    public Mono<CitasReactivasModel> updateStatusById(@PathVariable("id") String id) {
        return this.citasReactivasService.updateStatusById(id);
    }

    @GetMapping("/DateTime/{fecha}/{hora}")
    public Flux<CitasReactivasModel> getByDateTime(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
        return this.citasReactivasService.getByDateTime(fecha, hora);
    }

    @GetMapping("/getDoctorById/{id}")
    public Mono<CitasReactivasModel> getDoctorById(@PathVariable("id") String id) {
        return this.citasReactivasService.getDoctorById(id);
    }

    @GetMapping("/getPadecimientoById/{id}")
    public Mono<List<PadecimientosModel>> getPadecimientoById(@PathVariable("id") String id) {
        return this.citasReactivasService.getPadecimientoById(id);
    }

}
