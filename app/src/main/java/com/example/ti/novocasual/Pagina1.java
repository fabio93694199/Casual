package com.example.ti.novocasual;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Pagina1 extends Fragment{

    private RecyclerView mRecyclerView;
    private List<Usuario> mList = new ArrayList<>();
    //private ArrayList<Usuario> mList ;
    private Usuario usu = new Usuario();

    public Pagina1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pagina1, container, false);
        ///////////////////////////////////////////////////////////////////////


        mRecyclerView = (RecyclerView) v.findViewById(R.id.ID_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        for(int i=0;i<20;i++){
            usu = new Usuario();
            usu.setNome("gasparzinho"+i);
            usu.setEmail("gaspar"+i+"@gmail.com");
            mList.add(usu);
            usu = new Usuario();
        }


        AdaptadorDeUsuarios adapter = new AdaptadorDeUsuarios(getContext(),mList);
        mRecyclerView.setAdapter(adapter);
        ///////////////////////////////////////////////////////////////////////
        return v;
    }

}
