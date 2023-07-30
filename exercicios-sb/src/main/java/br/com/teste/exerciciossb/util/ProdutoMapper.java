package br.com.teste.exerciciossb.util;

import br.com.teste.exerciciossb.dto.request.ProdutoRequestDTO;
import br.com.teste.exerciciossb.dto.response.ProdutoResponseDTO;
import br.com.teste.exerciciossb.model.entities.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProdutoMapper {

    public Produto toProduto(ProdutoRequestDTO produtoDTO) {
        return Produto.builder()
                .nome(produtoDTO.getNome())
                .preco(produtoDTO.getPreco())
                .desconto(produtoDTO.getDesconto())
                .build();
    }

    public ProdutoResponseDTO toProdutoDTO(Produto produto) {
        return new ProdutoResponseDTO(produto);
    }

    public List<ProdutoResponseDTO> toProdutosDTO(List<Produto> produtoList) {
        return produtoList.stream().map(ProdutoResponseDTO::new).collect(Collectors.toList());
    }

    public void updateProdutoData(Produto produto, ProdutoRequestDTO produtoDTO) {
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(produtoDTO.getPreco());
        produto.setDesconto(produtoDTO.getDesconto());
    }
}
