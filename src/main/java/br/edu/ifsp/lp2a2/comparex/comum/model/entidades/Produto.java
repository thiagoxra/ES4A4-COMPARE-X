package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Produto{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nomeReduzido;
    private String imagem;
    private String nome;
    private String marca;
    @Column(name="id_fabricante") //Notação JPA indica para Hibernate a leitura do dado
    private int idFabricante;
    @Column(name="id_cor")
    private int idCor;
    @Column(name="id_acabamento")
    private int idAcabamento;

    public Produto(){}
    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_fabricante", insertable=false, updatable=false)
    private Fabricante fabricante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_cor", insertable=false, updatable=false)
    private Cor cor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_acabamento", insertable=false, updatable=false)
    private Acabamento acabamento;
    
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

    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public int getIdAcabamento() {
        return idAcabamento;
    }

    public void setIdAcabamento(int idAcabamento) {
        this.idAcabamento = idAcabamento;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Acabamento getAcabamento() {
        return acabamento;
    }

    public void setAcabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
    }
}