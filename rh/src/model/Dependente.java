package model;

import java.time.LocalDate;

public class Dependente {
	private String cpfEmpregado;
	private String nome;
	private String grauParentesco;
	private LocalDate dataNascimento;
	
	public Dependente() {}
	
	// Getters e Setters
	public String getCpfEmpregado() {
		return cpfEmpregado;
	}
	public void setCpfEmpregado(String cpfEmpregado) {
		this.cpfEmpregado = cpfEmpregado;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}
	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}