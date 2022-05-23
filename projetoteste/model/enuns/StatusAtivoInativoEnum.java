package projetoteste.model.enuns;

public enum StatusAtivoInativoEnum {

	INATIVO(new Long(0), "Inativo"), 
	ATIVO(new Long(1),"Ativo");
	
	private Long numero;

	private String descricao;

	private StatusAtivoInativoEnum(Long numero, String descricao) {
		this.numero = numero;
		this.descricao = descricao;
	}

	public Long getNumero() {
		return numero;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static StatusAtivoInativoEnum toEnum(Long numero) throws Exception {

		if (numero == null) {
			return null;
		}

		for (StatusAtivoInativoEnum x : StatusAtivoInativoEnum.values()) {
			if (numero.equals(x.getNumero())) {
				return x;
			}
		}

		throw new Exception("Código Status inválido: " + numero);
	}
	
	
	public static StatusAtivoInativoEnum toEnumDesc(String desc) throws Exception {

		if (desc == null || desc.isEmpty()) {
			throw new Exception("Enum inválido:  " + desc);
		}

		for (StatusAtivoInativoEnum x : StatusAtivoInativoEnum.values()) {
			if (desc.equals(x.name())) {
				return x;
			}
		}

		throw new Exception("Enum inválido:  " + desc);
	}

}

