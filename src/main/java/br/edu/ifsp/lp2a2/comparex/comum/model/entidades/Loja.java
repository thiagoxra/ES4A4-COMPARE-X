package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loja {
    @Id
    private Long id;

    private String nome;
    @ManyToOne
    @JoinColumn
    private Preco preco;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
}
