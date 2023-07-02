package AppEntregas;

public class Pratos {
	//O propósito desta classse não é armazenar os dados de cada prato, esta função é delegada ao arquivo de texto Cardápio
	public String nomePrato;
	public String ingredientes;

	//Construtor sem argumentos para chamar o outro construtor 
	public Pratos() {
		this.nomePrato = null;
		this.ingredientes = null;	
	}
	
	// Construtor com argumentos e valores padrão vindos do outro construtor
	public Pratos(String nP, String ingr) {
		setNomePrato(nP);
		setIngredientes(ingr);
	}
	
	//Obtém nome do prato
	public String getNomePrato() {
		return nomePrato;
	}
	//Configura nome do prato
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	//Obtém Ingredientes
	public String getIngredientes() {
		return ingredientes;
	}
	//Configura Ingredientes do prato
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
