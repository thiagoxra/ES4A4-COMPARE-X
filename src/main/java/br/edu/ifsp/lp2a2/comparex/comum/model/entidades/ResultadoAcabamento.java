package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

public class ResultadoAcabamento {
    private Integer id;
    private String imagem;
    private String marca;
    private String nome;
    private String link;
    private Integer idLoja;
    private Double preco;

    public ResultadoAcabamento(Integer id, String imagem, String marca, String nome, String link, Integer idLoja, Double preco) {
        this.id = id;
        this.imagem = imagem;
        this.marca = marca;
        this.nome = nome;
        this.link = link;
        this.idLoja = idLoja;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Integer idLoja) {
        this.idLoja = idLoja;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}