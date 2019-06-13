package com.br.lp3.prova.modelo;

public class Disciplina {
	
	private Integer id;
	private String codigo;
	private String descricao;
	private String ementa;
	private Double cargaHoraria;
	private Professor professor;
	
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
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	public Double getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String scriptBD() {
		return "CREATE TABLE IF NOT EXISTS `disciplina` ("
				+ " `id`           numeric NOT NULL ,"
				+ " `codigo`       varchar(6) NOT NULL , "
				+ " `decricao`     varchar(15) NOT NULL ,"
				+ " `ementa`       varchar(50) NOT NULL ,"
				+ " `cargaHoraria` double NOT NULL ,"
				+ " `professor`    numeric,"
				+ " PRIMARY KEY (`id`),"
				+ " KEY `fkIdx_35` (`professor`),"
				+ " CONSTRAINT `FK_35` FOREIGN KEY `fkIdx_35` (`professor`) REFERENCES `professor` (`id`));";
	}
}
