package com.springBajo8.springBajo8.repositories;

import com.springBajo8.springBajo8.models.CitasReactivasModel;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CitasReactivasRepository extends ReactiveMongoRepository<CitasReactivasModel, String> {
    Flux<CitasReactivasModel> findByIdPaciente(String idPaciente);
    Flux<CitasReactivasModel> findByFechaReservaCita(String fecha);
}
