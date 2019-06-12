package com.br.lp3.prova.modelo;

public class Professor {

	private String codigo;
	private String nome;
		
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String scriptBD() {
		return "CREATE TABLE IF NOT EXISTS professor("
				+ " id     numeric NOT NULL ,"
				+ " codigo varchar(15) NOT NULL ,"
				+ " nome   varchar(30) NOT NULL ,"
				+ " PRIMARY KEY (id));";
	}
}
