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
import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;
import com.example.medicoaplicacion.presentador.horarioatencion.AgregarHorarioAtencionPresentador;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditarHorarioAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditarHorarioAtencionFragment extends Fragment implements HorarioAtencionInterface.VistaEditar {

    HorarioAtencionInterface.Presentador presentador;
    TextInputEditText tfHoraInicio,tfHoraFinal;
    AutoCompleteTextView tfDia, tfEstado,editTextFilledExposedDropdowndia;
    Button btnEditar;
    public static String midhorarioAtencion;

    public EditarHorarioAtencionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditarHorarioAtencionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditarHorarioAtencionFragment newInstance(String param1, String param2) {
        EditarHorarioAtencionFragment fragment = new EditarHorarioAtencionFragment();
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
        View vista = inflater.inflate(R.layout.fragment_editar_horario_atencion, container, false);
        presentador = new AgregarHorarioAtencionPresentador(this);



        tfDia = vista.findViewById(R.id.tfDia);
        tfHoraInicio = vista.findViewById(R.id.tfHoraInicio);
        tfHoraFinal = vista.findViewById(R.id.tfHoraFinal);
        tfEstado = vista.findViewById(R.id.tfEstado);
        btnEditar = vista.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menejadorEditarHorarioAtencion();
            }
        });


        String[] dia = new String[] {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        ArrayAdapter<String> adapterdia =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        dia);
        editTextFilledExposedDropdowndia = vista.findViewById(R.id.tfDia);
        editTextFilledExposedDropdowndia.setAdapter(adapterdia);


        String[] estado = new String[] {"Activo", "Inactivo"};
        ArrayAdapter<String> adapterEstado =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        estado);
        AutoCompleteTextView editTextFilledExposedDropdownEstado = vista.findViewById(R.id.tfEstado);
        editTextFilledExposedDropdownEstado.setAdapter(adapterEstado);


        Bundle datosRecuperados = getArguments();
        if (datosRecuperados != null) {

            String idHorarioAtencion = datosRecuperados.getString("idHorarioAtencion");
            menejadorVerHorarioAtencion(idHorarioAtencion);
            midhorarioAtencion = idHorarioAtencion;
        }


        return vista;
    }



    @Override
    public void menejadorEditarHorarioAtencion() {

        HorarioAtencionModelo horario = new HorarioAtencionModelo();
        horario.setIdHorarioAtencion(midhorarioAtencion);
        horario.setDia(tfDia.getText().toString());
        horario.setHoraInicio(tfHoraInicio.getText().toString());
        horario.setHoraFin(tfHoraFinal.getText().toString());
        horario.setEstado(tfEstado.getText().toString());

        presentador.ejecutarEditarHorarioAtencion(horario);

    }

    @Override
    public void manejadorEditarHorarioAtencionExitoso() {
        Toast.makeText(getContext(), "Se ha editado exitosamente.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorEditarHorarioAtencionFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void menejadorVerHorarioAtencion(String idHorarioAtencion) {
        presentador.ejecutarVerHorarioAtencion(idHorarioAtencion);
    }

    @Override
    public void manejadorVerHorarioAtencionExitoso(HorarioAtencionModelo horarioAtencionModelo) {

        tfDia.setText(horarioAtencionModelo.getDia());
        tfHoraInicio.setText(horarioAtencionModelo.getHoraInicio());
        tfHoraFinal.setText(horarioAtencionModelo.getHoraFin());
        tfEstado.setText(horarioAtencionModelo.getEstado());


    }

    @Override
    public void manejadorVerHorarioAtencionFallido() {
        Toast.makeText(getContext(), "Fallido", Toast.LENGTH_SHORT).show();
    }
}
