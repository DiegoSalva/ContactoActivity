package com.example.diegosalva.contactoactivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private Button bSiguiente;
    private DatePicker dpFecha;

    private Datos mDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombreCompleto);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        dpFecha = (DatePicker) findViewById(R.id.dpFecha);

        bSiguiente = (Button) findViewById(R.id.bSiguiente);

        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDatos();

                String nombre = etNombre.getText().toString();
                String telefono = etTelefono.getText().toString();
                String email = etEmail.getText().toString();
                String descripcion = etDescripcion.getText().toString();

                //Toast.makeText(MainActivity.this, dpFecha.getDayOfMonth() + "/" + dpFecha.getMonth() + "/" + dpFecha.getYear(), Toast.LENGTH_LONG).show();

                Intent iSiguiente = new Intent(MainActivity.this, ConfirmarDatos.class);
                iSiguiente.putExtra("fechaKey", mDatos.getmFecha());
                Bundle bndAlmacenar = new Bundle();
                bndAlmacenar.putString(getResources().getString(R.string.nombreKey), nombre);
                bndAlmacenar.putString(getResources().getString(R.string.telefonoKey), telefono);
                bndAlmacenar.putString(getResources().getString(R.string.emailKey), email);
                bndAlmacenar.putString(getResources().getString(R.string.descripcionKey), descripcion);


                iSiguiente.putExtras(bndAlmacenar);
                startActivity(iSiguiente);
            }
        });
    }

        private void mostrarDatos(){
            String mounth;
            String day;
            String year;
            String fecha;

            mDatos= new Datos();

            //Tomar datos de fecha del picker
            mounth  =String.valueOf(dpFecha.getMonth());
            day     =String.valueOf(dpFecha.getDayOfMonth());
            year    =String.valueOf(dpFecha.getYear());
            fecha   = day+"/"+mounth+"/"+year;

            mDatos.setmFecha(fecha);
            }

    }


