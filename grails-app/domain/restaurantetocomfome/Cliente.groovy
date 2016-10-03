package restaurantetocomfome

class Cliente {

    String nome
    String email
    String senha

    // hasMany para relacionamento 1-N, os pedidos podem ser salvos em cascata
    static hasMany = [ pedidos:Pedido, produtosPreferidos:Produto ]

    static constraints = {
    }

    static mapping = {

        produtosPreferidos joinTable:[name:"preferencias_clientes", key: "id_cliente", column: "id_produto"]
    }
}
