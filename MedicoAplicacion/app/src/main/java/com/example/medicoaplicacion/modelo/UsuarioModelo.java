package com.example.medicoaplicacion.modelo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.medicoaplicacion.interfaces.CambiarContrasenaInterface;
import com.example.medicoaplicacion.interfaces.RegistrarInterface;
import com.example.medicoaplicacion.interfaces.UsuarioInterface;
import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Map;

public class UsuarioModelo implements UsuarioInterface.Modelo, PerfilInterface.Modelo, CambiarContrasenaInterface.Modelo, RegistrarInterface.Modelo {

    //CONSTANTES DE TIPO USUARIO
    public static String TIPO_USUARIO_MEDICO = "MEDICO";
    public static String TIPO_USUARIO_PACIENTE = "PACIENTE";
    public static String TIPO_USUARIO_ADMINISTRADOR = "ADMINISTRADOR";

    //usuario
    private String idUsuario;
    private String tipoUsuario;

    private String usuario;
    private String clave;
    private String nuevaClave;
    private String repetirClave;
    private String tipoDocumento;
    private String nroDocumento;
    private String nombres;
    private String fechaNacimiento;
    private String idEspecialidad;
    private String especialidad;
    private String colegiatura;
    private String telefono;
    private String biografia;
    private String email;
    private String celular;
    private String avatar;
    private String sexo;
    private String estado;
    private String fecha;



    //FIRESTORE DATOS
    private FirebaseAuth auth;
    //PRESENTADOR
    UsuarioInterface.Presentador presentador;
    PerfilInterface.Presentador presentadorperfil;
    CambiarContrasenaInterface.Presentador presentadorCambiarContrasena;
    RegistrarInterface.Presentador presentadorRegistrar;

    public UsuarioModelo() { }

    public UsuarioModelo(RegistrarInterface.Presentador presentadorRegistrar) {
        this.presentadorRegistrar = presentadorRegistrar;
        this.auth = FirebaseAuth.getInstance();
    }

    public UsuarioModelo(UsuarioInterface.Presentador presentador) {
        this.presentador = presentador;
        this.auth = FirebaseAuth.getInstance();
    }

    public UsuarioModelo(PerfilInterface.Presentador presentadorperfil) {
        this.presentadorperfil = presentadorperfil;
        this.auth = FirebaseAuth.getInstance();
    }

    public UsuarioModelo(CambiarContrasenaInterface.Presentador presentadorCambiarContrasena) {
        this.presentadorCambiarContrasena = presentadorCambiarContrasena;
        this.auth = FirebaseAuth.getInstance();
    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNuevaClave() {
        return nuevaClave;
    }

    public void setNuevaClave(String nuevaClave) {
        this.nuevaClave = nuevaClave;
    }

    public String getRepetirClave() {
        return repetirClave;
    }

    public void setRepetirClave(String repetirClave) {
        this.repetirClave = repetirClave;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public void iniciarSesion(String usuario , String clave) {

        auth.signInWithEmailAndPassword(usuario, clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                final FirebaseUser currentUser =  auth.getCurrentUser();
                Log.d("LOGIN",currentUser.getUid().toString());
                if(task.isSuccessful()) {
                    UsuarioModelo obj = new UsuarioModelo();

                    //presentador.cuandoInicioSesionExitoso(obj);

                    Conexion.getCollectionUsuario().document(currentUser.getUid()).get()
                            .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    if(documentSnapshot.exists()){
                                        final UsuarioModelo usuarioLogueado = documentSnapshot.toObject(UsuarioModelo.class);
                                        if(usuarioLogueado != null){
                                            presentador.cuandoInicioSesionExitoso(usuarioLogueado);
                                        }

                                    }else{
                                        presentador.cuandoInicioSesionFallido();
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            presentador.cuandoInicioSesionFallido();
                        }
                    });
                }else{
                    presentador.cuandoInicioSesionFallido();
                }
            }
        });
