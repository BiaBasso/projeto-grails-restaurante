package comum

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Usuario implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	Usuario(String username, String password) {
//		this()
		this.username = username
		this.password = password
	}

	// pega todas as permissoes
	Set<Permissao> getAuthorities() {
		UsuarioPermissao.findAllByUsuario(this)*.permissao
	}

	//antes de inserir no banco de dados, ele executa esse comando
	def beforeInsert() {
		encodePassword()
	}

	// se a senha foi alterada, ele faz novamente o encodePassword
	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	// ele chama o metodo para criptografar a senha
	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password

		// os dois pontos ali , estão fazendo a ação de else
	}

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}
}
