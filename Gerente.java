package AppEntregas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Gerente extends Funcionario{
	Scanner sc = new Scanner(System.in);
	public void setFuncao() {
		this.funcao = "Gerente"; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void CriarCardapio() {
		File cardapio = new File("Cardapio.txt");
		// Deve existir um botão "Criar Cardápio
		try {
				if (cardapio.createNewFile()) {
			    	System.out.println("Arquivo criado: " + cardapio.getName() + "\n");
			  	} 
				else {
					System.out.println("Arquivo já existe.\n");
		  	}
		} catch (IOException e) {
			System.out.println("Um erro ocorreu.\n");
			e.printStackTrace();
		}
		
		// Botão Adicionar prato
		// Deve-se ter um aviso "Aperte "?" para parar de digitar"
		try {

			FileOutputStream Foutput = new FileOutputStream("Cardapio.txt");
			String input = sc.next();
			int contador = input.length() -1;
			while(contador >=0) {//prototipo de funcao para parar de ler os inputs... deve ser substituido
				Foutput.write(input.charAt(contador));
				contador--;
				if(input == "?") {
					Foutput.close();
					System.out.println("Prato adicionado ao cardápio");
				}
			}
			
		} catch(IOException e){
			System.out.println("Ocorreu um erro ao adicionar ao cardápio");
			e.printStackTrace();
		}
		
			
								
			/*System.out.println("Prato adicionado ao cardápio");
		    } 
		catch (IOException e) {
		    System.out.println("An error occurred.");
		   	e.printStackTrace();
		    }
	}*/
	
}
