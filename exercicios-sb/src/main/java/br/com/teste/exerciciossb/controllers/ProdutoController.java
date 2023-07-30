package br.com.teste.exerciciossb.controllers;

import br.com.teste.exerciciossb.dto.request.ProdutoRequestDTO;
import br.com.teste.exerciciossb.dto.response.ProdutoResponseDTO;
import br.com.teste.exerciciossb.model.entities.Produto;
import br.com.teste.exerciciossb.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(produtoService.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoResponseDTO>> findAll() {
		return ResponseEntity.ok().body(produtoService.findAll());
	}

	@GetMapping("/preco_maior/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMaior(@PathVariable Double preco) {
		return ResponseEntity.ok().body(produtoService.findByPrecoMaior(preco));
	}

	@GetMapping("/preco_maior_query/{preco}")
	public ResponseEntity<List<Produto>> findByPrecoMaiorQuery(@PathVariable Double preco) {
		return ResponseEntity.ok().body(produtoService.findByPrecoMaiorQuery(preco));
	}

	@PostMapping
	public ResponseEntity<ProdutoResponseDTO> register (@RequestBody ProdutoRequestDTO produtoRequestDTO, UriComponentsBuilder uriBuilder) {
		ProdutoResponseDTO produtoResponseDTO = produtoService.register(produtoRequestDTO);
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produtoResponseDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(produtoResponseDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResponseDTO> update(@RequestBody ProdutoRequestDTO produtoDTO, @PathVariable Integer id) {
		return ResponseEntity.ok().body(produtoService.update(produtoDTO, id));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		return ResponseEntity.ok().body(produtoService.delete(id));
	}
}
