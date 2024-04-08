package ar.edu.unju.fi.ejercicio2;

public class Main {

	public static void main(String[] args) {
		/*
		  Dentro del paquete creado para el ejercicio crear la clase Main que contenga al método main().
			Declare variables que permitan almacenar los siguientes datos en el lenguaje Java:
			 El nombre de un país.
			 La edad de una persona.
			 La altura de un edificio.
			 El precio de un producto de supermercado.
			 Número de teléfono.
			 El cálculo de coseno de 0.5
			Asigne valores a cada variable y muéstrelas por consola.
		 */
		
		String pais;
		int edad;
		float alturaEdificio;
		float precioProducto;
		long numeroTelefono;
		double coseno;
		
		pais= "Peru";
		edad= 32;
		alturaEdificio= 443.2f;
		precioProducto= 1500.0f;
		numeroTelefono= 3885456852L;
		coseno=0.8775825618903728;
		
		System.out.println(pais + " es un pais");
		System.out.println("Maria tiene "+ edad + " años");
		System.out.println("El famoso Empire State Building en la ciudad de Nueva York mide: " + alturaEdificio + " metros");
		System.out.println("mi telefono es: " + numeroTelefono);
		System.out.println("el coseno de 0.5 es:  "+ coseno);
		System.out.println("El precio de 3kg de papa es de: $" + precioProducto);

	}

}
