package trabalho1;
import util.*;

public class Funcionario {
	Integer matricula;
	String nome;
	DataPadraoBrasil dataDeNascimento;
	String cargo;
	
	public Funcionario (Integer matricula, String nome, DataPadraoBrasil dataDeNascimento, String cargo) {
		this.matricula = matricula;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cargo = cargo;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n" + "Matrícula: " + matricula + "\n" + "Data de nascimento: " + dataDeNascimento + "\n" + "Cargo: " + cargo;
	}
}
