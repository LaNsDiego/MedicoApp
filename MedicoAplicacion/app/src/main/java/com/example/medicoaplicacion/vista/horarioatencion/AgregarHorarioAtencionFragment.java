package com.example.medicoaplicacion.vista.horarioatencion;

import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.presentador.horarioatencion.AgregarHorarioAtencionPresentador;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarHorarioAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarHorarioAtencionFragment extends Fragment implements HorarioAtencionInterface.VistaAgregar {

    HorarioAtencionInterface.Presentador presentador;
    TextInputEditText tfHoraInicio,tfHoraFinal;
    AutoCompleteTextView tfDia, tfEstado,editTextFilledExposedDropdowndia;
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

        tfHoraInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerHoraInicio();
            }
        });
        tfHoraFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerHoraFin();
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



        return vista;
    }

    private void obtenerHoraInicio(){

       Calendar calendar = Calendar.getInstance();
       int HOUR = calendar.get(Calendar.HOUR);
       int MINUTE = calendar.get(Calendar.MINUTE);
       final String CERO = "0";
       final String DOS_PUNTOS = ":";
        //boolean is24HourFormat = DateFormat.(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String HoraInicio = "";
                String AMPM = "AM";
                if (hourOfDay > 12 ){
                    AMPM = "PM";
                }
                HoraInicio = FormarHora(hourOfDay)+":"+FormarMinuto(minute)+" "+AMPM;
                tfHoraInicio.setText(HoraInicio);


            }
        }, HOUR, MINUTE, false);
        timePickerDialog.show();

    }

    private void obtenerHoraFin(){

        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        final String CERO = "0";
        final String DOS_PUNTOS = ":";
        //boolean is24HourFormat = DateFormat.(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String HoraInicio = "";
                String AMPM = "AM";
                if (hourOfDay > 12 ){
                    AMPM = "PM";
                }
                HoraInicio = FormarHora(hourOfDay)+":"+FormarMinuto(minute)+" "+AMPM;
                tfHoraFinal.setText(HoraInicio);


            }
        }, HOUR, MINUTE, false);
        timePickerDialog.show();

    }



    public String FormarHora(int hourOfDay){
        String horaString = "";
        switch (hourOfDay){

            case 1 : horaString = "01";  break;
            case 2 : horaString = "02";  break;
            case 3 : horaString = "03";  break;
            case 4 : horaString = "04";  break;
            case 5 : horaString = "05";  break;
            case 6 : horaString = "06";  break;
            case 7 : horaString = "07";  break;
            case 8 : horaString = "08";  break;
            case 9 : horaString = "09";  break;
            case 10 : horaString = "10";  break;
            case 11 : horaString = "11";  break;
            case 12 : horaString = "12";  break;
            case 13 : horaString = "01";  break;
            case 14 : horaString = "02";  break;
            case 15 : horaString = "03";  break;
            case 16 : horaString = "04";  break;
            case 17 : horaString = "05";  break;
            case 18 : horaString = "06";  break;
            case 19 : horaString = "07";  break;
            case 20 : horaString = "08";  break;
            case 21 : horaString = "09";  break;
            case 22 : horaString = "10";  break;
            case 23 : horaString = "11";  break;
            case 24 : horaString = "12";  break;

        }

        return horaString;
    }

    public String FormarMinuto(int minute){

        String minuteString = "";
        switch (minute){
            case 0 : minuteString = "00";  break;
            case 1 : minuteString = "01";  break;
            case 2 : minuteString = "02";  break;
            case 3 : minuteString = "03";  break;
            case 4 : minuteString = "04";  break;
            case 5 : minuteString = "05";  break;
            case 6 : minuteString = "06";  break;
            case 7 : minuteString = "07";  break;
            case 8 : minuteString = "08";  break;
            case 9 : minuteString = "09";  break;
            default: minuteString = String.valueOf(minute); break;

        }

        return minuteString;
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


        tfHoraInicio.setText("");
        tfHoraFinal.setText("");
        Toast.makeText(getContext(), "Se ha Agregado el nuevo horario de atención", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorAgregarHorarioAtencionFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
