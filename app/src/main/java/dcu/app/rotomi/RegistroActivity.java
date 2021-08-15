package dcu.app.rotomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dcu.app.rotomi.Entidades.Usuarios;
import dcu.app.rotomi.SQLiteHelper.ConexionSQLiteHelper;
import dcu.app.rotomi.Utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    private EditText mEditTextNombre,mEditTextApellido,mEditTextEmail,mEdittextPassword;
    private Button mBtnRegistrar, mbtnLogin;

    //Variables de los datos
    private String Nombre,Apellido, Email, Password;

    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"Usuarios",null,1);

    //Creamos una instancia de Usuarios
    Usuarios us = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextNombre = (EditText) findViewById(R.id.EditTextNombre);
        mEditTextApellido = (EditText) findViewById(R.id.editTextApellido);
        mEditTextEmail = (EditText) findViewById(R.id.EditTextEmail);
        mEdittextPassword = (EditText) findViewById(R.id.EditTextPassword);
        mbtnLogin = (Button) findViewById(R.id.btnLogin);
        mBtnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        //Pasamos al panel Login
        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            }
        });

        //Registramos al usuario en la base de datos
        mBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtenemos los datos de las cajas de texto
                Nombre = mEditTextNombre.getText().toString();
                Apellido = mEditTextApellido.getText().toString();
                Email = mEditTextEmail.getText().toString();
                Password = mEdittextPassword.getText().toString();

                us.setNombre(Nombre);
                us.setApellido(Apellido);
                us.setCorreo(Email);
                us.setClave(Password);

                //Ejecuta el metodo solo si ningun campo esta vacio y la clave es mayor a 6 caracteres
                if (!Nombre.isEmpty() && !Apellido.isEmpty() && !Email.isEmpty() && !Password.isEmpty()){

                    if (Password.length() >=6){
                        RegistrarUsuario();
                    }
                    else {
                        Toast.makeText(RegistroActivity.this, "La Contraseña debe tener almenos 6 caracteres", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    Toast.makeText(RegistroActivity.this, "Debe LLenar todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //Se registra el usuario en la base de datos
    private void RegistrarUsuario() {
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, Nombre);
        values.put(Utilidades.CAMPO_APELLIDO, Apellido);
        values.put(Utilidades.CAMPO_CORREO, Email);
        values.put(Utilidades.CAMPO_CLAVE, Password);

        try {
            Long IdResultado = db.insert(Utilidades.TABLA_USUARIOS, null, values);
            Toast.makeText(getApplicationContext(),"Se ha Registradp Exitosamente",Toast.LENGTH_LONG).show();
            db.close();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Se ha producido un error",Toast.LENGTH_LONG).show();
        }
        mEditTextNombre.setText("");
        mEditTextApellido.setText("");
        mEditTextEmail.setText("");
        mEdittextPassword.setText("");

    }

}