package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.UsuarioModelo;

public interface PerfilInterface {

    interface VistaPerfil{
        void menejadorVerPerfil(); ///1
        void manejadorVerPerfilExitoso(UsuarioModelo objUsuario); //5.1

        void actualizarPerfil();
        void manejadorActualizarPerfilExitoso(UsuarioModelo objUsuario); //5.1
        void manejadorActualizarPerfilFallido(); //5.1

        void actualizarFoto(UsuarioModelo usuarioModelo);
        void manejadorActualizarFotoExitoso(UsuarioModelo objUsuario); //5.1
        void manejadorActualizarFotoFallido(); //5.1
    }

    interface Presentador{

        void ejecutarVerPerfil(String idUsuario); /// general el arraylist  2
        void cuandoVerPerfilExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoVerPerfilFallido(); // // 4.1

        void ejecutarActualizarPerfil(UsuarioModelo objUsuario); /// general el arraylist  2
        void cuandoActualizarPerfilExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoActualizarPerfilFallido(); // // 4.1

        void ejecutarActualizarFoto(UsuarioModelo objUsuario); /// general el arraylist  2
        void cuandoActualizarFotoExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoActualizarFotoFallido(); // // 4.1


    }

    interface Modelo{
        void ObtenerPorIdUsuario(String idUsuario);  /// 3
        void actualizarPerfil(UsuarioModelo objUsuario);  /// 3
        void actualizarFoto(UsuarioModelo objUsuario);  /// 3
    }
}
