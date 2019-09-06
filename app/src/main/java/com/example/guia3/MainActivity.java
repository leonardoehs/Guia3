package com.example.guia3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAgregarNombres, btnMisDatos, btnVerLista;
    public static List<String> Ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("HS16-I04-001");
        }
        Ln = new ArrayList<>();
        btnAgregarNombres = findViewById(R.id.btnAgregarNombres);
        btnVerLista = findViewById(R.id.btnVerLista);
        btnMisDatos = findViewById(R.id.btnMisDatos);
        btnAgregarNombres.setOnClickListener(this);
        btnVerLista.setOnClickListener(this);
        btnMisDatos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMisDatos: {
                Intent datos = new Intent(this, ActivityDatos.class);
                startActivity(datos);
            }
            break;
            case R.id.btnAgregarNombres: {
                Intent agregar = new Intent(this, ActivityAgregar.class);
                startActivity(agregar);
            }
            break;
            case R.id.btnVerLista: {
                //Alerta si la lista se encuentra vacia
                if (Ln == null || Ln.size() == 0) {
                    new AlertDialog.Builder(this).setTitle("Alerta").setMessage("Lista Vacia").show();
                } else {
                    Intent verlista = new Intent(this, ActivityLista.class);
                    startActivity(verlista);
                }
            }
            break;

        }
    }
}
