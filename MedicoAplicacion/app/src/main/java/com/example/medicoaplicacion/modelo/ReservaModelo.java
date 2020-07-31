package com.example.medicoaplicacion.modelo;

import androidx.recyclerview.widget.RecyclerView;


import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.presentador.reserva.ReservaMPresentador;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReservaModelo implements ReservaMInterface.Modelo {

    private String idReserva;
    private String idAtencion;
    private String idUsuario;
    private String precioConsulta;
    private String estado;
    private Map<String,Object> datosExtra;
    //private List<AtencionModelo> atencion;


    ReservaMPresentador reservaMPresentador;

    public ReservaModelo (ReservaMPresentador reservaMPresentador){
        this.reservaMPresentador = reservaMPresentador;
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


    @Override
    public void listarReserva() {

        ReservaModelo reservaModelo1 = new ReservaModelo();
        ReservaModelo reservaModelo2 = new ReservaModelo();
        ReservaModelo reservaModelo3 = new ReservaModelo();
        ReservaModelo reservaModelo4 = new ReservaModelo();
        reservaModelo1.setIdReserva("Yonathan William, Mamani Calisaya");
        reservaModelo2.setIdReserva("Juan Luis, Torres Herrera");
        reservaModelo3.setIdReserva("Rosa Ericka, Perez Jarro");
        reservaModelo4.setIdReserva("Teresa Martha, Gonzales Pinto");
        List<ReservaModelo> lista = new ArrayList<>();

        lista.add(reservaModelo1);
        lista.add(reservaModelo2);
        lista.add(reservaModelo3);
        lista.add(reservaModelo4);

        reservaMPresentador.cuandoListaReservaExitoso(lista);


    }
}
