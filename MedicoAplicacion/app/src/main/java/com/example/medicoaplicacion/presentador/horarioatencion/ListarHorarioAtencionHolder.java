package com.example.medicoaplicacion.presentador.horarioatencion;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;
import com.google.android.material.card.MaterialCardView;

public class ListarHorarioAtencionHolder extends RecyclerView.ViewHolder {

    TextView tv_dia_horarioatencion_row,tv_horainicio_horarioatencion_row,tv_horafin_horarioatencion_row,tv_estado_horarioatencion_row;
    MaterialCardView card_container_horarioatencion_row;
    public ListarHorarioAtencionHolder(@NonNull View itemView) {
        super(itemView);
        tv_dia_horarioatencion_row = itemView.findViewById(R.id.tv_dia_horarioatencion_row);
        tv_horainicio_horarioatencion_row = itemView.findViewById(R.id.tv_horainicio_horarioatencion_row);
        tv_horafin_horarioatencion_row = itemView.findViewById(R.id.tv_horafin_horarioatencion_row);
        tv_estado_horarioatencion_row = itemView.findViewById(R.id.tv_estado_horarioatencion_row);
        card_container_horarioatencion_row = itemView.findViewById(R.id.card_container_horarioatencion_row);
    }
}
