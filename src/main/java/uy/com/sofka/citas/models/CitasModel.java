package uy.com.sofka.citas.models;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class CitasModel {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String idPaciente;

    private String nombrePaciente;

    private String apellidosPaciente;

    private String nombreMedico;

    private String apellidosMedico;

    private String fechaReservaCita;

    private String horaReservaCita;

    private String estadoReservaCita;

    private List<PadecimientosModel> padecimientos;

    public CitasModel(){}

    public CitasModel(String id, String idPaciente, String nombrePaciente, String apellidoPaciente, String nombreMedico, String apellidoMedico, String fechaReservaCita, String horaReservaCita, String estadoReservaCita, List<PadecimientosModel> padecimientos) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidosPaciente = apellidoPaciente;
        this.nombreMedico = nombreMedico;
        this.apellidosMedico = apellidoMedico;
        this.fechaReservaCita = fechaReservaCita;
        this.horaReservaCita = horaReservaCita;
        this.estadoReservaCita = estadoReservaCita;
    }

    public CitasModel(String idPaciente, String nombrePaciente, String apellidoPaciente, String nombreMedico, String apellidoMedico, String fechaReservaCita, String horaReservaCita, String estadoReservaCita, List<PadecimientosModel> padecimientos) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.apellidosPaciente = apellidoPaciente;
        this.nombreMedico = nombreMedico;
        this.apellidosMedico = apellidoMedico;
        this.fechaReservaCita = fechaReservaCita;
        this.horaReservaCita = horaReservaCita;
        this.estadoReservaCita = estadoReservaCita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidosPaciente() {
        return apellidosPaciente;
    }

    public void setApellidosPaciente(String apellidosPaciente) {
        this.apellidosPaciente = apellidosPaciente;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getApellidosMedico() {
        return apellidosMedico;
    }

    public void setApellidosMedico(String apellidosMedico) {
        this.apellidosMedico = apellidosMedico;
    }

    public String getFechaReservaCita() {
        return fechaReservaCita;
    }

    public void setFechaReservaCita(String fechaReservaCita) {
        this.fechaReservaCita = fechaReservaCita;
    }

    public String getHoraReservaCita() {
        return horaReservaCita;
    }

    public void setHoraReservaCita(String horaReservaCita) {
        this.horaReservaCita = horaReservaCita;
    }

    public String getEstadoReservaCita() {
        return estadoReservaCita;
    }

    public void setEstadoReservaCita(String estadoReservaCita) {
        this.estadoReservaCita = estadoReservaCita;
    }

    public List<PadecimientosModel> getPadecimientos() {
        return padecimientos;
    }

    public void setPadecimientos(List<PadecimientosModel> padecimientos) {
        this.padecimientos = padecimientos;
    }
    
}
