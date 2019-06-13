package com.br.lp3.prova.modelo;

public class ComboItem {
	private String alias;
	private Integer id;
	
	
	public ComboItem(String alias, Integer id) {
		super();
		this.alias = alias;
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return  alias;
	}
	
	
}
