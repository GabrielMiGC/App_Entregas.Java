package AppEntregas;

public class Pratos {
	//O propósito desta classse não é armazenar os dados de cada prato, esta função é delegada ao arquivo de texto Cardápio
	public String nomePrato;
	public String ingredientes;
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	
	
}
