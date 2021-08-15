package dcu.app.rotomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import dcu.app.rotomi.Controlador.HorarioActivity;
import dcu.app.rotomi.Controlador.PaginasActivity;
import dcu.app.rotomi.Entidades.Usuarios;

public class InicioActivity extends AppCompatActivity {
    Button btnHorario, btnPaginasUtiles;
    TextView textViewDatosInicio;

    String Correo, Clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnHorario = (Button) findViewById(R.id.btnHorario);
        btnPaginasUtiles = (Button) findViewById(R.id.btnPaginasUtiles);
        textViewDatosInicio = (TextView) findViewById(R.id.textViewDatosInicio);

        Correo = getIntent().getStringExtra("Correo");
        Clave = getIntent().getStringExtra("Clave");

        textViewDatosInicio.setText("Correo: " + Correo + "\n" + "\n" + "Clave: " + Clave);

        btnHorario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioActivity.this, HorarioActivity.class));
            }
        });

        btnPaginasUtiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InicioActivity.this, PaginasActivity.class));
            }
        });

    }
}