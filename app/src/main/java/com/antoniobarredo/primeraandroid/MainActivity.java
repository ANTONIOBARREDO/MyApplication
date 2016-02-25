package com.antoniobarredo.primeraandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // ABBO
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private RadioButton rb11;
    private RadioButton rb12;
    private RadioButton rb13;
    private RadioButton rb14;
    private EditText cantidad;
    private Button convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        setTitle("Calculadora informatica 1/2");

        // ABBO - Tratado para las etiquetas
        TextView e1 = (TextView) findViewById(R.id.TV1);
        TextView e2 = (TextView) findViewById(R.id.TV2);
        TextView e3 = (TextView) findViewById(R.id.TV3);
        e1.setText("< Origen >");
        //e2.setText(("Convertir :"));
        e3.setText("< Destino >");

        // Tratamiento de RadioButton
        rb1 = (RadioButton) findViewById(R.id.RB1);
        rb2 = (RadioButton) findViewById(R.id.RB2);
        rb3 = (RadioButton) findViewById(R.id.RB3);
        rb4 = (RadioButton) findViewById(R.id.RB4);
        rb11 = (RadioButton) findViewById(R.id.RB11);
        rb12 = (RadioButton) findViewById(R.id.RB12);
        rb13 = (RadioButton) findViewById(R.id.RB13);
        rb14 = (RadioButton) findViewById(R.id.RB14);
        rb1.setText("Bytes");
        rb2.setText("KBytes");
        rb3.setText("MBytes");
        rb4.setText("GBytes");
        rb11.setText("Bytes");
        rb12.setText("KBytes");
        rb13.setText("MBytes");
        rb14.setText("GBytes");

        rb1.setChecked(true);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);

        rb11.setChecked(true);
        rb12.setChecked(false);
        rb13.setChecked(false);
        rb14.setChecked(false);

        // EditText
        cantidad = (EditText) findViewById(R.id.cantidad);

        // Tratamiento del Button
        convertir = (Button) findViewById(R.id.B);
        convertir.setText(" <... Calcular ...>");

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

        findViewById(R.id.B).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // startActivity(new Intent(MainActivity.this, Main2Activity.class));

                //Recogemos valor del radiogroup1
                RadioGroup grupo = (RadioGroup) findViewById(R.id.RG1);
                int valor = grupo.indexOfChild(grupo.findViewById(grupo.getCheckedRadioButtonId()));

                //Recogemos valor del radiogroup2
                RadioGroup grupo2 = (RadioGroup) findViewById(R.id.RG2);
                int valor2 = grupo2.indexOfChild(grupo2.findViewById(grupo2.getCheckedRadioButtonId()));

                int n = 0;
                try {
                    n = Integer.parseInt(cantidad.getText().toString());
                }catch (NumberFormatException e){}

                // Creamos el Intent
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                // Cargamos los datos en el Intent
                i.putExtra("DATO", n);
                i.putExtra("VALOR", valor);
                i.putExtra("VALOR2", valor2);

                // Arrancar la actividad
                startActivity(i);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
