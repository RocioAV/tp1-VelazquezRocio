package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	private String nombre;
	private int legajo;
	private Float salario;
	
	//CONSTANTES
	final Float SALARIO_MINIMO = 210000.00f;
	final Float AUMENTO_MERITOS	 = 20000.00f;
	
	// CONSTRUCTORES
	public Empleado(String nombre, int legajo, Float salario) {
		this.nombre = nombre;
		this.legajo = legajo;
		if(salario>= SALARIO_MINIMO) {
			this.salario=salario;
		}else {
			this.salario=SALARIO_MINIMO;
		}
	}
	
	//METODOS
	
	public void mostrarDatos() {
		System.out.println("---------------------------------------");
		System.out.println("Nombre del empleado: " +  this.nombre);
		System.out.println("Legajo: " +  this.legajo);
		System.out.println("Salario: $" +  this.salario);
		System.out.println("---------------------------------------");
	}
	
	public void aumentoSalario() {
		this.salario += AUMENTO_MERITOS;
	}
	

}
