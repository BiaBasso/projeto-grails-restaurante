package restaurantetocomfome

class ItemPedido {

    Integer quantidade
    Double valorVenda
    String observacao

    Produto produto
    Pedido pedido

    static belongsTo = [Pedido]

    static constraints = {
    }
}
