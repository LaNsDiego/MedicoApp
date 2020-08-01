package com.example.medicoaplicacion.presentador.diaatencion;

import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.modelo.DiaAtencionModelo;

import java.util.List;

public class ListarDiaAtencionPresentador implements DiaAtencionInterface.Presentador {

    DiaAtencionInterface.Modelo diaAtencionModelo;
    DiaAtencionInterface.VistaList vistaList;

    public ListarDiaAtencionPresentador(DiaAtencionInterface.VistaList vistaList) {
        diaAtencionModelo = new DiaAtencionModelo(this);
        this.vistaList = vistaList;
    }

    @Override
    public void ejecutarListarDiasAtencion() {
        diaAtencionModelo.listarDiasAtencion();

    }

    @Override
    public void cuandoListaDiasAtencionExitoso(List<DiaAtencionModelo> list) {
        vistaList.manejadorListaDiasAtencionExitoso(list);
    }

    @Override
    public void cuandoListaDiasAtencionFallido() {

    }
}
