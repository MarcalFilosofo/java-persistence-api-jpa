package modelo.umpramuitos;

import javax.persistence.*;
import modelo.basico.Entidade;
import modelo.basico.Produto;

@Entity
public class ItemPedido implements Entidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;
    
    @Column(nullable = false)
    private Double preco;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    public ItemPedido() {
    }

    public ItemPedido(int quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    //Getters and Setters of the class
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void serPreco(){
        this.preco = preco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        if(produto != null && this.preco == null) {
            this.setPreco(produto.getPreco());
        }
        this.produto = produto;
    }
}
