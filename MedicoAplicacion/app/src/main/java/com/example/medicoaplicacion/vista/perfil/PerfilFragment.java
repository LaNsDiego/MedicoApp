package com.example.medicoaplicacion.vista.perfil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.perfil.VerPerfilPresentador;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment implements PerfilInterface.VistaPerfil {

    TextInputEditText tfNroDocumento;

    UsuarioModelo usuarioModelo;
    PerfilInterface.Presentador presentador;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View vista = inflater.inflate(R.layout.fragment_ver_perfil, container, false);

        presentador = new VerPerfilPresentador(this);
        tfNroDocumento = vista.findViewById(R.id.tfNroDocumento);
        menejadorVerPerfil("1");
        return  vista;


    }


    @Override
    public void menejadorVerPerfil(String idUsuario) {
        presentador.ejecutarVerPerfil();
    }

    @Override
    public void manejadorVerPerfilExitoso(UsuarioModelo objUsuario) {
        //Toast.makeText(getContext(), "click en una fila", Toast.LENGTH_SHORT).show();
    }
}
