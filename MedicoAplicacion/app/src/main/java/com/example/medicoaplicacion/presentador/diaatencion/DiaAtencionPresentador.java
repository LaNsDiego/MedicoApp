package com.example.medicoaplicacion.presentador.diaatencion;

import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.modelo.DiasAtencionModelo;

import java.util.List;

public class DiaAtencionPresentador implements DiaAtencionInterface.Presentador {

    DiaAtencionInterface.Modelo diaAtencionModelo;
    DiaAtencionInterface.VistaList vistaList;

    public DiaAtencionPresentador(DiaAtencionInterface.VistaList vistaList) {
        diaAtencionModelo = new DiasAtencionModelo(this);
        this.vistaList = vistaList;
    }

    @Override
    public void ejecutarListarDiasAtencion() {
        diaAtencionModelo.listarDiasAtencion();

    }

    @Override
    public void cuandoListaDiasAtencionExitoso(List<DiasAtencionModelo> list) {
        vistaList.manejadorListaDiasAtencionExitoso(list);
    }

    @Override
    public void cuandoListaDiasAtencionFallido() {

    }
}
