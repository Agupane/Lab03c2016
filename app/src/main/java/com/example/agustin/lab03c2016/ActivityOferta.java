package com.example.agustin.lab03c2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOferta extends AppCompatActivity implements View.OnClickListener{
    private Button botonGuardar;
    private Toolbar toolbar;
    private Trabajo trabajoNuevo;
    private EditText etNuevoTrabajo;
    private Intent iTrabajoAgregado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_oferta);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        botonGuardar = (Button) findViewById(R.id.buttonGuardar);
        botonGuardar.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        etNuevoTrabajo = (EditText) findViewById(R.id.etNombreOferta);
        trabajoNuevo = new Trabajo();
        trabajoNuevo.setDescripcion(etNuevoTrabajo.getText().toString());
        iTrabajoAgregado = getIntent();
        iTrabajoAgregado.putExtra("trabajoNuevo", trabajoNuevo);
        setResult(RESULT_OK, iTrabajoAgregado);
        finish();
    }

}
