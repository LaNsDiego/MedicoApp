package com.example.medicoaplicacion.modelo;

import androidx.annotation.NonNull;

import com.example.medicoaplicacion.interfaces.UsuarioInterface;
import com.example.medicoaplicacion.interfaces.PerfilMInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class UsuarioModelo implements UsuarioInterface.Modelo, PerfilMInterface.Modelo {

    //CONSTANTES DE TIPO USUARIO
    public static String TIPO_USUARIO_MEDICO = "MEDICO";
    public static String TIPO_USUARIO_PACIENTE = "PACIENTE";
    public static String TIPO_USUARIO_ADMINISTRADOR = "ADMINISTRADOR";

    //usuario
    private String idUsuario;
    private String usuario;
    private String clave;
    private String tipoDocumento;
    private String nroDocumento;
    private String nombres;
    private String fechaNacimiento;
    private int edad;
    private String email;
    private String celular;
    private String avatar;
    private String pais;
    private String ciudad;
    private String distrito;
    private String sexo;
    private String estado;
    private String fecha;
    private String tipoUsuario;
    //MEDICO
    private String idEspecialidad;
    private String telefono;
    private String biografia;
    //PACIENTE
    private double peso;
    private double talla;
    private String direccion;

    private Map<String,Object> datosExtra;

    //FIRESTORE DATOS
    private FirebaseAuth auth;
    //PRESENTADOR
    UsuarioInterface.Presentador presentador;
    PerfilMInterface.Presentador presentadorperfil;

    public UsuarioModelo() { }

    public UsuarioModelo(UsuarioInterface.Presentador presentador) {
        this.presentador = presentador;
        this.auth = FirebaseAuth.getInstance();
    }

    public UsuarioModelo(PerfilMInterface.Presentador presentadorperfil) {
        this.presentadorperfil = presentadorperfil;
        this.auth = FirebaseAuth.getInstance();
    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
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

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(String idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Map<String, Object> getDatosExtra() {
        return datosExtra;
    }

    public void setDatosExtra(Map<String, Object> datosExtra) {
        this.datosExtra = datosExtra;
    }

    @Override
    public void iniciarSesion(String usuario , String clave) {
        auth.signInWithEmailAndPassword(usuario, clave).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                final FirebaseUser currentUser =  auth.getCurrentUser();
                Conexion.getCollectionUsuario().document(currentUser.getUid()).get()
                        .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if(documentSnapshot.exists()){
                                    final UsuarioModelo usuarioLogueado = documentSnapshot.toObject(UsuarioModelo.class);
                                    presentador.cuandoInicioSesionExitoso(usuarioLogueado);
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
            }
        });
    }


    @Override
    public void ObtenerPorIdReserva(String idUsuario) {

        UsuarioModelo objUsuario = new UsuarioModelo();
        objUsuario.setNombres("Yonathan William Mamani Calisaya");


    }
}
