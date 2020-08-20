package com.example.medicoaplicacion.modelo;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public abstract class Conexion {

    private static FirebaseFirestore db ;
    private static CollectionReference collectionUsuario ;
    private static CollectionReference collectionConsultorio ;
    private static CollectionReference collectionEspecilidad ;
    private static CollectionReference collectionReserva ;
    private static CollectionReference collectionHorarioAtencion ;

    private Conexion() {}

    public static FirebaseFirestore getDb(){
        if(db == null){
            db = FirebaseFirestore.getInstance();
        }
        return db;
    }

    public static CollectionReference getCollectionUsuario() {
        if(collectionUsuario == null){
            collectionUsuario = getDb().collection("usuario");
        }
        return collectionUsuario;
    }

    public static CollectionReference getCollectionEspecilidad() {
        if(collectionEspecilidad == null){
            collectionEspecilidad = getDb().collection("especialidad");
        }
        return collectionEspecilidad;
    }

    public static CollectionReference getCollectionReserva() {
        if(collectionReserva == null){
            collectionReserva = getDb().collection("reserva");
        }
        return collectionReserva;
    }

    public static CollectionReference getCollectionHorarioAtencion() {
        if(collectionHorarioAtencion == null){
            collectionHorarioAtencion = getDb().collection("horario_atencion");
        }
        return collectionHorarioAtencion;
    }

    public static CollectionReference getCollectionConsultorio() {
        if(collectionConsultorio == null){
            collectionConsultorio = getDb().collection("consultorio");
        }
        return collectionConsultorio;
    }





}
