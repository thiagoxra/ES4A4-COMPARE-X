package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

public class ResultadoLojaProduto {
    private Integer id;
    private Long quantidade;

    public ResultadoLojaProduto(Integer id, Long quantidade){
        this.id = id;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}