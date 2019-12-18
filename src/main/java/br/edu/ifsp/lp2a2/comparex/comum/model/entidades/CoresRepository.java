package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CoresRepository extends CrudRepository<Cor, Integer>{
   @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoCor(p.id, p.imagem, p.marca, p.nome, lp.link, lp.idLoja, lp.preco) from Produto p, LojaProduto lp, Cor c where p.id = lp.idProduto and c.id = p.idCor and lp.idLoja = ?1 and c.id = ?2")
    List<ResultadoCor> filtrarCor(int idLoja, int idCor);
}