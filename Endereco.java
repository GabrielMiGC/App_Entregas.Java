package AppEntregas;

public class Endereco {
	private String rua;
	private int numero;
	private String bairro;
	private String cep;
	private String pontoDeReferencia;
	
	// Contrutor "vazio" para chamar o construtor base
	public Endereco() {
        this.rua = "";
        this.numero = 0;
        this.bairro = "";
        this.cep = "";
        this.pontoDeReferencia = "";
    }
	
	// Construtor implementando valores base
	public Endereco(String rua, int numero, String bairro, String cep, String pontRef) {
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
	public String getCep() {
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
