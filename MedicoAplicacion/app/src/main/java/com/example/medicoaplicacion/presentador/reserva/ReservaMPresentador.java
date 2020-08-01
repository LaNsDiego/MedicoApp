package com.example.medicoaplicacion.presentador.reserva;

import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;

import java.util.List;

public class ReservaMPresentador implements ReservaMInterface.Presentador {

    ReservaMInterface.VistaList vistaList;
    ReservaMInterface.Modelo reservaModelo;

    public ReservaMPresentador(ReservaMInterface.VistaList vistaList) {
        reservaModelo = new ReservaModelo(this);
        this.vistaList = vistaList;
    }


    @Override
    public void ejecutarListarReserva() {
        reservaModelo.listarReserva();
    }

    @Override
    public void cuandoListaReservaExitoso(List<ReservaModelo> list) {
        vistaList.manejadorListaReservaExitoso(list);
    }

    @Override
    public void cuandoListaReservaFallido() {

    }


}
