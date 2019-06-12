package com.br.lp3.prova.modelo;

import java.time.LocalDate;

public class Grade {

	private LocalDate ano;
	private Curso curso;
	private Disciplina disciplina;
	
	public LocalDate getAno() {
		return ano;
	}
	public void setAno(LocalDate ano) {
		this.ano = ano;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}	
	public String scriptBD() {
		return "CREATE TABLE IF NOT EXISTS `grade`("
				+ " `id`         numeric NOT NULL ,"
				+ " `ano`        year NOT NULL ,"
				+ " `curso`      numeric NOT NULL ,"
				+ " `disciplina` numeric NOT NULL ,"
				+ " PRIMARY KEY (`id`),"
				+ " KEY `fkIdx_42` (`curso`),"
				+ " CONSTRAINT `FK_42` FOREIGN KEY `fkIdx_42` (`curso`) REFERENCES `curso` (`id`),"
				+ " KEY `fkIdx_45` (`disciplina`),"
				+ " CONSTRAINT `FK_45` FOREIGN KEY `fkIdx_45` (`disciplina`) REFERENCES `disciplina` (`id`));";
	}
}
