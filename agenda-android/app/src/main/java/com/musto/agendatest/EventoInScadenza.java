package com.musto.agendatest;

public class EventoInScadenza {

    public String nome = null;
    public String anno = null;
    public String mese = null;
    public String giorno = null;
    public String ora = null;
    public String minuto = null;

    public EventoInScadenza(String nome, String anno, String mese, String giorno, String ora, String minuto){
        this.nome = nome;
        this.anno = anno;
        this.mese = mese;
        this.ora = ora;
        this.minuto = minuto;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAnno(String anno){
        this.anno = anno;
    }
    public void setMese(String mese){
        this.mese = mese;
    }
    public void setGiorno(String giorno){
        this.giorno = giorno;
    }
    public void setOra(String ora){
        this.ora = ora;
    }
    public void setMinuto(String minuto){
        this.minuto = minuto;
    }
    public String getNome(){
        return nome;
    }
    public String getAnno(){
        return anno;
    }
    public String getMese(){
        return mese;
    }
    public String getGiorno(){
        return giorno;
    }
    public String getOra(){
        return ora;
    }
    public String getMinuto(){
        return minuto;
    }

}

