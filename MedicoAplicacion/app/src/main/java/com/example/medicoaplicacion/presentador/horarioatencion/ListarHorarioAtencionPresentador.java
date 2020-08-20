package com.example.medicoaplicacion.presentador.horarioatencion;

import com.example.medicoaplicacion.interfaces.HorarioAtencionListarInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public class ListarHorarioAtencionPresentador implements HorarioAtencionListarInterface.Presentador {

    HorarioAtencionListarInterface.Modelo horarioAtencionModelo;
    HorarioAtencionListarInterface.VistaListar vistaListar;


    public ListarHorarioAtencionPresentador(HorarioAtencionListarInterface.VistaListar vistaListar) {
        this.vistaListar = vistaListar;
        horarioAtencionModelo = new HorarioAtencionModelo(this);
    }


    @Override
    public void ejecutarListarHorarioAtencion() {
        horarioAtencionModelo.listarHorarioAtencion("1");
    }

    @Override
    public void cuandoListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list) {
        vistaListar.manejadorListaHorarioAtencionExitoso(list);
    }





}
