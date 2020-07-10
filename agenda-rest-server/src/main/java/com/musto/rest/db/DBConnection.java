package com.musto.rest.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.musto.rest.model.Evento;

public class DBConnection {
	
	private Connection con 			= null;
	private Statement stm 			= null;
	private PreparedStatement pStm 	= null;
	private ResultSet res 			= null;
	
	public boolean openConnection() 
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://db:3306/agenda/"+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			
			//run without docker
			//String url = "jdbc:mysql://"+DBConfiguration.getDBHost()+":"+DBConfiguration.getPort()+"/"+DBConfiguration.getDBName()+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			con = DriverManager.getConnection(url, DBConfiguration.getUser(), DBConfiguration.getPwd());
			return true;
		} catch (Exception ex)
		{
			System.out.println(ex);
	      return false;
		}
	}
	
	public boolean closeConnection()
	{
		try {
			if ( con != null)
				con.close();
			con = null;
			return true;
		} catch (Exception ex)
		{
			return false;
		}
	}
	
	
	public int controlLogin(String user, String pwd) throws Exception
	{
		int code = 0;
		
		if ( con == null ){
			code = -1;
			return code;
		}
		stm = con.createStatement();
		String query = "SELECT id_login From login WHERE "+
					   "username='"+user+"' AND password=md5('"+pwd+"')";
		res = stm.executeQuery( query );
	
		while ( res.next())
		{
			 code = 1;
		}
		res.close();
		stm.close();
		return code;
	}
	
	private String getTableName(String category)
	{		
		switch (category.toUpperCase())
		{
		case "CASA" : return ( "evento_casa" );
		case "AMICI" : return ( "evento_amici" );
		case "TEMPO LIBERO" : return ( "evento_tempolibero" );
		case "SPORT" : return ( "evento_sport" );
		case "FAMIGLIA" : return ( "evento_famiglia" );
		case "LAVORO" : return ( "evento_lavoro" );
		default: return ( "evento_amici" );
		}
	}
	
	public ArrayList<Evento> getEventList(String category) throws Exception
	{
		String tableName = getTableName(category);
		String query = "select id, nome, data_evento, ora_evento, descrizione, luogo, note  FROM "+tableName;	
		if ( con == null)
		  	return null;
		stm = con.createStatement();
	 res = stm.executeQuery( query );
			Evento evento = null;
			ArrayList<Evento> listEventi = new ArrayList<Evento>();
			while ( res.next())
			{
				evento = new Evento(res.getInt("id"),res.getString("nome"), res.getString("data_evento"), res.getString("ora_evento"), res.getString("descrizione"), res.getString("luogo"),res.getString("note"));
				listEventi.add(evento);
			}
			res.close();
			stm.close();
			return listEventi;
	}
	
	public int getNumId(String category) throws SQLException{
		
		String tableName = getTableName(category);
		String query = "select id FROM "+tableName;
		if(con == null){
			return 0;
		}
		stm = con.createStatement();
		res = stm.executeQuery(query);
		
		int numero_id = 0;
		while(res.next())
		{
			numero_id++;
		}
		res.close();
		stm.close();
		return numero_id;
	}
	
	public int addEvento(String category, Evento evento){
		
		if ( con == null ){
			return 0;
		}
		String sqlInsert = "INSERT INTO agenda."+getTableName(category)+" (id, nome, descrizione, luogo, note, data_evento, ora_evento) VALUES "+
		"('"+evento.getId()+"','"+evento.getNomeEvento()+"','"+evento.getDescrizioneEvento()+"','"+evento.getLuogoEvento()+"','"+evento.getNoteAggiuntiveEvento()+"','"+evento.getDataEvento()+"','"+evento.getOraEvento()+"')";
	  	System.out.println("Query: "+sqlInsert);
		try {
			pStm = con.prepareStatement(sqlInsert);
			pStm.executeUpdate();
			System.out.println("OK_INSERT");
			pStm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return 1;
		  }
	
	public int controlEvento(String category, Evento evento) throws SQLException{
		
		int control_evento = 0;
		
		stm = con.createStatement();
		String sqlControl = "SELECT id FROM "+getTableName(category)+" WHERE "+"nome='"+evento.getNomeEvento()+"'";
		res = stm.executeQuery( sqlControl );
		while(res.next()){
			control_evento = res.getInt("id");
		}
		System.out.println(""+control_evento);
		res.close();
		stm.close();
		return control_evento;
	}
	
	public int modificaEvento(String category, Evento evento){
		int edit = 0;
		
		try{
		
			String sqlUpdate="update`"+getTableName(category)+"` set `nome` = '"+evento.getNomeEvento()+"', `data_evento` = '"+evento.getDataEvento()+"', `ora_evento` = '"+evento.getOraEvento()+"', `descrizione` = '"+evento.getDescrizioneEvento()+"', `luogo` = '"+evento.getLuogoEvento()+"', `note` = '"+evento.getNoteAggiuntiveEvento()+"'  where `id` = '"+evento.getId()+"'";
			pStm = con.prepareStatement(sqlUpdate);
			pStm.executeUpdate();
			edit = 1;
			System.out.println("OK_EDIT");
			pStm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return edit;
	}
	
	public int removeEvento(String category, int id_evento){
		int remove = 0;
		
		try{
			String sqlRemove="DELETE FROM "+getTableName(category)+" WHERE id = '"+id_evento+"'";

			pStm = con.prepareStatement(sqlRemove);
			pStm.executeUpdate();
			remove = 1;
			System.out.println("OK_REMOVE");
			System.out.println(""+id_evento);
			pStm.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return remove;
	}
}
	
