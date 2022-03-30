package uy.com.sofka.citas.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.citas.models.CitasModel;

public interface CitasService {
    Mono<CitasModel> save(CitasModel citasModel);

    Mono<CitasModel> delete(String id);

    Mono<CitasModel> update(String id, CitasModel citasModel);

    Flux<CitasModel> findByIdPaciente(String idPaciente);

    Flux<CitasModel> findAll();

    Mono<CitasModel> findById(String id);
}
