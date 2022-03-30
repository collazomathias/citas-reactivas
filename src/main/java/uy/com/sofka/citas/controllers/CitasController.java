package uy.com.sofka.citas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.citas.models.CitasModel;
import uy.com.sofka.citas.models.PadecimientosModel;
import uy.com.sofka.citas.services.CitasService;

@Api
@RestController
@CrossOrigin(origins = "*")
public class CitasController {
    
    @Autowired
    private CitasService citasService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<CitasModel> save(@RequestBody CitasModel citasModel) {
        return this.citasService.save(citasModel);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasModel>> delete(@PathVariable("id") String id) {
        return this.citasService.delete(id)
                .flatMap(citasModel -> Mono.just(ResponseEntity.ok(citasModel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<CitasModel>> update(@PathVariable("id") String id, @RequestBody CitasModel citasModel) {
        return this.citasService.update(id, citasModel)
                .flatMap(citasModel1 -> Mono.just(ResponseEntity.ok(citasModel)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<CitasModel> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.citasService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<CitasModel> findAll() {
        return this.citasService.findAll();
    }

    @PutMapping("/updateStatus/{id}")
    public Mono<CitasModel> updateStatusById(@PathVariable("id") String id) {
        return this.citasService.updateStatusById(id);
    }

    @GetMapping("/DateTime/{fecha}/{hora}")
    public Flux<CitasModel> getByDateTime(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
        return this.citasService.getByDateTime(fecha, hora);
    }

    @GetMapping("/getDoctorById/{id}")
    public Mono<CitasModel> getDoctorById(@PathVariable("id") String id) {
        return this.citasService.getDoctorById(id);
    }

    @GetMapping("/getPadecimientoById/{id}")
    public Mono<List<PadecimientosModel>> getPadecimientoById(@PathVariable("id") String id) {
        return this.citasService.getPadecimientoById(id);
    }

}
