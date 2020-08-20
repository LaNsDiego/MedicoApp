package com.example.medicoaplicacion.vista.horarioatencion;

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
import com.example.medicoaplicacion.interfaces.HorarioAtencionAgregarInterface;
import com.example.medicoaplicacion.interfaces.HorarioAtencionListarInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.presentador.horarioatencion.AgregarHorarioAtencionPresentador;
import com.example.medicoaplicacion.presentador.horarioatencion.ListarHorarioAtencionPresentador;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarHorarioAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarHorarioAtencionFragment extends Fragment implements HorarioAtencionAgregarInterface.VistaAgregar {

    HorarioAtencionAgregarInterface.Presentador presentador;
    TextInputEditText tfHoraInicio,tfHoraFinal;
    AutoCompleteTextView tfDia, tfEstado;
    Button btnAgregar;

    public AgregarHorarioAtencionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AgregarHorarioAtencionFragment newInstance(String param1, String param2) {
        AgregarHorarioAtencionFragment fragment = new AgregarHorarioAtencionFragment();
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
        View vista = inflater.inflate(R.layout.fragment_nuevo_horario_atencion, container, false);

        presentador = new AgregarHorarioAtencionPresentador(this);

        tfDia = vista.findViewById(R.id.tfDia);
        tfHoraInicio = vista.findViewById(R.id.tfHoraInicio);
        tfHoraFinal = vista.findViewById(R.id.tfHoraFinal);
        tfEstado = vista.findViewById(R.id.tfEstado);
        btnAgregar = vista.findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menejadorAgregarHorarioAtencion();
            }
        });

        String[] dia = new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        ArrayAdapter<String> adapterdia =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        dia);
        AutoCompleteTextView editTextFilledExposedDropdowndia = vista.findViewById(R.id.tfDia);
        editTextFilledExposedDropdowndia.setAdapter(adapterdia);



        String[] estado = new String[] {"Activo", "Inactivo"};
        ArrayAdapter<String> adapterEstado =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        estado);
        AutoCompleteTextView editTextFilledExposedDropdownEstado = vista.findViewById(R.id.tfEstado);
        editTextFilledExposedDropdownEstado.setAdapter(adapterEstado);



        return vista;
    }

    @Override
    public void menejadorAgregarHorarioAtencion() {

        boolean validar = true;
        if (tfDia.getText().toString().equals("")){
            Toast.makeText(getContext(), "Seleccione un dia.", Toast.LENGTH_SHORT).show();
            validar = false;
        }
        if (tfHoraInicio.getText().toString().equals("")){
            Toast.makeText(getContext(), "Ingrese una hora de inicio.", Toast.LENGTH_SHORT).show();
            validar = false;
        }
        if (tfHoraFinal.getText().toString().equals("")){
            Toast.makeText(getContext(), "Ingrese una hora final", Toast.LENGTH_SHORT).show();
            validar = false;
        }
        if (tfEstado.getText().toString().equals("")){
            Toast.makeText(getContext(), "Seleccione un estado.", Toast.LENGTH_SHORT).show();
            validar = false;
        }

        if (validar){

            String id_consultorio = SaveSharedPreference.getLoggedToken(getContext());

            HorarioAtencionModelo horarioAtencionModelo = new HorarioAtencionModelo();
            horarioAtencionModelo.setIdConsultorio(id_consultorio);
            horarioAtencionModelo.setDia(tfDia.getText().toString());
            horarioAtencionModelo.setHoraInicio(tfHoraInicio.getText().toString());
            horarioAtencionModelo.setHoraFin(tfHoraFinal.getText().toString());
            horarioAtencionModelo.setEstado(tfEstado.getText().toString());

            presentador.ejecutarAgregarHorarioAtencion(horarioAtencionModelo);
        }


    }

    @Override
    public void manejadorAgregarHorarioAtencionExitoso() {
        Toast.makeText(getContext(), "Se ha Agregado el nuevo horario de atención", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorAgregarHorarioAtencionFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
