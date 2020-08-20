package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public interface HorarioAtencionAgregarInterface {


    interface VistaAgregar{
        void menejadorAgregarHorarioAtencion(); ///1
        void manejadorAgregarHorarioAtencionExitoso(); //5.1
        void manejadorAgregarHorarioAtencionFallido(); //5.1
    }


    interface Presentador{


        void ejecutarAgregarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);

        void cuandoAgregarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo); // 4.1
        void cuandoAgregarHorarioAtencionFallido(); // // 4.1


    }

    interface Modelo{


        void agregarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);  /// 3


    }

}
