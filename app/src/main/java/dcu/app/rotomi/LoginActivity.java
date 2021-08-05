package dcu.app.rotomi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditTextEmailLogin,mEdittextPasswordLogin;
    private Button mBtnRegistrar, mbtnLogin;
    private final  static  String CHANNEL_ID = "NOTIFICACION";
    private  final  static int NOTIFICATION_ID =0;

    //Variables de los datos
    private String EmailLogin, PasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextEmailLogin = (EditText) findViewById(R.id.EditTextEmailLogin);
        mEdittextPasswordLogin = (EditText) findViewById(R.id.EditTextPasswordLogin);
        mbtnLogin = (Button) findViewById(R.id.btnLogin);
        mBtnRegistrar = (Button) findViewById(R.id.btnRegistrar);

        //Pasamos al panel Login
        mBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtengo los datos de as cajas de los editText
                EmailLogin = mEditTextEmailLogin.getText().toString();
                PasswordLogin = mEdittextPasswordLogin.getText().toString();

                //En caso de que algun campo este vacio, muestra un error
                if(EmailLogin.isEmpty()){
                    mEditTextEmailLogin.setError("Email es Requerido.");
                    return;
                }

                if(PasswordLogin.isEmpty()){
                    mEdittextPasswordLogin.setError("Clave es Requerida");
                    return;
                }

                if(PasswordLogin.length() < 6){
                    mEdittextPasswordLogin.setError("La clave debe tener mas de 6 caracteres");
                    return;
                }


                //Metodo para el inicio de Sesion
                IniciarSesion();


            }
        });
    }

    private void IniciarSesion() {
        startActivity(new Intent(LoginActivity.this, InicioActivity.class));
    }

    //para mostrar notificaciones
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Noticacion";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private void createNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_none_24);
        builder.setContentTitle("Bienvenido");
        builder.setContentText("Iniciaste Sesion como " + EmailLogin);
        builder.setColor(Color.BLUE);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        builder.setLights(Color.MAGENTA, 1000, 1000);
        builder.setVibrate(new long[]{1000,1000,1000,1000,1000});
        builder.setDefaults(Notification.DEFAULT_SOUND);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
        notificationManagerCompat.notify(NOTIFICATION_ID , builder.build());
    }
}