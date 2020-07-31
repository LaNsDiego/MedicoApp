package com.example.medicoaplicacion.modelo;

import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;

import java.util.ArrayList;
import java.util.List;

public class DiasAtencionModelo implements DiaAtencionInterface.Modelo {

    private String idDiaAtencion;
    private String nombreDia;
    private String estado;
    private String idUsuario;

    DiaAtencionInterface.Presentador diaAtencionPresentador;

    public DiasAtencionModelo(DiaAtencionInterface.Presentador diaAtencionPresentador) {
        this.diaAtencionPresentador = diaAtencionPresentador;
    }

    public DiasAtencionModelo() {

    }

    public String getIdDiaAtencion() {
        return idDiaAtencion;
    }

    public void setIdDiaAtencion(String idDiaAtencion) {
        this.idDiaAtencion = idDiaAtencion;
    }

    public String getNombreDia() {
        return nombreDia;
    }

    public void setNombreDia(String nombreDia) {
        this.nombreDia = nombreDia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    @Override
    public void listarDiasAtencion(String idMedico) {

        DiasAtencionModelo obj1 = new DiasAtencionModelo();
        DiasAtencionModelo obj2 = new DiasAtencionModelo();
        DiasAtencionModelo obj3 = new DiasAtencionModelo();
        DiasAtencionModelo obj4 = new DiasAtencionModelo();
        DiasAtencionModelo obj5 = new DiasAtencionModelo();
        DiasAtencionModelo obj6 = new DiasAtencionModelo();

        List<DiasAtencionModelo> lista = new ArrayList<>();
        obj1.setNombreDia("Lunes");
        obj2.setNombreDia("Martes");
        obj3.setNombreDia("Miercoles");
        obj4.setNombreDia("Jueves");
        obj5.setNombreDia("Viernes");
        obj6.setNombreDia("Sabado");

        obj1.setIdDiaAtencion(idMedico);

        lista.add(obj1);
        lista.add(obj2);
        lista.add(obj3);
        lista.add(obj4);
        lista.add(obj5);
        lista.add(obj6);

        diaAtencionPresentador.cuandoListaDiasAtencionExitoso(lista);
    }
}
