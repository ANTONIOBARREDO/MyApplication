package com.antoniobarredo.primeraandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Calculadora informatica 2/2");

        // Recoger el dato que nos llega en el Intent
        double dato = 0;
        int valor1 = 0;
        int valor2 = 0;
        double calculo=0;
        double total = 0;
        String texto1 = "";
        String texto2 = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {   // Hay que asegurarse de que existe
            dato = extras.getInt("DATO");
            valor1 = extras.getInt("VALOR");
            valor2 = extras.getInt("VALOR2");
        }

        if (valor1 == 0) {
            texto1="Bytes";
            calculo=dato;
        } else if (valor1 == 1) {
            texto1="KBytes";
            calculo=dato*1024;
        }else if (valor1 == 2) {
            texto1="MBytes";
            calculo=(dato*1024)*1024;
        } else if (valor1 == 3) {
            texto1="GBytes";
            calculo=((dato*1024)*1024)*1024;
        }
        if (valor2 == 0) {
            texto2="Bytes";
            total=calculo;
        } else if (valor2 == 1) {
            texto2="KBytes";
            total = calculo/1024;
        }else if (valor2 == 2) {
            texto2="MBytes";
            total=(calculo/1024)/1024;
        } else if (valor2 == 3) {
            texto2="GBytes";
            total=((calculo/1024)/1024)/1024;
        }

        // Mostramos el dato en el interfaz
        TextView tv1 = (TextView) findViewById(R.id.textView);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView3);
        //tv2.setText(dato + " " +texto1 +" son " + total + " " + texto2);
        tv1.setText("El resultado es la conversion es ");
        tv2.setText(dato + " " +texto1);
        tv3.setText(" son " + total + " " + texto2);
/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
    }

}
