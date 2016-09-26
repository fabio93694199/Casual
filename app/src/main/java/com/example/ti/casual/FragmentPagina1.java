package com.example.ti.casual;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPagina1 extends Fragment {

    private Button botao1,botao2;
    private TextView texto;
    //
    Firebase referenciaFirebase,objFirebase;
    //
    private Usuario usuario;
    //
    public FragmentPagina1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_pagina1, container, false);
        //////////////////////////////////////////////////////////////////////////////////
        Firebase.setAndroidContext(getContext());
        referenciaFirebase = new Firebase("https://casual-e8a19.firebaseio.com/");
        objFirebase = referenciaFirebase.child("Usuario");
        //////////////////////////////////////////////////////////////////////////////////
        texto = (TextView) view.findViewById(R.id.apresenta);
        botao1= (Button) view.findViewById(R.id.botao1);
        botao2= (Button) view.findViewById(R.id.botao2);
        //
        usuario = new Usuario("apelido","coodenadas","email","nome","redesSociais");
        //
        Firebase.ResultHandler teste = null;
        referenciaFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String mensagem = dataSnapshot.getValue(String.class);
                //texto.setText(mensagem);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //String mensagem = firebaseError.getValue(String.class);
                texto.setText("erro");
            }
        });
        //
        final Firebase.ResultHandler finalTeste = teste;
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                referenciaFirebase.setValue("Vermelho");
                objFirebase.child("userId2").setValue(usuario);
                //objFirebase.createUser("email","111111", finalTeste);
                //referenciaFirebase.child("");
            }
        });
        //
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                referenciaFirebase.setValue("Verde");
            }
        });
        //////////////////////////////////////////////////////////////////////////////////
        return view;
    }
}
