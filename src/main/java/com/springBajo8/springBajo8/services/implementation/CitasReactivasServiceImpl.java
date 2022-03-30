package com.springBajo8.springBajo8.services.implementation;

import java.util.List;

import com.springBajo8.springBajo8.models.CitasReactivasModel;
import com.springBajo8.springBajo8.models.PadecimientosModel;
import com.springBajo8.springBajo8.repositories.CitasReactivasRepository;
import com.springBajo8.springBajo8.services.CitasReactivasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CitasReactivasServiceImpl implements CitasReactivasService {

    @Autowired
    private CitasReactivasRepository citasReactivasRepository;

    @Override
    public Mono<CitasReactivasModel> save(CitasReactivasModel citasDTOReactiva) {
        return this.citasReactivasRepository.save(citasDTOReactiva);
    }

    @Override
    public Mono<CitasReactivasModel> delete(String id) {
        return this.citasReactivasRepository
                .findById(id)
                .flatMap(p -> this.citasReactivasRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<CitasReactivasModel> update(String id, CitasReactivasModel citasDTOReactiva) {
        return this.citasReactivasRepository.findById(id)
                .flatMap(citasDTOReactiva1 -> {
                    citasDTOReactiva.setId(id);
                    return save(citasDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasReactivasModel> findByIdPaciente(String idPaciente) {
        return this.citasReactivasRepository.findByIdPaciente(idPaciente);
    }


    @Override
    public Flux<CitasReactivasModel> findAll() {
        return this.citasReactivasRepository.findAll();
    }

    @Override
    public Mono<CitasReactivasModel> findById(String id) {
        return this.citasReactivasRepository.findById(id);
    }

    @Override
    public Mono<CitasReactivasModel> updateStatusById(String id) {
        return this.citasReactivasRepository.findById(id)
                .flatMap(citasModel1 -> {
                    citasModel1.setEstadoReservaCita("Cita cancelada");
                    return save(citasModel1);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasReactivasModel> getByDateTime(String fecha, String hora) {
        return this.citasReactivasRepository.findByFechaReservaCita(fecha)
                .filter(cita -> cita.getHoraReservaCita().equals(hora))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CitasReactivasModel> getDoctorById(String id) {
        return this.citasReactivasRepository.findById(id)
                .flatMap(citasModel1 -> {
                      CitasReactivasModel newCitasModel = new CitasReactivasModel();
                      newCitasModel.setNombreMedico(citasModel1.getNombreMedico());
                      newCitasModel.setApellidosMedico(citasModel1.getApellidosMedico());
                      return Mono.just(newCitasModel);
                  }
                )
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<List<PadecimientosModel>> getPadecimientoById(String id) {
        return this.citasReactivasRepository.findById(id)
                .flatMap(cita -> Mono.just(cita.getPadecimientos()))
                .switchIfEmpty(Mono.empty());
    }
    
}
