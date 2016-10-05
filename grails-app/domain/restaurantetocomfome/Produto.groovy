package restaurantetocomfome

class Produto {

    String nome
    Double preco
    Estoque estoque

    static hasMany = [clientes:Cliente, itens:ItemPedido]

    // hasOne o ID da tabela mãe vai para a tabela filha, ou seja, a referencia da chave estrangeira fica apenas na tabela filha (1-1)
    // static hasOne = [estoque:Estoque]

    //belongsTo: ele diz quem é classe dominio que manda, isso mostra pro grails, de que lado vai acontecer a cascata de salvar ou excluir
    static belongsTo = [Cliente]

    static constraints = {
        //nullable para valores nulos e blanck para espaços em branco

        nome nullable: false, blank: false
        preco min: new Double(0)
    }

    static mapping = {

        discriminator column: "tipo", value: "GERAL" // atributo que ira discriminar no banco de dados
        clientes joinTable:[name:"preferencias_clientes", key: "id_produto", column: "id_cliente"]
    }
}
