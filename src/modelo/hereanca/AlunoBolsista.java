package modelo.hereanca;

import javax.persistence.*;

@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno{
    private double valorBolsa;

    //Faça um construtor para a classe que recebe a matricula e o nome e outro contrutor que não recebe nada
    public AlunoBolsista() {
    }

    public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
        super(matricula, nome);
        this.valorBolsa = valorBolsa;
    }

    //Faça os getters e setters de todos os atributos
    public double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }


}
