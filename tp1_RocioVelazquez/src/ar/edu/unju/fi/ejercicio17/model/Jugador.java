package ar.edu.unju.fi.ejercicio17.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String nacionalidad;
	private int estatura;
	private float peso;
	private String posicion;
	
	//CONSTRUCTORES
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, int estatura, float peso,
			String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}
	
	//METODOS
	// Método para calcular la edad a partir de una fecha de nacimiento
    public  int calcularEdad() {
        int edad = LocalDate.now().getYear() - this.fechaNac.getYear();
        if (LocalDate.now().getDayOfYear() < this.fechaNac.getDayOfYear()) {
            edad--;
        }
        return edad;
    }

    
	
	//METODOS ACCESORES
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	
}
