package com.example.medicoaplicacion.presentador.diaatencion;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;
import com.google.android.material.card.MaterialCardView;

public class ListarDiaAtencionHolder extends RecyclerView.ViewHolder {

    public TextView tvDiaAtencion;
    public MaterialCardView materialCardView;
    public ListarDiaAtencionHolder(@NonNull View itemView) {
        super(itemView);
        tvDiaAtencion = itemView.findViewById(R.id.name_dia_atencion_row);
        materialCardView = itemView.findViewById(R.id.card_container_reserva_row);
    }
}
