package com.example.medicoaplicacion.presentador.reserva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.modelo.ReservaModelo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReservaMAdaptador extends RecyclerView.Adapter<ReservaMHolder> {
    private int resourceLayout;
    private List<ReservaModelo> listaReservaModelo;

    //ENVIAR EL compoment ROW Y EL ARRAYLIST
    public ReservaMAdaptador(int resourceLayout, List<ReservaModelo> listaReservaModelo) {
        this.resourceLayout = resourceLayout;
        this.listaReservaModelo = listaReservaModelo;
    }

    @NonNull
    @Override
    public ReservaMHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ///ENLAZAS EN COMPONENT ROT EN EL HOLDER
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout,parent,false);
        return new ReservaMHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservaMHolder holder, int position) {
            //SETEAR DATOS DEL XML
        ReservaModelo reservaModelo = listaReservaModelo.get(position);
        holder.txvName.setText(reservaModelo.getIdReserva());
        holder.txvName.setText(reservaModelo.getIdReserva());
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").resize(160, 160).centerCrop().into(holder.imgPhoto);


    }

    @Override
    public int getItemCount() {
        return listaReservaModelo.size();
    }
}
