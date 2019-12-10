package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loja_produto")
public class LojaProduto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;


	private String link;
	private double preco;
	
	@ManyToOne
    @JoinColumn(name="id_produto", insertable=false, updatable=false)
    private Produto produto;
	
	@ManyToOne
    @JoinColumn(name="id_loja", insertable=false, updatable=false)
    private Loja loja;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public Loja getLoja() {
		return loja;
	}
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}