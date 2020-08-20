package com.example.medicoaplicacion.modelo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.medicoaplicacion.interfaces.HorarioAtencionAgregarInterface;
import com.example.medicoaplicacion.interfaces.HorarioAtencionListarInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HorarioAtencionModelo implements HorarioAtencionListarInterface.Modelo, HorarioAtencionAgregarInterface.Modelo, Serializable {


    private String idHorarioAtencion;
    private String idConsultorio;
    private String dia;
    private String nroDia;
    private String horaInicio;
    private String horaFin;
    private String estado;


    HorarioAtencionListarInterface.Presentador presentadorListarHorarioAtencion;
    HorarioAtencionAgregarInterface.Presentador presentadorAgregarHorarioAtencion;



    public HorarioAtencionModelo() {

    }

    public HorarioAtencionModelo(HorarioAtencionAgregarInterface.Presentador presentadorAgregarHorarioAtencion) {
        this.presentadorAgregarHorarioAtencion = presentadorAgregarHorarioAtencion;
    }

    public HorarioAtencionModelo(HorarioAtencionListarInterface.Presentador presentadorListarHorarioAtencion) {
        this.presentadorListarHorarioAtencion = presentadorListarHorarioAtencion;
    }


    public String getIdHorarioAtencion() {
        return idHorarioAtencion;
    }

    public void setIdHorarioAtencion(String idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public String getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(String idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNroDia() {
        return nroDia;
    }

    public void setNroDia(String nroDia) {
        this.nroDia = nroDia;
    }

    @Override
    public void listarHorarioAtencion(String idDiaAtencion) {

        Conexion.getCollectionHorarioAtencion().orderBy("dia",Query.Direction.ASCENDING)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                     @Override
                     public void onComplete(@NonNull Task<QuerySnapshot> task) {

                         final List<HorarioAtencionModelo> listaHorario = new ArrayList<>();
                         for (DocumentSnapshot document : task.getResult().getDocuments()){
                             HorarioAtencionModelo horario = document.toObject(HorarioAtencionModelo.class);
                             Log.d("LISTA",horario.getDia());
                             listaHorario.add(horario);

                         }
                         presentadorListarHorarioAtencion.cuandoListaHorarioAtencionExitoso(listaHorario);
                     }
                 }

        );



    }

    @Override
    public void agregarHorarioAtencion(final HorarioAtencionModelo objhorario) {

        final DocumentReference nuevo = Conexion.getCollectionHorarioAtencion().document();
        nuevo.set(objhorario).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    presentadorAgregarHorarioAtencion.cuandoAgregarHorarioAtencionExitoso(objhorario);

                }else{

                    presentadorAgregarHorarioAtencion.cuandoAgregarHorarioAtencionFallido();

                }
            }
        });

    }


}
