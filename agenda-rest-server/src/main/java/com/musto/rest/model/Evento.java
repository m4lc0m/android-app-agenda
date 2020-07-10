package com.musto.rest.model;


public class Evento {
	
	private int id;
    private String nomeEvento;
    private String dataEvento;
    private String oraEvento;
    private String descrizioneEvento;
    private String luogoEvento;
    private String noteAggiuntiveEvento;

    public Evento() {
        
        id = -1;
        nomeEvento = "";
        dataEvento = "";
        oraEvento = "";
        descrizioneEvento ="";
        luogoEvento = "";
        noteAggiuntiveEvento ="";
         
    }
    
    public Evento(int id, String nomeEvento, String dataEvento, String oraEvento, String descrizioneEvento, String luogoEvento, String noteAggiuntiveEvento) {
   	 
        this.id = id;
        this.nomeEvento = nomeEvento;
        this.dataEvento = dataEvento;
        this.oraEvento = oraEvento;
        this.descrizioneEvento = descrizioneEvento;
        this.luogoEvento = luogoEvento;
        this.noteAggiuntiveEvento = noteAggiuntiveEvento;
        
    }
 
    
	 public String getNomeEvento() {
	    return nomeEvento;
	 }
	 public void setNomeEvento(String nomeEvento) {
	    this.nomeEvento = nomeEvento;
	 }
	 public String getDataEvento() {
	    return dataEvento;
	 }
	 public void setDataEvento(String dataEvento) {
	    this.dataEvento = dataEvento;
	 }
	 public String getOraEvento() {
	    return oraEvento;
	 }
	 public void setOraEvento(String oraEvento) {
	    this.oraEvento = oraEvento;
	 }
	 public String getDescrizioneEvento(){
		 return descrizioneEvento;
	 }
	 public void setDescrizioneEvento(String descrizioneEvento){
		 this.descrizioneEvento = descrizioneEvento;
	 }
	 public String getLuogoEvento(){
		 return luogoEvento;
	 }
	 public void setLuogoEvento(String luogoEvento){
		 this.luogoEvento = luogoEvento;
	 }
	 public String getNoteAggiuntiveEvento(){
		 return noteAggiuntiveEvento;
	 }
	 public void setNoteAggiuntiveEvento(String noteAggiuntiveEvento){
		 this.noteAggiuntiveEvento = noteAggiuntiveEvento;
	 }
	     
	 public int getId() {
	    return id;
	 }
	 public void setId(int id) {
	    this.id = id;
	 }

	@Override
	public String toString() {
		return "Evento [id=" + id + ", nomeEvento=" + nomeEvento + ", dataEvento=" + dataEvento + ", oraEvento="
				+ oraEvento + ", descrizioneEvento=" + descrizioneEvento + ", luogoEvento=" + luogoEvento
				+ ", noteAggiuntiveEvento=" + noteAggiuntiveEvento + "]";
	}  
	 
}


