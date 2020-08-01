package com.example.medicoaplicacion.presentador.reserva;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;
import com.google.android.material.card.MaterialCardView;

public class ReservaMHolder extends RecyclerView.ViewHolder{

    public TextView txvName;
    public ImageView imgPhoto;
    public MaterialCardView cvContainerReserva;
    public ReservaMHolder(@NonNull View itemView) {
        super(itemView);
        txvName = itemView.findViewById(R.id.fullname_paciente_row);
        imgPhoto = itemView.findViewById(R.id.img_profile_paciente_row);
        cvContainerReserva = itemView.findViewById(R.id.card_container_reserva_row);
    }
}
