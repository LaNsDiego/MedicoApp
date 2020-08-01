package com.example.medicoaplicacion.presentador.Home;

import com.example.medicoaplicacion.interfaces.HomeInterface;
import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;

import java.util.List;

public class HomePresentador implements HomeInterface.Presentador {

    HomeInterface.VistaHomeList vistaList;
    HomeInterface.Modelo reservaModelo;

    public HomePresentador(HomeInterface.VistaHomeList vistaList) {
        reservaModelo = new ReservaModelo(this);
        this.vistaList = vistaList;
    }

    @Override
    public void ejecutarHomeListarReserva() {
        reservaModelo.listarReservaHome();
    }

    @Override
    public void cuandoHomeListaReservaExitoso(List<ReservaModelo> list) {
        vistaList.manejadorHomeListaReservaExitoso(list);
    }

    @Override
    public void cuandoHomeListaReservaFallido() {

    }
}
