package projetoteste.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetoteste.model.Pessoa;
import projetoteste.model.enuns.StatusAtivoInativoEnum;
import projetoteste.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	// Pesquisa paginada
	public Page<Pessoa> pesquisar(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}

	// Pesquisa por lista
	public List<Pessoa> pesquisar() {
		return pessoaRepository.findAll();
	}

	public Pessoa salvar(Pessoa pessoa) {
		pessoa.setStatusPessoa(StatusAtivoInativoEnum.ATIVO);
		return pessoaRepository.save(pessoa);
	}

	public Pessoa buscarPeloId(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findById(id).get();
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}

	public Pessoa atualizar(Pessoa pessoa, Long id) {
		Pessoa pessoaSave = buscarPeloId(id);
		BeanUtils.copyProperties(pessoa, pessoaSave, "idenPessoa");
		return pessoaRepository.save(pessoa);
	}

	public void remover(Long id) {
		Pessoa pessoa = buscarPeloId(id);
		pessoa.setStatusPessoa(StatusAtivoInativoEnum.INATIVO);
		pessoaRepository.deleteById(id);
	}

}
