package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public interface HorarioAtencionInterface {

    interface VistaListar{
        void menejadorListarHorarioAtencion(); ///1

        void manejadorListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list); //5.1
    }

    interface Presentador{
        void ejecutarListarHorarioAtencion(); /// general el arraylist  2
        void cuandoListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list); // 4.1
        void cuandoListaHorarioAtencionFallido(); // // 4.1



    }

    interface Modelo{
        void listarHorarioAtencion(String idDiaAtencion);  /// 3

    }

    //interface RowListener {
     //   void onClickHorarioAtencionRow(String idHorarioAtencion);//clic en la fila
    //}
}
