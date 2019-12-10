package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto/* implements Comparable<Produto> */{
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
	
	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private Long pontuacao;
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void adicionarPontuacao(){
        ++this.pontuacao;
    }
    
    public Long getPontuacao(){
        return this.pontuacao;
    }
    @Override
    public int compareTo(Produto another){
        return (this.pontuacao == another.pontuacao) ? 0 : 
               (this.pontuacao > another.pontuacao) ? 1 :
               -1;
    }
    public Produto(){}
    public Produto(Long id, String descricao, Long pontuacao){
        this.id = id;
        this.descricao = descricao;
        this.pontuacao = pontuacao;
    }
    @Override
    public boolean equals(Object obj){
        Produto another = (Produto) obj;
        return (this.id == another.id && 
                this.descricao == another.descricao &&
                this.pontuacao == another.pontuacao);
    }*/
}
