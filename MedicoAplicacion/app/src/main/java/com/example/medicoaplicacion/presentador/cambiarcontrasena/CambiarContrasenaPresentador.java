package com.example.medicoaplicacion.presentador.cambiarcontrasena;

import com.example.medicoaplicacion.interfaces.CambiarContrasenaInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;

public class CambiarContrasenaPresentador implements CambiarContrasenaInterface.Presentador {

    CambiarContrasenaInterface.Modelo usuarioModelo;
    CambiarContrasenaInterface.VistaCambiarContrasena cambiarContrasenaVista;

    public CambiarContrasenaPresentador(CambiarContrasenaInterface.VistaCambiarContrasena cambiarContrasenaVista) {
        this.cambiarContrasenaVista = cambiarContrasenaVista;
        this.usuarioModelo = new UsuarioModelo(this);
    }

    @Override
    public void ejecutarActualizarContrasena(UsuarioModelo objUsuario) {
        usuarioModelo.actualizarContrasena(objUsuario);
    }

    @Override
    public void cuandoActualizarContrasenaExitoso(UsuarioModelo objUsuario) {
        cambiarContrasenaVista.manejadorActualizarContrasenaExitoso(objUsuario);
    }

    @Override
    public void cuandoActualizarContrasenaFallido() {
        cambiarContrasenaVista.manejadorActualizarContrasenaFallido();
    }
}
