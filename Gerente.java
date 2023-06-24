package AppEntregas;

import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Gerente extends Funcionario{
	Scanner sc = new Scanner(System.in);
	public Gerente() {
        setFuncao();
        setNomeFuncionario(nomeFuncionario);
        setNascimento();
    }
	public void abrirFecharRestaurante() 
	{
		Restaurante restaurante = new Restaurante();
		restaurante.setIsopen(true);
	}

	

	

	public void cadastrarRestaurante() 
	{
		Restaurante restaurante = new Restaurante();
		System.out.println("Digite o nome do Restaurante");
		restaurante.setNome(sc.nextLine());
		
		System.out.println("Digite o logradouro do Restaurante");
		String logr = sc.nextLine();
		
		System.out.println("Digite o número do Restaurante");
		int num = sc.nextInt();
		
		System.out.println("Digite o bairro do Restaurante");
		String bairro = sc.nextLine();
		
		System.out.println("Digite o CEP do Restaurante");
		int cep =sc.nextInt();
		
		System.out.println("Digite a cidade do Restaurante");
		String cidade = sc.nextLine();
		
		Endereco endereco = new Endereco(logr, num, bairro, cep, cidade);
		restaurante.setEnderecoRestaurante(endereco);
	}
	
	public void criarCardapio() 
	{
		File cardapio = new File("Cardapio.txt");
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
	public void addPrato()
	{
		// Botão Adicionar prato
		// Deve-se ter um aviso "Aperte "Esc" para parar de digitar"
		try {
            FileOutputStream Foutput = new FileOutputStream("Cardapio.txt", true);
            System.out.println("Insira os dados seguindo o padrão:");
            System.out.println("O formato padrão é: ");
            System.out.println("Nome do prato");
            System.out.println("Ingrediente, Ingrediente...");

            System.out.println("Insira os dados ('Esc' para parar):");

            while (true) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("Esc")) {
                    Foutput.close();
                    break;
                }
                String[] pratoData = input.split(",");
                if (pratoData.length >= 2) {
                    String nomePrato = pratoData[0].trim();
                    String ingredientes = pratoData[1].trim();
                    Pratos prato = new Pratos(nomePrato, ingredientes);
                    Foutput.write((prato.toString() + System.lineSeparator()).getBytes());
                    System.out.println("Prato adicionado ao cardápio");
                } else {
                    System.out.println("Dados inválidos. Insira novamente.");
                }
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao adicionar ao cardápio");
            e.printStackTrace();
        } catch (SecurityException securityException) {
            System.err.println("Você não tem permissão para escrever neste arquivo.");
            System.exit(1);
        }
	}
	public void alterarPrato()
	{	
		/*Usuário insere o nome do prato que deseja alterar e o código busca no Cardapio.txt.
		* Caso encontre, uma variável armazena as alterações a serem feitas e depois substitui
		* o conteudo no arquivo, caso o prato não exista no txt, uma mensagem será exibida.
		*/
		System.out.print("Digite o nome do prato a ser alterado: ");
        String pratoBuscado = sc.nextLine();

        try {
            File cardapioFile = new File("Cardapio.txt");
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

	public Date getNascimento() {
		return getNascimento();
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	
	public void setFuncao() {
		this.funcao = "Gerente"; 
	}
	public void setNascimento() {
		System.out.print("Digite a data de nascimento do gerente (dd/MM/yyyy): ");
        String dataString = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.nascimento = dateFormat.parse(dataString);
        } catch (ParseException e) {
            System.out.println("Data inválida. A data deve estar no formato dd/MM/yyyy");
        }
	}
	
	public void setNomeFuncionario(String nome) {
		//o nome do gerente será inserido via Scanner;
		this.nomeFuncionario = sc.nextLine();
	}
}