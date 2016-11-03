package com.example.ti.novocasual;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pagina1 extends Fragment{

    //private DatabaseReference databaseReference,banco,banco1,refBanco,pessoasEncontradas,refObjeto;
    private ListView listPessoasEncontradas;
    private ArrayList<String> listaDeUsuarios = new ArrayList<>();
    private ArrayList<Usuario> listaDeUsuarios2 = new ArrayList<Usuario>();

    public Pagina1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pagina1, container, false);
        ///////////////////////////////////////////////////////////////////////
        /*
        Usuario use1 = new Usuario();
        use1.setId("01");
        use1.setNome("gaspar");
        use1.setEmail("gaspar@gmail.com");
        use1.setSenha("123456");
        use1.setLat("-51.11254");
        use1.setOnline("true");
        //
        listaDeUsuarios2.add(use1);
        //
        comunicacao.responder(listaDeUsuarios2);
        */
        ///////////////////////////////////////////////////////////////////////
//        databaseReference = FirebaseDatabase.getInstance().getReference();
//        refObjeto = databaseReference.child("brasil").child("RioGrandeDoSul");
        listPessoasEncontradas = (ListView) v.findViewById(R.id.IDlistadepessoasEncontradas);

        //final ArrayAdapter<Usuario> adaptador = new ArrayAdapter<Usuario>(getContext(),android.R.layout.simple_list_item_1, listaDeUsuarios);


        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, listaDeUsuarios);
        listPessoasEncontradas.setAdapter(adaptador);

//        refObjeto.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                /*
                for(DataSnapshot dsp : dataSnapshot.getChildren()){
                    //lst.add(String.valueOf(dsp.getKey())); //add o resultado no array list
                    //listaDeUsuarios.add(String.valueOf(dsp.getValue()));
                    //Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    String usuario = dataSnapshot.getValue(String.class);
                    listaDeUsuarios.add(String.valueOf(dataSnapshot.getKey()));
                    //listaDeUsuarios.add(usuario.getNome());
                    //pListadas.pessoasEncontradas(listaDeUsuarios);
                }
                */

//                Usuario usuario = dataSnapshot.getValue(Usuario.class);
//                listaDeUsuarios.add(usuario.getNome());
                //listaDeUsuarios.add(dataSnapshot.getValue(Usuario.class).getNome()+s);

                //listaDeUsuarios.add(String.valueOf(dataSnapshot.getValue(Usuario.class).getNome()));
                //pListadas.pessoasEncontradas(listaDeUsuarios);

                //for(String dado:listaDeUsuarios){
                //    Toast.makeText(getContext(),dado, Toast.LENGTH_SHORT).show();
                //}
//                adaptador.notifyDataSetChanged();
//            }
/*
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ///////////////////////////////////////////////////////////////////////
*/
        ///////////////////////////////////////////////////////////////////////
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
