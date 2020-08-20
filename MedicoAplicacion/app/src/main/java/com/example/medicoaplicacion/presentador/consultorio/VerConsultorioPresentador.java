package com.example.medicoaplicacion.presentador.consultorio;

import com.example.medicoaplicacion.interfaces.ConsultorioInterface;
import com.example.medicoaplicacion.modelo.ConsultorioModelo;

public class VerConsultorioPresentador implements ConsultorioInterface.Presentador {

    ConsultorioInterface.Modelo consultorioModelo;
    ConsultorioInterface.VistaConsultorio vistaConsultorioVista;

    public VerConsultorioPresentador(ConsultorioInterface.VistaConsultorio vistaConsultorioVista) {
        consultorioModelo = new ConsultorioModelo(this);
        this.vistaConsultorioVista = vistaConsultorioVista;
    }

    @Override
    public void ejecutarVerConsultorio(String idUsuario) {
        consultorioModelo.ObtenerPorIdConsultorio(idUsuario);
    }

    @Override
    public void cuandoVerConsultorioExitoso(ConsultorioModelo objConsultorio) {
        vistaConsultorioVista.manejadorVerConsultorioExitoso (objConsultorio);
    }

    @Override
    public void cuandoVerConsultorioFallido() {
        vistaConsultorioVista.manejadorActualizarConsultorioFallido();
    }

    @Override
    public void ejecutarActualizarConsultorio(ConsultorioModelo objConsultorio) {
        consultorioModelo.actualizarConsultorio(objConsultorio);
    }

    @Override
    public void cuandoActualizarConsultorioExitoso(ConsultorioModelo objConsultorio) {
        vistaConsultorioVista.manejadorActualizarConsultorioExitoso(objConsultorio);
    }

    @Override
    public void cuandoActualizarConsultorioFallido() {
        vistaConsultorioVista.manejadorActualizarConsultorioFallido();
    }
}
