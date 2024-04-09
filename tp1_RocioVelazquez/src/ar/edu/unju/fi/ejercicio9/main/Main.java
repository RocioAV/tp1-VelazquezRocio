package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i =1;
		while(i<=3) {
			Producto producto= generarProducto();
			System.out.println("PRODUCTO "+ i);
			producto.mostrarDatos();
			if(producto.getDescuento()== 0 ) {
				System.out.println("Este producto no tiene descuento.");
			}else {
				System.out.println("Este producto tiene un descuento del %"+producto.getDescuento());
				Float precioFinal= producto.calcularDescuento();
				System.out.println("Su precio final queda en: $"+ precioFinal);
				System.out.println("------------------------------------");
			}
			i++;
		}
		
	}
	
	public static Producto generarProducto() {
		Scanner sc = new Scanner(System.in);
		Producto prod = new Producto();
		System.out.println("Ingrese codigo del producto: ");
		int cod= sc.nextInt();
		System.out.println("Ingrese nombre del producto: ");
		String nombre=sc.next();
		System.out.println("Ingrese precio del producto: ");
		Float precio=sc.nextFloat();
		int desc;
		do {
			System.out.println("Ingrese descuento del producto: ");
			desc= sc.nextInt();
			if(desc<0 || desc > 50) {
				System.out.println("Descuento fuera de rango, intente de nuevo.");
			}
		} while (desc<0 || desc>50);
		prod.setCodigo(cod);
		prod.setNombre(nombre);
		prod.setPrecio(precio);
		prod.setDescuento(desc);
		
		return prod;
	}
}
