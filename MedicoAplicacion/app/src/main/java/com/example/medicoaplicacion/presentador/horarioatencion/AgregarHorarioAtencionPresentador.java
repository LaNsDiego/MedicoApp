package com.example.medicoaplicacion.presentador.horarioatencion;

import com.example.medicoaplicacion.interfaces.HorarioAtencionAgregarInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

public class AgregarHorarioAtencionPresentador implements HorarioAtencionAgregarInterface.Presentador {

    HorarioAtencionAgregarInterface.Modelo horarioAtencionModelo;
    HorarioAtencionAgregarInterface.VistaAgregar vistaAgregar;


    public AgregarHorarioAtencionPresentador(HorarioAtencionAgregarInterface.VistaAgregar vistaAgregar) {
        this.vistaAgregar = vistaAgregar;
        this.horarioAtencionModelo = new HorarioAtencionModelo(this);
    }

    @Override
    public void ejecutarAgregarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo) {

        switch (horarioAtencionModelo.getDia()){
            case "Lunes": horarioAtencionModelo.setNroDia("1"); break;
            case "Martes": horarioAtencionModelo.setNroDia("2"); break;
            case "Miercoles": horarioAtencionModelo.setNroDia("3"); break;
            case "Jueves": horarioAtencionModelo.setNroDia("4"); break;
            case "Viernes": horarioAtencionModelo.setNroDia("5"); break;
            case "Sabado": horarioAtencionModelo.setNroDia("6"); break;
            case "Domingo": horarioAtencionModelo.setNroDia("7"); break;
        }

        horarioAtencionModelo.agregarHorarioAtencion(horarioAtencionModelo);
    }

    @Override
    public void cuandoAgregarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo) {
        vistaAgregar.manejadorAgregarHorarioAtencionExitoso();
    }

    @Override
    public void cuandoAgregarHorarioAtencionFallido() {
        vistaAgregar.manejadorAgregarHorarioAtencionFallido();
    }
}
