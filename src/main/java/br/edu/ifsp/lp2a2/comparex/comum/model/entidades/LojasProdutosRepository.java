package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LojasProdutosRepository extends CrudRepository<LojaProduto, Long>{
    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, count(lp.idLoja)) from LojaProduto lp group by lp.idProduto")
    List<ResultadoLojaProduto> quantidadeLojas();
}
