package com.example.medicoaplicacion.vista.consultorio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.ConsultorioInterface;
import com.example.medicoaplicacion.modelo.ConsultorioModelo;
import com.example.medicoaplicacion.modelo.EspecialidadModelo;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.consultorio.VerConsultorioPresentador;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConsultorioMFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConsultorioMFragment extends Fragment implements ConsultorioInterface.VistaConsultorio {


    TextInputEditText tfnombre,tfDireccion,tfReferencia,tfTelefono,tfCelular,tfEmail,tfPrecioConsulta,tfServiciosOfrecidos;
    Button btnActualizarConsultorio,btnSubirFoto;
    AutoCompleteTextView tfEspecialidad;
    public  static  Double latitud;
    public  static  Double Longitud;
    public  static  String Direccion;
    ConsultorioInterface.Presentador consultorioPresentador;
    EspecialidadModelo especialidadModelo;
    ImageView imageConsultorio;
    LinearLayout bgConsultorio;

    private static final int GALLERY_INTENT = 1;
    private static final String PATH_IMAGES = "images";
    StorageReference storageReference;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private StorageReference mStorageRef;
    public ConsultorioMFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsultorioMFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsultorioMFragment newInstance(String param1, String param2) {
        ConsultorioMFragment fragment = new ConsultorioMFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_consultorio_m, container, false);

        consultorioPresentador = new VerConsultorioPresentador(this);
        especialidadModelo = new EspecialidadModelo();

        tfnombre = vista.findViewById(R.id.tfnombre);
        tfDireccion = vista.findViewById(R.id.tfDireccion);
        tfReferencia = vista.findViewById(R.id.tfReferencia);
        tfTelefono = vista.findViewById(R.id.tfTelefono);
        tfCelular = vista.findViewById(R.id.tfCelular);
        tfEmail = vista.findViewById(R.id.tfEmail);
        tfPrecioConsulta = vista.findViewById(R.id.tfPrecioConsulta);
        tfServiciosOfrecidos = vista.findViewById(R.id.tfServiciosOfrecidos);
        tfEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        btnActualizarConsultorio = vista.findViewById(R.id.btnActualizarConsultorio);
        imageConsultorio = vista.findViewById(R.id.imageConsultorio);
        tfDireccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje();
            }
        });
        btnSubirFoto = vista.findViewById(R.id.btnSubirFoto);

        btnSubirFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });
        btnActualizarConsultorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarConsultorio();
            }
        });
        menejadorVerConsultorio();

        String[] especialidad = new String[] {"Anesteciología", "Ginecobstetra" , "Pediatría","Odontologia","Psiquiatría","Dermatología","Neurología"};

        ArrayAdapter<String> adapterEspecialidad =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        especialidad);
        AutoCompleteTextView editTextFilledExposedDropdownEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        editTextFilledExposedDropdownEspecialidad.setAdapter(adapterEspecialidad);

        //ABRIR MAPA
        TextInputLayout til = vista.findViewById(R.id.tf_layout_address);
        til.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirModalMapa();
            }
        });




        return vista;
    }

    public void abrirModalMapa(){
        MapaFragment mapaF = new MapaFragment();
        mapaF.show(getChildFragmentManager(),"GAA");
    }


    public void mensaje(){
        tfDireccion.setText(Direccion);
    }


    @Override
    public void menejadorVerConsultorio() {
        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        consultorioPresentador.ejecutarVerConsultorio(idUsuario);
    }

    @Override
    public void manejadorVerConsultorioExitoso(ConsultorioModelo objConsultorio) {
        Longitud = objConsultorio.getLongitud();
        latitud = objConsultorio.getLatitud();
        Direccion  = objConsultorio.getDireccion();

        //Picasso.get().load(objConsultorio.getImage()).resize(200, 200).centerCrop().into(imageConsultorio);


        Glide.with(this).load(objConsultorio.getImage()).into(imageConsultorio);
        tfnombre.setText(objConsultorio.getNombre());
        tfDireccion.setText(objConsultorio.getDireccion());
        tfReferencia.setText(objConsultorio.getReferencia());
        tfTelefono.setText(objConsultorio.getTelefono());
        tfCelular.setText(objConsultorio.getCelular());
        tfEmail.setText(objConsultorio.getEmail());
        tfPrecioConsulta.setText(String.valueOf(objConsultorio.getPrecioConsulta()));
        tfServiciosOfrecidos.setText(objConsultorio.getServiciosOfresidos());
        tfEspecialidad.setText(objConsultorio.getEspecialidad());
        //Toast.makeText(getContext(), "Exitoso. "+objConsultorio.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void actualizarConsultorio() {

        String id_consultorio = SaveSharedPreference.getLoggedToken(getContext());
        ConsultorioModelo consultorioModelo = new ConsultorioModelo();
        consultorioModelo.setIdConsultorio(id_consultorio);
        consultorioModelo.setNombre(tfnombre.getText().toString());
        consultorioModelo.setLatitud(latitud);
        consultorioModelo.setLongitud(Longitud);
        consultorioModelo.setDireccion(tfDireccion.getText().toString());
        consultorioModelo.setDireccion(tfDireccion.getText().toString());
        consultorioModelo.setReferencia(tfReferencia.getText().toString());
        consultorioModelo.setTelefono(tfTelefono.getText().toString());
        consultorioModelo.setCelular(tfCelular.getText().toString());
        consultorioModelo.setEmail(tfEmail.getText().toString());
        consultorioModelo.setEspecialidad(tfEspecialidad.getText().toString());
        String monto = tfPrecioConsulta.getText().toString();

        consultorioModelo.setPrecioConsulta(Double.parseDouble(monto));
        consultorioModelo.setServiciosOfresidos(tfServiciosOfrecidos.getText().toString());

        consultorioPresentador.ejecutarActualizarConsultorio(consultorioModelo);


    }

    @Override
    public void manejadorActualizarConsultorioExitoso(ConsultorioModelo objConsultorio) {
        Toast.makeText(getContext(), "Se ha actualizado exitosamente los datos.", Toast.LENGTH_SHORT).show();
    }


    public void subirFoto() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarConsultorioFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK) {
            if (data != null) {

                final Uri localUri = data.getData();
                Log.d(TAG, "Uri: " + localUri.toString());
                storageReference = FirebaseStorage.getInstance().getReference(String.valueOf(new Random().nextInt()));
                UploadTask uploadTask = storageReference.putFile(localUri);
                putImageInStorage(storageReference,uploadTask);



            }
        }

    }

    private void putImageInStorage(final StorageReference storageReference,final UploadTask uploadTask) {

        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                if (!task.isSuccessful()) {
                    throw task.getException();
                }
                // Continue with the task to get the download URL
                Log.d(TAG,storageReference.getDownloadUrl().toString());
                return storageReference.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                if (task.isSuccessful()) {
                    Uri downloadUri = task.getResult();
                    Log.w("IMAGENEXISOTSO", downloadUri.toString());

                    ConsultorioModelo consultorio = new ConsultorioModelo();
                    consultorio.setImage(downloadUri.toString());
                    actualizarFotoConsultorio(consultorio);

                    if (task.isSuccessful()) {

                    } else {
                        Log.w(TAG, "Image upload task was not successful.",
                                task.getException());
                    }
                }
            }
        });
    }
    @Override
    public void actualizarFotoConsultorio(ConsultorioModelo objConsultorio) {
        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        objConsultorio.setIdConsultorio(idUsuario);
        consultorioPresentador.ejecutarActualizarFotoConsultorio(objConsultorio);
    }

    @Override
    public void manejadorActualizarFotoConsultorioExitoso(ConsultorioModelo objConsultorio) {
        Toast.makeText(getContext(), "Se ha Actualizado la foto.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarFotoConsultorioFallido() {
        Toast.makeText(getContext(), "A Ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
