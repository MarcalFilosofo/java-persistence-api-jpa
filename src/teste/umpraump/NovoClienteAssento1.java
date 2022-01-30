package teste.umpraump;

import infra.DAO;
import modelo.umpraum.*;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("A1");
        Cliente cliente = new Cliente("João", assento);

        DAO<Object> dao = new DAO<>();
        dao.abrirT()
            .incluir(assento)
            .incluir(cliente)
            .fecharT()
            .fechar();

    }
}
