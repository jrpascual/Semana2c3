package com.jrpascual.semana2c3;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private TextInputEditText nombreCompleto;
    private TextInputEditText email;
    private TextInputEditText telefono;
    private TextInputEditText descripcion;
    private DatePicker fechanac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btEnviar = (Button) findViewById(R.id.buttonEnviar);
        // Ponemos el listener
        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al pulsar boton Siguiente, crear la nueva activity
                Intent intent = new Intent(MainActivity.this,DatosActivity.class);

                nombreCompleto = (TextInputEditText)findViewById(R.id.etNombreCompleto);
                email = (TextInputEditText)findViewById(R.id.etEmail);
                telefono = (TextInputEditText)findViewById(R.id.etTelefono);
                fechanac = (DatePicker) findViewById(R.id.dpfecha);
                descripcion = (TextInputEditText)findViewById(R.id.etDescripcion);

                intent.putExtra(getResources().getString(R.string.lNombreCompleto),nombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.lEmail),email.getText().toString());
                intent.putExtra(getResources().getString(R.string.lTelefono),telefono.getText().toString());
                //intent.putExtra(getResources().getString(R.string.lFechaNacimiento),fechanac.toString());
                intent.putExtra(getResources().getString(R.string.lDescripcionContacto),descripcion.getText().toString());


                int day = fechanac.getDayOfMonth();
                int month = fechanac.getMonth()+1;
                int year = fechanac.getYear();

                intent.putExtra(getResources().getString(R.string.vdia),day);
                intent.putExtra(getResources().getString(R.string.vmes), month);
                intent.putExtra(getResources().getString(R.string.vano), year);

                startActivity(intent);
            }
        });


    }
}
