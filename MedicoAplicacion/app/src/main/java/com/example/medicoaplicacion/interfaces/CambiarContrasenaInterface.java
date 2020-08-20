package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.UsuarioModelo;

public interface CambiarContrasenaInterface {

    interface VistaCambiarContrasena{


        void actualizarContrasena();
        void manejadorActualizarContrasenaExitoso(UsuarioModelo objUsuario); //5.1
        void manejadorActualizarContrasenaFallido(); //5.1
    }

    interface Presentador{


        void ejecutarActualizarContrasena(UsuarioModelo objUsuario); /// general el arraylist  2
        void cuandoActualizarContrasenaExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoActualizarContrasenaFallido(); // // 4.1


    }

    interface Modelo{
        void actualizarContrasena(UsuarioModelo objUsuario);  /// 3
    }
}
