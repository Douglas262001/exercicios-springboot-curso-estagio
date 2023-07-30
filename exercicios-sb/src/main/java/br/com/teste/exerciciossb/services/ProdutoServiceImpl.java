package br.com.teste.exerciciossb.services;

import br.com.teste.exerciciossb.dto.request.ProdutoRequestDTO;
import br.com.teste.exerciciossb.dto.response.ProdutoResponseDTO;
import br.com.teste.exerciciossb.model.repositories.ProdutoRepository;
import br.com.teste.exerciciossb.model.entities.Produto;
import br.com.teste.exerciciossb.util.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoResponseDTO findById(Integer id) {
        return produtoMapper.toProdutoDTO(returnProduto(id));
    }

    @Override
    public List<ProdutoResponseDTO> findAll() {
        return produtoMapper.toProdutosDTO(produtoRepository.findAll());
    }

    @Override
    public List<Produto> findByPrecoMaior(Double preco) {
        return produtoRepository.findByPrecoGreaterThanEqual(preco);
    }

    @Override
    public List<Produto> findByPrecoMaiorQuery(Double preco) {
        return produtoRepository.findByPrecoMaiorQuery(preco);
    }

    @Override
    public ProdutoResponseDTO register(ProdutoRequestDTO produtoDTO) {
        Produto produto = produtoMapper.toProduto(produtoDTO);

        return produtoMapper.toProdutoDTO(produtoRepository.save(produto));
    }

    @Override
    public ProdutoResponseDTO update(ProdutoRequestDTO produtoDTO, Integer id) {
        Produto produto = returnProduto(id);

        produtoMapper.updateProdutoData(produto, produtoDTO);

        return produtoMapper.toProdutoDTO(produtoRepository.save(produto));
    }

    @Override
    public String delete(Integer id) {
        produtoRepository.deleteById(id);
        return "Produto de id: " + id + " deletado";
    }

    private Produto returnProduto(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não está no banco"));
    }

}
