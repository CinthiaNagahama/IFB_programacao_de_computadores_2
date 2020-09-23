package trabalho4;

public class Livro {
	private String codigo;
	private String titulo;
	private String autor;
	private String ISBN;
	private float preco;
	private String codfornecedor;
	
	
	public Livro(String codigo, String titulo, String autor, String iSBN, float preco, String codfornecedor) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		ISBN = iSBN;
		this.preco = preco;
		this.codfornecedor = codfornecedor;
	}
	
	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCodfornecedor() {
		return codfornecedor;
	}
	public void setCodfornecedor(String codfornecedor) {
		this.codfornecedor = codfornecedor;
	}
	
	// Métodos
	public void inserir() {
		System.out.println("Inserir efeituado com sucesso");
	}
	
	public void consultar() {
		System.out.println("Consultar efeituado com sucesso");
	}
	
	public void alterar() {
		System.out.println("Alterar efeituado com sucesso");
	}
	
	public void excluir() {
		System.out.println("Excluir efeituado com ... na verdade eu não sei como fazer isso");
	}
}
