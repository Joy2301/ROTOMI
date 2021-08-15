package dcu.app.rotomi.Utilidades;

public class Utilidades {

    //Constantes campos tabla Usuarios
    public static final String TABLA_USUARIOS = "Usuarios";
    public static final String CAMPO_ID="Id";
    public static final String CAMPO_NOMBRE="Nombre";
    public static final String CAMPO_APELLIDO="Apellido";
    public static final String CAMPO_CORREO="Correo";
    public static final String CAMPO_CLAVE="Clave";

    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE " +
            ""+TABLA_USUARIOS+" ("+CAMPO_ID+" " +
            "INTEGER primary key autoincrement, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT,"+CAMPO_CORREO+" TEXT,"+CAMPO_CLAVE+" TEXT)";

}
