
package utiles;
import java.util.Scanner;
import articulos.Articulo;
import articulos.Articulos;

public class MenuArticulo {
    
    Archivador archi = new Archivador();
	Scanner sc = new Scanner(System.in);
        
	
	//Ingresar un nuevo articulo
	public void cargarArticulo(Articulos articulos, String rutaArticulos) {
		System.out.println("Ingrese el codigo del articulo");
		String codigoArticulo = sc.next();
		
		System.out.println("Ingrese el nombre del articulo");
		String nombreArticulo = sc.next();
		
		System.out.println("Ingrese la descripcion del articulo");
		String descripcion = sc.next();
                
                
                 
                
                 int cantidad=0; 
                
                     System.out.println("Ingrese la cantidad disponible del articulo");
                 Validador vali = new Validador(sc);
                   cantidad = vali.validarInt("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
                                          
              
                 
                 double precio=0;
               
             
                    System.out.println("Ingrese el precio unitario del producto");
                    
                     precio = vali.validarDouble("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
                    
                  
                   
		
		if(   articulos.addArticulo(codigoArticulo, nombreArticulo, descripcion, cantidad, precio)) {
			System.out.println("El articulo se creo correctamente");
			archi.save(articulos, rutaArticulos);
		}else {
			System.out.println("El articulo ya existe");
		}
	}
	//Modificar un articulo
		public Articulo modificarArticulo(Articulos articulos, String rutaArticulos) {
			System.out.println("Ingrese el codigo del articulo");
			String codigoArticulo = sc.next();
		
			if(!articulos.existeArticulo(codigoArticulo)) {
				System.out.println("El articulo no existe");
				return null;
			}
		
			Articulo art = articulos.getArticulo(codigoArticulo);
			System.out.println("Desea modificar el nombre del articulo? S o (N, presione cualquier tecla)");
			if (sc.next().toLowerCase().equals("s")) {
				System.out.println("Ingrese el nuevo nombre del articulo");
				art.setNombreArticulo(sc.next());
			}
			System.out.println("Desea modificar la descripcion del articulo? S o (N, presione cualquier tecla)");
			if (sc.next().toLowerCase().equals("s")) {
				System.out.println("Ingrese la nueva descripcion del articulo");
				art.setDescripcion(sc.next());
			}
			System.out.println("Desea modificar el precio del articulo? S o (N, presione cualquier tecla)");
			if (sc.next().toLowerCase().equals("s")) {
                            
                          
                           double precio=0;
                        
                               System.out.println("Ingrese el precio del articulo");
                                Validador vali = new Validador(sc);
                              precio = vali.validarDouble("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
                                
                                
				art.setPrecio(precio);
                                
                            
				
			}
                        int cantidad=0;
			System.out.println("Desea modificar el stock del articulo? S o (N, presione cualquier tecla)");
			if (sc.next().toLowerCase().equals("s") ) {
                            
                           
                            
                           
                                System.out.println("Ingrese la cantidad de articulos ");
                                 Validador vali = new Validador(sc);
                                cantidad = vali.validarInt("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
                                
                                
				
				
                          art.setCantidad( cantidad);
			}
                        
			archi.save(articulos, rutaArticulos);
			return null;
		}
	//Roponer stock
	public Articulo agregarStock(Articulos articulos, String rutaArticulos) {
		System.out.println("Ingrese el codigo del articulo");
		String codigoArticulo = sc.next();
		
		if(!articulos.existeArticulo(codigoArticulo)) {
			System.out.println("El articulo no existe");
			return null;
		}else {
			Articulo art = articulos.getArticulo(codigoArticulo);
                       
                        int cantidad=0;
                       
                            System.out.println(" cuantas unidades desea reponer al stock del articulo?");
                             Validador vali = new Validador(sc);
                             cantidad = vali.validarInt("Ingrese un numero", "Valor incorrecto, Ingrese un numero positivo");
		
                        
                        
			
			art.setCantidad(art.getCantidad() + cantidad);
			archi.save(articulos, rutaArticulos);
			return null;
		}
	}
	//Eliminar un articulo
	public void eliminarArticulo(Articulos articulos, String rutaArticulos) {
		System.out.println("Ingrese el codigo de articulo");
		String codigoArticulo = sc.next();
		articulos.removerArticulo(codigoArticulo);
		archi.save(articulos, rutaArticulos);
		System.out.println("El articulo se eliminado con exito");
	}
    
}
