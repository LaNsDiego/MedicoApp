package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.UsuarioModelo;

public interface PerfilInterface {

    interface VistaPerfil{
        void menejadorVerPerfil(String idUsuario); ///1
        void manejadorVerPerfilExitoso(UsuarioModelo objUsuario); //5.1
    }

    interface Presentador{

        void ejecutarVerPerfil(); /// general el arraylist  2
        void cuandoVerPerfilExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoVerPerfilFallido(); // // 4.1



    }

    interface Modelo{
        void ObtenerPorIdUsuario(String idUsuario);  /// 3
    }
}
