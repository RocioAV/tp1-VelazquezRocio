package ar.edu.unju.fi.ejercicio9.model;

public class Producto {
	private String nombre;
	private int codigo;
	private Float precio;
	private int descuento;
	
	//CONSTRUCTORES
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	
	//METODOS
	public Float calcularDescuento() {
		return precio - (this.descuento*this.precio / 100.0f);
	}
	
	public void mostrarDatos() {
		System.out.println("Codigo producto: "+ this.codigo);
		System.out.println("Nombre producto: "+ this.nombre);
		System.out.println("Precio producto: $"+ this.precio);
		
	}
	
	
	//METODOS ACCESORES
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	
}
