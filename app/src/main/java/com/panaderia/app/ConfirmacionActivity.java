
package com.panaderia.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        TextView datos = findViewById(R.id.txtDatos);
        Button salir = findViewById(R.id.btnSalir);

        String nombre = getIntent().getStringExtra("nombre");
        String correo = getIntent().getStringExtra("correo");
        String telefono = getIntent().getStringExtra("telefono");
        String servicio = getIntent().getStringExtra("servicio");

        String informacion =
                "Nombre: " + nombre +
                "\nCorreo: " + correo +
                "\nTeléfono: " + telefono +
                "\nServicio: " + servicio;

        datos.setText(informacion);

        salir.setOnClickListener(v -> finishAffinity());
    }
}

