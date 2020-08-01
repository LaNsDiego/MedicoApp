package com.example.medicoaplicacion.presentador.perfil;

import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.google.android.material.textview.MaterialTextView;

public class VerPerfilPresentador implements PerfilInterface.Presentador {

    PerfilInterface.Modelo usuarioModelo;
    PerfilInterface.VistaPerfil vistaPerfil;
    MaterialTextView tf;
    public VerPerfilPresentador(PerfilInterface.VistaPerfil vistaPerfil) {

        usuarioModelo = new UsuarioModelo(this);
        this.vistaPerfil = vistaPerfil;

    }

    @Override
    public void ejecutarVerPerfil() {
        usuarioModelo.ObtenerPorIdUsuario("1");
    }

    @Override
    public void cuandoVerPerfilExitoso(UsuarioModelo objUsuario) {
        vistaPerfil.manejadorVerPerfilExitoso(objUsuario);

    }

    @Override
    public void cuandoVerPerfilFallido() {

    }
}
