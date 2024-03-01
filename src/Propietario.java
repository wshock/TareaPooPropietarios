public class Propietario extends Persona{
    private String id_Propietario;
    public Propietario(String nombres, String apellidos, String documento, int edad, String id_Propietario) {
        super(nombres, apellidos, documento, edad);
        this.id_Propietario = id_Propietario;
    }
}
