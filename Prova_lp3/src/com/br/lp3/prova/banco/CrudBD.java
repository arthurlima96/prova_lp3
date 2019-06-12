package com.br.lp3.prova.banco;

import java.sql.Connection;
import java.sql.Statement;

import com.br.lp3.prova.modelo.Aluno;
import com.br.lp3.prova.modelo.Curso;
import com.br.lp3.prova.modelo.Disciplina;
import com.br.lp3.prova.modelo.Grade;
import com.br.lp3.prova.modelo.Professor;

import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudBD {

    protected Connection con = null;
    protected Statement state = null;
    protected ResultSet result;
    protected PreparedStatement pstate;
   
    public void mysqlConnect(){
    	con = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
    }

    public void closeConnection(){
        try{
            if(!con.isClosed()){
                con.close();
                System.out.println("Conexão Fechada.");
            }
        }catch(NullPointerException e){
            System.err.println("Não carregou o driver.");
        }catch(SQLException e){
            System.err.println("Não fechou a database");
        }
    }
    
    public void gerarTabelas(){
		try {
    		state = con.createStatement();
    		state.executeUpdate(new Professor().scriptBD());
    		state.executeUpdate(new Curso().scriptBD());
    		state.executeUpdate(new Disciplina().scriptBD());
    		state.executeUpdate(new Aluno().scriptBD());
    		state.executeUpdate(new Grade().scriptBD());
	    } catch (SQLException e) {
    	      e.printStackTrace();
	    }
    }

    public void insertData(String word, String meaning, String synonyms, String antonyms){
        try{
            //using PreparedStatement
            pstate = con.prepareStatement("insert into dictionary(word, meaning, synonyms, antonyms)"+
                                            "values(?,?,?,?)");
            pstate.setString(1, word);
            pstate.setString(2, meaning);
            pstate.setString(3, synonyms);
            pstate.setString(4, antonyms);
            int value = pstate.executeUpdate();

            //using Statement
            //state = con.createStatement();
            //int value = state.executeUpdate("insert into dictionary(word, meaning, synonyms, antonyms)"+
            //                      "values('"+word+"', '"+meaning+"', '"+synonyms+"', '"+antonyms+"')");

            System.out.println("Query OK, 1 row insertedted.");
            }
        catch(SQLException e){
            System.err.println("Query error.");
            }
        }

    public void deleteData(String word){
        try{
            //using PreparedStatement
            pstate = con.prepareStatement("delete from dictionary where word = ?");
            pstate.setString(1,"word");
            int value = pstate.executeUpdate();

            //using Statement
            //state = con.createStatement();
            //int value = state.executeUpdate("delete from dictionary where word='"+word+"'");

            System.out.println("Query OK, 1 row deleted.");
            }
        catch(SQLException e){
            System.err.println("Query error.");
            }
        }

    public void countRow(String table){
        try{
            result = state.executeQuery("SELECT COUNT(*) FROM "+table);
            result.next();
            int rowcount = result.getInt(1);
            System.out.println("Number of rows: "+rowcount);
            }
        catch(SQLException e){
            System.err.println("Query error.");
            }
        }

    public void showData(String word){
        try{
            state = con.createStatement();
            result = state.executeQuery("select * from dictionary where word='"+word+"'");
            while(result.next()){
                String word1 = result.getString("word");
                String mean = result.getString("meaning");
                String syno = result.getString("synonyms");
                String anto = result.getString("antonyms");
                System.out.println("Word: "+word1+" Meaning: "+mean+" Synonyms: "+syno+" Antonyms: "+anto);
                }
            }
        catch(SQLException e){
            System.err.println("Query error.");
            }
        catch(NullPointerException e){
            System.err.println("Element not found.");
            }
        }

    public void updateData(String word, String meaning){
        try{
            //using Statement
            //state = con.createStatement();
            //int value = state.executeUpdate("update dictionary set meaning='"+meaning+"' where word='"+word+"'");

            //using PreparedStatement
            pstate = con.prepareStatement("update dictionary set meaning= ? whrere word = ?");
            pstate.setString(1, meaning);
            pstate.setString(2, word);
            pstate.executeUpdate();

            System.out.println("Query OK, 1 row updated.");
            }
        catch(SQLException e){
            System.err.println("Query error."+e.getMessage());
            }
        }
}
