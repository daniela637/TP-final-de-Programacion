
package usuarios;

import java.io.Serializable;


public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 6901470749414479172L;
	private String username;
	private String password;
	private String nickname;
	private double saldo;
	private String tipoCuenta;

	public Usuario(String username, String password, String nickname, double saldo, String tipoCuenta) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}
	

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getUsername() {
		return username;
	}


	public String getTipoCuenta() {
		return tipoCuenta;
	}

    @Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", nickname=" + nickname + ", saldo="
				+ saldo + ", tipoCuenta=" + tipoCuenta + "]";
	}


	public boolean isClave(String password) {
		return this.getPassword().equals(password);
	}
	
}
