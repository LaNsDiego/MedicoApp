package com.example.medicoaplicacion.presentador.diaatencion;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;

public class DiaAtencionHolder extends RecyclerView.ViewHolder {

    public TextView tvDiaAtencion;
    public DiaAtencionHolder(@NonNull View itemView) {
        super(itemView);
        tvDiaAtencion = itemView.findViewById(R.id.name_dia_atencion_row);
    }
}
