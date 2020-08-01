package com.example.medicoaplicacion.presentador.Home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;
import com.google.android.material.card.MaterialCardView;

public class HomeHolder extends RecyclerView.ViewHolder {
    public TextView txvName,txvFecha, txvHora,txvTurno;
    public ImageView imgPhoto;
    public MaterialCardView cvContainerReserva;
    public HomeHolder(@NonNull View itemView) {
        super(itemView);

        txvName = itemView.findViewById(R.id.fullname_paciente_row);
        txvFecha = itemView.findViewById(R.id.fecha_Atencion_row);
        txvHora = itemView.findViewById(R.id.hora_atencion_row);
        txvTurno = itemView.findViewById(R.id.turno_atencion_row);

        imgPhoto = itemView.findViewById(R.id.img_profile_paciente_row);
        cvContainerReserva = itemView.findViewById(R.id.card_container_reserva_row);
    }
}
