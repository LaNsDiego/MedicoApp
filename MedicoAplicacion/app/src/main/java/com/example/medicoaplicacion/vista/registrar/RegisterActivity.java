package com.example.medicoaplicacion.vista.registrar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.medicoaplicacion.MainActivity;
import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.RegistrarInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.registrar.RegistrarPresentador;
import com.example.medicoaplicacion.vista.LoginActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity implements RegistrarInterface.VistaRegistrar {
    TextInputEditText tfUsuario,tfClave,tfNombres;
    Button btnRegistrar;
    RegistrarInterface.Presentador presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        presentador = new RegistrarPresentador(this);

        tfUsuario = findViewById(R.id.tfUsuario);
        tfClave = findViewById(R.id.tfClave);
        tfNombres = findViewById(R.id.tfNombres);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevoMedico();
            }
        });


    }

    @Override
    public void nuevoMedico() {
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.setUsuario(tfUsuario.getText().toString());
        usuario.setClave(tfClave.getText().toString());
        usuario.setNombres(tfNombres.getText().toString());
        presentador.ejecutarRegistrarMedico(usuario);

    }

    @Override
    public void manejadorNuevoMedicoExitoso(UsuarioModelo objUsuario) {
        //Log.d("ASDSD",objUsuario.getIdUsuario());
        Toast.makeText(this, "Se ha Registrado exitosamente." , Toast.LENGTH_SHORT).show();
        goToActivityLoginMedico();
    }

    @Override
    public void manejadorNuevoMedicoFallido() {
        Toast.makeText(this, "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }

    private void goToActivityLoginMedico(){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
