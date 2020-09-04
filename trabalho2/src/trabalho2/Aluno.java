package trabalho2;

import util.DataPadraoBrasil;

public class Aluno {
	Integer matricula;
	String nome;
	DataPadraoBrasil dataNascimento;

	public Aluno(Integer matricula, String nome, DataPadraoBrasil dataNascimento) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return ("\nNome: " + nome + "\nMatr�cula: " + matricula + "\nData de Nascimento: " + dataNascimento);
	}
}
