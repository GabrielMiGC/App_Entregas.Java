package AppEntregas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Pedido {
    private String restaurante;
    private Prato prato;
    private Endereco endereco;
    private boolean cancelado;

    public Pedido() {
        this.restaurante = null;
        this.prato = null;
        this.endereco = null;
        this.cancelado = false;
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***** Menu *****");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Cancelar Pedido");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    cancelarPedido();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void fazerPedido(String nomeRestaurante) {
        restaurante = nomeRestaurante;

        Scanner scanner = new Scanner(System.in);

        System.out.println("***** Faça seu pedido e adicione seu endereço *****");
        System.out.print("Prato: ");
        String nomePrato = scanner.nextLine();
        prato = new Prato(nomePrato);

        System.out.print("Endereço: ");
        String enderecoCompleto = scanner.nextLine();
        endereco = new Endereco(enderecoCompleto);
    }

    //public void cancelarPedidos(){}
    
    public void arqPedidos() {
        String nomeArquivo = "Pedidos feitos.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.write("Restaurante: " + restaurante);
            writer.newLine();
            writer.write("Prato: " + prato.getNomePrato());
            writer.newLine();
            writer.write("Endereço: " + endereco.getEnderecoCompleto());
            writer.newLine();
            writer.write("Status: " + getStatusDoPedido());
            writer.newLine();
            System.out.println("Pedido salvo com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao escrever o pedido no arquivo: " + e.getMessage());
        }
    }
    //public void removerPedidoCancelado(){}
}
    //status do pedido
