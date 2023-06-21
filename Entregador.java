package AppEntregas;

public class Entregador extends Funcionario{
	public String localizacao;
	// falta implementar os metodos - conatrutor classe pai
	public void setFuncao(){
		this.funcao = "Entregador";
	}

	public int numeroPedidos;
	public Pedido[] pedidosCarregados;
	
}
