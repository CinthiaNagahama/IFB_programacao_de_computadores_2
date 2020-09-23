package trabalho4;

public class Cliente {
	private String codigo;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String cep;
	private String telefone;
	private PedidoCliente pedcli;
	
	public Cliente(String codigo, String nome, String endereco, String cidade, String estado, String cep, String telefone, PedidoCliente pedcli) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.pedcli = pedcli;
	}
	
	// Getters e Setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public PedidoCliente getPedcli() {
		return pedcli;
	}
	public void setPedcli(PedidoCliente pedcli) {
		this.pedcli = pedcli;
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
	
	public void efetuarPedidoCliente() {
		
	}
	
	public void efetuarPagamento() {
		
	}
}
