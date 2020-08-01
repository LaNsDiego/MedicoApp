package com.example.medicoaplicacion.modelo;

import androidx.recyclerview.widget.RecyclerView;


import com.example.medicoaplicacion.interfaces.HomeInterface;
import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.presentador.Home.HomePresentador;
import com.example.medicoaplicacion.presentador.reserva.ReservaMPresentador;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservaModelo implements ReservaMInterface.Modelo, HomeInterface.Modelo {

    private String idReserva;
    private String idAtencion;
    private String idUsuario;
    private String precioConsulta;
    private String estado;

    private String horaAtencion;
    private String fechaAtencion;
    private String nombreUsuario;
    private String turnoAtencion;

    private Map<String,Object> datosExtra;
    //private List<AtencionModelo> atencion;


    ReservaMPresentador reservaMPresentador;
    HomePresentador homePresentador;


    public ReservaModelo (ReservaMPresentador reservaMPresentador){
        this.reservaMPresentador = reservaMPresentador;
    }

    public ReservaModelo(HomePresentador homePresentador) {
        this.homePresentador = homePresentador;
    }

    public ReservaModelo() {

    }




    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public String getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(String idAtencion) {
        this.idAtencion = idAtencion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrecioConsulta() {
        return precioConsulta;
    }

    public void setPrecioConsulta(String precioConsulta) {
        this.precioConsulta = precioConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Map<String, Object> getDatosExtra() {
        return datosExtra;
    }

    public void setDatosExtra(Map<String, Object> datosExtra) {
        this.datosExtra = datosExtra;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(String fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTurnoAtencion() {
        return turnoAtencion;
    }

    public void setTurnoAtencion(String turnoAtencion) {
        this.turnoAtencion = turnoAtencion;
    }

    @Override
    public void listarReserva() {

        ReservaModelo reservaModelo1 = new ReservaModelo();
        ReservaModelo reservaModelo2 = new ReservaModelo();
        ReservaModelo reservaModelo3 = new ReservaModelo();
        ReservaModelo reservaModelo4 = new ReservaModelo();

        reservaModelo1.setNombreUsuario("Yonathan W, Mamani C.");
        reservaModelo1.setFechaAtencion("Miercoles 29 de Julio del 2020");
        reservaModelo1.setHoraAtencion("12:00");
        reservaModelo1.setTurnoAtencion("PM");

        reservaModelo2.setNombreUsuario("Juan L, Torres H.");
        reservaModelo2.setFechaAtencion("Miercoles 29 de Julio del 2020");
        reservaModelo2.setHoraAtencion("15:00");
        reservaModelo2.setTurnoAtencion("PM");

        reservaModelo3.setNombreUsuario("Rosa E., Perez J");
        reservaModelo3.setFechaAtencion("Jueves 30 de Julio del 2020");
        reservaModelo3.setHoraAtencion("10:00");
        reservaModelo3.setTurnoAtencion("AM");

        reservaModelo4.setNombreUsuario("Teresa M., Gonzales P.");
        reservaModelo4.setFechaAtencion("Viernes 31 de Julio del 2020");
        reservaModelo4.setHoraAtencion("16:00");
        reservaModelo4.setTurnoAtencion("PM");

        List<ReservaModelo> lista = new ArrayList<>();

        lista.add(reservaModelo1);
        lista.add(reservaModelo2);
        lista.add(reservaModelo3);
        lista.add(reservaModelo4);

        reservaMPresentador.cuandoListaReservaExitoso(lista);


    }

    @Override
    public void listarReservaHome() {
        ReservaModelo reservaModelo1 = new ReservaModelo();
        ReservaModelo reservaModelo2 = new ReservaModelo();
        ReservaModelo reservaModelo3 = new ReservaModelo();
        ReservaModelo reservaModelo4 = new ReservaModelo();
        reservaModelo1.setNombreUsuario("Yonathan W, Mamani C.");
        reservaModelo1.setFechaAtencion("Lunes 3 de agosto del 2020");
        reservaModelo1.setHoraAtencion("12:00");
        reservaModelo1.setTurnoAtencion("PM");

        reservaModelo2.setNombreUsuario("Juan L, Torres H.");
        reservaModelo2.setFechaAtencion("Lunes 3 de agosto del 2020");
        reservaModelo2.setHoraAtencion("15:00");
        reservaModelo2.setTurnoAtencion("PM");

        reservaModelo3.setNombreUsuario("Rosa E., Perez J");
        reservaModelo3.setFechaAtencion("Martes 4 de agosto del 2020");
        reservaModelo3.setHoraAtencion("10:00");
        reservaModelo3.setTurnoAtencion("AM");

        reservaModelo4.setNombreUsuario("Teresa M., Gonzales P.");
        reservaModelo4.setFechaAtencion("Miercoles 5 de agosto del 2020");
        reservaModelo4.setHoraAtencion("16:00");
        reservaModelo4.setTurnoAtencion("PM");


        List<ReservaModelo> lista = new ArrayList<>();

        lista.add(reservaModelo1);
        lista.add(reservaModelo2);
        lista.add(reservaModelo3);
        lista.add(reservaModelo4);

        homePresentador.cuandoHomeListaReservaExitoso(lista);
    }
}
