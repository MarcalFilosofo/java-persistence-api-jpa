package teste.muitospramuitos;

import infra.DAO;
import modelo.muitospramuitos.*;

public class NovoFilmeAtor {
    //Metodo main
    public static void main(String[] args) {
        Filme filmeA = new Filme("Festa dos morangos", 5.0);
        Filme filmeB = new Filme("Poeira em alto mar", 10.0);

        Ator ator1 = new Ator("moranguinho");
        Ator ator2 = new Ator("morangão");

        filmeA.adicionarAtor(ator1);
        filmeA.adicionarAtor(ator2);

        filmeB.adicionarAtor(ator1);

        DAO<Filme> daoFilme = new DAO<>(Filme.class);
        daoFilme.incluirAtomico(filmeA);
        
    }
}
