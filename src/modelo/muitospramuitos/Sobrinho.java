package modelo.muitospramuitos;

import javax.persistence.*;
import modelo.basico.Entidade;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Sobrinho implements Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    private List<Tio> tios = new ArrayList<>();

    public Sobrinho() {}
    public Sobrinho(String nome) {
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

    public void serTios(List<Tio>){
        this.tios = tios;
    }

    public List<Tio> getTios() {
        return tios;
    }
}
