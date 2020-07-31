package com.example.medicoaplicacion.vista.atencion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.modelo.DiasAtencionModelo;
import com.example.medicoaplicacion.presentador.diaatencion.DiaAtencionAdapter;
import com.example.medicoaplicacion.presentador.diaatencion.DiaAtencionPresentador;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AtencionMFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AtencionMFragment extends Fragment implements DiaAtencionInterface.VistaList {

    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<DiasAtencionModelo> listaDiaAtencion;
    DiaAtencionInterface.Presentador presentador;


    public AtencionMFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AtencionMFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AtencionMFragment newInstance(String param1, String param2) {
        AtencionMFragment fragment = new AtencionMFragment();
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
        View vista = inflater.inflate(R.layout.fragment_atencion_m, container, false);

        presentador = new DiaAtencionPresentador(this);

        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_diaatencion);
        menejadorListarDiasAtencion();
        return  vista;
    }

    @Override
    public void menejadorListarDiasAtencion() {
        presentador.ejecutarListarDiasAtencion();
    }

    @Override
    public void manejadorListaDiasAtencionExitoso(List<DiasAtencionModelo> list) {

        DiaAtencionAdapter reservaMAdaptador = new DiaAtencionAdapter(R.layout.component_row_dias_antencion,list);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(reservaMAdaptador);
    }
}
