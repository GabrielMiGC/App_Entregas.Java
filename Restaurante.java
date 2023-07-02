package AppEntregas;

public class Restaurante {
	public String nome;
	public boolean isOpen;
	public Endereco enderecoRestaurante;
	
	public Restaurante(String nome, String rua, int numero, String bairro, int CEP, String pontoDeReferencia) {
		setNome(nome);
		this.isOpen = true;
		enderecoRestaurante = new Endereco(rua, numero, bairro, CEP, pontoDeReferencia);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean getIsopen() {
		return isOpen;
	}
	public void setIsopen(boolean isopen) {
		this.isOpen = isopen;
	}
	
	public Endereco getEnderecoRestaurante() {
		return enderecoRestaurante;
	}
	public void setEnderecoRestaurante(Endereco enderecoRestaurante) {
		this.enderecoRestaurante = enderecoRestaurante;
	}

}
