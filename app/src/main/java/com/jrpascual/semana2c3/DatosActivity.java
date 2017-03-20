package com.jrpascual.semana2c3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DatosActivity extends AppCompatActivity {

    // Variables de los textview donde recogeremos los extras
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    TextView tvfechanac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        //Obtener el manejador de los textview
        tvNombre = (TextView) findViewById(R.id.tvNombreConf);
        tvTelefono = (TextView) findViewById(R.id.tvTelefConf);
        tvEmail = (TextView) findViewById(R.id.tvEmailConf);
        tvDescripcion = (TextView) findViewById(R.id.tvDescConf);
        tvfechanac = (TextView) findViewById(R.id.tvFechaNacConf);

        Bundle bundle = getIntent().getExtras();

        //Actualizar texto con lo que viene de extras
        tvNombre.setText(bundle.getString(getResources().getString(R.string.lNombreCompleto)).toString());
        tvTelefono.setText(bundle.getString(getResources().getString(R.string.lTelefono)).toString());
        tvEmail.setText(bundle.getString(getResources().getString(R.string.lEmail)).toString());
        tvDescripcion.setText(bundle.getString(getResources().getString(R.string.lDescripcionContacto)).toString());
        int idia = bundle.getInt(getResources().getString(R.string.vdia));
        int imes = bundle.getInt(getResources().getString(R.string.vmes));
        int iano = bundle.getInt(getResources().getString(R.string.vano));
        tvfechanac.setText(String.valueOf(idia) + "/" + String.valueOf(imes) + "/" + String.valueOf(iano));

        //Coger el manejador del boton
        Button btEditar = (Button)findViewById(R.id.buttonEditar);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }
}
