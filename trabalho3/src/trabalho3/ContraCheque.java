package trabalho3;

public class ContraCheque {
	private float valorHoraAula;
	private float horasSemanais;
	private int noitesTrabalhadas;
	
	private Professor professor;
	private double salarioBase = 0;
	private double salarioBruto = 0;
	private double salario = 0;
	private double FGTS = 0;
	private double descontoINSS = 0;
	private double descontoIRPF = 0;
	private double descontoSVC = 0;

	
	public ContraCheque(float valorHoraAula, float horasSemanais, int noitesTrabalhadas, Professor p){
		this.setValorHoraAula(valorHoraAula);
		this.setHorasSemanais(horasSemanais);
		this.setNoitesTrabalhadas(noitesTrabalhadas);
		this.setProfessor(p);
		salarioBruto();
	}
	
	public void setValorHoraAula(float valor) {
		this.valorHoraAula = valor;
	}
	public float getValorHoraAula() {
		return this.valorHoraAula;
	}
	
	public void setHorasSemanais(float horas) {
		this.horasSemanais = horas;
	}
	public float getHorasSemanais() {
		return this.horasSemanais;
	}
	
	public void setNoitesTrabalhadas(int noites) {
		this.noitesTrabalhadas = noites;
	}
	public float getNoitesTrabalhadas() {
		return this.noitesTrabalhadas;
	}
	
	private void setSalario(double salario) {
		this.salario = salario;
	}
	private double getSalario() {
		return this.salario;
	}

	private void setSalarioBruto(double salario) {
		this.salarioBruto = salario;
	}
	private double getSalarioBruto() {
		return this.salarioBruto;
	}

	private void setSalarioBase(double salario) {
		this.salarioBase = salario;
	}
	private double getSalarioBase() {
		return this.salarioBase;
	}

	
	private void setDescontoINSS(double desconto) {
		this.descontoINSS = desconto;
	}
	private double getDescontoINSS() {
		return this.descontoINSS;
	}
	
	private void setDescontoIRPF(double desconto) {
		this.descontoIRPF = desconto;
	}
	private double getDescontoIRPF() {
		return this.descontoIRPF;
	}
	
	private void setFGTS(double FGTS) {
		this.FGTS = FGTS;
	}
	private double getFGTS() {
		return this.FGTS;
	}
	
	private void setDescontoSVC(double desconto) {
		this.descontoSVC = desconto;
	}
	private double getDescontoSVC() {
		return this.descontoSVC;
	}
	
	private void setProfessor(Professor p) {
		this.professor = p;
	}
	private Professor getProfessor() {
		return this.professor;
	}
	
	// Salário bruto
	private void salarioBruto() {
		setSalarioBase(this.getValorHoraAula() * this.getHorasSemanais() * 4.5);
		double dsr = getSalarioBase() * 0.167;
		double act = getSalarioBase() * 0.021;
		
		this.setSalarioBruto(getSalarioBase() + dsr + act + this.getValorHoraAula() * this.getNoitesTrabalhadas() * 0.2);
		descontoINSS();
	}
	
	// INSS
	private void descontoINSS() {
		double salario = this.getSalarioBruto();
		if(salario <= 1045) {
			this.setDescontoINSS(salario * 0.075);
		} 
		else if(salario > 1045 && salario <= 2089.60) {
			this.setDescontoINSS(salario * 0.09);
		} 
		else if(salario > 2089.60 && salario <= 3134.40) {
			this.setDescontoINSS(salario * 0.12);
		} 
		else if(salario > 3134.40 && salario <= 6101.06) {
			this.setDescontoINSS(salario * 0.14);
		} 
		else {
			this.setDescontoINSS(854.15); // 6101.06 * 0.14
		}
		this.setSalario(salario - this.getDescontoINSS());
		descontoIRPF();
	}
	
	// IRPF
	private void descontoIRPF() {
		double salario = (this.getSalario() - (this.getProfessor().getDependentes() * 189.59));
		
		if(salario <= 1903.98) {
			this.setDescontoIRPF(0);
		}
		else if (salario > 1903.98 && salario <= 2826.65) {
			this.setDescontoIRPF(salario * 0.075 - 142.80);
		} 
		else if (salario > 2826.65 && salario <= 3751.05) {
			this.setDescontoIRPF(salario * 0.15 - 354.80);
		} 
		else if (salario > 3751.05 && salario <= 4664.68) {
			this.setDescontoIRPF(salario * 0.225 - 636.13);
		} 
		else {
			this.setDescontoIRPF(salario * 0.275 - 869.36);
		}
		this.setSalario(this.getSalario() - this.getDescontoIRPF());
		calculaFGTS();
	}
	
	// FGTS
	private void calculaFGTS() {
		this.setFGTS(this.getSalarioBruto() * 0.08);
		calculaSalarioLiquido();
	}
	
	// Salario líquido
	private void calculaSalarioLiquido() {
		this.setDescontoSVC(this.getSalarioBruto() * 0.2);
		this.setSalario(this.getSalario() - this.getDescontoSVC());
	}
	
	@Override
	public String toString() {
		String texto;
		texto = this.getProfessor().toString();
		texto += "\n------------------------------------------------\nSalário Base: ";
		texto += String.format("%.2f", this.getSalarioBase());
		texto += "\nDescanso Semanal Remunerado: ";
		texto += String.format("%.2f", (this.getSalarioBase() * 0.167));
		texto += "\nAcordo Coletivo de Trabalho: ";
		texto += String.format("%.2f", (this.getSalarioBase() * 0.021));
		texto += "\nAdicional Noturno: " ;
		texto += String.format("%.2f", (this.getValorHoraAula() * this.getNoitesTrabalhadas() * 0.2));
		texto += "\nDesconto do INSS: ";
		texto += String.format("%.2f", this.getDescontoINSS());
		texto += "\nDesconto do IRPF: ";
		texto += String.format("%.2f", this.getDescontoIRPF());
		texto += "\nDesconto de Seguro de Vida: ";
		texto += String.format("%.2f", this.getDescontoSVC());
		texto += "\nSalário Bruto: ";
		texto += String.format("%.2f", this.getSalarioBruto());
		texto += "\nSalário Base para INSS: ";
		texto += String.format("%.2f", this.getSalarioBruto());
		texto += "\nSalário Base para FGTS: ";
		texto += String.format("%.2f", this.getSalarioBruto());
		texto += "\nSalário Base para IRPF: ";
		texto += String.format("%.2f", (this.getSalarioBruto() - this.getDescontoINSS() - (this.getProfessor().getDependentes() * 189.59)));
		texto += "\nValor do FGTS: ";
		texto += String.format("%.2f", this.getFGTS());
		texto += "\nSalário Líquido: ";
		texto += String.format("%.2f", this.getSalario());
		
		return texto;
	}
}