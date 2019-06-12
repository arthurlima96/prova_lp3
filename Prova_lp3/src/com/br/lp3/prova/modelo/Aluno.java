package com.br.lp3.prova.modelo;

public class Aluno {

	private String codigo;
	private String nome;
	private String endereco;
	private Integer curso;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getCurso() {
		return curso;
	}
	public void setCurso(Integer curso) {
		this.curso = curso;
	}
	
	public String scriptBD() {
		return "CREATE TABLE IF NOT EXISTS `aluno` ("
				+ " `id`       numeric NOT NULL ,"
				+ " `codigo`   varchar(15) NOT NULL ,"
				+ " `nome`     varchar(30) NOT NULL ,"
				+ "	`endereco` varchar(50) NOT NULL ,"
				+ "	`curso`    numeric NOT NULL ,"
				+ "	PRIMARY KEY (`id`),"
				+ "	KEY `fkIdx_25` (`curso`),"
				+ "	CONSTRAINT `FK_25` FOREIGN KEY `fkIdx_25` (`curso`) REFERENCES `curso` (`id`)); ";

	}
}
