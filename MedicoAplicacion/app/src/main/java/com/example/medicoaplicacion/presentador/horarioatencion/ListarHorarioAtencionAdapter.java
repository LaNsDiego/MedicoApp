package com.example.medicoaplicacion.presentador.horarioatencion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.interfaces.HorarioAtencionListarInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public class ListarHorarioAtencionAdapter extends RecyclerView.Adapter<ListarHorarioAtencionHolder>{

    private int resourceLayout;
    private List<HorarioAtencionModelo> listaHorarioAtencionModelo;
    HorarioAtencionListarInterface.RowListener eventosClick;

    public ListarHorarioAtencionAdapter(int resourceLayout, List<HorarioAtencionModelo> listaHorarioAtencionModelo, HorarioAtencionListarInterface.RowListener eventosClick) {
        this.resourceLayout = resourceLayout;
        this.listaHorarioAtencionModelo = listaHorarioAtencionModelo;
        this.eventosClick = eventosClick;
    }

    @NonNull
    @Override
    public ListarHorarioAtencionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout,parent,false);
        return new ListarHorarioAtencionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarHorarioAtencionHolder holder, int position) {

        final HorarioAtencionModelo diaAtencionModelo = listaHorarioAtencionModelo.get(position);
        holder.tv_dia_horarioatencion_row.setText(diaAtencionModelo.getDia());
        holder.tv_horainicio_horarioatencion_row.setText(diaAtencionModelo.getHoraInicio());
        holder.tv_horafin_horarioatencion_row.setText(diaAtencionModelo.getHoraFin());
        holder.tv_estado_horarioatencion_row.setText(diaAtencionModelo.getEstado());
        holder.card_container_horarioatencion_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventosClick.onClickHorarioAtencionRow(diaAtencionModelo.getIdHorarioAtencion());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaHorarioAtencionModelo.size();
    }
}
