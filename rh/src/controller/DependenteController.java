package controller;

import model.Dependente;
import persistencia.DependenteDAOImp;
import java.util.List;

public class DependenteController {
	public String inserir(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.inserir(dep);
	}
	
	public String alterar(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.alterar(dep);
	}
	
	public String excluir(Dependente dep) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.excluir(dep);
	}
	
	public List<Dependente> listarTodos() {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.listarTodos();
	}
	
	public List<Dependente> pesquisarPorEmpregado(String cpf) {
		DependenteDAOImp dao = new DependenteDAOImp();
		return dao.pesquisarPorEmpregado(cpf);
	}
}
