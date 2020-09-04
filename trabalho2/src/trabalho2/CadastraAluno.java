package trabalho2;

import util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class CadastraAluno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Checa se algum aluno será inserido
		System.out.println("Insira a matrícula do aluno: ");
		Integer matricula = Integer.parseInt(sc.nextLine());
		
		if(matricula == 0) {
			System.exit(0);
		}
		
		// Inicia os vetores de alunos e notas
		ArrayList <Aluno> alunos = new ArrayList<Aluno>();
		ArrayList <Float> notas = new ArrayList<Float>();
		int i = 0;
		
		while(matricula != 0) {
			// Recebe os dados do aluno
			System.out.println("Insira o nome do aluno: ");
			String nome = sc.nextLine();
				
			System.out.println("Insira o dia de nascimento do aluno: ");
			String dia = sc.nextLine();
				
			System.out.println("Insira o mês de nascimento do aluno: ");
			String mes = sc.nextLine();
				
			System.out.println("Insira o ano de nascimento do aluno: ");
			String ano = sc.nextLine();
			
			// Recebe e atribui a nota
			System.out.println("Insira a nota do aluno: ");
			notas.add(Float.parseFloat(sc.nextLine()));
			
			// Cria um objeto aluno, atribui os dados ao aluno
			DataPadraoBrasil d = new DataPadraoBrasil(dia, mes, ano);
			Aluno a = new Aluno(matricula, nome, d);
			
			// Insere o aluno ao vetor alunos
			alunos.add(a);
			
			// Mostra na tela os dados e a nota do aluno 
			System.out.println(alunos.get(i) + "\nNota: " + notas.get(i));
			i++;
			
			// Recebe a matrícula do próximo aluno ou o pedido de saída (matricula = 0)
			System.out.println("\nInsira a matrícula do aluno: ");
			matricula = Integer.parseInt(sc.nextLine());
		}
		
		// Mostra na tela a quantidade de alunos inseridos
		if(alunos.size() == 1) {
			System.out.println("\n1 aluno inserido.");
		}
		else {
			System.out.println("\n"+ alunos.size() + " alunos inseridos.");
		}

		sc.close();
	}
}