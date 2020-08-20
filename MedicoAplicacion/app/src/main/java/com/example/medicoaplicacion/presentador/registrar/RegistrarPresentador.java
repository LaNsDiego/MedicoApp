package com.example.medicoaplicacion.presentador.registrar;

import com.example.medicoaplicacion.interfaces.RegistrarInterface;
import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;

public class RegistrarPresentador implements RegistrarInterface.Presentador {

    RegistrarInterface.VistaRegistrar vistaRegistrar;
    RegistrarInterface.Modelo usuarioModelo;

    public RegistrarPresentador(RegistrarInterface.VistaRegistrar vistaRegistrar) {
        this.vistaRegistrar = vistaRegistrar;
        this.usuarioModelo = new UsuarioModelo(this);
    }

    @Override
    public void ejecutarRegistrarMedico(UsuarioModelo objUsuario) {
        usuarioModelo.nuevoMedico(objUsuario);
    }

    @Override
    public void cuandoRegistrarMedicoExitoso(UsuarioModelo objUsuario) {
        vistaRegistrar.manejadorNuevoMedicoExitoso(objUsuario);
    }

    @Override
    public void cuandoRegistrarMedicoFallido() {
        vistaRegistrar.manejadorNuevoMedicoFallido();
    }
}
