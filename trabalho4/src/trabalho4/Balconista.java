package trabalho4;

public class Balconista {
	protected String nomeusuario;
	protected String senha;
	protected int nivelacesso;

	public Balconista(String nomeusuario, String senha, int nivelacesso) {
		this.nomeusuario = nomeusuario;
		this.senha = senha;
		this.nivelacesso = nivelacesso;
	}
	
	// Getters e Setters
	public String getNomeusuario() {
		return nomeusuario;
	}
	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNivelacesso() {
		return nivelacesso;
	}
	public void setNivelacesso(int nivelacesso) {
		this.nivelacesso = nivelacesso;
	}
	
	// Métodos
	public void login() {
		System.out.println("Login efeituado com sucesso");
	}
	
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
	
	public void remessaCliente() {
		
	}
	
	public void efetuarPedidoCliente() {
		
	}	
}
