package com.example.medicoaplicacion.presentador.horarioatencion;

import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public class ListarHorarioAtencionPresentador implements HorarioAtencionInterface.Presentador {

    HorarioAtencionInterface.Modelo horarioAtencionModelo;
    HorarioAtencionInterface.VistaListar vistaList;

    public ListarHorarioAtencionPresentador(HorarioAtencionInterface.VistaListar vistaList) {
        horarioAtencionModelo = new HorarioAtencionModelo(this);
        this.vistaList = vistaList;
    }

    @Override
    public void ejecutarListarHorarioAtencion() {
        horarioAtencionModelo.listarHorarioAtencion("1");
    }

    @Override
    public void cuandoListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list) {
        vistaList.manejadorListaHorarioAtencionExitoso(list);
    }

    @Override
    public void cuandoListaHorarioAtencionFallido() {

    }
}
