package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.ConsultorioModelo;

public interface ConsultorioInterface {

    interface VistaConsultorio{
        void menejadorVerConsultorio(); ///1
        void manejadorVerConsultorioExitoso(ConsultorioModelo objConsultorio); //5.1

        void actualizarConsultorio();
        void manejadorActualizarConsultorioExitoso(ConsultorioModelo objConsultorio); //5.1
        void manejadorActualizarConsultorioFallido(); //5.1
    }

    interface Presentador{

        void ejecutarVerConsultorio(String idUsuario); /// general el arraylist  2
        void cuandoVerConsultorioExitoso(ConsultorioModelo objConsultorio); // 4.1
        void cuandoVerConsultorioFallido(); // // 4.1

        void ejecutarActualizarConsultorio(ConsultorioModelo objConsultorio); /// general el arraylist  2
        void cuandoActualizarConsultorioExitoso(ConsultorioModelo objConsultorio); // 4.1
        void cuandoActualizarConsultorioFallido(); // // 4.1


    }

    interface Modelo{
        void ObtenerPorIdConsultorio(String idConsultorio);  /// 3
        void actualizarConsultorio(ConsultorioModelo objConsultorio);  /// 3
    }
}
