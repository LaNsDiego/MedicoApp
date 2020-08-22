package com.example.medicoaplicacion.vista.consultorio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.ConsultorioInterface;
import com.example.medicoaplicacion.modelo.ConsultorioModelo;
import com.example.medicoaplicacion.modelo.EspecialidadModelo;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.presentador.consultorio.VerConsultorioPresentador;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultorioMFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultorioMFragment extends Fragment implements ConsultorioInterface.VistaConsultorio {


    TextInputEditText tfnombre,tfDireccion,tfReferencia,tfTelefono,tfCelular,tfEmail,tfPrecioConsulta,tfServiciosOfrecidos;
    Button btnActualizarConsultorio;
    AutoCompleteTextView tfEspecialidad;
    public  static  Double latitud;
    public  static  Double Longitud;
    public  static  String Direccion;
    ConsultorioInterface.Presentador consultorioPresentador;
    EspecialidadModelo especialidadModelo;
    public ConsultorioMFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultorioMFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultorioMFragment newInstance(String param1, String param2) {
        ConsultorioMFragment fragment = new ConsultorioMFragment();
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
        View vista = inflater.inflate(R.layout.fragment_consultorio_m, container, false);

        consultorioPresentador = new VerConsultorioPresentador(this);
        especialidadModelo = new EspecialidadModelo();

        tfnombre = vista.findViewById(R.id.tfnombre);
        tfDireccion = vista.findViewById(R.id.tfDireccion);
        tfReferencia = vista.findViewById(R.id.tfReferencia);
        tfTelefono = vista.findViewById(R.id.tfTelefono);
        tfCelular = vista.findViewById(R.id.tfCelular);
        tfEmail = vista.findViewById(R.id.tfEmail);
        tfPrecioConsulta = vista.findViewById(R.id.tfPrecioConsulta);
        tfServiciosOfrecidos = vista.findViewById(R.id.tfServiciosOfrecidos);
        tfEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        btnActualizarConsultorio = vista.findViewById(R.id.btnActualizarConsultorio);
        tfDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje();
            }
        });
        btnActualizarConsultorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarConsultorio();
            }
        });
        menejadorVerConsultorio();

        String[] especialidad = new String[] {"Anesteciología", "Ginecobstetra" , "Pediatría","Odontologia","Psiquiatría","Dermatología","Neurología"};

        ArrayAdapter<String> adapterEspecialidad =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        especialidad);
        AutoCompleteTextView editTextFilledExposedDropdownEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        editTextFilledExposedDropdownEspecialidad.setAdapter(adapterEspecialidad);

        //ABRIR MAPA
        TextInputLayout til = vista.findViewById(R.id.tf_layout_address);
        til.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirModalMapa();
            }
        });




        return vista;
    }

    public void abrirModalMapa(){
        MapaFragment mapaF = new MapaFragment();
        mapaF.show(getChildFragmentManager(),"GAA");
    }


    public void mensaje(){
        tfDireccion.setText(Direccion);
    }


    @Override
    public void menejadorVerConsultorio() {
        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        consultorioPresentador.ejecutarVerConsultorio(idUsuario);
    }

    @Override
    public void manejadorVerConsultorioExitoso(ConsultorioModelo objConsultorio) {
        Longitud = objConsultorio.getLongitud();
        latitud = objConsultorio.getLatitud();
        Direccion  = objConsultorio.getDireccion();

        tfnombre.setText(objConsultorio.getNombre());
        tfDireccion.setText(objConsultorio.getDireccion());
        tfReferencia.setText(objConsultorio.getReferencia());
        tfTelefono.setText(objConsultorio.getTelefono());
        tfCelular.setText(objConsultorio.getCelular());
        tfEmail.setText(objConsultorio.getEmail());
        tfPrecioConsulta.setText(String.valueOf(objConsultorio.getPrecioConsulta()));
        tfServiciosOfrecidos.setText(objConsultorio.getServiciosOfresidos());
        //Toast.makeText(getContext(), "Exitoso. "+objConsultorio.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actualizarConsultorio() {

        String id_consultorio = SaveSharedPreference.getLoggedToken(getContext());
        ConsultorioModelo consultorioModelo = new ConsultorioModelo();
        consultorioModelo.setIdConsultorio(id_consultorio);
        consultorioModelo.setNombre(tfnombre.getText().toString());
        consultorioModelo.setLatitud(latitud);
        consultorioModelo.setLongitud(Longitud);
        consultorioModelo.setDireccion(tfDireccion.getText().toString());
        consultorioModelo.setDireccion(tfDireccion.getText().toString());
        consultorioModelo.setReferencia(tfReferencia.getText().toString());
        consultorioModelo.setTelefono(tfTelefono.getText().toString());
        consultorioModelo.setCelular(tfCelular.getText().toString());
        consultorioModelo.setEmail(tfEmail.getText().toString());
        //consultorioModelo.setPrecioConsulta(Double.parseDouble(String.valueOf(tfPrecioConsulta.getText())));
        consultorioModelo.setServiciosOfresidos(tfServiciosOfrecidos.getText().toString());

        consultorioPresentador.ejecutarActualizarConsultorio(consultorioModelo);


    }

    @Override
    public void manejadorActualizarConsultorioExitoso(ConsultorioModelo objConsultorio) {
        Toast.makeText(getContext(), "Se ha actualizado exitosamente los datos.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarConsultorioFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
