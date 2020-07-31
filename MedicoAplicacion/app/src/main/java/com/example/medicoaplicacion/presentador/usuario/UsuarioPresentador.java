package com.example.medicoaplicacion.presentador.usuario;

import com.example.medicoaplicacion.interfaces.UsuarioInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;

public class UsuarioPresentador implements UsuarioInterface.Presentador {

    UsuarioModelo modelo;
    UsuarioInterface.VistaLoginActivity vistaLoginActivity;

    public UsuarioPresentador(UsuarioInterface.VistaLoginActivity vistaLoginActivity) {
        this.modelo = new UsuarioModelo(this);
        this.vistaLoginActivity = vistaLoginActivity;
    }

    @Override
    public void ejecutarInicioSesion(String usuario , String clave) {
        modelo.iniciarSesion(usuario , clave);
    }

    @Override
    public void cuandoInicioSesionExitoso(UsuarioModelo usuarioLogueado) {
        vistaLoginActivity.manejadorInicioSesionExitoso(usuarioLogueado);
    }

    @Override
    public void cuandoInicioSesionFallido() {
        vistaLoginActivity.manejadorInicioSesionFallido();
    }
}
