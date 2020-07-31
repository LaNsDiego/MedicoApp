package com.example.medicoaplicacion.vista.reserva;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Component_row_reserva#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Component_row_reserva extends Fragment {


    public Component_row_reserva() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Component_row_reserva newInstance() {
        Component_row_reserva fragment = new Component_row_reserva();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.component_row_reserva, container, false);
    }
}
