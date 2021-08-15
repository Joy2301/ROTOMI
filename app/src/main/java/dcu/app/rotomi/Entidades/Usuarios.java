package dcu.app.rotomi.Entidades;

public class Usuarios {
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Clave;

    public Usuarios(String nombre, String apellido, String correo, String clave) {
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Clave = clave;
    }

    public Usuarios(){
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}
