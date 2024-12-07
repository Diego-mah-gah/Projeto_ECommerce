package model;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstoque")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    private Produto produto;

    private Integer quantidade;

    public Estoque() {}

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
