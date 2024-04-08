package ar.edu.unju.fi.ejercicio4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.println("Ingrese numero para resolver su factorial: ");
			 n = sc.nextInt();
			if (n>10 || n<0) {
				System.out.println("El numero debe ser entre 0 y 10, intentelo de nuevo");
			}
		} while (n>10 || n<0);
		int fact;
		if (n==0) {
			fact =1;
		}else {
			fact=1;
			int i=n;
			while (i>0) {
				fact=fact*i;
				i--;
			}
		}
		
		System.out.println("El factorial de "+ n + " es: " + fact);

	}

}
