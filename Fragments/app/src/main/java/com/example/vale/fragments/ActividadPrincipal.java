package com.example.vale.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class ActividadPrincipal extends AppCompatActivity //Importantísimo. Esta actividad soporta fragments
        implements FragmentListado.CorreosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        FragmentListado frgListado = (FragmentListado)fm.findFragmentById(R.id.FrgListado);

        frgListado.setCorreosListener(this);
    }


    @Override
    public void onCorreoSeleccionado(Libro c) {

        FragmentManager fm = getSupportFragmentManager();

        FragmentDetalle fd = (FragmentDetalle)fm.findFragmentById(R.id.FrgDetalle); //el casting que no falte ;)

        fd.mostrarDetalle(c.getResumen());
    }
}
