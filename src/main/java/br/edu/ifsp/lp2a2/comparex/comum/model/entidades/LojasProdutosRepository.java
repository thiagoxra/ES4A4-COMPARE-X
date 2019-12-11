package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LojasProdutosRepository extends CrudRepository<LojaProduto, Integer>{
    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, count(lp.idLoja)) from LojaProduto lp group by lp.idProduto")
    List<ResultadoLojaProduto> quantidadeLojas();

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, min(lp.preco)) from LojaProduto lp group by lp.idProduto")
    List<ResultadoLojaProduto> menorPreco();

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1")
    List<ResultadoLojaProduto> listarPorLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1 order by lp.preco")
    List<ResultadoLojaProduto> ordenarPorMenorPrecoEmLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1 order by lp.preco desc")
    List<ResultadoLojaProduto> ordenarPorMaiorPrecoEmLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1 order by p.nome")
    List<ResultadoLojaProduto> ordenarPorMenorNomeEmLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco) from Produto p, LojaProduto lp where p.id = lp.idProduto and lp.idLoja = ?1 order by p.nome desc")
    List<ResultadoLojaProduto> ordenarPorMaiorNomeEmLoja(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco, l.nome) from Produto p, LojaProduto lp, Loja l where p.id = lp.idProduto and lp.idLoja = l.id and lp.idProduto = ?1")
    List<ResultadoLojaProduto> listarPorProduto(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco, l.nome) from Produto p, LojaProduto lp, Loja l where p.id = lp.idProduto and lp.idLoja = l.id and lp.idProduto = ?1 order by lp.preco")
    List<ResultadoLojaProduto> ordenarPorMenorPrecoEmVerPrecos(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco, l.nome) from Produto p, LojaProduto lp, Loja l where p.id = lp.idProduto and lp.idLoja = l.id and lp.idProduto = ?1 order by lp.preco desc")
    List<ResultadoLojaProduto> ordenarPorMaiorPrecoEmVerPrecos(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco, l.nome) from Produto p, LojaProduto lp, Loja l where p.id = lp.idProduto and lp.idLoja = l.id and lp.idProduto = ?1 order by l.nome")
    List<ResultadoLojaProduto> ordenarPorMenorNomeLojaEmVerPrecos(int id);

    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(p.id, p.imagem, p.nome, p.marca, lp.link, lp.preco, l.nome) from Produto p, LojaProduto lp, Loja l where p.id = lp.idProduto and lp.idLoja = l.id and lp.idProduto = ?1 order by l.nome desc")
    List<ResultadoLojaProduto> ordenarPorMaiorNomeLojaEmVerPrecos(int id);
}