package restaurantetocomfome

class Cliente {

    String nome
    String email
    String senha
    String cpf

    // hasMany para relacionamento 1-N, os pedidos podem ser salvos em cascata
    static hasMany = [ pedidos:Pedido, produtosPreferidos:Produto ]

    static constraints = {

        nome nullable: false, blank: false
        email email: true, nullable: false, blank: false, unique: true // unique unico email
        senha size: 6..10 // o tamanho/quantidade de caracteres que quero que tenha
        cpf validator: {valor, objeto ->
            (valor.size() == 11)
        } // você pode montar o seu próprio validador
    }

    static mapping = {

        produtosPreferidos joinTable:[name:"preferencias_clientes", key: "id_cliente", column: "id_produto"]
    }
}
