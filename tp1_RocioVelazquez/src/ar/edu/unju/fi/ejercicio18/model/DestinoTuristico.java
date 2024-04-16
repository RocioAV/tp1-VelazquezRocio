package ar.edu.unju.fi.ejercicio18.model;

public class DestinoTuristico {
	private String codigo;
	private String nombre;
	private Float precio;
	private Pais pais;
	private int cantDias;
	
	public DestinoTuristico() {
		// TODO Auto-generated constructor stub
	}

	public DestinoTuristico(String codigo, String nombre, Float precio, Pais pais, int cantDias) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.pais = pais;
		this.cantDias = cantDias;
	}
	

	@Override
	public String toString() {
		return "DestinoTuristico [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", pais= " + pais.getCodigo() + " - " +pais.getNombre()
				+ ", cantidad de dias=" + cantDias + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	
	
	
}
