package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] array = new int[8];
		int i=0;
		while (i<8) {
			System.out.println("ingrese un valor para la posicion "+ i);
			array[i]=sc.nextInt();
			System.out.println("----Se ha agregado "+ (i+1) +" numeros----");
			i++;
		}
		
		System.out.println("Los numeros ingresados: ");
		for (int j = 0; j < array.length; j++) {
			System.out.println("posicion ["+j+"] = "+ array[j] );
		}

	}

}
