package com.example.ti.casual;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by ti on 24/09/16.
 */
@IgnoreExtraProperties
public class Usuario {

    private String apelido;
    private String coordenadas;
    private String email;
    private String nome_usuario;
    private String redesSociais;

    public Usuario() {
        // Default constructor required for calls to DataSnapshot.getValue(Usuario.class)
    }

    public Usuario(String apelido, String coordenadas, String email,String nome_usuario, String redesSociais) {
        this.setApelido(apelido);
        this.setCoordenadas(coordenadas);
        this.setEmail(email);
        this.setNome_usuario(nome_usuario);
        this.setRedesSociais(redesSociais);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getRedesSociais() {
        return redesSociais;
    }

    public void setRedesSociais(String redesSociais) {
        this.redesSociais = redesSociais;
    }
    ////////////////////////////////////////////
}
