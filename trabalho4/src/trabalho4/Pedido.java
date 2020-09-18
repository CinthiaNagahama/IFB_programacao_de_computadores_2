package trabalho4;

import java.util.ArrayList;
import util.*;

public class Pedido {
	protected String codigo;
	protected DataPadraoBrasil datapedido;
	protected ArrayList<Livro> listalivro;
	protected int quantidade;
	protected float valor;
	
	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public DataPadraoBrasil getDatapedido() {
		return datapedido;
	}
	public void setDatapedido(DataPadraoBrasil datapedido) {
		this.datapedido = datapedido;
	}
	public ArrayList<Livro> getListalivro() {
		return listalivro;
	}
	public void setListalivro(ArrayList<Livro> listalivro) {
		this.listalivro = listalivro;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	// Métodos
	public void calcvalor() {
		
	}
}
