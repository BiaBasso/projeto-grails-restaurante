package restaurantetocomfome

class Estoque {

    Integer quantidade
    Integer quantidadeMinima

    Produto produto

    static constraints = {

        quantidade min: 0
        quantidadeMinima min: 0
        produto nullable: false
    }
}
