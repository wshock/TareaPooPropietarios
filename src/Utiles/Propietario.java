package Utiles;

import Utiles.Persona;

public class Propietario extends Persona {
    private String id_Propietario;
    public Propietario(String nombres, String apellidos, String documento, int edad, String id_Propietario) {
        super(nombres, apellidos, documento, edad);
        this.id_Propietario = id_Propietario;
    }

    public String getId_Propietario() {
        return id_Propietario;
    }

    public Object[] getInformacionPropietario(){
        Object[] info = {this.getNombres(),
                this.getApellidos(), this.getEdad(), this.getDocumento(), this.getId_Propietario()};
        return info;
    }
}
