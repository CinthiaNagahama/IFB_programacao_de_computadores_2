package trabalho4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import util.DataPadraoBrasil;

public class Teste {
	public static void main(String[] args) {
		
		/* Teste sem input */
		/* 
		ArrayList <Livro> pedidolivros = new ArrayList<Livro>();
		Livro livro0 = new Livro("123456", "JAVA para INICIANTES", "Desconhecido", "aaaaaa", 65.4f, "cod_fornecedor");
		Livro livro1 = new Livro("123457", "JAVA AVANÇADO", "Desconhecido", "bbbbbb", 102.45f, "cod_fornecedor");
		pedidolivros.add(livro0);
		pedidolivros.add(livro1);
		
		Balconista b = new Balconista("SarahAlmeida", "PQO#2934", 3);
		
		DataPadraoBrasil d = new DataPadraoBrasil("12", "12", "2012");
		
		float valorTotal = 25 * pedidolivros.get(0).getPreco() + 25 * pedidolivros.get(1).getPreco();
		PedidoCliente pc = new PedidoCliente("09876C", d, pedidolivros, 25, valorTotal, "CCCCCC", d);

		Cliente c = new Cliente("CCCCCC", "José Maria Fastos", "Rua 1, casa 100", "VeraCruz", "AC", "00000-000", "9999-9999", pc);
		*/
		
		/* Teste com input */
		Scanner scan = new Scanner(System.in);
		
		Balconista b = new Balconista("SarahAlmeida", "PQO#2934", 3);
		b.login();
		
		ArrayList <Livro> pedidolivros = new ArrayList<Livro>();
		Livro livro0 = new Livro("1", "JAVA para INICIANTES", "Desconhecido", "aaaaaa", 65.4f, "cod_fornecedor");
		Livro livro1 = new Livro("2", "JAVA INTERMEDIÁRIO", "Desconhecido", "bbbbbb", 82.49f, "cod_fornecedor");
		Livro livro2 = new Livro("3", "JAVA AVANÇADO", "Desconhecido", "cccccc", 102.45f, "cod_fornecedor");
		pedidolivros.add(livro0);
		pedidolivros.add(livro1);
		pedidolivros.add(livro2);
		
		System.out.println("Livros Disponíveis: ");
		for(Livro l : pedidolivros) {
			System.out.println(l.getTitulo());
		}
		
		ArrayList <String> cod_livro = new ArrayList<String>();
		ArrayList <Integer> qtd_livro = new ArrayList<Integer>();
		
		
		System.out.print("Por favor, insira o código do livro e a quantidade. (Para sair digite s)\n");
		cod_livro.add(scan.next());
		
		int i = 0;
		while(!cod_livro.get(i).equals("s")) {
			qtd_livro.add(scan.nextInt());
			System.out.print("Por favor, insira o código do livro e a quantidade. (Para sair digite s)\n");
			cod_livro.add(scan.next());
			i++;
		}
		
		Calendar calendar = Calendar.getInstance();
		String dia = Integer.toString(calendar.get(Calendar.DATE));
		String mes = Integer.toString(calendar.get(Calendar.MONTH));
		String ano = Integer.toString(calendar.get(Calendar.YEAR));
		DataPadraoBrasil d = new DataPadraoBrasil(dia, mes, ano);
		
		int qtd = 0;
		float valorTotal = 0f;
		for(i = 0; i < cod_livro.size() && !cod_livro.get(i).contentEquals("s"); i++) {
			qtd += qtd_livro.get(i);
			for(Livro l : pedidolivros) {
				if(l.getCodigo().equals(cod_livro.get(i))) {
					valorTotal += qtd_livro.get(i) * l.getPreco();
				}
			}
		}
		
		System.out.println("Por favor, insira o código do cliente: ");
		String cod_cliente = scan.next();
		cod_cliente = scan.nextLine();
		System.out.println("Por favor, insira o nome do cliente: ");
		String nome = scan.nextLine();
		System.out.println("Por favor, insira o endereço do cliente: ");
		String endereco = scan.nextLine();
		System.out.println("Por favor, insira o cidade do cliente: ");
		String cidade = scan.nextLine();
		System.out.println("Por favor, insira o estado do cliente: ");
		String estado = scan.nextLine();
		System.out.println("Por favor, insira o cep do cliente: ");
		String cep = scan.nextLine();
		System.out.println("Por favor, insira o telefone do cliente: ");
		String telefone = scan.nextLine();
		
		PedidoCliente pc = new PedidoCliente("09876C", d, pedidolivros, qtd, valorTotal, cod_cliente, d);
		Cliente c = new Cliente(cod_cliente, nome, endereco, cidade, estado, cep, telefone, pc);
		
		// Impressão do Pedido
		System.out.println("\n---------------Pedido efetuado com sucesso -----------------\nTítulo do(s) livro(s): ");
		
		for(i = 0; i < cod_livro.size() && !cod_livro.get(i).contentEquals("s"); i++) {
			for(Livro l : pedidolivros) {
				if(l.getCodigo().equals(cod_livro.get(i))) {
					System.out.println(l.getTitulo());
				}
			}
		}
		System.out.println("Cliente: " + c.getNome() + "\nData do Pedido: " + pc.getDatapedido() + "\nBalconista responsável: " + b.getNomeusuario());
		scan.close();
	}
}
