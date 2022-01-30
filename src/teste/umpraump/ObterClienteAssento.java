package teste.umpraump;

import infra.DAO;
import modelo.umpraum.*;

public class ObterClienteAssento {
    public static void main(String[] args) {
        DAO<Cliente> daoCliente = new DAO<Cliente>(Cliente.class);

        Cliente cliente = daoCliente.obterPorId(1L);

        cliente.getAssento().getNome();
        cliente.getAssento().getCliente().getNome();

        daoCliente.fechar();

        DAO<Assento> daoAssento = new DAO<>(Assento.class);
        Assento assento = daoAssento.obterPorId(1L);

        assento.getCliente().getNome();
        assento.getCliente().getAssento().getNome();

        daoAssento.fechar();
    }
}
