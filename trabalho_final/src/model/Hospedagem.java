package model;

import java.time.LocalDate;

public class Hospedagem {
	private Integer codHospedagem;
	private Integer codChale;
	private String estado;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	
	public Hospedagem() {}

	// Getters e Setters
	
	public int getCodHospedagem() {
		return codHospedagem;
	}
	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public int getCodChale() {
		return codChale;
	}
	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}
	public void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal - this.getDesconto() * valorFinal;
	}
}
