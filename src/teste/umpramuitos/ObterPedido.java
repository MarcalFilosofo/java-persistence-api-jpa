package teste.umpramuitos;

import infra.DAO;
import modelo.umpramuitos.*;

public class ObterPedido {
    public static void main(String[] args) {
        DAO<Pedito> dao = new DAO<>(Pedito.class);

        Pedido pedido = dao.obterPorId(1L);

        for(ItemPedido item : pedido.getItens()) {
            System.out.println(item.getProduto().getNome() + " - " + item.getProduto().getPreco());
        }
        
        dao.fechar();
    }

}
