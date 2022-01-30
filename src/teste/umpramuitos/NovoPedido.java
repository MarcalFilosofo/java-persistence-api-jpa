package teste.umpramuitos;

import modelo.umpramuitos.*;
import modelo.basico.*;
import infra.DAO;

public class NovoPedido {
    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        Produto produto = new Produto("Produto 1", 10.0);
        Pedido pedido = new Pedido();
        ItemPedido item = new ItemPedido(1, pedido, produto);

        dao.abrirT()
            .incluir(produto)
            .incluir(pedido)
            .incluir(item)
            .fecharT()
            .fechar();
    }
}
