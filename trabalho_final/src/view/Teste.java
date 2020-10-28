package view;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controller.ChaleController;
import model.Chale;
import persistencia.ConnectionFactory;

public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			Chale c = new Chale();
			ChaleController controller = new ChaleController();
			/*
			c.setCodChale(1);
			c.setLocalizacao("Algum lugar do Rio Grande do Sul");
			c.setCapacidade(5);
			c.setValorAltaEstacao(130.50);
			c.setValorBaixaEstacao(97.0);
			
			System.out.println(controller.inserir(c));
			*/
			
			List<Chale> lista = new ArrayList<>();
			lista = controller.listarTodos();
			if (lista != null){
				for(Chale chale : lista){
					System.out.println("Código do Chale: " + chale.getCodChale());
					System.out.println("Localização: " + chale.getLocalizacao());
				}
			}
		}
		else {
			System.out.println("Erro de conexão.");
		}
	}
}
