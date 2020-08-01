package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.ReservaModelo;
import java.util.List;
public interface HomeInterface {


    interface VistaHomeList{
        void menejadorHomeListarReserva(); ///1
        void manejadorHomeListaReservaExitoso(List<ReservaModelo> list); //5.1
    }

    interface Presentador{

        void ejecutarHomeListarReserva(); /// general el arraylist  2
        void cuandoHomeListaReservaExitoso(List<ReservaModelo> list); // 4.1
        void cuandoHomeListaReservaFallido(); // // 4.1

    }

    interface Modelo{
        void listarReservaHome();  /// 3
    }

    interface RowListener {
        void onClickHomeVerReservaRow(String idReserva);//clic en la fila
    }

}


