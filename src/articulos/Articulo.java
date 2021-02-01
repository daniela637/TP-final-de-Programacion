
package articulos;

import java.io.Serializable;



public class Articulo implements Serializable{
    
    private static final long serialVersionUID = 7392807849002757180L;
	private String codigoArticulo;
	private String nombreArticulo;
	private String descripcion;
	private int cantidad;
	private double precio;
	
	public Articulo(String codigoArticulo, String nombreArticulo, String descripcion, int cantidad, double precio) {
		super();
		this.codigoArticulo = codigoArticulo;
		this.nombreArticulo = nombreArticulo;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getNombreArticulo() {
		return nombreArticulo;
	}
	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
    @Override
	public String toString() {
		return "Articulo [codigoArticulo=" + codigoArticulo + ", nombreArticulo=" + nombreArticulo + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
    
}
