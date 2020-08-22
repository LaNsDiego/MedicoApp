package com.example.medicoaplicacion.vista.perfil;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.example.medicoaplicacion.interfaces.PerfilInterface;
import com.example.medicoaplicacion.modelo.SaveSharedPreference;
import com.example.medicoaplicacion.modelo.UsuarioModelo;
import com.example.medicoaplicacion.presentador.perfil.VerPerfilPresentador;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment implements PerfilInterface.VistaPerfil {

    TextInputEditText tfNroDocumento,tfNombresApellidos,tfEmail,tfCelular,tfFechaNacimiento,tfNroColegiatura,tfBiografia;
    AutoCompleteTextView tfTipoDocumento, tfEspecialidad;
    Button btnActualizarPerfil,btnSubirFoto, btnSeleccionarFoto;


    ImageView imageMedico;
    UsuarioModelo usuarioModelo;
    PerfilInterface.Presentador presentador;

    private static final int GALLERY_INTENT = 1;
    private static final String PATH_IMAGES = "images";
    StorageReference storageReference;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private StorageReference mStorageRef;

    public PerfilFragment() {
        // Required empty public constructor
    }

    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
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


        View vista = inflater.inflate(R.layout.fragment_ver_perfil, container, false);

        presentador = new VerPerfilPresentador(this);
        tfNroDocumento = vista.findViewById(R.id.tfNroDocumento);
        tfNombresApellidos = vista.findViewById(R.id.tfNombresApellidos);
        tfEmail = vista.findViewById(R.id.tfEmail);
        tfCelular = vista.findViewById(R.id.tfCelular);
        tfFechaNacimiento = vista.findViewById(R.id.tfFechaNacimiento);
        tfNroColegiatura = vista.findViewById(R.id.tfNroColegiatura);
        tfBiografia = vista.findViewById(R.id.tfBiografia);
        tfTipoDocumento = vista.findViewById(R.id.tfTipoDocumento);
        tfEspecialidad = vista.findViewById(R.id.tfEspecialidad);

        imageMedico = vista.findViewById(R.id.imageMedico);
        btnActualizarPerfil = vista.findViewById(R.id.btnActualizarPerfil);
        btnSubirFoto = vista.findViewById(R.id.btnSubirFoto);

        btnActualizarPerfil = vista.findViewById(R.id.btnActualizarPerfil);

        btnActualizarPerfil.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               actualizarPerfil();
           }
        });
        btnSubirFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_INTENT);
            }
        });
        menejadorVerPerfil();


        String[] tipoDocumento = new String[] {"DNI", "RUC", "PASAPORTE"};
        ArrayAdapter<String> adapterTipoDocumento =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        tipoDocumento);
        AutoCompleteTextView editTextFilledExposedDropdownTipoDocumento = vista.findViewById(R.id.tfTipoDocumento);
        editTextFilledExposedDropdownTipoDocumento.setAdapter(adapterTipoDocumento);

        String[] especialidad = new String[] {"Anesteciología", "Ginecobstetra" , "Pediatría","Odontologia","Psiquiatría","Dermatología","Neurología"};
        ArrayAdapter<String> adapterEspecialidad =
                new ArrayAdapter<>(requireContext(),
                        R.layout.list_item,
                        especialidad);
        AutoCompleteTextView editTextFilledExposedDropdownEspecialidad = vista.findViewById(R.id.tfEspecialidad);
        editTextFilledExposedDropdownEspecialidad.setAdapter(adapterEspecialidad);

        return  vista;


    }


    @Override
    public void menejadorVerPerfil() {

        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        presentador.ejecutarVerPerfil(idUsuario);

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
                    /*
                    MessageModel newMessagePhoto = new MessageModel();
                    newMessagePhoto.setTypeMessage(MessageModel.TYPE_PHOTO);
                    newMessagePhoto.setContent(downloadUri.toString());
                    newMessagePhoto.setUserEmiterId(RealUserIdEmitter);
                    newMessagePhoto.setUserReceptorId(RealUserIdReceptor);
                    presenterMessage.doCreateMessageByConversationId(currentConversation.getId(),newMessagePhoto);
                    */

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
    public void manejadorVerPerfilExitoso(UsuarioModelo objUsuario) {

        tfTipoDocumento.setText(objUsuario.getTipoDocumento());
        tfNroDocumento.setText(objUsuario.getNroDocumento());
        tfNombresApellidos.setText(objUsuario.getNombres());
        tfEmail.setText(objUsuario.getEmail());
        tfCelular.setText(objUsuario.getCelular());
        tfFechaNacimiento.setText(objUsuario.getFechaNacimiento());
        tfEspecialidad.setText(objUsuario.getEspecialidad());
        tfNroColegiatura.setText(objUsuario.getColegiatura());
        tfBiografia.setText(objUsuario.getBiografia());

    }

    @Override
    public void actualizarPerfil() {
        String idUsuario = SaveSharedPreference.getLoggedToken(getContext());
        UsuarioModelo user = new UsuarioModelo();
        user.setIdUsuario(idUsuario);
        user.setTipoDocumento(tfTipoDocumento.getText().toString());
        user.setNroDocumento(tfNroDocumento.getText().toString());
        user.setNombres(tfNombresApellidos.getText().toString());
        user.setEmail(tfEmail.getText().toString());
        user.setCelular(tfCelular.getText().toString());
        user.setFechaNacimiento(tfFechaNacimiento.getText().toString());
        user.setEspecialidad(tfEspecialidad.getText().toString());
        user.setColegiatura(tfNroColegiatura.getText().toString());
        user.setBiografia(tfBiografia.getText().toString());

        presentador.ejecutarActualizarPerfil(user);
    }

    @Override
    public void manejadorActualizarPerfilExitoso(UsuarioModelo objUsuario) {
        Toast.makeText(getContext(), "Se ha actualizado exitosamente los datos.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void manejadorActualizarPerfilFallido() {
        Toast.makeText(getContext(), "A ocurrido un error.", Toast.LENGTH_SHORT).show();
    }
}
