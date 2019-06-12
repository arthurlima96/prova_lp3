package com.br.lp3.prova.banco;

import java.sql.SQLException;

public class CrudBDAluno extends CrudBD{

	public void insertData(String word, String meaning, String synonyms, String antonyms){
		try{
		    //using PreparedStatement
		    pstate = con.prepareStatement("insert into aluno(word, meaning, synonyms, antonyms)"+
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
	    }catch(SQLException e){
		    System.err.println("Query error.");
	    }
    }
}
