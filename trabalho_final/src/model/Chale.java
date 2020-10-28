package model;

public class Chale {
	private Integer codChale;
	private String localizacao;
	private Integer capacidade;
	private Double valorAltaEstacao;
	private Double valorBaixaEstacao;
	
	public Chale() {}

	// Getters e Setters
	
	public int getCodChale() {
		return codChale;
	}
	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}

	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public double getValorAltaEstacao() {
		return valorAltaEstacao;
	}
	public void setValorAltaEstacao(double valorAltaEstacao) {
		this.valorAltaEstacao = valorAltaEstacao;
	}

	public double getValorBaixaEstacao() {
		return valorBaixaEstacao;
	}
	public void setValorBaixaEstacao(double valorBaixaEstacao) {
		this.valorBaixaEstacao = valorBaixaEstacao;
	}
}
