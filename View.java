package AppEntregas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class View {

    public void Index() {
        System.out.println("========== BEM-VINDO ==========");
        System.out.println("1. Entrar como cliente");
        System.out.println("2. Entrar como gerente");
        System.out.println("3. Entrar como entregador");
        System.out.println("4. Cadastrar como cliente");
        System.out.println("5. Cadastrar como funcionário");
        System.out.println("====================================");
        System.out.print("Digite a opção desejada: ");
    }

    //================= ÁREA DO CLIENTE =========================
    public void MenuPrincipalCliente() {
        System.out.println("========== MENU PRINCIPAL ==========");
        System.out.println("1. Realizar pedido");
        System.out.println("2. Pesquisar prato");
        System.out.println("3. Acompanhar pedidos");
        System.out.println("4. Sair");
        System.out.println("====================================");
        System.out.print("Digite a opção desejada: ");
    }

    public Cliente CadastrarCliente(Scanner scanner) {
        System.out.println("========== Cadastrar ==========");
        
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataNascimento, formatter);
        
        Endereco endereco = new Endereco();
        endereco = CadastrarEndereco(scanner);

        System.out.print("Cadastro realizado com sucesso!: ");
        
        return new Cliente(nomeCliente, data, endereco);
    }

    public Pedido RealizarPedido(Scanner scanner){
        System.out.println("========== Pedido ==========");

        System.out.println("Qual restaurante?");
        String restaurante = scanner.nextLine();
        
        System.out.println("Informe o prato desejo");
        Prato prato = new Prato();
        String prato.setNome = scanner.nextLine();
        
        Endereco endereco = new Endereco();
        endereco = CadastrarEndereco(scanner);

        return new Pedido (restaurante, prato, endereco);
    }

    public Pagamento RealizarPagamento(){
        System.out.println("========== Pagamento ==========");
        System.out.println("Digite o nome presente no cartão");
        String nome = scanner.nextLine();
        
        System.out.println("Digite o número do cartão");
        int num = scanner.nextInt();

        System.out.println("Digite o código de segurança");
        int cvv = scanner.nextInt();

        System.out.println("Digite a data de validade (dd/mm/aaaa)");
        String dataValidade = scanner.nextLine();

        Pagamento pagamento = new Pagamento(nome, num, cvv, dataValidade);
        return pagamento;
    }
    
    //================= ÁREA DO GERENTE =========================
    public void MenuPrincipalGerente() {
        System.out.println("========== MENU PRINCIPAL ==========");
        System.out.println("1. Abrir/Fechar restaurante");
        System.out.println("2. Criar/Alterar cardápio");
        System.out.println("3. Alterar prato");
        System.out.println("4. Exibir pedidos");
        System.out.println("5. Sair");
        System.out.println("====================================");
        System.out.print("Digite a opção desejada: ");
    }

    public void AlterarPrato(){
        System.out.println("========== ALTERAR PRATO ==========");
    }

    public void AbrirFecharRestaurante(Restaurante restaurante){
        System.out.println("========== ABRIR/FECHAR RESTAURANTE ==========");

        if (restaurante.isOpen()) {
        System.out.println("O restaurante está aberto.");
         } else {
        System.out.println("O restaurante está fechado.");
        }
        System.out.println("O Status de abertura do restaurante foi alterado");
    }

    //============================================================
    
    public Endereco CadastrarEndereco(Scanner scanner){
        System.out.print("Endereço de entrega: ");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        int num = scanner.nextInt();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Ponto de referência: ");
        String pontoDeReferencia = scanner.nextLine();
        Endereco endereco = new Endereco(rua, num, bairro, cep, pontoDeReferencia);

        return endereco;
    }

     public void ExibirPedidos(List<Pedido> pedidos) {
        System.out.println("========== PEDIDOS ==========");
        
        for (Pedido pedido : pedidos) {
            System.out.println("Restaurante: " + pedido.getRestaurante ());
            System.out.println("Endereço: " + pedido.getEndereco());
            System.out.println("Itens: " + pedido.getPrato());
            System.out.println("Status do pedido: " + pedido.getStatusDoPedido());
            System.out.println("--------------------------------");
        }
        
        System.out.println("=============================");
    }
}