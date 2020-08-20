package com.example.medicoaplicacion.vista.horarioatencion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.HorarioAtencionListarInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;
import com.example.medicoaplicacion.presentador.horarioatencion.ListarHorarioAtencionAdapter;
import com.example.medicoaplicacion.presentador.horarioatencion.ListarHorarioAtencionPresentador;
import com.example.medicoaplicacion.vista.diaatencion.ListarHorarioAtencionFragmentmal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarHorarioAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarHorarioAtencionFragment extends Fragment implements HorarioAtencionListarInterface.VistaListar, HorarioAtencionListarInterface.RowListener {

    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<HorarioAtencionModelo> horarioAtencionModelo;
    HorarioAtencionListarInterface.Presentador presentador;


    public ListarHorarioAtencionFragment() {
        // Required empty public constructor
    }

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
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listar_horario_atencion, container, false);



        presentador = new ListarHorarioAtencionPresentador(this);
        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_horarioatencion);
        menejadorListarHorarioAtencion();

        FloatingActionButton fab = vista.findViewById(R.id.floating_action_nuevo_horario_atencion);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevoHorarioAtencion();
            }
        });
        return  vista;
    }




    @Override
    public void menejadorListarHorarioAtencion() {
        presentador.ejecutarListarHorarioAtencion();
    }

    @Override
    public void manejadorListaHorarioAtencionExitoso(List<HorarioAtencionModelo> list) {

        ListarHorarioAtencionAdapter reservaMAdaptador = new ListarHorarioAtencionAdapter(R.layout.component_row_horario_atencion,list , this);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(reservaMAdaptador);
    }

    @Override
    public void nuevoHorarioAtencion() {
        AgregarHorarioAtencionFragment nuevoFragmento = new AgregarHorarioAtencionFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_new_horario_atencion, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClickHorarioAtencionRow(String idHorarioAtencion) {

        ListarHorarioAtencionFragmentmal nuevoFragmento = new ListarHorarioAtencionFragmentmal();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_new_horario_atencion, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
