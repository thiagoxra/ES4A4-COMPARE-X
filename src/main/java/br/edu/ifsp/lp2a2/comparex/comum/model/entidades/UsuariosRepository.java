package br.edu.ifsp.lp2a2.comparex.comum.model.entidades;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {

//    @Query("select new br.edu.ifsp.lp2a2.comparex.comum.model.entidades.Usuario(nome, senha) from Usuario u")

//    @Query("SELECT u FROM Usuario u where u.email =:login AND u.password =:senha")
//   // Usuario findByUser(@Param("login") String login,@Param("senha") String senha);
//     Usuario findByUser(int id);
        <T> Optional<T> findById(int id);
        Usuario findUserById(int id);
//
//    // É assim que se faz uma query se for necessário
//    @Query("SELECT u FROM Usuario u where u.email = :login And u.password = :senha ")
//    Usuario findByUser(@Param("login") int login,@Param("senha") String senha);

//     @Query("SELECT p FROM Produto p ORDER BY pontuacao DESC")
//     Iterable<Produto> findByPontuacaoOrder();
//
    @Query(value = "SELECT u FROM Usuario u where u.email = ?1 AND u.senha = ?2")
   Usuario findByUser (String email, String senha);

    @Query(value = "SELECT COUNT (u) FROM Usuario u where u.nome = ?1 AND u.email = ?2")
    int findByUserRepeticao (String nome, String email);

    @Query(value = "SELECT u FROM Usuario u where u.email = ?1 AND u.senha = ?2 AND u.nome = ?3")
    Usuario findByTodos (String email, String senha, String nome);






    //  List<Produto> findByNomeContaining(String nome);



}
