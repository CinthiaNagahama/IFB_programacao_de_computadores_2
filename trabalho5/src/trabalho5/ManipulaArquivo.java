package trabalho5;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManipulaArquivo {
	// Questão 1
	public static ArrayList<String> lerArquivoAlunos(String arq){
		ArrayList<String> dados = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(arq));
			
			while (br.ready()) {
				String linha = br.readLine();
				System.out.println(linha);
				String texto = linha;
			
				System.out.println("Nota do aluno: ");
				texto += " " + scan.nextLine();
				dados.add(texto);
			}
			br.close();
			
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		scan.close();
		return dados;
	}
	
	public static void gravarArquivo(ArrayList<String> dados, String arq) throws IOException {
		FileOutputStream fos = new FileOutputStream(arq);
		String jump = "\r\n";
		for(String s : dados) {
			fos.write(s.getBytes());
			fos.write(jump.getBytes());
		}
		fos.close();
	}
	
	// Questão 2
	public static void tradutor(String arq){
		try {
			BufferedReader br = new BufferedReader(new FileReader(arq));
			String text = "";
			while (br.ready()) {
				String linha = br.readLine();
				
				for(int i = 0; i < linha.length(); i++) {
					Character c = linha.charAt(i);
					if(c == 'R' || c == 'r') continue;
					if(c == 'l') text += "u";
					else if(c == 'L') text += "U";
					else {
						text += c;
					}
				}
				
				text += "\n";
			}

			System.out.println(text);
			br.close();
			
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
