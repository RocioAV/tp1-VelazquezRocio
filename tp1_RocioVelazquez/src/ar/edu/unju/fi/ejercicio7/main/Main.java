package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese su legajo de empleado: ");
		int legajo= sc.nextInt();
		System.out.println("Ingrese nombre: ");
		String nombre= sc.next();
		System.out.println("Ingrese su salario: ");
		Float salario =sc.nextFloat();
		
		Empleado empleado1 = new Empleado(nombre, legajo, salario);
		
		empleado1.mostrarDatos();
		empleado1.aumentoSalario();
		empleado1.mostrarDatos();
		sc.close();
	}

}
