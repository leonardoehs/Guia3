package com.example.guia3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Toast;

import static com.example.guia3.MainActivity.Ln;

public class ActivityAgregar extends AppCompatActivity implements View.OnClickListener {
    Button btnAgregar;
    EditText edtNombre;
    ProgressBar Pbar;
    TextView porcentaje;
    private int mProgressStatus = 0;
    Handler mHandler = new Handler();
    boolean Activo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("HS16-I04-001");
        }
        edtNombre = findViewById(R.id.edtNombre);
        Pbar = findViewById(R.id.Pbar);
        porcentaje = findViewById(R.id.porcentaje);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAgregar: {
                if (edtNombre.getText().toString().isEmpty()) {
                   //Toast.makeText(this, "¡Campo Nombre vacio!", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(this).setTitle("Alerta").setMessage("El campo nombre esta vacio").show();
                } else if (!Activo) {
                    Thread hr = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (mProgressStatus <= 100) {
                                mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        porcentaje.setText(mProgressStatus + " %");
                                        Pbar.setProgress(mProgressStatus);
                                    }
                                });
                                try {
                                    Thread.sleep(20);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (mProgressStatus == 100) {
                                    Ln.add(edtNombre.getText().toString());
                                    runOnUiThread(new Runnable() {
                                        public void run() {
                                            new AlertDialog.Builder(ActivityAgregar.this).setTitle("¡Aviso!").setMessage("El nombre: "+edtNombre.getText().toString()+" "+ ".\nSe guardo correctamente"+". \n¿Desea agregar otro nombre?")
                                                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialogInterface, int i) {
                                                            finish();
                                                        }
                                                    })
                                                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                                        @Override
                                                        public void onClick(DialogInterface dialog, int which) {
                                                            Activo = false;
                                                            mProgressStatus = 0;
                                                            porcentaje.setText("");
                                                            edtNombre.setText("");
                                                            Pbar.setProgress(0);
                                                        }
                                                    }).show();
                                        }
                                    });
                                }
                                mProgressStatus++;
                                Activo = true;
                            }
                        }
                    });
                    hr.start();
                }
            }
            break;
        }
    }
}
