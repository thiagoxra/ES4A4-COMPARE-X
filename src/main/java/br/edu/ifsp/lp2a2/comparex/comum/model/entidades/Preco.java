package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "Produto")
    private Set<Produto> produtos;
    @OneToMany(mappedBy = "Loja")
    private Set<Loja> lojas;

    public Set<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Set<Loja> getLojas() {
        return this.lojas;
    }

    public void setLojas(Set<Loja> lojas) {
        this.lojas = lojas;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    public Long getId() {
        return id;
    }
    private Double preco;
    private String link;

    public Preco(){}
    
}
