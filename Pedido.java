package AppEntregas;

public class Pedido {
    Restaurante restaurante;
    Prato prato;
    Endereco endereco;

    public String StatusDoPedido() {
        if (restaurante != null && prato != null && endereco != null) {
            // concluído!!
            return "Pedido de " + prato.nomePrato + " concluído";
        } else if (restaurante != null && prato != null) {
            // na lista para entrega
            return "Pedido de " + prato.nomePrato + " a caminho";
        } else if (restaurante != null) {
            // em produção
            return "Pedido está sendo feito";
        } else {
            // quando algum atributo está nulo
            return "Pedido inválido";
        }
    }
}
