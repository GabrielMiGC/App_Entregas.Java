package AppEntregas;

import java.util.Date;

public class Entregador extends Funcionario{
	public int numeroPedidos;
	public Pedido[] pedidosCarregados;
	public String localizacao;
	
	public Entregador(String nomeFuncionario, Date nascimento){
		super(nomeFuncionario, "Entregador", nascimento);
		this.numeroPedidos = 0;
		this.pedidosCarregados = new Pedido[5];
	}


	public void setFuncao(){
		this.funcao = "Entregador";
	}
	public void setNumeroPedidos(int numeroPedidos){
		this.numeroPedidos = numeroPedidos;
	}
	public void setPedidosCarregados (Pedido[] pedidosCarregados){
		this.pedidosCarregados = pedidosCarregados;
	}
	public int getNumeroPedidos(){
		return numeroPedidos;
	}
	public Pedido[] getPedidosCarregados(){
		return pedidosCarregados;
	}

	public void adicionarPedidos(Pedido pedido){
		if(numeroPedidos < 5){
			try{
				pedidosCarregados[numeroPedidos + 1] = pedido;
				numeroPedidos ++;
				pedido.setStatusDoPedido(2);// atualiza o status do pedido para mostrar que o pedido esta a caminho
			}catch (Exception e){
				System.out.println("Um erro ocorreu.");
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Entregador indisponivel");
		}
	}
	public void entregarPedido(){
		Pedido[] vetorNovo = new Pedido[5]; // cria um novo vetor 
		for (int i = 1; i < 5 ; i++){
			vetorNovo[i-1] = pedidosCarregados[i]; // carrega todas as informações dos pedidos para o novo vetor excluindo o primeiro
		}
		pedidosCarregados = vetorNovo;
		numeroPedidos --;
	}
	
}