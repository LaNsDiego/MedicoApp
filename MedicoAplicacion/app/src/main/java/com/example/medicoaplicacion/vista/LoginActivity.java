package com.example.medicoaplicacion.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.medicoaplicacion.MainActivity;
import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.UsuarioInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.usuario.UsuarioPresentador;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements UsuarioInterface.VistaLoginActivity {

    TextInputEditText txtUsuario;
    TextInputEditText txtClave;
    RadioButton rdnRecordarSesion;
    MaterialButton btnLogin;
    UsuarioInterface.Presentador presentadorUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Iniciar y conectar vista con presentador
        presentadorUsuario = new UsuarioPresentador(this);

        txtUsuario = findViewById(R.id.txt_usuario);
        txtClave = findViewById(R.id.txt_clave);
        rdnRecordarSesion = findViewById(R.id.rdn_recordar_sesion);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manejadorIniciarSesion();
            }
        });


        //codigo temporal para agregar 10
//        EspecialidadModelo em = new EspecialidadModelo();
//        EspecialidadModelo obj1 = new EspecialidadModelo();
//        obj1.setNombre("Pediatría");
//        obj1.setDescripcion("La pediatría es una rama de la medicina humana que se ocupa de la atención completa de bebés, niños y adolescentes desde su etapa de nacimiento hasta los 18 años.");
//        obj1.setEstado("ACTIVO");
//        EspecialidadModelo obj2 = new EspecialidadModelo();
//        obj2.setNombre("Neurología");
//        obj2.setDescripcion("Es la rama de la medicina que se especializa en el diagnóstico y tratamiento de enfermedades del cerebro, la médula espinal, sistema nervioso y los músculos.");
//        obj2.setEstado("ACTIVO");
//        EspecialidadModelo obj3 = new EspecialidadModelo();
//        obj3.setNombre("Ginecobstetra");
//        obj3.setDescripcion("La ginecobstetricia, es la rama de la medicina humana que se especializa en el embarazo, el parto y el sistema reproductivo de una mujer.");
//        obj3.setEstado("ACTIVO");
//        EspecialidadModelo obj4 = new EspecialidadModelo();
//        obj4.setNombre("Psiquiatría");
//        obj4.setDescripcion("Es la rama de la medicina que realiza el diagnóstico tratamiento y prevención de enfermedades mentales, emocionales y del comportamiento humano.");
//        obj4.setEstado("ACTIVO");
//        EspecialidadModelo obj5 = new EspecialidadModelo();
//        obj5.setNombre("Anesteciología");
//        obj5.setDescripcion("Al término la especialidad, el alumno aplicará la terapéutica específica, los métodos y procedimientos de la nueva tecnología disponible mediante la categorización del origen y desarrollo de las diferentes entidades nosológicas que afectan la piel y sus anexos.");
//        obj5.setEstado("ACTIVO");
//        EspecialidadModelo obj6 = new EspecialidadModelo();
//        obj6.setNombre("Dermatología");
//        obj6.setDescripcion("Al término la especialidad, el alumno aplicará la terapéutica específica, los métodos y procedimientos de la nueva tecnología disponible mediante la categorización del origen y desarrollo de las diferentes entidades nosológicas que afectan la piel y sus anexos.");
//        obj6.setEstado("ACTIVO");
//        EspecialidadModelo obj7 = new EspecialidadModelo();
//        obj7.setNombre("Neurología");
//        obj7.setDescripcion("Al finalizar la especialidad, el alumno proporcionara atención específica, directa, integral a los pacientes con problemas neurológicos, para restablecer el funcionamiento normal del sistema nervioso central en todas las edades, que le permita una adecuada integración a su vida cotidiana.");
//        obj7.setEstado("ACTIVO");
//        em.agregarEspecialidad(obj1);
//        em.agregarEspecialidad(obj2);
//        em.agregarEspecialidad(obj3);
//        em.agregarEspecialidad(obj4);
//        em.agregarEspecialidad(obj5);
//        em.agregarEspecialidad(obj6);
//        em.agregarEspecialidad(obj7);
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
        Toast.makeText(this, "Bienvenido al sistema " + usuarioLogueado.getTipoUsuario(), Toast.LENGTH_SHORT).show();

        if(usuarioLogueado.getTipoUsuario().equals(UsuarioModelo.TIPO_USUARIO_MEDICO)){
            goToActivityPrincipalMedico();
        }

    }

    @Override
    public void manejadorInicioSesionFallido() {
        Toast.makeText(this, "Usuario y/o clave de usuario incorrecto.", Toast.LENGTH_SHORT).show();
    }
}
