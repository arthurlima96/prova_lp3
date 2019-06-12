package com.br.lp3.prova.modelo;

public class Curso {

	private String codigo;
	private String descricao;
	
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
}
