package TrabalhoAppEntregas;

public class Gerente extends Funcionario{
	private String nome;
	private int idade;
	
	public void setFuncao() {
		this.funcao = "Gerente"; 
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
	
}
