package teste.consulta;

import java.util.*;
import infra.DAO;
import modelo.muitospramuitos.*;

public class ObterFilmes {
    public static void main(String[] args){
        DAO<Filme> dao = new DAO<>(Filme.class);
        List<Filme> filmes = dao.consulta("filmesNotaMaiorQue", "nota", 5.0);

        for(Filme filme : filmes){
            System.out.println(filme.getNome());

            for(Ator ator : filme.getAtores()){
                System.out.println("\t" + ator.getNome());
            }
        }
    }
}
