package uy.com.sofka.citas.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import uy.com.sofka.citas.models.CitasModel;

public interface CitasRepository extends ReactiveMongoRepository<CitasModel, String> {
    Flux<CitasModel> findByIdPaciente(String idPaciente);
    Flux<CitasModel> findByFechaReservaCita(String fecha);
}
