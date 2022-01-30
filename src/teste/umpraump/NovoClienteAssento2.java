package teste.umpraump;

import infra.DAO;
import modelo.umpraum.*;

public class NovoClienteAssento2 {
    public static void main(String[] args) {
        Assento assento = new Assento("A1");
        Cliente cliente = new Cliente("João", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);

        dao.incluirAtomico(cliente);

    }
}
