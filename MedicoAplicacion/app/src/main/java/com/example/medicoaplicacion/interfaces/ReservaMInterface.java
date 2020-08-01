package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.ReservaModelo;

import java.util.List;

public interface ReservaMInterface {
    interface VistaList{
        void menejadorListarReserva(); ///1
        void manejadorListaReservaExitoso(List<ReservaModelo> list); //5.1
    }


    interface Presentador{
        void ejecutarListarReserva(); /// general el arraylist  2
        void cuandoListaReservaExitoso(List<ReservaModelo> list); // 4.1
        void cuandoListaReservaFallido(); // // 4.1


    }

    interface Modelo{
        void listarReserva();  /// 3

    }

    interface RowListener {
        void onClickVerReservaRow(String idReserva);//clic en la fila
    }

}
