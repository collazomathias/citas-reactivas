package uy.com.sofka.citas.services.implementation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uy.com.sofka.citas.models.CitasModel;
import uy.com.sofka.citas.models.PadecimientosModel;
import uy.com.sofka.citas.repositories.CitasRepository;
import uy.com.sofka.citas.services.CitasService;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    private CitasRepository citasRepository;

    @Override
    public Mono<CitasModel> save(CitasModel citasModel) {
        return this.citasRepository.save(citasModel);
    }

    @Override
    public Mono<CitasModel> delete(String id) {
        return this.citasRepository
                .findById(id)
                .flatMap(p -> this.citasRepository.deleteById(p.getId()).thenReturn(p));

    }

    @Override
    public Mono<CitasModel> update(String id, CitasModel citasModel) {
        return this.citasRepository.findById(id)
                .flatMap(citasModel1 -> {
                    citasModel.setId(id);
                    return save(citasModel);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasModel> findByIdPaciente(String idPaciente) {
        return this.citasRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public Flux<CitasModel> findAll() {
        return this.citasRepository.findAll();
    }

    @Override
    public Mono<CitasModel> findById(String id) {
        return this.citasRepository.findById(id);
    }

    @Override
    public Mono<CitasModel> updateStatusById(String id) {
        return this.citasRepository.findById(id)
                .flatMap(citasModel1 -> {
                    citasModel1.setEstadoReservaCita("Cita cancelada");
                    return save(citasModel1);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<CitasModel> getByDateTime(LocalDate fecha, LocalTime hora) {
        return this.citasRepository.findByFechaReservaCita(fecha)
                .filter(cita -> cita.getHoraReservaCita().equals(hora.toString()))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<CitasModel> getDoctorById(String id) {
        return this.citasRepository.findById(id)
                .flatMap(citasModel1 -> {
                      CitasModel newCitasModel = new CitasModel();
                      newCitasModel.setNombreMedico(citasModel1.getNombreMedico());
                      newCitasModel.setApellidosMedico(citasModel1.getApellidosMedico());
                      return Mono.just(newCitasModel);
                  }
                )
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<List<PadecimientosModel>> getPadecimientoById(String id) {
        return this.citasRepository.findById(id)
                .flatMap(cita -> Mono.just(cita.getPadecimientos()))
                .switchIfEmpty(Mono.empty());
    }

}
