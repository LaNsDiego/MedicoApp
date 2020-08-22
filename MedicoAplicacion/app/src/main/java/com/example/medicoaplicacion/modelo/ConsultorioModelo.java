package com.example.medicoaplicacion.modelo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.medicoaplicacion.interfaces.ConsultorioInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

public class ConsultorioModelo implements ConsultorioInterface.Modelo {

    private String idConsultorio;
    private String idMedico;
    private String image;
    private String especialidad;
    private String nombre;
    private double precioConsulta;
    private Double latitud;
    private Double longitud;
    private String direccion;
    private String referencia;
    private String email;
    private String serviciosOfresidos;
    private String foto;
    private String estado;
    private String telefono;
    private String celular;
    private String fecha;


    ConsultorioInterface.Presentador consultorioPresentador;

    public ConsultorioModelo(ConsultorioInterface.Presentador consultorioPresentador) {
        this.consultorioPresentador = consultorioPresentador;
    }

    public ConsultorioModelo(){};

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(String idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(double precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getServiciosOfresidos() {
        return serviciosOfresidos;
    }

    public void setServiciosOfresidos(String serviciosOfresidos) {
        this.serviciosOfresidos = serviciosOfresidos;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getReferencia() {
        return referencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public void ObtenerPorIdConsultorio(String idConsultorio) {

        Conexion.getCollectionConsultorio().document(idConsultorio)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                                @Override
                                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists()){
                        final ConsultorioModelo objconsultorio = documentSnapshot.toObject(ConsultorioModelo.class);
                        if(objconsultorio != null){
                            Log.d("LOGCONSUSLTORIO",objconsultorio.getIdConsultorio());
                            consultorioPresentador.cuandoVerConsultorioExitoso(objconsultorio);
                        }

                    }else{
                        consultorioPresentador.cuandoVerConsultorioFallido();
                    }
                }
            }

        );
    }

    @Override
    public void actualizarConsultorio(final ConsultorioModelo objConsultorio) {
        Log.d("LOGCONSUL",objConsultorio.getIdConsultorio());
        Conexion.getCollectionConsultorio().document(objConsultorio.getIdConsultorio())
                .update(
                        "nombre",objConsultorio.getNombre(),
                        "direccion",objConsultorio.getDireccion(),
                        "latitud",objConsultorio.getLatitud(),
                        "longitud",objConsultorio.getLongitud(),
                        "referencia",objConsultorio.getReferencia(),
                        "telefono",objConsultorio.getTelefono(),
                        "celular",objConsultorio.getCelular(),
                        "email",objConsultorio.getEmail(),
                        "precioConsulta",objConsultorio.getPrecioConsulta(),
                        "serviciosOfrecidos",objConsultorio.getServiciosOfresidos(),
                        "especialidad",objConsultorio.getEspecialidad(),
                        "estado","Activo"
                ).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    consultorioPresentador.cuandoActualizarConsultorioExitoso(objConsultorio);
                }else{
                    consultorioPresentador.cuandoActualizarConsultorioFallido();
                }


            }
        });
    }

    @Override
    public void actualizarFotoConsultorio(final ConsultorioModelo objConsultorio) {
        Conexion.getCollectionConsultorio().document(objConsultorio.getIdConsultorio())
                .update(
                        "image",objConsultorio.getImage()
                ).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    consultorioPresentador.cuandoActualizarFotoConsultorioExitoso(objConsultorio);
                }else{
                    consultorioPresentador.cuandoActualizarFotoConsultorioFallido();
                }
            }
        });
    }
}
