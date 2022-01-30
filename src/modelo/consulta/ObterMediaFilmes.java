package modelo.consulta;

import infra.DAO;
import modelo.basico.*;
import modelo.muitospramuitos.*;
import java.util.List;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        
        NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes");

        System.out.println(nota.getMedia());

        dao.fechar();
    }
}
