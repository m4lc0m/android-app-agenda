package com.musto.rest.web;

public class EventoResource {
	
	private int id_evento;
    private String nomeEvento;
    private String dataEvento;
    private String oraEvento;
    private String descrizioneEvento;
    private String luogoEvento;
    private String noteAggiuntiveEvento;
    private String username;
    private String password;
    private String nome_categoria;
    
    public EventoResource() {
    	
    }

	public int getId_evento() {
		return id_evento;
	}

	public void setId_evento(int id) {
		this.id_evento = id;
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

	public String getDescrizioneEvento() {
		return descrizioneEvento;
	}

	public void setDescrizioneEvento(String descrizioneEvento) {
		this.descrizioneEvento = descrizioneEvento;
	}

	public String getLuogoEvento() {
		return luogoEvento;
	}

	public void setLuogoEvento(String luogoEvento) {
		this.luogoEvento = luogoEvento;
	}

	public String getNoteAggiuntiveEvento() {
		return noteAggiuntiveEvento;
	}

	public void setNoteAggiuntiveEvento(String noteAggiuntiveEvento) {
		this.noteAggiuntiveEvento = noteAggiuntiveEvento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	@Override
	public String toString() {
		return "EventoResource [id_evento=" + id_evento + ", nomeEvento=" + nomeEvento + ", dataEvento=" + dataEvento + ", oraEvento="
				+ oraEvento + ", descrizioneEvento=" + descrizioneEvento + ", luogoEvento=" + luogoEvento
				+ ", noteAggiuntiveEvento=" + noteAggiuntiveEvento + ", username=" + username + ", password=" + password
				+ ", nome_categoria=" + nome_categoria + "]";
	}
    
    

}
