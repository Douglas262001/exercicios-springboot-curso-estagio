package br.com.teste.exerciciossb.dto.response;

import br.com.teste.exerciciossb.model.entities.Produto;
import lombok.Getter;

@Getter
public class ProdutoResponseDTO {

    private Integer id;

    private String nome;

    private double preco;

    private double desconto;

    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.desconto = produto.getDesconto();
    }
}
