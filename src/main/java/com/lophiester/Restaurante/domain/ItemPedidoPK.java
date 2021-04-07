package com.lophiester.Restaurante.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ItemPedidoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedidoPK)) return false;

        ItemPedidoPK that = (ItemPedidoPK) o;

        if (getProduto() != null ? !getProduto().equals(that.getProduto()) : that.getProduto() != null) return false;
        return getPedido() != null ? getPedido().equals(that.getPedido()) : that.getPedido() == null;
    }

    @Override
    public int hashCode() {
        int result = getProduto() != null ? getProduto().hashCode() : 0;
        result = 31 * result + (getPedido() != null ? getPedido().hashCode() : 0);
        return result;
    }
}
