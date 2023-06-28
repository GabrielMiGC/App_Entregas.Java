package AppEntregas;
import java.util.Scanner;

public class Pagamento {
    private String NomeDoCartao;
    private int Numero;
    private int CVV;
    private String DataVencimento;

    private Scanner scanner = new Scanner(System.in);

    public String getNomeDoCartao() {
        return NomeDoCartao;
    }

    public void setNomeDoCartao(String nomeDoCartao) {
        NomeDoCartao = nomeDoCartao;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int cVV) {
        CVV = cVV;
    }

    public String getDataVencimento() {
        return DataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        DataVencimento = dataVencimento;
    }

    public void realizarPagamento() {
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Cartão de crédito");
        System.out.println("2. Cartão de débito");
        System.out.println("3. Pix");

        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Pagamento com cartão de crédito selecionado.");
                processarPagamentoCartaoCredito();
                break;

            case 2:
                System.out.println("Pagamento com cartão de débito selecionado.");
                processarPagamentoCartaoDebito();
                break;

            case 3:
                System.out.println("Pagamento com Pix seleciondo.");
                processarPagamentoPix();
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    private void processarPagamentoCartaoCredito() {
        System.out.println("Informe o valor do pagamento:");
        double valor = scanner.nextDouble();

        System.out.println("Informe a quantidade de parcelas:");
        int parcelas = scanner.nextInt();

        System.out.println("Processando pagamento com cartão de crédito...");
        System.out.println("Valor: " + valor);
        System.out.println("Parcelas: " + parcelas);
    }

    private void processarPagamentoCartaoDebito() {
        System.out.println("Informe o valor do pagamento:");
        double valor = scanner.nextDouble();

        System.out.println("Processando pagamento com cartão de débito...");
        System.out.println("Valor: " + valor);
    }

    private void processarPagamentoPix() {
        System.out.println("Informe o valor do pagamento:");
        double valor = scanner.nextDouble();

        System.out.println("Processando pagamento com Pix..");
        System.out.println("Valor: " + valor);
    }

    public void alterarFormaPagamento() {
        System.out.println("Forma de pagamento atual: " + pedido.getFormaPagamento());
        System.out.println("Selecione a nova forma de pagamento:");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. Cartão de Débito");
        System.out.println("3. Pix");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                pedido.setFormaPagamento("Cartão de Crédito");
                processarPagamentoCartaoCredito();
                break;
            case 2:
                pedido.setFormaPagamento("Cartão de Débito");
                processarPagamentoCartaoDebito();
                break;
            case 3:
                pedido.setFormaPagamento("Pix");
                processarPagamentoPix();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
    }
}
