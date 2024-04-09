package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ingrese numero: ");
		int num= sc.nextInt();
		CalculadoraEspecial n = new CalculadoraEspecial();
		n.setN(num);
		
		int sumatoria= n.calcularSumatoria();
		int productoria= n.calcularProductoria();
		
		System.out.println("La sumatoria para " + n.getN() + " es: "+ sumatoria);
		System.out.println("La productorial para " + n.getN() + " es: "+ productoria);
		
	}

}
