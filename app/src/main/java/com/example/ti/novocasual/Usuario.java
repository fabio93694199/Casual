package com.example.ti.novocasual;

import android.content.Context;

/**
 * Created by ti on 11/10/16.
 */

public class Usuario {
    public static String TOKEN = "com.example.ti.novocasual.TOKEN";

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String lat;
    private String lng;
    private String online;
    private String genero;
    private String pais;
    private String estado;

    public Usuario(){}

    public Usuario(String i,String n,String e,String s,String la,String ln,String o){
        id=i;
        nome=n;
        email=e;
        senha=s;
        lat=la;
        lng=ln;
        online=o;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    /*
        public void gerarCryptSenha(){
            senha = CryptWithMD5.cryptWithMD5(senha);
        }
    */
    public String getTokenSP(Context context){
        //String token = ClassePadrao.getSP(context,TOKEN);
        //return (token);
        return ("");
    }

    public void saveTokenSP(Context context,String token){
        //ClassePadrao.saveSP(context,TOKEN,token);
    }

    public void saveDB (){
        //Firebase firebase = ClassePadrao.getFirebase();
        //firebase.child("usuarios").child(getId());
        setId(null);
        setSenha(null);
        //firebase.setValue(this);
    }
}

