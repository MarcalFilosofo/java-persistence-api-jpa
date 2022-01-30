package modelo.muitospramuitos;

import javax.persistence.*;
import modelo.basico.Entidade;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Tio implements Entidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "sobrinhos")
    private List<Sobrinho> sobrinhos = new ArrayList<>();

    public Tio(){}
    public Tio(String nome) {
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

    public void setSobrinhos(List<Sobrinho> sobrinhos) {
        this.sobrinhos = sobrinhos;
    }

    public List<Sobrinho> getSobrinhos() {
        return sobrinhos;
    }
}
