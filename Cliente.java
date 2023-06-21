package AppEntregas;

import java.util.Scanner;

public class Cliente {
	public String nome;
	Endereco enderecoCliente = new Endereco();
	private int idade;
	Pratos pratos;
	
	Scanner sc = new Scanner(System.in);
	public String PesquisarPrato() {
		System.out.printf("Pesquise no cardápio\n");
		System.out.printf("Qual prato deseja pesquisar?\n");
		//codigo da pesquisa.
		//A pesquisa é feita no arquivo cardápio
		String pesquisa = sc.nextLine();
		
		return pratos.nomePrato;
		
		
	}
	public String RealizarPedido(){
		 //Usuário escolhe um prato, a classe Pedido recebe os dados
		// Usuário seleciona opção 
		return "retorno";
	}
	public  void CancelarPedido() {
		// código emitindo um aviso ao restaurante informando que o pedido #**** foi cancelado
		System.out.println("Pedido cancelado");
	}
	public String AcompanharPedido(Entregador entregador) {
		return entregador.localizacao;
		
	}
	public Pratos AlterarPedido(String alteracao) {
		//codigo, os dados da classe pedido deve ser alterados
		return pratos;
		
	}
	public void Pagar(Pagamento pagamento) {
		
	}
	public void AlterarFormaPagamento(Pagamento pagamento) {
		
	}
}
