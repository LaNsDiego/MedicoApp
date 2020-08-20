package com.example.medicoaplicacion.vista.perfil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
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

    TextInputEditText tfNroDocumento,tfNombresApellidos,tfEmail,tfCelular,tfFechaNacimiento,tfNroColegiatura,tfBiografia;
    AutoCompleteTextView tfTipoDocumento, tfEspecialidad;
    Button btnActualizarPerfil;
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
        tfNombresApellidos = vista.findViewById(R.id.tfNombresApellidos);
        tfEmail = vista.findViewById(R.id.tfEmail);
        tfCelular = vista.findViewById(R.id.tfCelular);
        tfFechaNacimiento = vista.findViewById(R.id.tfFechaNacimiento);
        tfNroColegiatura = vista.findViewById(R.id.tfNroColegiatura);
        tfBiografia = vista.findViewById(R.id.tfBiografia);
        tfTipoDocumento = vista.findViewById(R.id.tfTipoDocumento);
        tfEspecialidad = vista.findViewById(R.id.tfEspecialidad);

        btnActualizarPerfil = vista.findViewById(R.id.btnActualizarPerfil);

        btnActualizarPerfil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               actualizarPerfil();
           }
        });

        menejadorVerPerfil();


        String[] tipoDocumento = new String[] {"DNI", "RUC", "PASAPORTE"};
        ArrayAdapter<String> adapterTipoDocumento =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        tipoDocumento);
        AutoCompleteTextView editTextFilledExposedDropdownTipoDocumento = vista.findViewById(R.id.tfTipoDocumento);
        editTextFilledExposedDropdownTipoDocumento.setAdapter(adapterTipoDocumento);

        String[] especialidad = new String[] {"Cardiologo", "Radiologo" , "Medicio General"};
        ArrayAdapter<String> adapterEspecialidad =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        especialidad);
        AutoCompleteTextView editTextFilledExposedDropdownEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        editTextFilledExposedDropdownEspecialidad.setAdapter(adapterEspecialidad);

        return  vista;


    }


    @Override
    public void menejadorVerPerfil() {

        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        presentador.ejecutarVerPerfil(idUsuario);

    }

    @Override
    public void manejadorVerPerfilExitoso(UsuarioModelo objUsuario) {

        tfTipoDocumento.setText(objUsuario.getTipoDocumento());
        tfNroDocumento.setText(objUsuario.getNroDocumento());
        tfNombresApellidos.setText(objUsuario.getNombres());
        tfEmail.setText(objUsuario.getEmail());
        tfCelular.setText(objUsuario.getCelular());
        tfFechaNacimiento.setText(objUsuario.getFechaNacimiento());
        tfEspecialidad.setText(objUsuario.getEspecialidad());
        tfNroColegiatura.setText(objUsuario.getColegiatura());
        tfBiografia.setText(objUsuario.getBiografia());

    }

    @Override
    public void actualizarPerfil() {
        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        UsuarioModelo user = new UsuarioModelo();
        user.setIdUsuario(idUsuario);
        user.setTipoDocumento(tfTipoDocumento.getText().toString());
        user.setNroDocumento(tfNroDocumento.getText().toString());
        user.setNombres(tfNombresApellidos.getText().toString());
        user.setEmail(tfEmail.getText().toString());
        user.setCelular(tfCelular.getText().toString());
        user.setFechaNacimiento(tfFechaNacimiento.getText().toString());
        user.setEspecialidad(tfEspecialidad.getText().toString());
        user.setColegiatura(tfNroColegiatura.getText().toString());
        user.setBiografia(tfBiografia.getText().toString());

        presentador.ejecutarActualizarPerfil(user);
    }

    @Override
    public void manejadorActualizarPerfilExitoso(UsuarioModelo objUsuario) {
        Toast.makeText(getContext(), "Se ha actualizado exitosamente los datos.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarPerfilFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
