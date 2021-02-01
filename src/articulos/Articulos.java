
package articulos;

import java.io.Serializable;
import java.util.HashMap;



public class Articulos implements Serializable{
    
    private static final long serialVersionUID = -5414322963852247905L;
	private HashMap<String, Articulo> diccionarioArticulos = new HashMap<String, Articulo>();
	
	public boolean addArticulo(String codigoArticulo, String nombreArticulo, String descripcion, int cantidad, double precio) {
		 if(existeArticulo(codigoArticulo) ){
			return false;
		}
		
		
		Articulo art = new Articulo(codigoArticulo, nombreArticulo, descripcion, cantidad, precio);

		this.diccionarioArticulos.put(codigoArticulo.toLowerCase(), art);
		
		return true;
	}
	//Cinfirmar si existe un articulo en especial
	public boolean existeArticulo(String codigoArticulo) {
		return this.diccionarioArticulos.containsKey(codigoArticulo.toLowerCase());
	}
	
	public Articulo getArticulos(String codigoArticulo) {
		return this.diccionarioArticulos.get(codigoArticulo.toLowerCase());
	}
	//Mostrar todos los articulos
	public void mostrarArticulos() {
		for( String clave : this.diccionarioArticulos.keySet() ) {
			System.out.println(clave);
			System.out.println(this.getArticulo(clave));
		}
		
	}
	public Articulo getArticulo(String codigoArticulo) {
		return this.diccionarioArticulos.get(codigoArticulo.toLowerCase());
	}
	public void removerArticulo(String codigoArticulo) {
		this.diccionarioArticulos.remove(codigoArticulo);
	}
	public boolean midificarArticulo(String codigoArticulo, String nombreArticulo, String descripcion, int cantidad, double precio) {
		 if(existeArticulo(codigoArticulo)){
			 this.diccionarioArticulos.get(codigoArticulo);
			 return false;
		 }
		 return false;
	}

    
    
}
