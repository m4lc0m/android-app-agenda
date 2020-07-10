package com.musto.agendatest;

public class Evento {

    public String nomeEvento = null;
    public String dataEvento = null;
    public String oraEvento = null;
    public String descrizione = null;
    public String luogoEvento = null;
    public String tempoStimato = null;
    public String noteAggiuntive = null;
    public int id = 0;

    public Evento(String name, String data, String time, String description, String place, String timeLeft, String note){

        this.nomeEvento = name;
        this.dataEvento = data;
        this.oraEvento = time;
        this.descrizione = description;
        this.luogoEvento = place;
        this.tempoStimato = timeLeft;
        this.noteAggiuntive = note;
    }

    public void setNomeEvento(String s){
        this.nomeEvento = s;
    }

    public void setDataEvento(String s){
        this.dataEvento = s;
    }

    public void setOraEvento(String s){
        this.oraEvento = s;
    }

    public void setDescrizione(String s){
        this.descrizione = s;
    }

    public void setLuogoEvento(String s){
        this.luogoEvento = s;
    }

    public void setTempoStimato(String s){
        this.tempoStimato = s;
    }

    public void setNoteAggiuntive(String s){
        this.noteAggiuntive = s;
    }

    public void setId(int idEvento){
        this.id = idEvento;
    }

    public int getId(){
        return id;
    }

    public String getNomeEvento(){
        return nomeEvento;
    }

    public String getDataEvento(){
        return dataEvento;
    }

    public String getOraEvento(){
        return oraEvento;
    }

    public String getDescrizione(){
        return descrizione;
    }

    public String getLuogoEvento(){
        return luogoEvento;
    }

    public String getTempoStimato(){
        return tempoStimato;
    }

    public String getNoteAggiuntive(){
        return noteAggiuntive;
    }
}
