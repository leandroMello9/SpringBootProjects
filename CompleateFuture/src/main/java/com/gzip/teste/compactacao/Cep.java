package com.gzip.teste.compactacao;


import com.google.gson.Gson;

import java.io.Serializable;
public class Cep implements Serializable  {
    private String cep;
    private String logradouro;
    private String complemento;


    public Cep() {

    }
    public Cep(String cep, String logradouro, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}
