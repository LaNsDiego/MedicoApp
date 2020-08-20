package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.DiaAtencionModelo;

import java.util.List;

public interface DiaAtencionInterface {

    interface VistaList{
        void menejadorListarDiasAtencion(); ///1
        void NuevoHorarioAtencion(); ///1
        void manejadorListaDiasAtencionExitoso(List<DiaAtencionModelo> list); //5.1
    }

    interface Presentador{
        void ejecutarListarDiasAtencion(); /// general el arraylist  2
        void cuandoListaDiasAtencionExitoso(List<DiaAtencionModelo> list); // 4.1
        void cuandoListaDiasAtencionFallido(); // // 4.1



    }

    interface Modelo{
        void listarDiasAtencion();  /// 3

    }

    interface RowListener {
        void onClickDiaAtencionRow(String idDiaAtencion);//clic en la fila
    }
}
