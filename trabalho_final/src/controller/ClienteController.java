package controller;

import java.util.List;

import model.Cliente;
import persistencia.ClienteDAOImp;

public class ClienteController {
	public String inserir(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.inserir(c);
	}
	
	public String alterar(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.alterar(c);
	}
	
	public String excluir(Cliente c) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.excluir(c);
	}
	
	public List<Cliente> listarTodos() {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.listarTodos();
	}
	
	public Cliente pesquisarPorRG(String rg) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorRG(rg);
	}
	
	public List<Cliente> pesquisarPorNome(String nome) {
		ClienteDAOImp dao = new ClienteDAOImp();
		return dao.pesquisarPorNome(nome);
	}
}
