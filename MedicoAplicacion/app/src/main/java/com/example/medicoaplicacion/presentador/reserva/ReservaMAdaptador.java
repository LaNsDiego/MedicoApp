package com.example.medicoaplicacion.presentador.reserva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.interfaces.ReservaMInterface;
import com.example.medicoaplicacion.modelo.ReservaModelo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReservaMAdaptador extends RecyclerView.Adapter<ReservaMHolder> {
    private int resourceLayout;
    private List<ReservaModelo> listaReservaModelo;
    ReservaMInterface.RowListener eventosClick;
    //ENVIAR EL compoment ROW Y EL ARRAYLIST
    public ReservaMAdaptador(int resourceLayout, List<ReservaModelo> listaReservaModelo, ReservaMInterface.RowListener eventosClick) {
        this.resourceLayout = resourceLayout;
        this.listaReservaModelo = listaReservaModelo;
        this.eventosClick = eventosClick;
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
        final ReservaModelo reservaModelo = listaReservaModelo.get(position);


        holder.txvName.setText(reservaModelo.getNombreUsuario());
        holder.txvFecha.setText(reservaModelo.getFechaAtencion());
        holder.txvHora.setText(reservaModelo.getHoraAtencion());
        holder.txvTurno.setText(reservaModelo.getTurnoAtencion());

        Picasso.get().load("https://www.pngfind.com/pngs/m/610-6104451_image-placeholder-png-user-profile-placeholder-image-png.png").resize(160, 160).centerCrop().into(holder.imgPhoto);

        holder.cvContainerReserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventosClick.onClickVerReservaRow(reservaModelo.getIdReserva());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaReservaModelo.size();
    }
}

