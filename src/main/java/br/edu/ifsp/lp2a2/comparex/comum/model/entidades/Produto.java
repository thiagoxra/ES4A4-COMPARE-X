package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto implements Comparable<Produto> {
    @Id
    private Long id;
    private String nomeResumido;

    public String getNomeResumido() {
        return this.nomeResumido;
    }

    public void setNomeResumido(String nomeResumido) {
        this.nomeResumido = nomeResumido;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUnidade() {
        return this.unidade;
    }

    public void setUnidade(Integer unidade) {
        this.unidade = unidade;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setPontuacao(Long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Set<Preco> getPrecos() {
        return this.precos;
    }

    public void setPrecos(Set<Preco> precos) {
        this.precos = precos;
    }
    private String imagem;
    private String nome;
    private Integer unidade;
    private String marca;
    private Long pontuacao;
    

   // produto-id;produto-nome-resumido;produto-imagem;produto-nome;produt-unidade;produto-marca

    @OneToMany(mappedBy = "Produto")
    private Set<Preco> precos;
    

    public Long getId() {
        return id;
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
    public Produto(Long id, String nome, Long pontuacao){
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    @Override
    public boolean equals(Object obj){
        // TODO: Colocar novos atributos para serem comparados
        Produto another = (Produto) obj;
        return (this.id == another.id && 
                this.nome == another.nome &&
                this.pontuacao == another.pontuacao);
    }
}
