package dcu.app.rotomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import dcu.app.rotomi.Controlador.PagerController;

public class InicioActivity extends AppCompatActivity {
    TabLayout tablayout;
    ViewPager viewpager;
    TabItem tabperfil, tabhorario, tabpaginas;

    PagerController pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        tablayout = findViewById(R.id.TabLayout);
        viewpager = findViewById(R.id.ViewPager);

        tabperfil = findViewById(R.id.TabPerfil);
        tabhorario = findViewById(R.id.TabHorario);
        tabpaginas = findViewById(R.id.TabPaginas);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tablayout.getTabCount());
        viewpager.setAdapter(pagerAdapter);
    }
}