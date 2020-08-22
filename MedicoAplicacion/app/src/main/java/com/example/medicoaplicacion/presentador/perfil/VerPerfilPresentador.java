package com.example.medicoaplicacion.presentador.perfil;

import android.util.Log;
import android.widget.Toast;

import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.google.android.material.textview.MaterialTextView;

public class VerPerfilPresentador implements PerfilInterface.Presentador {

    PerfilInterface.Modelo usuarioModelo;
    PerfilInterface.VistaPerfil vistaPerfil;


    public VerPerfilPresentador(PerfilInterface.VistaPerfil vistaPerfil) {

        usuarioModelo = new UsuarioModelo(this);
        this.vistaPerfil = vistaPerfil;

    }

    @Override
    public void ejecutarVerPerfil(String idUsuario) {


        usuarioModelo.ObtenerPorIdUsuario(idUsuario);

    }

    @Override
    public void cuandoVerPerfilExitoso(UsuarioModelo objUsuario) {
        vistaPerfil.manejadorVerPerfilExitoso(objUsuario);

    }

    @Override
    public void cuandoVerPerfilFallido() {

    }

    @Override
    public void ejecutarActualizarPerfil(UsuarioModelo objUsuario) {
        usuarioModelo.actualizarPerfil(objUsuario);
    }

    @Override
    public void cuandoActualizarPerfilExitoso(UsuarioModelo objUsuario) {
        vistaPerfil.manejadorActualizarPerfilExitoso(objUsuario);
    }

    @Override
    public void cuandoActualizarPerfilFallido() {
        vistaPerfil.manejadorActualizarPerfilFallido();
    }

    @Override
    public void ejecutarActualizarFoto(UsuarioModelo objUsuario) {
        usuarioModelo.actualizarFoto(objUsuario);
    }

    @Override
    public void cuandoActualizarFotoExitoso(UsuarioModelo objUsuario) {
        vistaPerfil.manejadorActualizarFotoExitoso(objUsuario);
    }

    @Override
    public void cuandoActualizarFotoFallido() {
        vistaPerfil.manejadorActualizarFotoFallido();
    }
}
