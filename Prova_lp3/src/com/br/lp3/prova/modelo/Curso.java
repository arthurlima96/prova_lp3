package com.br.lp3.prova.modelo;

public class Curso {

	private Integer id;
	private String codigo;
	private String descricao;
		
	public Curso(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
		
	public Curso(String codigo) {
		super();
		this.codigo = codigo;
	}
		
	public Curso() {}
		
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String scriptBD() {
		return "CREATE TABLE IF NOT EXISTS `curso` ("
				+ " `id`        numeric NOT NULL ,"
				+ " `codigo`    varchar(2) NOT NULL ,"
				+ " `descricao` varchar(15) NOT NULL ,"
				+ " PRIMARY KEY (`id`));";
	}
	
	@Override
	public String toString() {
		return getDescricao();
	}
}
