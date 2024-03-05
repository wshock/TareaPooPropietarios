package Utiles;

public class Persona {
    private String nombres, apellidos, documento;
    private int edad;

    public Persona(String nombres, String apellidos, String documento, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documento = documento;
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDocumento() {
        return documento;
    }

    public int getEdad() {
        return edad;
    }
}
