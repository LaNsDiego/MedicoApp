package com.example.medicoaplicacion.presentador.diaatencion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.interfaces.DiaAtencionInterface;
import com.example.medicoaplicacion.modelo.DiaAtencionModelo;

import java.util.List;

public class ListarDiaAtencionAdapter extends RecyclerView.Adapter<ListarDiaAtencionHolder>{

    private int resourceLayout;
    private List<DiaAtencionModelo> listaDiaAtencionModelo;
    DiaAtencionInterface.RowListener eventosClick;
    public ListarDiaAtencionAdapter(int resourceLayout, List<DiaAtencionModelo> listaDiaAtencionModelo , DiaAtencionInterface.RowListener eventosClick ) {
        this.resourceLayout = resourceLayout;
        this.listaDiaAtencionModelo = listaDiaAtencionModelo;
        this.eventosClick = eventosClick;
    }

    @NonNull
    @Override
    public ListarDiaAtencionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout,parent,false);
        return new ListarDiaAtencionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarDiaAtencionHolder holder, int position) {
        final DiaAtencionModelo diaAtencionModelo = listaDiaAtencionModelo.get(position);
        holder.tvDiaAtencion.setText(diaAtencionModelo.getNombreDia());
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventosClick.onClickDiaAtencionRow(diaAtencionModelo.getIdDiaAtencion());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDiaAtencionModelo.size();
    }
}
