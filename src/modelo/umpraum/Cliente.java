package modelo.umpraum;

import javax.persistence.*;
import modelo.basico.Entidade;

@Entity
@Table(name = "clientes")
public class Cliente implements Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assento_id", unique = true)
    private Assento assento;

    public Cliente(){

    }
    public Cliente(String nome, Assento assento) {
        this.nome = nome;
        this.assento = assento;
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

    public Assento getAssento() {
        return this.assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }


}
