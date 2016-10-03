package restaurantetocomfome

class Produto {

    String nome
    Double preco

    // hasOne o ID da tabela mãe vai para a tabela filha, ou seja, a referencia da chave estrangeira fica apenas na tabela filha
    static hasOne = [estoque:Estoque]

    static constraints = {
    }
}
