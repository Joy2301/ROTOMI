package dcu.app.rotomi.SQLiteHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import dcu.app.rotomi.Utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utilidades.TABLA_USUARIOS");
        db.execSQL(Utilidades.CREAR_TABLA_USUARIOS);
    }

    //Metodo que permite validar si el usuario existe (Para el login)
    public Cursor ConsultarUsuPass(String Usu, String Pass) throws SQLException {
        Cursor mCursor = null;
        mCursor = this.getReadableDatabase().query(Utilidades.TABLA_USUARIOS,
                new String[]{Utilidades.CAMPO_ID, Utilidades.CAMPO_NOMBRE,
                Utilidades.CAMPO_APELLIDO, Utilidades.CAMPO_CORREO, Utilidades.CAMPO_CLAVE},
                "Correo like '"+Usu+"' and Clave like '"+Pass+"' ", null, null, null, null);
        return mCursor;
    }
}
