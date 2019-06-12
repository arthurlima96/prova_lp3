package com.br.lp3.prova.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
    private String connection = "jdbc:mysql://localhost:3306/faculdade?autoReconnect=true&useSSL=false"; 
    private String user = "root";                  
    private String password = "root";     
    
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(connection,user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}