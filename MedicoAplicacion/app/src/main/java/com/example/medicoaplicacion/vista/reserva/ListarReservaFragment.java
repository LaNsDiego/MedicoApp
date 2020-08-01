package com.example.medicoaplicacion.vista.reserva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;
import com.example.medicoaplicacion.presentador.reserva.ReservaMAdaptador;
import com.example.medicoaplicacion.presentador.reserva.ReservaMPresentador;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListarReservaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListarReservaFragment extends Fragment implements ReservaMInterface.VistaList, ReservaMInterface.RowListener {

    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<ReservaModelo> listaReservas;
    ReservaMInterface.Presentador presentador;


    public ListarReservaFragment() {
        // Required empty public constructor
    }


    public static ListarReservaFragment newInstance(String param1, String param2) {
        ListarReservaFragment fragment = new ListarReservaFragment();
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
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_listar_reserva, container, false);

        presentador = new ReservaMPresentador(this);

        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_reservas);
        menejadorListarReserva();
//        Toolbar toolbar = vista.findViewById(R.id.toolbar_medico);
//        toolbar.setTitle("Reserva Medico");

        return vista;
    }


    @Override
    public void menejadorListarReserva() {
        presentador.ejecutarListarReserva();
    }

    @Override
    public void manejadorListaReservaExitoso(List<ReservaModelo> list) {

        ReservaMAdaptador reservaMAdaptador = new ReservaMAdaptador(R.layout.component_row_reserva,list,this);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(reservaMAdaptador);

    }


    @Override
    public void onClickVerReservaRow(String idReserva) {
        VerReservaFragment nuevoFragmento = new VerReservaFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_ver_reserva, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
