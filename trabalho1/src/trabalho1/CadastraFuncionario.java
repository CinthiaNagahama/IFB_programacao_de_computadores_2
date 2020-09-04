package trabalho1;
import util.*;

public class CadastraFuncionario {
	public static void main(String[] args) {
		DataPadraoBrasil d1 = new DataPadraoBrasil("12", "05", "1988");
		DataPadraoBrasil d2 = new DataPadraoBrasil("24", "03", "1979");
		
		Funcionario f1 = new Funcionario(123456789, "João Maria de Jesus", d1, "Caixa");
		Funcionario f2 = new Funcionario(222222222, "Martha Alvez", d2, "Segurança");
		
		System.out.println(f1);
		System.out.println(f2);
	}

}
