package AppEntregas;

import java.util.Date;
import java.util.Scanner;

public class Gerente extends Funcionario{
	private Restaurante restaurante;

	Scanner sc = new Scanner(System.in);

	public Gerente(){
		super(null, null, null);
        this.restaurante = null;
	}

	public Gerente(String nomeFuncionario,String funcao, Date nascimento, Restaurante restaurante){
		super(nomeFuncionario, funcao, nascimento);
		this.restaurante = restaurante;
	}

	public Restaurante getRestaurante(){
		return restaurante;
	}

	public void abrirFecharRestaurante() {
		restaurante.setIsopen(true);
	}

	public void adicionarPrato(Restaurante restaurante, Pratos pratos){
		Cardapio cardapio = new Cardapio();
		cardapio.addPrato(restaurante, pratos);
	}
}