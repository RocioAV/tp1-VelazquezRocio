package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		do {
			System.out.println("Ingrese un numero entre 5 y 10");
			n= sc.nextInt();
			if(n<5 || n>10) {
				System.out.println("Dato fuera de rango, intente de nuevo");
			}
		} while (n<5 || n>10);
		
		String[] nombres = new String[n];
		
		int i=0;
		//INGRESO DE NUMEROS POR CONSOLA
		while (i<n) {
			System.out.println("ingrese un nombre: ");
			nombres[i]=sc.next();
			System.out.println("----Se ha agregado "+ (i+1) +" nombres----");
			i++;
		}
		
		//muestra de datos normal
		System.out.println("Los nombres ingresados: ");
		for (int j = 0; j < nombres.length; j++) {
			System.out.println("posicion ["+j+"] = "+ nombres[j] );
		}
		
		//muestra de datos desde el final
		System.out.println("Los nombres ingresados desde la ultima posicion: ");
		for (int j = nombres.length-1; j >= 0; j--) {
			System.out.println("posicion ["+j+"] = "+ nombres[j] );
		}
	}

}
