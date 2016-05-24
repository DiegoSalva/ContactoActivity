package com.example.diegosalva.contactoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private Button bEditar;
    private TextView tvFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombre = (TextView) findViewById(R.id.tvNombreCompleto);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvFecha= (TextView) findViewById(R.id.tvFecha);

        bEditar= (Button) findViewById(R.id.bEditar);

        Bundle bndRecuperar = getIntent().getExtras();
        tvNombre.setText("Nombre: "+(CharSequence) bndRecuperar.get(getResources().getString(R.string.nombreKey)));
        tvTelefono.setText("Teléfono: "+(CharSequence) bndRecuperar.get(getResources().getString(R.string.telefonoKey)));
        tvEmail.setText("Email: "+(CharSequence) bndRecuperar.get(getResources().getString(R.string.emailKey)));
        tvDescripcion.setText("Descripción: "+(CharSequence) bndRecuperar.get(getResources().getString(R.string.descripcionKey)));

        tvFecha.setText(bndRecuperar.getString("fechaKey"));


        bEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
