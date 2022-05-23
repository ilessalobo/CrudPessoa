package projetoteste.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import projetoteste.model.enuns.StatusAtivoInativoEnum;

/*A serialização do Objeto serve para salvar o estado atual em arquivos em formato binario[bytes], posteriormente recriando o objeto em memória*/
/*Em caso de um estado atual fosse perdido o serializable "guardaria" o estado daquele momento para recria-lo novamente quando retornado*/
@Entity
@Table(name = "TESTE_PESSOA")
public class Pessoa implements Serializable {

	
	/*O serialVersionUID serve para rastrear a compatibilidade de versões serializadas das classes.*/
	private static final long serialVersionUID = 1L;

	/* allocationSize é o valor a ser incrementado ao alocar números de sequência da sequência.*/
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
	@SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "TESTE.TESTESQ_PESSOA", allocationSize = 1)
	@Column
	private Long idenPessoa;

	@Column
	private String cpf;

	@Column
	private String nome;

	@Column
	private String rg;

	@Column
	private Long statusPessoa;

	public Long getIdenPessoa() {
		return idenPessoa;
	}

	public void setIdenPessoa(Long idenPessoa) {
		this.idenPessoa = idenPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public StatusAtivoInativoEnum getStatusPessoa() throws Exception {
		return StatusAtivoInativoEnum.toEnum(statusPessoa);
	}

	public void setStatusPessoa(StatusAtivoInativoEnum statusPessoa) {
		this.statusPessoa = statusPessoa.getNumero();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idenPessoa == null) ? 0 : idenPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (idenPessoa == null) {
			if (other.idenPessoa != null)
				return false;
		} else if (!idenPessoa.equals(other.idenPessoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [idenPessoa=" + idenPessoa + ", cpf=" + cpf + ", nome=" + nome + ", rg=" + rg + ", statusPessoa="
				+ statusPessoa + "]";
	}

}
