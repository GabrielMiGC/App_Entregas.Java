package TrabalhoAppEntregas;

public class Pagamento {
	private String NomeDoCartao;
	private int Numero;
	private int CVV;
	private String DataVencimento;
	
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
	
}
