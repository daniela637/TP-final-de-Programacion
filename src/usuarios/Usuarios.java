
package usuarios;

import java.io.Serializable;
import java.util.HashMap;


public class Usuarios implements Serializable{
    
    private static final long serialVersionUID = -6480292937126472730L;
	private HashMap<String, Usuario> diccionarioUsuarios = new HashMap<String, Usuario>();
	
	//Crear una nueva cuenta
	public boolean addUsuario(String username, String password, String nickname, double saldo, String tipoCuenta) {
		if(existeUsuario(username)){
			return false;
		}
		Usuario usu = new Usuario(username, password, nickname, saldo, tipoCuenta);
		this.diccionarioUsuarios.put(username.toLowerCase(), usu);
		return true;
	}
	public boolean existeUsuario(String username) {
		return this.diccionarioUsuarios.containsKey(username.toLowerCase());
	}
	public Usuario getUsuario(String username) {
		return this.diccionarioUsuarios.get(username.toLowerCase());
	}
    
}
