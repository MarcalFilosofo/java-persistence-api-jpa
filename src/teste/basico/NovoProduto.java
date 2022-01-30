package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        Produto p = new Produto('Caneta', 1.99);
        
        DAO<Produto> dao = new DAO<Produto>(Produto.class);

        dao.incluirAtomico(p).fechar();;
    }
}
