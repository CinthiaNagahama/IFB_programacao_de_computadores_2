package view;

import java.sql.Connection;
import java.util.List;

import controller.EmpregadoController;
import model.Empregado;
import persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if(con != null) {
			
			Empregado emp = new Empregado();
			EmpregadoController controller = new EmpregadoController();
			/*
			emp.setCpf("11111");
			emp.setNome("Maria da Silva Ribeiro");
			emp.setIdade(25);
			emp.setSalario(2500.0);
			System.out.println(controller.inserir(emp));
			*/
			
			/*
			List<Empregado> lista = controller .listarTodos();
			if(lista != null){
				for(Empregado e : lista){
					System.out.println("CPF: "+e.getCpf());
					System.out.println("Nome: "+e.getNome());
					System.out.println("Idade: "+e.getIdade());
					System.out.println("Salário: "+e.getSalario());
				}
			}
			*/
			
			emp = controller.pesquisarCpf("11111");
			if (emp != null) {
				System.out.println("CPF: " + emp.getCpf());
				System.out.println("Nome: " + emp.getNome());
				System.out.println("Idade: " + emp.getIdade());
				System.out.println("Salário: " + emp.getSalario());
			}
			
			ConnectionFactory.close(con);
		}
	}
}
