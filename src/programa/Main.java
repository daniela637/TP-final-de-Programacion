
package programa;

import java.util.Scanner;
import articulos.Articulos;
import usuarios.Usuario;
import usuarios.Usuarios;
import utiles.Archivador;
import utiles.MenuArticulo;
import utiles.Carrito;
import utiles.MenuUsuario;

public class Main {

    
    public static void main(String[] args) {
       
        String rutaUsuarios = "usuarios.dat";
		String rutaArticulos = "articulos.dat";
		Archivador archi = new Archivador();
		Scanner sc = new Scanner(System.in);
		Usuarios usuarios;
		Articulos articulos;
		//Archivo de usuarios
		if (archi.createFile(rutaUsuarios)) {
			usuarios = new Usuarios();
			archi.save(usuarios, rutaUsuarios);
		} else {
			usuarios = (Usuarios) archi.load(rutaUsuarios);
		}
		//Archivo de articulos
		if (archi.createFile(rutaArticulos)) {
			articulos = new Articulos();
			archi.save(articulos, rutaArticulos);
		} else {
			articulos = (Articulos) archi.load(rutaArticulos);
		}
		MenuUsuario menu1 = new MenuUsuario();
		MenuArticulo menu2 = new MenuArticulo();
		Carrito carrito = new Carrito();
		Usuario usuarioActivo;
		boolean fin = false;
		System.out.println("Bienvenido!!");
		System.out.println("*********************************************");
		while (!fin) {
			System.out.println("Que accion desea realizar?");
			System.out.println("*********************************************");
			System.out.println("1.Crear una cuenta");
			System.out.println("2.Iniciar sesion");
			System.out.println("3.Salir del sistema");
			System.out.println("*********************************************");
			switch (sc.next()) {
			case "1":
				menu1.cargarUsuario(usuarios,rutaUsuarios);
			break;
			case "2":
				usuarioActivo = menu1.ingresar(usuarios);
//				String username = usuarioActivo.getUsername();
//				String nickname = usuarioActivo.getNickname();
				while(usuarioActivo != null) {
                                    String username = usuarioActivo.getUsername();
				String nickname = usuarioActivo.getNickname();
                                    
					if (usuarioActivo.getTipoCuenta().equals("administrador")) {
					System.out.println("Que accion desea realizar? " +nickname);
					System.out.println("*********************************************");
					System.out.println("1.Mostrar todos los articulos");
					System.out.println("2.Agregar un nuevo articulo");
					System.out.println("3.Modificar un articulo");
					System.out.println("4.Reponer stock");
					System.out.println("5.Eliminar un articulo");
					System.out.println("6.Consultar saldo");
					System.out.println("7.Agregar saldo");
					System.out.println("8.Comprar");
					System.out.println("9.Cerrar sesion");
					System.out.println("*********************************************");
					switch (sc.next()) {
					 case "1":
						 articulos.mostrarArticulos();
					 break;
					 case "2":
					   	 menu2.cargarArticulo(articulos, rutaArticulos);
					 break;
					 case "3":
						 menu2.modificarArticulo(articulos, rutaArticulos);
					 break;
					 case "4":
						 menu2.agregarStock(articulos, rutaArticulos);
					 break;
					 case "5":
						 menu2.eliminarArticulo(articulos, rutaArticulos);
					 break;
					 case "6":
						 menu1.consultarSaldo(usuarios, rutaUsuarios, username);
                                                 break;
					 case "7":
						 menu1.agregarSaldo(usuarios, rutaUsuarios, username);
					 break;
					 case "8":
						 carrito.comprarArticulo(articulos, usuarios, rutaUsuarios, rutaArticulos, username);
                                                 break;
					 case "9":
						 usuarioActivo = null;
					 break;
					 default:
						 System.out.println("Opcion incorrecta");
					 break;
					 }
					}else /*if (usuarioActivo.getTipoCuenta().equals("usuario"))*/ {
						System.out.println("Que accion desea realizar? " +nickname);
						System.out.println("*********************************************");
						System.out.println("1.Mostrar todos los articulos");
						System.out.println("2.Agregar saldo");
						System.out.println("3.Conssultar saldo");
						System.out.println("4.Comprar");
						System.out.println("5.Cerrar sesion");
						System.out.println("*********************************************");
						switch (sc.next()) {
						 case "1":
							 articulos.mostrarArticulos();
						 break;
						 case "2":
							 menu1.agregarSaldo(usuarios, rutaUsuarios, username);
						 break;
						 case "3":
							 menu1.consultarSaldo(usuarios, rutaUsuarios, username);
						 break;
						 case "4":
							 carrito.comprarArticulo(articulos, usuarios, rutaUsuarios, rutaArticulos, username);
						 break;
						 case "5":
							 usuarioActivo = null;
						 break;
						 default:
							 System.out.println("Opcion incorrecta");
						 break;
						 }
					}
				}
				break;
			case "3":
				System.out.println("Gracias por utilizar el sistema!");
				fin = true;
			break;
//			case "4":
			default:
				System.out.println("Opcion incorrecta");
			break;
			}
		
		}
		sc.close();
	}
        
        
    }
    

