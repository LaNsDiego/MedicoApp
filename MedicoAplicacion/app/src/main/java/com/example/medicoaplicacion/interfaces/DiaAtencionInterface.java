package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.DiasAtencionModelo;

import java.util.List;

public interface DiaAtencionInterface {

    interface VistaList{
        void menejadorListarDiasAtencion(); ///1

        void manejadorListaDiasAtencionExitoso(List<DiasAtencionModelo> list); //5.1
    }

    interface Presentador{
        void ejecutarListarDiasAtencion(); /// general el arraylist  2
        void cuandoListaDiasAtencionExitoso(List<DiasAtencionModelo> list); // 4.1
        void cuandoListaDiasAtencionFallido(); // // 4.1



    }

    interface Modelo{
        void listarDiasAtencion(String idMedico);  /// 3

    }
}
