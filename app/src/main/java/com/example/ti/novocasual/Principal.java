package com.example.ti.novocasual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    TabLayout abas;
    ViewPager paginaDasAbas;
    AdaptadorDePaginas adaptadorDePaginas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //////////////////////////////////////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.IDtoolbarPincipal);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Oi... Deslize para direita, OK!!!", Snackbar.LENGTH_LONG)
                        .setAction("Ação", null).show();
            }
        });
        */
        /////////////////////////////////// ABAS /////////////////////////////////////
        abas = (TabLayout) findViewById(R.id.IDabas);
        /////////////////////////////// PAGINA DAS ABAS //////////////////////////////
        paginaDasAbas = (ViewPager) findViewById(R.id.IDadaptardorDePaginas);
        //////////////////////////// ADAPTAR AS PAGINAS //////////////////////////////
        adaptadorDePaginas = new AdaptadorDePaginas(getSupportFragmentManager());
        adaptadorDePaginas.addPaginas(new Pagina1(), "Onlines");
        adaptadorDePaginas.addPaginas(new Conversas(), "Conversas");
        adaptadorDePaginas.addPaginas(new Apontamentos(), "Apontamentos");
        paginaDasAbas.setAdapter(adaptadorDePaginas);
        abas.setupWithViewPager(paginaDasAbas);
    }

    ///////////////////////////// MENU "PEQUENO" LATERAL /////////////////////////////
    @Override                                                                       //
    public boolean onCreateOptionsMenu(Menu menu) {                                 //
        // Inflate the menu; this adds items to the action bar if it is present.    //
        getMenuInflater().inflate(R.menu.menu_principal, menu);                     //
        return true;                                                                //
    }                                                                               //
    //
    @Override                                                                       //
    public boolean onOptionsItemSelected(MenuItem item) {                           //
        //
        int id = item.getItemId();                                                  //
        //
        //noinspection SimplifiableIfStatement                                      //
        if (id == R.id.IDatualizar) {                                               //
            //
            return true;                                                            //
        }                                                                           //
        if (id == R.id.IDconfigurar) {                                              //
            return true;                                                            //
        }                                                                           //
        if (id == R.id.IDsair) {                                                    //
            //
            Intent intent = new Intent (this, Login.class);                         //
            startActivity(intent);                                                  //
            finish();                                                               //
            return true;                                                            //
        }                                                                           //
        //
        return super.onOptionsItemSelected(item);                                   //
    }                                                                               //

    //////////////////////////////////////////////////////////////////////////////////

}