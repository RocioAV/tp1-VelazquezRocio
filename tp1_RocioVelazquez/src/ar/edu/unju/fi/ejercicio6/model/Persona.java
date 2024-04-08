package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;

public class Persona {
	private String dni;
	private String nombre;
	private LocalDate fechaNac;
	private String provincia;
	
	
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", provincia=" + provincia
				+ "]";
	}

	//constructores
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNac, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.provincia = provincia;
	}
	
	public Persona(String dni, String nombre, LocalDate fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.provincia = "Jujuy";
    }
	
	//METODOS
	public int calcularEdad() {
		
		LocalDate hoy = LocalDate.from(LocalDate.now());
		
		return hoy.getYear() - fechaNac.getYear();
	}
	
	public boolean mayorEdad() {
		int edad = calcularEdad();
		if (edad >= 18) {
			return true;
		}else {
			return false;
		}
	}
	
	public void mostrarDatos() {
		System.out.println("DNI: " + this.dni);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de Nacimiento: " + this.fechaNac);
        System.out.println("Provincia: " + this.provincia);
        if (mayorEdad()) {
            System.out.println("La persona es mayor de edad");
        } else {
            System.out.println("La persona no es mayor de edad");
        }
       System.out.println("-----------------------");
	}
	

	//metodos accesores
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
}
