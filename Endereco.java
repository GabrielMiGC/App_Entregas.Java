package AppEntregas;

public class Endereco {
	private String rua;
	private int numero;
	private String bairro;
	private int cep;
	private String pontoDeReferencia;
	
	// Contrutor "vazio" para chamar o construtor base
	public Endereco() {
		this("Rua ex", 777, "bairro ex", 00000, "Ao lado do exemplo");
	}
	
	// Construtor implementando valores base
	public Endereco(String rua, int numero, String bairro, int cep, String pontRef) {
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCep(cep);
		setPontoDeReferencia(pontRef);
	}


	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}
	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}
	
}
