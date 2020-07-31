package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.UsuarioModelo;

public interface UsuarioInterface {

    interface VistaLoginActivity{
        void manejadorIniciarSesion();
        void manejadorInicioSesionExitoso(UsuarioModelo usuarioLogueado);
        void manejadorInicioSesionFallido();
    }

    interface Presentador{
        void ejecutarInicioSesion(String usuario , String clave);

        //Callbacks
        void cuandoInicioSesionExitoso(UsuarioModelo usuarioLogueado);
        void cuandoInicioSesionFallido();
    }

    interface Modelo{
        void iniciarSesion(String usuario , String clave);
    }
}
