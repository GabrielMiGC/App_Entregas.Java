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
    public void cancelarPedido(String nomePrato, String nomeCliente) {
        if (this.nomePrato.equalsIgnoreCase(nomePrato) && this.nomeCliente.equalsIgnoreCase(nomeCliente)) {
            this.cancelado = true;
            System.out.println("Pedido cancelado com sucesso.");
        } else {
            System.out.println("Não foi possível cancelar o pedido. Verifique o nome do prato e do cliente.");
        }
    }
    
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
    public void remPedidoCancelado(String nomeArquivo, String nomePrato, String senhaCliente) {
        File arquivoPedidos = new File(nomeArquivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoPedidos))) {
            List<String> linhas = new ArrayList<>();
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("Nome do Prato:") && linha.substring(15).trim().equalsIgnoreCase(nomePrato)) {
                    String status = reader.readLine();
                    String endereco = reader.readLine();
                    String cliente = reader.readLine();
                    if (cliente.startsWith("Cliente:") && cliente.substring(9).trim().equalsIgnoreCase(senhaCliente)) {
                        continue;
                    }
                }
                linhas.add(linha);
            }
            FileWriter writer = new FileWriter(arquivoPedidos);
            for (String line : linhas) {
                writer.write(line + "\n");
            }
            writer.close();

            System.out.println("O pedido cancelado foi removido do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao remover o pedido cancelado do arquivo: " + e.getMessage());
        }
    }
	
    public int StatusDoPedido() {
        if (restaurante != null && prato != null && endereco != null) {
            // concluído!!
        	System.out.println("Pedido de " + prato.nomePrato + " concluído");
            return 1;
        } else if (restaurante != null && prato != null) {
            // na lista para entrega
        	System.out.println("Pedido de " + prato.nomePrato + " a caminho");
            return 2;
        } else if (restaurante != null) {
            // em produção
        	System.out.println("Pedido está sendo feito");
            return 3;
        } else {
            // quando algum atributo está nulo
        	System.out.println("Pedido inválido");
            return 4;
        }
    }
    
}
