package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;



public class Main {

	public static void main(String[] args) {
		int i =1;
		while(i<=3) {
			Pizza pizza= generarPizza();
			System.out.println("*** PIZZA "+ i+ " ***");
			pizza.calcularArea();
			pizza.calcularPrecio();
			pizza.mostrarDatos();
			System.out.println("----------------------------");
			i++;
		}
		
	}
	
	public static Pizza generarPizza() {
		Scanner sc = new Scanner(System.in);
		Pizza pizza = new Pizza();
		do {
			System.out.println("Ingrese diametro de la pizza (20/30/40)");
			pizza.setDiametro(sc.nextInt());
			if (!(pizza.getDiametro() == 20 || pizza.getDiametro() == 30 ||pizza.getDiametro() == 40 ) ) {
				System.out.println("Valor fuera de rango, ingrese nuevamente");
			}
		} while (!(pizza.getDiametro() == 20 || pizza.getDiametro() == 30 ||pizza.getDiametro() == 40 ) );
		String ingEsp;
		boolean band=true;
		do {
			System.out.println("Desea ingredientes especiales? true / false");
			ingEsp = sc.next(); 
			if (ingEsp.compareToIgnoreCase("true")==0) {
				pizza.setIngredientesEsp(true);
				band=false;
			}else if(ingEsp.compareToIgnoreCase("false")== 0) {
				pizza.setIngredientesEsp(false);
				band=false;
			}
			if (band) {
				System.out.println("opcion erronea, ingrese nuevamente");
			}
			
		} while (band);
		
		return pizza;
	}

}
