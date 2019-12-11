package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LojasProdutosRepository extends CrudRepository<LojaProduto, Long>{
    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, count(lp.idLoja)) from LojaProduto lp group by lp.idProduto")
    List<ResultadoLojaProduto> quantidadeLojas();

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1")
    List<ResultadoLojaProduto> listarPorLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, min(lp.preco)) from LojaProduto lp group by lp.idProduto")
    List<ResultadoLojaProduto> menorPreco();
}
