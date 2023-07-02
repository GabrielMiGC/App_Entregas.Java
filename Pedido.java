package AppEntregas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pedido {
    private String restaurante;
    private Pratos prato;
    private Endereco endereco;
    private int statusDoPedido;

    public Pedido() {
        this.restaurante = null;
        this.prato = null;
        this.endereco = null;
        this.statusDoPedido = 0;
    }

public String getRestaurante() {
        return restaurante;
}

public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
}

public Pratos getPrato() {
        return prato;
    }

public void setPrato(Pratos prato) {
        this.prato = prato;
    }

public Endereco getEndereco() {
        return endereco;
    }

public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
	
    public Pedido(String restaurante, Pratos prato, Endereco endereco){
        this.restaurante = restaurante;
        this.prato = prato;
        this.endereco = endereco;
        this.statusDoPedido = 0;
    }

    public void setStatusDoPedido(int Status){
		this.statusDoPedido = Status;
	}
	
	public String getStatusDoPedido(Pedido pedido) {
		if(pedido.statusDoPedido == 3) { //pedido entregue
			return "Pedido de " + prato.nomePrato+ "entregue";
		}else if(pedido.statusDoPedido == 2) { //pedido na lista do entregador
			return "Pedido de " + prato.nomePrato + "a caminho";
		}else if(pedido.statusDoPedido == 1) { //pedido em produção
			return "Pedido esta sendo feito";
		}else{
			return "Status invalido";
		}
	}

    public void fazerPedido(Restaurante restaurante, Pratos prato, Endereco endereco) {
        String nomeRestaurante = restaurante.nome;

        new Pedido(nomeRestaurante, prato, endereco);
    }
    
    
    public void arqPedidos(Pedido pedido) {
        String nomeArquivo = "Pedidos feitos.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Restaurante: " + pedido.restaurante);
            writer.newLine();
            writer.write("Prato: " + pedido.prato);
            writer.newLine();
            writer.write("Endereço: " + pedido.endereco);
            writer.newLine();
            writer.write("Status: " + pedido.statusDoPedido);
            writer.newLine();
            System.out.println("Pedido salvo com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever o pedido no arquivo: " + e.getMessage());
        }
    }
    //public void removerPedidoCancelado(){}
}
