package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

import java.util.List;
/**
 * ObterProdutos
 */
public class ObterProdutos {

    public static void main(String[] args) {
        DAO<Produto> dao = new DAO<Produto>(Produto.class);

        List<Produto> produtos = dao.obterTodos();

        for (Produto p : produtos) {
            System.out.println(p.getNome() + " - " + p.getPreco());
        }

        double precoTotal = produtos
            .stream()
            .mapToDouble(p -> p.getPreco())
            .reduce(0.0, (t, p) -> t + p);
    }
}
