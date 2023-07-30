package br.com.teste.exerciciossb.services;

import br.com.teste.exerciciossb.dto.request.ProdutoRequestDTO;
import br.com.teste.exerciciossb.dto.response.ProdutoResponseDTO;
import br.com.teste.exerciciossb.model.entities.Produto;

import java.util.List;

public interface ProdutoService {

    ProdutoResponseDTO findById(Integer id);

    List<ProdutoResponseDTO> findAll();

    List<Produto> findByPrecoMaior(Double preco);

    List<Produto> findByPrecoMaiorQuery(Double preco);

    ProdutoResponseDTO register(ProdutoRequestDTO produtoDTO);

    ProdutoResponseDTO update(ProdutoRequestDTO produtoDTO, Integer id);

    String delete(Integer id);
}
