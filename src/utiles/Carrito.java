
package utiles;

import java.util.Scanner;

import articulos.Articulo;
import articulos.Articulos;
import usuarios.Usuario;
import usuarios.Usuarios;

public class Carrito {
    
    Archivador archi = new Archivador();
	Scanner sc = new Scanner(System.in);
	

	//Comprar articulo
		public void comprarArticulo(Articulos articulos, Usuarios usuarios, String rutaUsuarios, String rutaArticulos, String username) {
			Articulo art;
			Usuario usu = null;
			System.out.println("Ingrese el codigo de articulo que desea comprar");
			String codigoArticulo = sc.next();
			if (usuarios.existeUsuario(username)) {
				usu = usuarios.getUsuario(username);
			}
			
			if (articulos.existeArticulo(codigoArticulo)) {
				art = articulos.getArticulo(codigoArticulo);
				int cantidad = 0;
				double total = 0;
				boolean fin = false;
				while (!fin) {
					System.out.println("Cuantas unidades desea comprar?");
                                        Validador vali = new Validador(sc);
                                        cantidad = vali.validarInt("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
					
					if (cantidad <= art.getCantidad() ) {
						total = art.getPrecio() * cantidad;
						fin = true;
					}else {
						System.out.println("La cantidad que ha ingresado supera el stock ");
					}
				}
				if (total <= usu.getSaldo()) {
					art.setCantidad(art.getCantidad() - cantidad);
					usu.setSaldo(usu.getSaldo() - total);
					archi.save(articulos, rutaArticulos);
					archi.save(usuarios, rutaUsuarios);
					System.out.println("*********************************************");
					System.out.println("Detalles de la compra:");
					System.out.println("*********************************************");
					System.out.println("Codigo de articulo: " + art.getCodigoArticulo());
					System.out.println("Cantidad: " + cantidad);
					System.out.println("Total: " + total);
					System.out.println("*********************************************");
                                        
				}else {
					System.out.println("No posee saldo suficienta para realizar la compra, ingrese mas dinero a su cuenta");
				}
				
			}
			
		}	
}
