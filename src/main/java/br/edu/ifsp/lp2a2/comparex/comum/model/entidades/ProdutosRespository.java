package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRespository extends CrudRepository<Produto, Long> {
    // É assim que se faz uma query se for necessário
    // @Query("SELECT p FROM Produto p ORDER BY pontuacao DESC")
    // Iterable<Produto> findByPontuacaoOrder();
	List<Produto> findByNomeContaining(String nome);
}
