package AppEntregas;


public class Cliente {
	public String nome;
	private Endereco enderecoCliente;
	private int idade;
	Pratos pratos;
	Pagamento pagamento;
	Pedido pedido;

	public Cliente(String nome, int idade, String rua, int numero, String bairro, int CEP, String pontoDeReferencia, String NomeDoCartao, int Numero, int CVV, String DataVencimento){
		this.nome = nome;
		this.enderecoCliente = new Endereco(rua, numero, bairro, CEP, pontoDeReferencia);
		this.idade = idade;
		this.pagamento = new Pagamento(NomeDoCartao, Numero, CVV, DataVencimento);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
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
		
	}
}
