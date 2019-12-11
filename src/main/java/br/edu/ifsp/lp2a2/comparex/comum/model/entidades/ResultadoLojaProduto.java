package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

public class ResultadoLojaProduto {
    private Integer id;
    private Double preco;
    private Long quantidade;
    private String imagem;
    private String nome;
    private String marca;
    private String link;
    private String nomeLoja;

    public ResultadoLojaProduto(Integer id, Double preco){
        this.id = id;
        this.preco = preco;
    }

    public ResultadoLojaProduto(Integer id, Long quantidade){
        this.id = id;
        this.quantidade = quantidade;
    }

    

    public ResultadoLojaProduto(Integer id, String imagem, String nome, String marca, String link, Double preco) {
        this.id = id;
        this.imagem = imagem;
        this.nome = nome;
        this.marca = marca;
        this.link = link;
        this.preco = preco;
    }

    public ResultadoLojaProduto(Integer id, String imagem, String nome, String marca, String link, Double preco, String nomeLoja) {
        this.id = id;
        this.imagem = imagem;
        this.nome = nome;
        this.marca = marca;
        this.link = link;
        this.preco = preco;
        this.nomeLoja = nomeLoja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }
}