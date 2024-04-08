package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * 3. Uso de variables – Estructura de control condicional.
			Dentro del paquete creado para el ejercicio crear la clase Main que contenga al método main().
			Declare las variables necesarias para realizar lo siguiente:
			Solicitar al usuario que ingrese por consola un número entero que debe ser almacenado en una
			variable (Investigue como utilizar la clase Scanner para poder ingresar datos por consola).
			Si el número ingresado es impar mostrar el doble del número y si es par mostrar el triple del número.
					
		
					 */
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese numero: ");
		int n = sc.nextInt();
		int r;
		if(n%2 == 0) {
			r= n*3;
			System.out.println("el triple de su numero es: " +r);
		}else {
			r=n*2;
			System.out.println("el doble de su numero es: " +r);
		}

	}

}
