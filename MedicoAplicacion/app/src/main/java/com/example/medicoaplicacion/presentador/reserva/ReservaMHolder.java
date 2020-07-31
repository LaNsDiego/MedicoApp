package com.example.medicoaplicacion.presentador.reserva;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medicoaplicacion.R;

public class ReservaMHolder extends RecyclerView.ViewHolder{

    public TextView txvName;
    public ImageView imgPhoto;

    public ReservaMHolder(@NonNull View itemView) {
        super(itemView);
        txvName = itemView.findViewById(R.id.fullname_paciente_row);
        imgPhoto = itemView.findViewById(R.id.img_profile_paciente_row);
    }
}
