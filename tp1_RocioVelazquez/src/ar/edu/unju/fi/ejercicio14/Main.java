package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Ingrese un numero entre 3 y 10");
			n= sc.nextInt();
			if(n<3 || n>10) {
				System.out.println("Dato fuera de rango, intente de nuevo");
			}
		} while (n<3 || n>10);
		
		int[] numerosEnteros = new int[n];
		int i=0;
		//INGRESO DE NUMEROS POR CONSOLA
		while (i<n) {
			System.out.println("ingrese un valor: ");
			numerosEnteros[i]=sc.nextInt();
			System.out.println("----Se ha agregado "+ (i+1) +" numeros----");
			i++;
		}
		//MUESTRA Y SUMA DE VALORES DEL ARRAY
		int suma=0;
		System.out.println("Los numeros ingresados: ");
		for (int j = 0; j < numerosEnteros.length; j++) {
			suma += numerosEnteros[j];
			System.out.println("posicion ["+j+"] = "+ numerosEnteros[j] );
		}
		System.out.println("La suma de todos los numeros ingresados es: "+ suma);

	}

}
