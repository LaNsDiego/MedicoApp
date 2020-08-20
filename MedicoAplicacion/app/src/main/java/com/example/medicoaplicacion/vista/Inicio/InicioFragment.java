package com.example.medicoaplicacion.vista.Inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.HomeInterface;
import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;
import com.example.medicoaplicacion.presentador.Home.HomeAdapter;
import com.example.medicoaplicacion.presentador.Home.HomePresentador;
import com.example.medicoaplicacion.presentador.reserva.ReservaMAdaptador;
import com.example.medicoaplicacion.presentador.reserva.ReservaMPresentador;
import com.example.medicoaplicacion.vista.reserva.VerReservaFragment;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment implements HomeInterface.VistaHomeList,HomeInterface.RowListener {


    private RecyclerView recyclerViewReserva;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<ReservaModelo> listaReservas;
    HomeInterface.Presentador presentador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_home, container, false);

        presentador = new HomePresentador(this);

        recyclerViewReserva = (RecyclerView) vista.findViewById(R.id.rv_homereservas);
        menejadorHomeListarReserva();


        return vista;
    }


    @Override
    public void menejadorHomeListarReserva() {
        presentador.ejecutarHomeListarReserva();
    }

    @Override
    public void manejadorHomeListaReservaExitoso(List<ReservaModelo> list) {

        HomeAdapter reservaMAdaptador = new HomeAdapter(R.layout.component_row_reserva,list,this);
        LinearLayoutManager llms = new LinearLayoutManager(getContext());
        llms.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewReserva.setLayoutManager(llms);
        recyclerViewReserva.setAdapter(reservaMAdaptador);
    }

    @Override
    public void onClickHomeVerReservaRow(String idReserva) {

        VerReservaFragment nuevoFragmento = new VerReservaFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.container_home_ver_reserva, nuevoFragmento);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
