package com.springBajo8.springBajo8.models;

public class PadecimientosModel {
    
    private String padecimiento;
    private String tratamiento;

    public PadecimientosModel(){}

    public PadecimientosModel(String padecimiento, String tratamiento) {
        this.padecimiento = padecimiento;
        this.tratamiento = tratamiento;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
}
