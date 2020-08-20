package com.example.medicoaplicacion.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.medicoaplicacion.MainActivity;
import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.vista.registrar.RegisterActivity;
import com.example.medicoaplicacion.interfaces.UsuarioInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.usuario.UsuarioPresentador;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements UsuarioInterface.VistaLoginActivity {

    TextInputEditText txtUsuario;
    TextInputEditText txtClave;
    RadioButton rdnRecordarSesion;
    MaterialButton btnLogin , btnRegistrarse;
    UsuarioInterface.Presentador presentadorUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //SaveSharedPreference.setLoggedIn(getApplicationContext(), "", false);
        String token = SaveSharedPreference.getLoggedToken(getApplicationContext());

        if (token != ""){
            goToActivityPrincipalMedico();
        }
        //Iniciar y conectar vista con presentador
        presentadorUsuario = new UsuarioPresentador(this);

        txtUsuario = findViewById(R.id.txt_usuario);
        txtClave = findViewById(R.id.txt_clave);
        rdnRecordarSesion = findViewById(R.id.rdn_recordar_sesion);
        btnLogin = findViewById(R.id.btn_login);
        btnRegistrarse = findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manejadorIniciarSesion();
            }
        });
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuevo_registro();
            }
        });


    }

    private void goToActivityPrincipalMedico(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void manejadorIniciarSesion() {
        if(!TextUtils.isEmpty(txtClave.getText()) &&
                !TextUtils.isEmpty(txtUsuario.getText())){
            presentadorUsuario.ejecutarInicioSesion(txtUsuario.getText().toString(),txtClave.getText().toString());
        }
    }

    @Override
    public void manejadorInicioSesionExitoso(UsuarioModelo usuarioLogueado) {

        SaveSharedPreference.setLoggedIn(getApplicationContext(), usuarioLogueado.getIdUsuario(), true);


        //Toast.makeText(this, usuarioLogueado.getIdUsuario(), Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, "Bienvenido al sistema. "+usuarioLogueado, Toast.LENGTH_SHORT).show();
//        if(usuarioLogueado.getTipoUsuario().equals(UsuarioModelo.TIPO_USUARIO_MEDICO)){
            goToActivityPrincipalMedico();
//        }

    }

    @Override
    public void manejadorInicioSesionFallido() {
        Toast.makeText(this, "Usuario y/o clave de usuario incorrecto.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nuevo_registro() {

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }
}
