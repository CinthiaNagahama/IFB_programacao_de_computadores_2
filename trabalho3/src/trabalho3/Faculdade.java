package trabalho3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Faculdade {

	public static void main(String[] args) {
		
		String continuar;
		continuar = JOptionPane.showInputDialog("Você deseja continuar? [S/N]");

		if(continuar.equals("N")) {
			System.exit(0);
		}
		else {			
			ArrayList <Professor> professores = new ArrayList <Professor>();
			ArrayList <ContraCheque> contraCheques = new ArrayList <ContraCheque>();
		
			while(continuar.equals("S")) {
				int ctps = Integer.parseInt(JOptionPane.showInputDialog("Favor inserir o CTPS do professor: "));
				String nome = JOptionPane.showInputDialog("Favor inserir o nome do professor: ");
				String formacao = JOptionPane.showInputDialog("Favor inserir a formação do professor: ");
				int dependentes = Integer.parseInt(JOptionPane.showInputDialog("Favor inserir a quantidade de dependentes do professor: "));
				
				float valorHoraAula = Float.parseFloat(JOptionPane.showInputDialog("Favor inserir o valor da hora-aula: "));
				float horasSemanais = Float.parseFloat(JOptionPane.showInputDialog("Favor inserir a quantidade horas trabalhadas semanalmente: "));
				int noitesTrabalhadas = Integer.parseInt(JOptionPane.showInputDialog("Favor inserir a quantidade de noites trabalhadas: "));
				
				Professor p = new Professor(ctps, nome, formacao, dependentes);
				ContraCheque cc = new ContraCheque(valorHoraAula, horasSemanais, noitesTrabalhadas, p);
				
				professores.add(p);
				contraCheques.add(cc);
				continuar = JOptionPane.showInputDialog("Você deseja continuar? [S/N]");
			}
			
			for (ContraCheque c : contraCheques) {
				JOptionPane.showMessageDialog(null, c);
			}	
		}
	}
}
