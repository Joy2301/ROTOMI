package dcu.app.rotomi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText mEditTextNombre,mEditTextApellido,mEditTextEmail,mEdittextPassword;
    private Button mBtnRegistrar, mbtnLogin;

    //Variables de los datos
    private String Nombre,Apellido, Email, Password;

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
    private void RegistrarUsuario() {}

}