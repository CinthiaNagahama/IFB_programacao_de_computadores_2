package trabalho3;

public class Professor {
	private int ctps;
	private String nome;
	private String formacao;
	private int dependentes;
	
	public Professor(int ctps, String nome, String formacao, int dependentes) {
		this.setCTPS(ctps);
		this.setNome(nome);
		this.setFormacao(formacao);
		this.setDependentes(dependentes);
	}
	
	public void setCTPS(int ctps) {
		this.ctps = ctps;
	}
	public int getCTPS() {
		return this.ctps;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String getFormacao() {
		return this.formacao;
	}

	private void setDependentes(int dependentes) {
		this.dependentes = dependentes;
	}
	public int getDependentes() {
		return this.dependentes;
	}
	
	@Override
	public String toString() {
		return "\nDados do Professor:\n------------------------------------------------\nNome: " + this.getNome() +
				"\nCTPS: " + this.getCTPS() + "\nFormação: " + this.getFormacao();
	}
}
