package com.example.medicoaplicacion.presentador.horarioatencion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.interfaces.HorarioAtencionInterface;
import com.example.medicoaplicacion.modelo.HorarioAtencionModelo;

import java.util.List;

public class ListarHorarioAtencionAdapter extends RecyclerView.Adapter<ListarHorarioAtencionHolder>{

    private int resourceLayout;
    private List<HorarioAtencionModelo> listaHorarioAtencionModelo;


    public ListarHorarioAtencionAdapter(int resourceLayout, List<HorarioAtencionModelo> listaHorarioAtencionModelo) {
        this.resourceLayout = resourceLayout;
        this.listaHorarioAtencionModelo = listaHorarioAtencionModelo;

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
        holder.tvNameHorarioAtencion.setText(diaAtencionModelo.getHoraInicio() +" - "+ diaAtencionModelo.getHoraFin());

    }

    @Override
    public int getItemCount() {
        return listaHorarioAtencionModelo.size();
    }
}
