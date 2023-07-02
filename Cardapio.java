package AppEntregas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cardapio {

    Scanner sc = new Scanner(System.in);

    public void criarCardapio(Restaurante restaurante) 
	{
		File cardapio = new File("Cardapio do "+ restaurante.getNome() +".txt");
		// Deve existir um botão "Criar Cardápio
		try {
				if (cardapio.createNewFile()) {
			    	System.out.println("Arquivo criado: " + cardapio.getName());
			  	} else {
					System.out.println("Arquivo já existe.");
		  	}
		} 
		catch (IOException e) {
			System.out.println("Um erro ocorreu.");
			e.printStackTrace();
		}
	}


	public  void addPrato(Restaurante restaurante, Pratos pratos){
		// Botão Adicionar prato
		// Deve-se ter um aviso "Aperte "Esc" para parar de digitar"
	    try (FileOutputStream Foutput = new FileOutputStream("Cardapio do "+ restaurante.getNome() +".txt", true)) {
        
            Foutput.write((System.lineSeparator() + pratos.getNomePrato() + System.lineSeparator() + pratos.getIngredientes()).getBytes());
            System.out.println("Prato adicionado ao cardápio");
            
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao adicionar ao cardápio");
            e.printStackTrace();
        } 
	}


	public void alterarPrato(Restaurante restaurante)
	{	
		/*Usuário insere o nome do prato que deseja alterar e o código busca no Cardapio.txt.
		* Caso encontre, uma variável armazena as alterações a serem feitas e depois substitui
		* o conteudo no arquivo, caso o prato não exista no txt, uma mensagem será exibida.
		*/
		System.out.print("Digite o nome do prato a ser alterado: ");
        String pratoBuscado = sc.nextLine();

        try {
            File cardapioFile = new File("Cardapio do "+ restaurante.getNome() +".txt");
            Scanner fileScanner = new Scanner(cardapioFile);
            StringBuilder cardapioContent = new StringBuilder();

            boolean pratoEncontrado = false;

            while (fileScanner.hasNextLine()) {
            	String line = fileScanner.nextLine();
            	if (line.startsWith(pratoBuscado + ":")) {
            		pratoEncontrado = true;

            		System.out.print("Digite o novo nome do prato: ");
            		String novoNomePrato = sc.nextLine();

            		System.out.print("Digite os novos ingredientes: ");
            		String novosIngredientes = sc.nextLine();

            		line = novoNomePrato + ": " + novosIngredientes;
            		}
            	cardapioContent.append(line).append(System.lineSeparator());
            }

            if (!pratoEncontrado) {
            	System.out.println("O prato informado não foi encontrado no cardápio.");
        } else {
        	FileWriter writer = new FileWriter(cardapioFile);
        	writer.write(cardapioContent.toString());
        	writer.close();
        	System.out.println("O prato foi alterado com sucesso.");
        	}

    	fileScanner.close();
        } catch(IOException e) {
		System.out.println("Ocorreu um erro ao acessar o arquivo do cardápio.");
		e.printStackTrace();
		}
	}


    public static void imprimirCardapio(Restaurante restaurante) {
		Scanner input = null;
		try {
			input = new Scanner(new File("Cardapio do "+ restaurante.getNome() +".txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo, certifique-se que ele existe");
			e.printStackTrace();
			System.exit(1);
		}
		
		Pratos prato = new Pratos();
		
		try {
			while(input.hasNextLine()) {
				//Lê o arquivo
				prato.setNomePrato(input.nextLine());
				prato.setIngredientes(input.nextLine());
				
				//Imprime o conteúdo
				System.out.printf("%s:\n%s\n", prato.getNomePrato(), prato.getIngredientes());
			}
		}catch(NoSuchElementException elementExept){
			System.err.println("Erro ao ler aquivo");
			input.close();
			System.exit(1);
		}
		input.close();
	}
}
