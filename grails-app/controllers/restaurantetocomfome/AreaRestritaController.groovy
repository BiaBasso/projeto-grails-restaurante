package restaurantetocomfome

class AreaRestritaController {

    // injeção de dependencia do objeto que esta relacionado com o serviço dentro da aplicação,
    // de forma que consigo pegar algumas informações; ex: usuario logado
    def springSecurityService

    def index() {

    }

    def logar(){

        render(view: "/areaRestrita/logar")
    }

    def admin(){

        /* Pegando os dados de usuario, especificamente o username do usuario*/
        String usuario = springSecurityService.principal.username

        render(view: "/areaRestrita/admin", model: [usuario: usuario])
    }

    def logout(){

        redirect(action: "logar")
    }
}
