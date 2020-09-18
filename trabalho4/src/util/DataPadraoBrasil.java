package util;

public class DataPadraoBrasil {
		private String dia;
		private String mes;
		private String ano;
		
		public DataPadraoBrasil(String dia, String mes, String ano) {
			this.setDia(dia);
			this.setMes(mes);
			this.setAno(ano);
		}
		
		public void setDia(String dia) {
			this.dia = dia;
		}
		public String getDia() {
			return this.dia;
		}
		public String getMes() {
			return mes;
		}

		public void setMes(String mes) {
			this.mes = mes;
		}

		public String getAno() {
			return ano;
		}

		public void setAno(String ano) {
			this.ano = ano;
		}
		
		@Override
		public String toString(){
			return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
		}		
}
