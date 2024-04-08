package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Ingrese numero: ");
			 n = sc.nextInt();
			if (n>9 || n<1) {
				System.out.println("El numero debe ser entre 1 y 9, intentelo de nuevo");
			}
		} while (n>9 || n<1);
		
		for (int i = 0; i <=10 ; i++) {
			System.out.println(n + " x " + i + " = " + n*i);
		}

	}

}
