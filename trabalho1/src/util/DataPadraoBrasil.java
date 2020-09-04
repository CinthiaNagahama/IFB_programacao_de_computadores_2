package util;

public class DataPadraoBrasil {
	String dia;
	String mes;
	String ano;
	
	public DataPadraoBrasil(String dia, String mes, String ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	@Override
	public String toString(){
		return dia + "/" + mes + "/" + ano;
	}
}
