package com.example.medicoaplicacion.modelo;

import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;

import java.util.ArrayList;
import java.util.List;

public class HorarioAtencionModelo implements HorarioAtencionInterface.Modelo {

    private String idHorarioAtencion;
    private String idDiaAtencion;
    private String horaInicio;
    private String horaFin;
    private String estado;

    HorarioAtencionInterface.Presentador presentadorHorarioAtencion;

    public HorarioAtencionModelo(HorarioAtencionInterface.Presentador presentadorHorarioAtencion) {
        this.presentadorHorarioAtencion = presentadorHorarioAtencion;
    }

    public HorarioAtencionModelo() {

    }


    public String getIdHorarioAtencion() {
        return idHorarioAtencion;
    }

    public void setIdHorarioAtencion(String idHorarioAtencion) {
        this.idHorarioAtencion = idHorarioAtencion;
    }

    public String getIdDiaAtencion() {
        return idDiaAtencion;
    }

    public void setIdDiaAtencion(String idDiaAtencion) {
        this.idDiaAtencion = idDiaAtencion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public void listarHorarioAtencion(String idDiaAtencion) {

        HorarioAtencionModelo horarioAtencionModelo1 = new HorarioAtencionModelo();
        HorarioAtencionModelo horarioAtencionModelo2 = new HorarioAtencionModelo();
        HorarioAtencionModelo horarioAtencionModelo3 = new HorarioAtencionModelo();
        HorarioAtencionModelo horarioAtencionModelo4 = new HorarioAtencionModelo();
        HorarioAtencionModelo horarioAtencionModelo5 = new HorarioAtencionModelo();

        horarioAtencionModelo1.setIdHorarioAtencion("1");
        horarioAtencionModelo1.setIdDiaAtencion(idDiaAtencion);
        horarioAtencionModelo1.setHoraInicio("10:00");
        horarioAtencionModelo1.setHoraFin("12:00");
        horarioAtencionModelo1.setEstado("Activo");

        horarioAtencionModelo2.setIdHorarioAtencion("2");
        horarioAtencionModelo2.setIdDiaAtencion(idDiaAtencion);
        horarioAtencionModelo2.setHoraInicio("12:00");
        horarioAtencionModelo2.setHoraFin("14:00");
        horarioAtencionModelo2.setEstado("Activo");

        horarioAtencionModelo3.setIdHorarioAtencion("3");
        horarioAtencionModelo3.setIdDiaAtencion(idDiaAtencion);
        horarioAtencionModelo3.setHoraInicio("14:00");
        horarioAtencionModelo3.setHoraFin("16:00");
        horarioAtencionModelo3.setEstado("Activo");

        horarioAtencionModelo4.setIdHorarioAtencion("4");
        horarioAtencionModelo4.setIdDiaAtencion(idDiaAtencion);
        horarioAtencionModelo4.setHoraInicio("16:00");
        horarioAtencionModelo4.setHoraFin("18:00");
        horarioAtencionModelo4.setEstado("Activo");

        horarioAtencionModelo5.setIdHorarioAtencion("5");
        horarioAtencionModelo5.setIdDiaAtencion(idDiaAtencion);
        horarioAtencionModelo5.setHoraInicio("18:00");
        horarioAtencionModelo5.setHoraFin("20:00");
        horarioAtencionModelo5.setEstado("Activo");

       List<HorarioAtencionModelo> lista = new ArrayList<>();
       lista.add(horarioAtencionModelo1);
       lista.add(horarioAtencionModelo2);
       lista.add(horarioAtencionModelo3);
       lista.add(horarioAtencionModelo4);
       lista.add(horarioAtencionModelo5);

        presentadorHorarioAtencion.cuandoListaHorarioAtencionExitoso(lista);

    }
}
