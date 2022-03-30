package uy.com.sofka.citas.services;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.citas.models.CitasModel;
import uy.com.sofka.citas.models.PadecimientosModel;

public interface CitasService {
    
    Mono<CitasModel> save(CitasModel citasModel);

    Mono<CitasModel> delete(String id);

    Mono<CitasModel> update(String id, CitasModel citasModel);

    Flux<CitasModel> findByIdPaciente(String idPaciente);

    Flux<CitasModel> findAll();

    Mono<CitasModel> findById(String id);

    Mono<CitasModel> updateStatusById(String id);

    Flux<CitasModel> getByDateTime(String fecha, String hora);

    Mono<CitasModel> getDoctorById(String id);

    Mono<List<PadecimientosModel>> getPadecimientoById(String id);

}
