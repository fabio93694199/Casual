package com.example.ti.casual;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

public class Principal extends AppCompatActivity {

    TabLayout abas;
    ViewPager paginaDasAbas;
    AdaptadorDePaginas adaptadorDePaginas;
    //////////////////////////////////////
    //Firebase referenciaFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Oi... Deslize para direita, OK!!!", Snackbar.LENGTH_LONG)
                        .setAction("Ação", null).show();
            }
        });

        /////////////////////////////////// ABAS /////////////////////////////////////
        abas = (TabLayout) findViewById(R.id.IDabas);
        /////////////////////////////// PAGINA DAS ABAS //////////////////////////////
        paginaDasAbas = (ViewPager) findViewById(R.id.IDadaptardorDePaginas);
        //////////////////////////// ADAPTAR AS PAGINAS //////////////////////////////
        adaptadorDePaginas = new AdaptadorDePaginas(getSupportFragmentManager());
        adaptadorDePaginas.addPaginas(new FragmentPagina1(),"Primeira");
        adaptadorDePaginas.addPaginas(new FragmentPagina2(),"Segunda");
        adaptadorDePaginas.addPaginas(new FragmentUsuariosMapeados(),"Mapeamento");
        adaptadorDePaginas.addPaginas(new Apontamentos(),"Apontamentos");
        //adaptadorDePaginas.addPaginas(new Teste(),"test");
        paginaDasAbas.setAdapter(adaptadorDePaginas);
        abas.setupWithViewPager(paginaDasAbas);
        /////////////////////////////// LOCALIZAÇÃO //////////////////////////////////

        ////////////////////////////////// TESTE /////////////////////////////////////
        //Firebase.setAndroidContext(this);
        //referenciaFirebase = new Firebase("https://casual-e8a19.firebaseio.com/");
        //
        /*
        texto = (TextView) findViewById(R.id.apresenta);
        botao1= (Button) findViewById(R.id.botao1);
        botao2= (Button) findViewById(R.id.botao2);
        //
        botao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Vermelho");
            }
        });
        botao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Verde");
            }
        });
        */

    }
    ///////////////////////////// MENU "PEQUENO" LATERAL /////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.IDatualizar) {

            return true;
        }
        if (id == R.id.IDconfigurar) {
            return true;
        }
        if (id == R.id.IDsair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void Botoes() {

    }
*/
}