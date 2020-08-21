package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public interface HorarioAtencionInterface {


    interface VistaAgregar{
        void menejadorAgregarHorarioAtencion(); ///1
        void manejadorAgregarHorarioAtencionExitoso(); //5.1
        void manejadorAgregarHorarioAtencionFallido(); //5.1
    }

    interface VistaEditar{
        void menejadorEditarHorarioAtencion(); ///1
        void manejadorEditarHorarioAtencionExitoso(); //5.1
        void manejadorEditarHorarioAtencionFallido(); //5.1

        void menejadorVerHorarioAtencion(String idHorarioAtencion); ///1
        void manejadorVerHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo); //5.1
        void manejadorVerHorarioAtencionFallido(); //5.1
    }


    interface Presentador{


        void ejecutarAgregarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);
        void cuandoAgregarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo); // 4.1
        void cuandoAgregarHorarioAtencionFallido(); // // 4.1


        void ejecutarEditarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);
        void cuandoEditarHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo); // 4.1
        void cuandoEditarHorarioAtencionFallido(); // // 4.1

        void ejecutarVerHorarioAtencion(String idHorarioAtencion);
        void cuandoVerHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo); // 4.1
        void cuandoVerHorarioAtencionFallido(); // // 4.1


    }

    interface Modelo{


        void agregarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);  /// 3
        void editarHorarioAtencion(HorarioAtencionModelo horarioAtencionModelo);  /// 3
        void verHorarioAtencion(String idHorarioAtencion);  /// 3


    }

}
