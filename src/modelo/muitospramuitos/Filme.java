package modelo.muitospramuitos;

import javax.persistence.*;
import java.util.*;
import modelo.basico.Entidade;

@Entity
@Table(name = "filmes")
public class Filme implements Entidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double nota;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "atores_filmes",
        joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id", referencedColumnName = "id")
    )
    private List<Ator> atores = new ArrayList<>();

    public Filme() {}
    public Filme(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
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

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    //Metodos de negocio
    public void adicionarAtor(Ator ator) {
        if(ator != null && !this.getAtores().contains(ator)) {
            this.atores.add(ator);

            if(!ator.getFilmes().contains(this)) {
                ator.getFilmes().add(this);
            }
        }
    }
}
