package com.example.medicoaplicacion.presentador.diaatencion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.modelo.DiasAtencionModelo;

import java.util.List;

public class DiaAtencionAdapter extends RecyclerView.Adapter<DiaAtencionHolder>{

    private int resourceLayout;
    private List<DiasAtencionModelo> listaDiaAtencionModelo;

    public DiaAtencionAdapter(int resourceLayout, List<DiasAtencionModelo> listaDiaAtencionModelo) {
        this.resourceLayout = resourceLayout;
        this.listaDiaAtencionModelo = listaDiaAtencionModelo;
    }

    @NonNull
    @Override
    public DiaAtencionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resourceLayout,parent,false);
        return new DiaAtencionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaAtencionHolder holder, int position) {

        DiasAtencionModelo diasAtencionModelo = listaDiaAtencionModelo.get(position);
        holder.tvDiaAtencion.setText(diasAtencionModelo.getNombreDia());


    }

    @Override
    public int getItemCount() {
        return listaDiaAtencionModelo.size();
    }
}
