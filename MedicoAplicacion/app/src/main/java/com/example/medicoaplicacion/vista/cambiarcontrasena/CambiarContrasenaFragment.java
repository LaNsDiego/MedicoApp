package com.example.medicoaplicacion.vista.cambiarcontrasena;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.CambiarContrasenaInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.cambiarcontrasena.CambiarContrasenaPresentador;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CambiarContrasenaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CambiarContrasenaFragment extends Fragment implements CambiarContrasenaInterface.VistaCambiarContrasena {

    TextInputEditText tfNuevaContrasena,tfContrasenaActual,tfRepetirContrasena;
    Button btnCambiarContrasena;
    CambiarContrasenaInterface.Presentador presentador;
    public CambiarContrasenaFragment() {
        // Required empty public constructor
    }


    public static CambiarContrasenaFragment newInstance(String param1, String param2) {
        CambiarContrasenaFragment fragment = new CambiarContrasenaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_cambiar_contrasena_m, container, false);
        presentador = new CambiarContrasenaPresentador(this);

        tfNuevaContrasena = vista.findViewById(R.id.tfContrasenaNueva);
        tfRepetirContrasena = vista.findViewById(R.id.tfRepetirContrasena);
        tfContrasenaActual = vista.findViewById(R.id.tfContrasenaActual);
        btnCambiarContrasena = vista.findViewById(R.id.btnCambiarContrasena);

        btnCambiarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarContrasena();
            }
        });


        return vista;
    }

    @Override
    public void actualizarContrasena() {
        UsuarioModelo usuario = new UsuarioModelo();
        usuario.setClave(tfContrasenaActual.getText().toString());
        usuario.setNuevaClave(tfNuevaContrasena.getText().toString());
        usuario.setRepetirClave(tfRepetirContrasena.getText().toString());

        presentador.ejecutarActualizarContrasena(usuario);
    }

    @Override
    public void manejadorActualizarContrasenaExitoso(UsuarioModelo objUsuario) {
        Toast.makeText(getContext(), "Se ha actualizado exitosamente la contraseña.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarContrasenaFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
