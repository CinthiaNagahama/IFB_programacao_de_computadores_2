package controller;

import java.util.List;
import model.Empregado;
import persistencia.EmpregadoDAOImp;

public class EmpregadoController {
	public String inserir(Empregado emp) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.inserir(emp);
	}
	
	public String alterar(Empregado emp) {;
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.alterar(emp);
	}
	
	public String excluir(Empregado emp) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.excluir(emp);		
	}
	
	public List<Empregado> listarTodos(){
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.listarTodos();		
	}
	
	public Empregado pesquisarCpf(String cpf) {
		EmpregadoDAOImp dao = new EmpregadoDAOImp();
		return dao.pesquisarCpf(cpf);		
	}
}
