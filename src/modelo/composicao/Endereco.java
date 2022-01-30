package modelo.composicao;

import javax.persistence.*;

@Embeddable
public class Endereco {
    private String logradouro;
    private String complemento;

    public Endereco(String logradouro, String complemento) {
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public Endereco() {
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(){
        this.complemento = complemento;
    }
} 