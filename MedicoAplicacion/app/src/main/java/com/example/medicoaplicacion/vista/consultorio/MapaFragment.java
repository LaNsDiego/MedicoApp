package com.example.medicoaplicacion.vista.consultorio;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.medicoaplicacion.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapaFragment extends DialogFragment implements OnMapReadyCallback, GoogleMap.OnMapClickListener , GoogleMap.OnCameraIdleListener {

    //ATRIBUTOS MAPA MI UBICACION
    private final LatLng mDefaultLocation = new LatLng(-33.8523341, 151.2106085);
    private Marker marker;
    //private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int DEFAULT_ZOOM = 15;
    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;
    private boolean mLocationPermissionGranted;
    // The geographical location where the device is currently located. That is, the last-known
    // location retrieved by the Fused Location Provider.
    private Location mLastKnownLocation;
    Button btnCerrar;
    // Keys for storing activity state.
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    private GoogleMap map;

    ConsultorioMFragment consultorioMFragment;
    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapa_fragmento);

        btnCerrar = view.findViewById(R.id.btnCerrar);
        mapFragment.getMapAsync(this);
        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CerrarMapa();
            }
        });
        consultorioMFragment = new ConsultorioMFragment();
        return view;
    }

    public void CerrarMapa(){
        this.dismiss();
    }

    //CUANDO MUEVES LA CAMARA O PANATALLA DEL MAPA
    @Override
    public void onCameraIdle() {
        LatLng centerPoint = map.getCameraPosition().target;
        Log.d("MAPAF","Lat: " + centerPoint.latitude + "___ Long: " + centerPoint.longitude  );
        if(marker == null){
            marker.remove();

            map.addMarker(new MarkerOptions()
                            .position(centerPoint)
//                    .title(getStringAddress(centerPoint.latitude,centerPoint.longitude))
            );
        }else{
            marker.setPosition(centerPoint);
//            marker.setTitle(
//                    getStringAddress(centerPoint.latitude,centerPoint.longitude)
//            );
        }

        String strAddress = getStringAddress(centerPoint.latitude,centerPoint.longitude);

        ConsultorioMFragment.latitud = centerPoint.latitude;
        ConsultorioMFragment.Longitud = centerPoint.longitude;
        ConsultorioMFragment.Direccion = strAddress;
        //consultorioMFragment.mensaje(strAddress);
        Toast.makeText(getContext(), strAddress, Toast.LENGTH_SHORT).show();

    }

    public String getStringAddress(Double latitud, Double longitud){
        String address = "";
//        String city = "";
        Geocoder geocoder;
        List<Address> addresses ;
        geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitud,longitud,1);
            if(addresses.size() > 0){
                Address objAddress = addresses.get(0);
                address = objAddress.getAddressLine(0);
//            city = objAddress.getLocality();
            }else{
                address = "Desconocido";
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return address;
    }

    //CUANDO DES CLICK EN EL MAPA , NO MARCADORES
    @Override
    public void onMapClick(LatLng latLng) {

    }

    //CARGAR MAPA
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        if(marker != null){

        }
        map.setOnCameraIdleListener(this);
        marker = map.addMarker(new MarkerOptions().position(mDefaultLocation ).title("Ubicación por defecto").draggable(true));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(mDefaultLocation,14f));

        // Prompt the user for permission.
        getLocationPermission();


        // Turn on the My Location layer and the related control on the map.
        updateLocationUI();

    }

    private void updateLocationUI() {
        if (map == null) {
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                map.setMyLocationEnabled(true);
                map.getUiSettings().setMyLocationButtonEnabled(true);
            } else {
                map.setMyLocationEnabled(false);
                map.getUiSettings().setMyLocationButtonEnabled(false);
                mLastKnownLocation = null;
                getLocationPermission();
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
        }
    }

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }
}
