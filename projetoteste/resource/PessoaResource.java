package projetoteste.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoteste.model.Pessoa;
import projetoteste.service.PessoaService;

/*retorna o objeto e os dados do objeto são gravados diretamente na resposta HTTP como JSON ou XML.*/
@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/paginado")
	public Page<Pessoa> pesquisar(Pageable pageable) {
		return pessoaService.pesquisar(pageable);
	}

	@GetMapping("/paginado")
	public List<Pessoa> pesquisar() {
		return pessoaService.pesquisar();
	}

	@GetMapping("{id}")
	public ResponseEntity<Pessoa> buscarPeloId(@PathVariable Long id) {
		return ResponseEntity.ok().body(pessoaService.buscarPeloId(id));
	}

	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoa));
	}

	@PutMapping("{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(pessoa, id);
		return ResponseEntity.ok(pessoaSalva);
	}

	@DeleteMapping
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		pessoaService.remover(id);
		return ResponseEntity.noContent().build();
	}
}
