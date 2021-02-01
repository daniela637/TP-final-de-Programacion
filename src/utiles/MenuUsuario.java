
package utiles;
import java.util.Scanner;
import usuarios.Usuario;
import usuarios.Usuarios;

public class MenuUsuario {
    
    Archivador archi = new Archivador();
	Scanner sc = new Scanner(System.in);
	//Crear un nuevo usuario
	public void cargarUsuario(Usuarios usuarios, String rutaUsuarios) {
		System.out.println("Ingrese el nombre de usuario");
		String username = sc.next();
		System.out.println("ingrese la contraseña del usuario a ingresar");
		String password = sc.next();
		System.out.println("ingrese el nick del usuario a ingresar");
		String nickname = sc.next();
               
                double saldo=0;
               
                    System.out.println("Cuanto dinero desea ingresar?");
                    Validador vali = new Validador(sc);
                    saldo = vali.validarDouble("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
		
                
		
		String tipoCuenta = "";
		int respuesta = 0;
		while (respuesta != 1 && respuesta != 2) {
			System.out.println("Indique el tipo de cuenta (1.administrador 2.usuario)");
			respuesta = sc.nextInt();
			if (respuesta == 1) {
				tipoCuenta = "administrador";
			}else if (respuesta == 2) {
				tipoCuenta = "usuario";
			}
		}
		if(usuarios.addUsuario(username, password, nickname, saldo, tipoCuenta)     ) {
			System.out.println("El usuario se creó perfectamente");
			archi.save(usuarios, rutaUsuarios);
		}else {
			System.out.println("Ya existe un usuario con ese nombre");
		}
	}
	//Iniciar sesion
	public Usuario ingresar(Usuarios usuarios) {
           
		System.out.println("Ingrese el nombre de usuario");
		String username = sc.next();
                
		if(!usuarios.existeUsuario(username)) {
			System.out.println("No existe el usuario");
                        return null;
			
                        
		}
               
		Usuario usu = usuarios.getUsuario(username);
		System.out.println("Ingrese la clave de usuario");
		String password = sc.next();
		//Comprobar que la clave es correcta
		if(usu.isClave(password)) {
			return usu;
		}
		return null;
	}
	//agregar saldo
	public  void agregarSaldo(Usuarios usuarios, String rutaUsuarios, String username) {
		if(usuarios.existeUsuario(username)) {
			Usuario usu = usuarios.getUsuario(username);
                        
                       
                       double saldo =0;
                      
                            System.out.println("Cuanto dinero desea ingresar?");
                            Validador vali = new Validador(sc);
                            saldo = vali.validarDouble("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
                           
                            
                           
			usu.setSaldo(usu.getSaldo() + saldo);
                        
			
			archi.save(usuarios, rutaUsuarios);
		}
	}
	public  void consultarSaldo(Usuarios usuarios, String rutaUsuarios, String username) {
		if(usuarios.existeUsuario(username)) {
			Usuario usu = usuarios.getUsuario(username);
			System.out.println("Su saldo es: $"+usu.getSaldo());
		}
	}
    
}
