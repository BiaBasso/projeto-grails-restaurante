package restaurantetocomfome

class Bebida {

    Double liquido
    String unidade

    static constraints = {

        liquido min: 0
        unidade nullable: false, blank: false, inList: ["L", "ml"]
    }
}
