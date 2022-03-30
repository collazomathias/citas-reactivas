package com.springBajo8.springBajo8.services;

import java.util.List;

import com.springBajo8.springBajo8.models.CitasReactivasModel;
import com.springBajo8.springBajo8.models.PadecimientosModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CitasReactivasService {
    Mono<CitasReactivasModel> save(CitasReactivasModel citasDTOReactiva);

    Mono<CitasReactivasModel> delete(String id);

    Mono<CitasReactivasModel> update(String id, CitasReactivasModel citasDTOReactiva);

    Flux<CitasReactivasModel> findByIdPaciente(String idPaciente);

    Flux<CitasReactivasModel> findAll();

    Mono<CitasReactivasModel> findById(String id);

    Mono<CitasReactivasModel> updateStatusById(String id);

    Flux<CitasReactivasModel> getByDateTime(String fecha, String hora);

    Mono<CitasReactivasModel> getDoctorById(String id);

    Mono<List<PadecimientosModel>> getPadecimientoById(String id);
    
}
