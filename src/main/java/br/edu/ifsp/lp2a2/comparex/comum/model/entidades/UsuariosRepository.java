package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {
//
// @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Usuario(nome, senha) from Usuario u ")

//List<Usuario> loginUsuario(String nome);

//
//  @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Usuario(u.id, u.nome, u.senha, u.email) from Usuario u where u.email = login and u.senha = senha")
//  Usuario findByUser(@Param("login") String login,@Param("senha") String senha);
//
//    <T> Optional<T> findById(int id);
//    Usuario findUserById(int id);
////    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.ResultadoLojaProduto(lp.idProduto, count(lp.idLoja)) from LojaProduto lp group by lp.idProduto")
////    List<ResultadoLojaProduto> quantidadeLojas();

}
