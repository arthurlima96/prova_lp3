package com.br.lp3.prova.modelo;

public class Professor {

	private Integer id;
	private String codigo;
	private String nome;
	
	public Professor() {}
		
	public Professor(String codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
				+ " id     int NOT NULL AUTO_INCREMENT,"
				+ " codigo varchar(15) NOT NULL ,"
				+ " nome   varchar(30) NOT NULL ,"
				+ " PRIMARY KEY (id));";
	}
}
