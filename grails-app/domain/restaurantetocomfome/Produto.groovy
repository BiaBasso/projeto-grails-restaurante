package restaurantetocomfome

class Produto {

    String nome
    Double preco
    Estoque estoque

    // hasOne o ID da tabela mãe vai para a tabela filha, ou seja, a referencia da chave estrangeira fica apenas na tabela filha (1-1)
    // static hasOne = [estoque:Estoque]

    static constraints = {
    }
}
