package com.example.ti.casual;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by ti on 26/08/16.
 */
public class AdaptadorDePaginas extends FragmentStatePagerAdapter {

    ArrayList<Fragment> paginas = new ArrayList<>();
    ArrayList<String> tituloDasAbas= new ArrayList<>();

    public AdaptadorDePaginas(FragmentManager fm){
        super(fm);
    }

    public void addPaginas (Fragment paginas, String titulo){
        this.paginas.add(paginas);
        this.tituloDasAbas.add(titulo);
    }

    @Override
    public Fragment getItem(int posisao){
        return paginas.get(posisao);
    }
    @Override
    public int getCount(){
        return paginas.size();
    }
    @Override
    public CharSequence getPageTitle(int posisao){
        return tituloDasAbas.get(posisao);
    }
}
