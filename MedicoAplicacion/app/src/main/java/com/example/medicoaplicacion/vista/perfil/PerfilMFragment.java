package com.example.medicoaplicacion.vista.perfil;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicoaplicacion.R;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilMFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilMFragment extends Fragment {


    public PerfilMFragment() {
        // Required empty public constructor
    }

    public static PerfilMFragment newInstance(String param1, String param2) {
        PerfilMFragment fragment = new PerfilMFragment();
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


        return inflater.inflate(R.layout.fragment_perfil_m, container, false);


    }


}
