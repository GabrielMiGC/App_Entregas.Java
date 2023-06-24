package AppEntregas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Restaurante {
	public String nome;
	public boolean isOpen;
	Endereco enderecoRestaurante = new Endereco();
	
	public Restaurante(String nome, Boolean isOpen, Endereco enderecoRestaurante) {
		setNome(nome);
		setIsopen(isOpen);
		setEnderecoRestaurante(enderecoRestaurante);
	}
	public Restaurante() {
		this("Exemplo Restaurante", false, null);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getIsopen() {
		return isOpen;
	}
	public void setIsopen(boolean isopen) {
		this.isOpen = isopen;
	}
	
	public Endereco getEnderecoRestaurante() {
		return enderecoRestaurante;
	}
	public void setEnderecoRestaurante(Endereco enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}
	public void imprimirCardapio() {
		Scanner input = null;
		try {
			// Usa o Scanner para ler o arquivo ao invés do teclado
			input = new Scanner(new File("Cardapio.txt"));
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
