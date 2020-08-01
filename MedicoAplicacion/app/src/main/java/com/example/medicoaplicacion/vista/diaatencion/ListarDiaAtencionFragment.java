package com.example.medicoaplicacion.vista.diaatencion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.medicoaplicacion.vista.horarioatencion.ListarHorarioAtencionFragment;
import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.modelo.DiaAtencionModelo;
import com.example.medicoaplicacion.presentador.diaatencion.ListarDiaAtencionAdapter;
import com.example.medicoaplicacion.presentador.diaatencion.ListarDiaAtencionPresentador;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarDiaAtencionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarDiaAtencionFragment extends Fragment implements DiaAtencionInterface.VistaList, DiaAtencionInterface.RowListener {

    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<DiaAtencionModelo> listaDiaAtencion;
    DiaAtencionInterface.Presentador presentador;


    public ListarDiaAtencionFragment() {
        // Required empty public constructor
    }

    public static ListarDiaAtencionFragment newInstance(String param1, String param2) {
        ListarDiaAtencionFragment fragment = new ListarDiaAtencionFragment();
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
        View vista = inflater.inflate(R.layout.fragment_listar_dia_atencion, container, false);

        presentador = new ListarDiaAtencionPresentador(this);

        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_diaatencion);
        menejadorListarDiasAtencion();
        return  vista;
    }

    @Override
    public void menejadorListarDiasAtencion() {
        presentador.ejecutarListarDiasAtencion();
    }

    @Override
    public void manejadorListaDiasAtencionExitoso(List<DiaAtencionModelo> list) {

        ListarDiaAtencionAdapter reservaMAdaptador = new ListarDiaAtencionAdapter(R.layout.component_row_dias_antencion,list , this);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(reservaMAdaptador);
    }

    @Override
    public void onClickDiaAtencionRow(String idDiaAtencion) {


        ListarHorarioAtencionFragment nuevoFragmento = new ListarHorarioAtencionFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_ver_atencion, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
