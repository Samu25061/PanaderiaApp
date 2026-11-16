
package com.panaderia.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class FormularioActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        EditText nombre = findViewById(R.id.txtNombre);
        EditText correo = findViewById(R.id.txtCorreo);
        EditText telefono = findViewById(R.id.txtTelefono);

        RadioButton recoger = findViewById(R.id.rbRecoger);
        RadioButton domicilio = findViewById(R.id.rbDomicilio);

        Button registrar = findViewById(R.id.btnRegistrar);
        Button salir = findViewById(R.id.btnSalir);

        registrar.setOnClickListener(v -> {

            String n = nombre.getText().toString().trim();
            String c = correo.getText().toString().trim();
            String t = telefono.getText().toString().trim();

            if (n.isEmpty() || c.isEmpty() || t.isEmpty()) {
                Toast.makeText(this, "Complete todos los campos",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            String servicio = "";

            if (recoger.isChecked()) {
                servicio = "Recoger en el local";
            } else if (domicilio.isChecked()) {
                servicio = "Domicilio";
            } else {
                Toast.makeText(this, "Seleccione un servicio",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this,
                    ConfirmacionActivity.class);

            intent.putExtra("nombre", n);
            intent.putExtra("correo", c);
            intent.putExtra("telefono", t);
            intent.putExtra("servicio", servicio);

            startActivity(intent);
        });

        salir.setOnClickListener(v -> finishAffinity());
    }
}