/*
        auth.signInWithEmailAndPassword(email, clave).addOnCompleteListener(this, OnCompleteListener { task ->
            if(task.isSuccessful) {
                Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
            }
        })
*/

    }


    @Override
    public void ObtenerPorIdUsuario(String idUsuario) {

        Conexion.getCollectionUsuario().document(idUsuario)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                   @Override
                   public void onSuccess(DocumentSnapshot documentSnapshot) {
                       if(documentSnapshot.exists()){
                           final UsuarioModelo usuario = documentSnapshot.toObject(UsuarioModelo.class);
                           if(usuario != null){
                               presentadorperfil.cuandoVerPerfilExitoso(usuario);
                           }

                       }else{
                           presentadorperfil.cuandoVerPerfilFallido();
                       }
                   }
               }

        );



    }

    @Override
    public void actualizarPerfil(final UsuarioModelo objUsuario) {

        Conexion.getCollectionUsuario().document(objUsuario.getIdUsuario())
                        .update(
                                "tipoDocumento",objUsuario.getTipoDocumento(),
                                "nroDocumento",objUsuario.getNroDocumento(),
                                "nombres",objUsuario.getNombres(),
                                "email",objUsuario.getEmail(),
                                "celular",objUsuario.getCelular(),
                                "fechaNacimiento",objUsuario.getFechaNacimiento(),
                                "especialidad",objUsuario.getEspecialidad(),
                                "colegiatura",objUsuario.getColegiatura(),
                                "biografia",objUsuario.getBiografia()
                        ).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()){
                                    presentadorperfil.cuandoActualizarPerfilExitoso(objUsuario);
                                }else{
                                    presentadorperfil.cuandoActualizarPerfilFallido();
                                }
            }
        });

    }

    @Override
    public void actualizarFoto(final UsuarioModelo objUsuario) {
        Conexion.getCollectionUsuario().document(objUsuario.getIdUsuario())
                .update(
                        "avatar",objUsuario.getAvatar()
                ).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    presentadorperfil.cuandoActualizarFotoExitoso(objUsuario);
                }else{
                    presentadorperfil.cuandoActualizarFotoFallido();
                }
            }
        });
    }

    @Override
    public void actualizarContrasena(UsuarioModelo objUsuario) {
        UsuarioModelo obj1 = objUsuario;

        presentadorCambiarContrasena.cuandoActualizarContrasenaExitoso(obj1);
    }

    @Override
    public void nuevoMedico(final UsuarioModelo objUsuario) {

        //presentadorRegistrar.cuandoRegistrarMedicoExitoso(objUsuario);
        //UsuarioModelo obj1 = objUsuario;
       // add--nuevo
       // get lista
       // document  buscar por id
        // set autogenera el id

        auth.createUserWithEmailAndPassword(objUsuario.getUsuario(),objUsuario.getClave()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    objUsuario.setIdUsuario(task.getResult().getUser().getUid());
                    objUsuario.setEmail(objUsuario.getUsuario());
                    objUsuario.setEstado("Activo");
                    objUsuario.setTipoUsuario("Medico");

                    Log.d("NEWUSUARIO_CREADO",objUsuario.getIdUsuario());
                    final DocumentReference nuevo = Conexion.getCollectionUsuario().document(objUsuario.getIdUsuario());
                    nuevo.set(objUsuario).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){

                                nuevoUsuario(objUsuario);

                            }else{
                                presentadorRegistrar.cuandoRegistrarMedicoFallido();
                            }
                        }
                    });



                }else{

                }
            }
        });
    }

    @Override
    public void nuevoUsuario(final UsuarioModelo objUsuario) {

        final ConsultorioModelo consultorioModelo = new ConsultorioModelo();
        consultorioModelo.setIdMedico(objUsuario.getIdUsuario());
        consultorioModelo.setIdConsultorio(objUsuario.getIdUsuario());

        final DocumentReference nuevo = Conexion.getCollectionConsultorio().document(objUsuario.getIdUsuario());
        nuevo.set(consultorioModelo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    presentadorRegistrar.cuandoRegistrarMedicoExitoso(objUsuario);

                }else{
                    presentadorRegistrar.cuandoRegistrarMedicoFallido();
                }
            }
        });
    }




}
