package projetoteste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoteste.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>  {

	
	public Pessoa findByCpf(String cpf);
	
	public Pessoa findByNomeAndRgAndCpf(String nome, String rg, String cpf);

}
