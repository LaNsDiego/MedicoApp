package com.example.medicoaplicacion.presentador.horarioatencion;

import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

public class AgregarHorarioAtencionPresentador implements HorarioAtencionInterface.Presentador {

    HorarioAtencionInterface.Modelo horarioAtencionModelo;
    HorarioAtencionInterface.VistaAgregar vistaAgregar;

    HorarioAtencionInterface.VistaEditar vistaEditar;


    public AgregarHorarioAtencionPresentador(HorarioAtencionInterface.VistaAgregar vistaAgregar) {
        this.vistaAgregar = vistaAgregar;
        this.horarioAtencionModelo = new HorarioAtencionModelo(this);
    }

    public AgregarHorarioAtencionPresentador(HorarioAtencionInterface.VistaEditar vistaEditar) {
        this.vistaEditar = vistaEditar;
        this.horarioAtencionModelo = new HorarioAtencionModelo(this);
    }

    @Override
    public void ejecutarAgregarHorarioAtencion(HorarioAtencionModelo objhorario) {

        switch (objhorario.getDia()){
            case "Lunes": objhorario.setNroDia("1"); break;
            case "Martes": objhorario.setNroDia("2"); break;
            case "Miercoles": objhorario.setNroDia("3"); break;
            case "Jueves": objhorario.setNroDia("4"); break;
            case "Viernes": objhorario.setNroDia("5"); break;
            case "Sabado": objhorario.setNroDia("6"); break;
            case "Domingo": objhorario.setNroDia("7"); break;
        }

        horarioAtencionModelo.agregarHorarioAtencion(objhorario);
    }

    @Override
    public void cuandoAgregarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo) {
        vistaAgregar.manejadorAgregarHorarioAtencionExitoso();
    }

    @Override
    public void cuandoAgregarHorarioAtencionFallido() {
        vistaAgregar.manejadorAgregarHorarioAtencionFallido();
    }

    @Override
    public void ejecutarEditarHorarioAtencion(HorarioAtencionModelo horario) {

        switch (horario.getDia()){
            case "Lunes": horario.setNroDia("1"); break;
            case "Martes": horario.setNroDia("2"); break;
            case "Miercoles": horario.setNroDia("3"); break;
            case "Jueves": horario.setNroDia("4"); break;
            case "Viernes": horario.setNroDia("5"); break;
            case "Sabado": horario.setNroDia("6"); break;
            case "Domingo": horario.setNroDia("7"); break;
        }
        horarioAtencionModelo.editarHorarioAtencion(horario);

    }

    @Override
    public void cuandoEditarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo) {
        vistaEditar.manejadorEditarHorarioAtencionExitoso();
    }

    @Override
    public void cuandoEditarHorarioAtencionFallido() {
        vistaEditar.manejadorEditarHorarioAtencionFallido();
    }

    @Override
    public void ejecutarVerHorarioAtencion(String idHorarioAtencion) {
        horarioAtencionModelo.verHorarioAtencion(idHorarioAtencion);
    }

    @Override
    public void cuandoVerHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo) {
        vistaEditar.manejadorVerHorarioAtencionExitoso(horarioAtencionModelo);
    }

    @Override
    public void cuandoVerHorarioAtencionFallido() {
        vistaEditar.manejadorVerHorarioAtencionFallido();
    }



}
