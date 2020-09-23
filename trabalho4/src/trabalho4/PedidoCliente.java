package trabalho4;

import java.util.ArrayList;

import util.*;

public class PedidoCliente extends Pedido{
	private String codcliente;
	private DataPadraoBrasil dataremessa;
	
	public PedidoCliente(String codigo, DataPadraoBrasil datapedido, ArrayList<Livro> listalivro, int quantidade, float valor, 
							String codcliente, DataPadraoBrasil dataremessa) {
		super(codigo, datapedido, listalivro, quantidade, valor);
		this.codcliente = codcliente;
		this.dataremessa = dataremessa;
	}
	
	// Getters e Setters
	public String getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}
	public DataPadraoBrasil getDataremessa() {
		return dataremessa;
	}
	public void setDataremessa(DataPadraoBrasil dataremessa) {
		this.dataremessa = dataremessa;
	}
	
	// Métodos
	public void pagamentoCliente() {
		
	}
	
	public void remessaCliente() {
		
	}
	
	public void recuperarPedCliente() {
		
	}
}
