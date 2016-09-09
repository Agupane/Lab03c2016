package com.example.agustin.lab03c2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView ofertas;
    private AdapterOfertas adapterLvOfertas;
    private Trabajo[] trabajos;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ofertas = (ListView) findViewById(R.id.lvOfertas);
        trabajos=Trabajo.TRABAJOS_MOCK;
        adapterLvOfertas = new AdapterOfertas(this, Arrays.asList(trabajos));
        ofertas.setAdapter(adapterLvOfertas);
    }
}
