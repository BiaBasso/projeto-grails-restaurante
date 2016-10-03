package restaurantetocomfome

class Cliente {

    String nome
    String email
    String senha

    // hasMany para relacionamento 1-N, os pedidos podem ser salvos em cascata
    static hasMany = [ pedidos:Pedido ]

    static constraints = {
    }
}
