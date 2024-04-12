package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] nombres = new String[5];
		
		//ingreso de datos
		for (int i = 0; i < nombres.length; i++) {
			System.out.println("Ingrese nombre: ");
			nombres[i]= sc.next();
			
		}
		//muestra de datos
		mostrarDatos(nombres);
		//muestra tamaño del array
		System.out.println("El tamaño del array es: "+ nombres.length);
		//pedido del indice a eliminar
		byte indice;
		do {
			System.out.println("Ingrese el indice del array a eliminar: ");
			indice=sc.nextByte();
			if(indice<0 || indice>4) {
				System.out.println("No existe el indice ingresado, intente nuevamente");
			}
		} while (indice<0 || indice>4 );
		// eliminacion del String en la posicion del indice_
		
		eliminarNombre(indice, nombres);
        
      //muestra de datos
      	mostrarDatos(nombres);
        

	}
	public static void mostrarDatos(String[] nombres) {
		
				int j=0;
				System.out.println("NOMBRES: ");
				while(j<nombres.length) {
					System.out.println("posicion ["+j+"] = "+ nombres[j]);
					j++;
				}
	}
	
	public static void eliminarNombre(byte indice, String[] nombres) {
		//desplazamientos de nombre si es necesario
		for (int i = indice; i < nombres.length - 1; i++) {
            nombres[i] = nombres[i + 1];
        }
		// se pone en blanco la ultima posicion donde estaba almacenado un nombre
        nombres[nombres.length - 1] = "";
	}

}
