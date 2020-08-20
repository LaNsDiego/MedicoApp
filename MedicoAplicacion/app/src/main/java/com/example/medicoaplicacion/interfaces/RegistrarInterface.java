package com.example.medicoaplicacion.interfaces;

import com.example.medicoaplicacion.modelo.UsuarioModelo;

public interface RegistrarInterface {

    interface VistaRegistrar{
        void nuevoMedico();
        void manejadorNuevoMedicoExitoso(UsuarioModelo objUsuario); //5.1
        void manejadorNuevoMedicoFallido(); //5.1
    }

    interface Presentador{

        void ejecutarRegistrarMedico(UsuarioModelo objUsuario); /// general el arraylist  2
        void cuandoRegistrarMedicoExitoso(UsuarioModelo objUsuario); // 4.1
        void cuandoRegistrarMedicoFallido(); // // 4.1

    }

    interface Modelo{
        void nuevoMedico(UsuarioModelo objUsuario);  /// 3
        void nuevoUsuario(UsuarioModelo objUsuario);  /// 3
    }
}
