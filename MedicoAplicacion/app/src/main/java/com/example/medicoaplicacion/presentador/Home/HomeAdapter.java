package com.example.medicoaplicacion.presentador.Home;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.interfaces.HomeInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter  extends RecyclerView.Adapter<HomeHolder>{

    private int resourceLayout;
    private List<ReservaModelo> listaReservaModelo;
    HomeInterface.RowListener eventosClick;

    public HomeAdapter(int resourceLayout, List<ReservaModelo> listaReservaModelo, HomeInterface.RowListener eventosClick) {
        this.resourceLayout = resourceLayout;
        this.listaReservaModelo = listaReservaModelo;
        this.eventosClick = eventosClick;
    }


    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        final ReservaModelo reservaModelo = listaReservaModelo.get(position);


        holder.txvName.setText(reservaModelo.getNombreUsuario());
        holder.txvFecha.setText(reservaModelo.getFechaAtencion());
        holder.txvHora.setText(reservaModelo.getHoraAtencion());
        holder.txvTurno.setText(reservaModelo.getTurnoAtencion());

        Picasso.get().load("https://noverbal.es/uploads/blog/rostro-de-un-criminal.jpg").resize(150, 150).centerCrop().into(holder.imgPhoto);

        holder.cvContainerReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventosClick.onClickHomeVerReservaRow(reservaModelo.getIdReserva());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaReservaModelo.size();
    }
}
