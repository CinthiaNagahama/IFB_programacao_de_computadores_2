package controller;

import java.util.List;

import model.Hospedagem;
import persistencia.HospedagemDAOImp;

public class HospedagemController {
	public String inserir(Hospedagem h) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.inserir(h);
	}
	
	public String alterar(Hospedagem h) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.alterar(h);
	}
	
	public String excluir(Hospedagem h) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.excluir(h);
	}
	
	public List<Hospedagem> listarTodos() {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.listarTodos();
	}
	
	public Hospedagem pesquisarPorCodigo(int cod) {
		HospedagemDAOImp dao = new HospedagemDAOImp();
		return dao.pesquisarPorCodigo(cod);
	}
}
