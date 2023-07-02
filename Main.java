package AppEntregas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] Args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		List<Restaurante> restauranteList = new ArrayList<>();
		List<Pratos> pratosList = new ArrayList<>();

		System.out.println("QUAL A SUA FUNÇÃO: ");
		System.out.println("1 - CLIENTE ");
		System.out.println("2 - FUNCIONARIO DO RESTAURANTE ");
		System.out.println("3 - ENTREGADOR ");
		System.out.println("4 - CRIAR RESTAURANTE ");
		switch(Integer.parseInt(sc.nextLine())){
			case 1:
				System.out.println("________________________________________________________________");
				System.out.println("NOME COMPLETO:");
				String nome = (sc.nextLine());
				System.out.println("DATA DE NASCIMENTO:");
				String nascimentoCliente =(sc.nextLine());
				SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        		Date NascimentoCliente = formatoData.parse(nascimentoCliente);

				System.out.println("________________________________________________________________");
				System.out.println("DADOS DO PAGAMENTO");
				System.out.println("NOME DO TITULAR:");
				String nomeDoCartao = (sc.nextLine());
				System.out.println("NÚMERO DO CARTÃO:");
				int numerocartao = Integer.parseInt(sc.nextLine());
				System.out.println("CVV:");
				int CVV = Integer.parseInt(sc.nextLine());
				System.out.println("DATA DE VENCIMENTO (MM/AA):");
				String dataVencimento = (sc.nextLine());

				System.out.println("________________________________________________________________");
				System.out.println("DADOS DO SEU ENDEREÇO");
				System.out.println("RUA:");
				String rua = (sc.nextLine());
				System.out.println("NUMERO:");
				int numero = Integer.parseInt(sc.nextLine());
				System.out.println("BAIRRO:");
				String bairro = (sc.nextLine());
				System.out.println("CEP:");
				int CEP = Integer.parseInt(sc.nextLine());
				System.out.println("PONTO DE REFERENCIA:");
				String referencia = (sc.nextLine());
				System.out.println("________________________________________________________________");

				Cliente cliente = new Cliente(nome, NascimentoCliente, rua, numero, bairro, CEP, referencia, nomeDoCartao, numerocartao, CVV, dataVencimento);
				do{
					System.out.println("O QUE DESEJA FAZER: ");
					System.out.println("1 - OLHAR CARDÁPIO  ");
					System.out.println("2 - REALIZAR PEDIDO ");
					System.out.println("3 - ACOMPANHAR PEDIDO ");
					System.out.println("4 - CANCELAR PEDIDO ");

					switch(Integer.parseInt(sc.nextLine())){


						case 1:
							System.out.printf("PESQUISE NO CARDÁPIO\n");
							System.out.printf("QUAL RESTAURANTE DESEJA PROCURAR?\n");
							for (int i = 0; i < restauranteList.size(); i++) {
								Restaurante restaurante = restauranteList.get(i);
								System.out.println((i) + " - " + restaurante.getNome());// Listar restaurantes existentes
							}
							int escolherestaurante = Integer.parseInt(sc.nextLine());
							if (escolherestaurante > 0 && escolherestaurante <= restauranteList.size()) {
								Restaurante restauranteSelecionado = restauranteList.get(escolherestaurante - 1);
								Cardapio.imprimirCardapio(restauranteSelecionado);// exibir cardapio
							} else {
								System.out.println("Número inválido. Tente novamente.");
							}
							break;
							// adicionar função para sair 

						case 2:
							System.out.printf("PESQUISE NO CARDÁPIO\n");
							System.out.printf("QUAL RESTAURANTE DESEJA PROCURAR?\n");

							for (int i = 0; i < restauranteList.size(); i++) {
								Restaurante restaurante = restauranteList.get(i);
								System.out.println((i) + " - " + restaurante.getNome());// Listar restaurantes existentes
							}
							int escolherest = Integer.parseInt(sc.nextLine());

							if (escolherest > 0 && escolherest <= restauranteList.size()) {
								Restaurante restauranteSelec = restauranteList.get(escolherest - 1);
								Cardapio.imprimirCardapio(restauranteSelec);// exibir cardapio
								//escolher o prato da lista

								for (int i = 0; i < pratosList.size(); i++) {
									Pratos pratos = pratosList.get(i);
									System.out.println((i) + " - " + pratos.getNomePrato());// Listar restaurantes existentes
									System.out.println("      Ingredientes:" + pratos.getIngredientes()+ "\n");
								}

								System.out.printf("QUAL PRATO VOCÊ DESEJA?\n");
								int escolheprato = Integer.parseInt(sc.nextLine());

								if (escolheprato > 0 && escolheprato <= pratosList.size()) {
									Pratos pratosSelecionaso = pratosList.get(escolheprato - 1);
									Pedido pedido = new Pedido();
									pedido.fazerPedido(restauranteSelec, pratosSelecionaso, cliente.getEndereco());
									pedido.setStatusDoPedido(1);

								} else {
									System.out.println("Número inválido. Tente novamente.");
								}

							} else {
								System.out.println("Número inválido. Tente novamente.");
							}

							break;


						case 3:
							//puxar a função
							cliente.AcompanharPedido(cliente.pedido);
							break;

						}
				}while(Integer.parseInt(sc.nextLine()) != 0);


			case 2:
				System.out.println("NOME COMPLETO:");
				String nomefuncio = (sc.nextLine());
				System.out.println("FUNÇÃO:");
				System.out.println("    1 - GERENTE  ");
				System.out.println("    2 - COLABORADOR ");
				int funcao = Integer.parseInt(sc.nextLine());
				System.out.println("DATA DE NASCIMENTO:");
				String nascimento =(sc.nextLine());
				SimpleDateFormat formatoDataFunc = new SimpleDateFormat("dd/MM/yyyy");
        		Date Nascimento = formatoDataFunc.parse(nascimento);

				if (funcao == 1){
					System.out.printf("QUAL RESTAURANTE VOCÊ TRABALHA?\n");
					for (int i = 0; i < restauranteList.size(); i++) {
						Restaurante restaurante = restauranteList.get(i);
						System.out.println((i) + " - " + restaurante.getNome());// Listar restaurantes existentes
					}
					int trabrestaurante = Integer.parseInt(sc.nextLine());

					Restaurante restauranteTrab = restauranteList.get(trabrestaurante - 1);
					Gerente gerente = new Gerente(nomefuncio, "Gerente", Nascimento, restauranteTrab);

					System.out.println("O QUE DESEJA FAZER");
					System.out.println("    1 - ABRIR/FECHAR RESTAURANTE  ");
					System.out.println("    2 - ADICIONAR PRATO AO CARDÁPIO");
					switch(Integer.parseInt(sc.nextLine())){


						case 1:
							break;


						case 2:
							System.out.println("ADICIONAR AO CARDÁPIO");
							System.out.println("NOME DO PRATO:");
							String nomePrato = (sc.nextLine());
							System.out.println("INGREDIENTES:");
							String ingredientes = (sc.nextLine());

							Pratos pratos = new Pratos(nomePrato, ingredientes);
							pratosList.add(pratos);
							gerente.adicionarPrato(gerente.getRestaurante(), pratos);
							break;
					}

				}else if (funcao == 2){
					new Funcionario(nomefuncio, "Colaborador", Nascimento);
				}
		

			case 3:
				System.out.println("NOME COMPLETO:");
				String nomeentreg = (sc.nextLine());
				System.out.println("DATA DE NASCIMENTO:");
				String nascimentoentre =(sc.nextLine());
				SimpleDateFormat formatoDataEntregador = new SimpleDateFormat("dd/MM/yyyy");
        		Date dataNascimento = formatoDataEntregador.parse(nascimentoentre);

				new Entregador(nomeentreg, dataNascimento);
			
				
			case 4:
				System.out.println("________________________________________________________________");
				System.out.println("NOME DO ESTABELECIMENTO:");
				String nomerestaurante = (sc.nextLine());
				
				System.out.println("________________________________________________________________");
				System.out.println("DADOS DO SEU ENDEREÇO");
				System.out.println("RUA:");
				String ruarestaurante = (sc.nextLine());
				System.out.println("NUMERO:");
				int numerorestaurante = Integer.parseInt(sc.nextLine());
				System.out.println("BAIRRO:");
				String bairrorestaurante = (sc.nextLine());
				System.out.println("CEP:");
				int CEPrestaurante = Integer.parseInt(sc.nextLine());
				System.out.println("PONTO DE REFERENCIA:");
				String referenciarestaurante = (sc.nextLine());
				System.out.println("________________________________________________________________");

				Restaurante restaurante = new Restaurante(nomerestaurante, ruarestaurante, numerorestaurante, bairrorestaurante, CEPrestaurante, referenciarestaurante);
				restauranteList.add(restaurante);
				Cardapio cardapio = new Cardapio();
				cardapio.criarCardapio(restaurante);

			
			
		}
	}
}
