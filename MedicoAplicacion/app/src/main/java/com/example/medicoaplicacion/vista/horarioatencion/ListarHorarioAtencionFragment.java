package com.example.medicoaplicacion.vista.horarioatencion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.DiaAtencionModelo;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;
import com.example.medicoaplicacion.presentador.horarioatencion.ListarHorarioAtencionAdapter;
import com.example.medicoaplicacion.presentador.horarioatencion.ListarHorarioAtencionPresentador;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarHorarioAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarHorarioAtencionFragment extends Fragment implements HorarioAtencionInterface.VistaListar {

    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<HorarioAtencionModelo> listaHorarioAtencion;
    HorarioAtencionInterface.Presentador presentador;

    public ListarHorarioAtencionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListarHorarioAtencionFragment newInstance(String param1, String param2) {
        ListarHorarioAtencionFragment fragment = new ListarHorarioAtencionFragment();
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

        View vista = inflater.inflate(R.layout.fragment_listar_horario_atencion, container, false);

        presentador = new ListarHorarioAtencionPresentador(this);

        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_horarioatencion);
        menejadorListarHorarioAtencion();
        return  vista;
    }

    @Override
    public void menejadorListarHorarioAtencion() {
        presentador.ejecutarListarHorarioAtencion();
    }

    @Override
    public void manejadorListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list) {

        ListarHorarioAtencionAdapter HorarioAtencionAdaptador = new ListarHorarioAtencionAdapter(R.layout.component_row_horario_atencion, list);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(HorarioAtencionAdaptador);
    }
}
