package br.com.santander.gerenciadoremprestimo.model;

public enum Status {

	PENDENTE("Pendente"), NEGADA("Negada"), APROVADA("Aprovada");

	private String descricao;

	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
