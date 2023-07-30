package br.com.teste.exerciciossb.model.repositories;

import br.com.teste.exerciciossb.model.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByPrecoGreaterThanEqual(Double preco);

    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    public List<Produto> findByPrecoMaiorQuery(Double preco);
}
