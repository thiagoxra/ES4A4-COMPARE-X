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

    public Produto(){}
    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

//    @OneToMany(mappedBy="produto")
//    private Set<Categoria> categorias;
//

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
    private String nome;
    private double preco;
    private String unid;
    private String marca;
    private String imagem;
    private String acabamento;
    private String categoria;
    private String embalagem;
    private String cor;
    
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
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getUnid() {
        return unid;
    }
    public void setUnid(String unid) {
        this.unid = unid;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public String getAcabamento() {
        return acabamento;
    }
    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getEmbalagem() {
        return embalagem;
    }
    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
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