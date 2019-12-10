package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Loja {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String Nome;
	
	@OneToMany(mappedBy="loja")
    private Set<LojaProduto> lojasProdutos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	
	public Set<LojaProduto> getLojasProdutos() {
		return lojasProdutos;
	}
	public void setLojasProdutos(Set<LojaProduto> lojasProdutos) {
		this.lojasProdutos = lojasProdutos;
	}
}