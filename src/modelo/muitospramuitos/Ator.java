package modelo.muitospramuitos;

import javax.persistence.*;
import java.util.*;
import modelo.basico.Entidade;

@Entity
@Table(name = "atores")
public class Ator implements Entidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "atores", cascade = CascadeType.ALL)
    private List<Filme> filmes = new ArrayList<>();

    public Ator() {}
    public Ator(String nome) {
        this.nome = nome;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }
}
