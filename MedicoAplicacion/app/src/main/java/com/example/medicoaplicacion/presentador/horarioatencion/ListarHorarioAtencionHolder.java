package com.example.medicoaplicacion.presentador.horarioatencion;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;

public class ListarHorarioAtencionHolder extends RecyclerView.ViewHolder {

    TextView tvNameHorarioAtencion;
    public ListarHorarioAtencionHolder(@NonNull View itemView) {
        super(itemView);
        tvNameHorarioAtencion = itemView.findViewById(R.id.name_horario_atencion_row);
    }
}
