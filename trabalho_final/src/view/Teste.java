package view;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ChaleController;
import controller.ClienteController;
import controller.HospedagemController;
import model.Chale;
import model.Cliente;
import model.Hospedagem;
import persistencia.ConnectionFactory;

public class Teste {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			/* Teste da Classe Chalé
			Chale c = new Chale();
			ChaleController controller = new ChaleController();
			
			c.setCodChale(1);
			c.setLocalizacao("Algum lugar do Rio Grande do Sul");
			c.setCapacidade(5);
			c.setValorAltaEstacao(130.50);
			c.setValorBaixaEstacao(97.0);
			
			System.out.println(controller.inserir(c));
			
			List<Chale> lista = new ArrayList<>();
			lista = controller.listarTodos();
			if (lista != null){
				for(Chale chale : lista){
					System.out.println("Código do Chale: " + chale.getCodChale());
					System.out.println("Localização: " + chale.getLocalizacao());
				}
			}
			*/
			/* Teste da Classe Clientes
			Cliente c = new Cliente();
			ClienteController controller = new ClienteController();
			
			c.setCodCliente(11);
			c.setNomeCliente("Cláudio César de Almeida");
			c.setEnderecoCliente("Próximo ao clube");
			c.setBairroCliente("Bairro no Rio Grande do Sul");
			c.setCEPCliente("11111-111");
			c.setRgCliente("111111111");
			c.setNascimentoCliente(LocalDate.of(1995, 12, 03));
			
			System.out.println(controller.inserir(c));
			
			c = controller.pesquisarPorRG("111111111");
			System.out.println(c.getNomeCliente());
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes = controller.pesquisarPorNome("Cláudio César de Almeida");
			for(Cliente c2 : clientes) {
				System.out.println(c2.getNomeCliente());
			}
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes = controller.listarTodos();
			for(Cliente c2 : clientes) {
				System.out.println(c2.getNomeCliente());
			}
			*/
			/* Teste da Classe Hospedagem
			Hospedagem h = new Hospedagem();
			HospedagemController controller = new HospedagemController();
			
			h.setCodHospedagem(31);
			h.setCodChale(1);
			h.setEstado("RS");
			h.setDataInicio(LocalDate.of(2002, 10, 31));
			h.setDataFim(LocalDate.of(2002, 10, 31));
			h.setDesconto(0.2);
			h.setValorFinal(900.0);
			h.setQtdPessoas(50);
			
			System.out.println(controller.inserir(h));
			
			List<Hospedagem> hospedagens = new ArrayList<Hospedagem>();
			hospedagens = controller.listarTodos();
			for(Hospedagem hospedagem : hospedagens) {
				System.out.println(hospedagem.getCodHospedagem());
			}
			
			h = controller.pesquisarPorCodigo(31);
			System.out.println(h.getCodChale());
			*/
		}
	}
}
