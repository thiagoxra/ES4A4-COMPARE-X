package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AcabamentosRepository extends CrudRepository<Acabamento, Integer>{
    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoAcabamento(p.id, p.imagem, p.marca, p.nome, lp.link, lp.idLoja, lp.preco) from Produto p, LojaProduto lp, Acabamento a where p.id = lp.idProduto and a.id = p.idAcabamento and lp.idLoja = ?1 and a.id = ?2")
    List<ResultadoAcabamento> filtrarAcabamento(int idLoja, int idAcabamento);
}