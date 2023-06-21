package AppEntregas;

import java.util.ArrayList;

public class Pedido {
	Restaurante restaurante;
	Pratos prato;
	Endereco endereco;
	
	public String StatusDoPedido() {
		if() { //pedido concluido
			return "Pedido de " + prato.nomePrato+ "concluido";
		}if() { //pedido na lista do entregador
			return "Pedido de " + prato.nomePrato + "a caminho";
		}if() { //pedido em produção
			return "Pedido esta sendo feito";
		}
	}
}
