package TrabalhoAppEntregas;

public class Entregador extends Funcionario{
	public String localizacao;
	
	public void setFuncao(){
		this.funcao = "Entregador";
	}

	public int numeroPedidos;
	public Pedido[] pedidosCarregados;
	
}
