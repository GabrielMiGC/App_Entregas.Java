package AppEntregas;

import java.util.Date;

public class Cliente {
	public String nome;
	private Endereco enderecoCliente;
	private Date nascimento;
	Pratos pratos;
	Pagamento pagamento;
	Pedido pedido;

	public Cliente(String nome, Date nascimento, Endereco endereco){
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
	}
	
	public Cliente(String nome, Date nascimento, String rua, int numero, String bairro, String CEP, String pontoDeReferencia, String NomeDoCartao, int Numero, int CVV, String DataVencimento){
		this.nome = nome;
		this.enderecoCliente = new Endereco(rua, numero, bairro, CEP, pontoDeReferencia);
		this.nascimento = nascimento;
		this.pagamento = new Pagamento(NomeDoCartao, Numero, CVV, DataVencimento);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Endereco getEndereco() {
        return enderecoCliente;
    }
	public void RealizarPedido(Restaurante restaurante, Pratos pratos){
		pedido.fazerPedido(restaurante, pratos, enderecoCliente);
	}
	public String AcompanharPedido(Pedido pedido) {
		return pedido.getStatusDoPedido(pedido);
		
	}
	public void Pagar(Pagamento pagamento) {
		Pagamento pagar = new Pagamento(nome, 0, 0, nome);
		pagar.realizarPagamento();
	}
}
