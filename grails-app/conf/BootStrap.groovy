import comum.Permissao
import comum.Usuario
import comum.UsuarioPermissao

class BootStrap {

    def init = { servletContext ->

        /* Tudo isso, para criar os usuários e verificar se eles já foram criados. */

        Permissao admin = Permissao.findByAuthority("ROLE_ADMIN")

        if (admin == null){
            admin = new Permissao(authority: "ROLE_ADMIN").save(flush: true)
        }

        Permissao balcao = Permissao.findByAuthority("ROLE_BALCAO")

        if (balcao == null){
            balcao = new Permissao(authority: "ROLE_BALCAO").save(flush: true)
        }

        Usuario administrador = Usuario.findByUsername("administrador")
        if (administrador == null){
            administrador = new Usuario(username: "administrador", password: "123", enabled: true,
                    accountExpired: false, accountLocked:false, passwordExpired: false).save(flush: true)
        }

        Usuario balconista = Usuario.findByUsername("balconista")
        if (balconista == null){
            balconista = new Usuario(username: "balconista", password: "123", enabled: true,
                    accountExpired: false, accountLocked:false, passwordExpired: false).save(flush: true)
        }

        if (UsuarioPermissao.findByUsuarioAndPermissao(administrador, admin) == null){

            new UsuarioPermissao(usuario: administrador, permissao: admin).save(flush: true)
        }

        if (UsuarioPermissao.findByUsuarioAndPermissao(balconista, balcao) == null){

            new UsuarioPermissao(usuario: balconista, permissao: balcao).save(flush: true)
        }
    }

    def destroy = {
    }
}
