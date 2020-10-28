package controller;

import java.util.List;

import model.Chale;
import persistencia.ChaleDAOImp;

public class ChaleController {
	public String inserir(Chale c) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(c);
	}
	
	public String alterar(Chale c) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(c);
	}
	
	public String excluir(Chale c) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(c);
	}
	
	public List<Chale> listarTodos(){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}
}
