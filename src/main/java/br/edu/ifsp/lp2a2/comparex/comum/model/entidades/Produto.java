package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomeReduzido;
    private String imagem;
    private String nome;
    private String marca;
    
    @OneToMany(mappedBy="produto")
    private Set<LojaProduto> lojasProdutos;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeReduzido() {
		return nomeReduzido;
	}
	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Set<LojaProduto> getLojasProdutos() {
		return lojasProdutos;
	}
	public void setLojasProdutos(Set<LojaProduto> lojasProdutos) {
		this.lojasProdutos = lojasProdutos;
	}
	public Produto(){}
	public Produto(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
}