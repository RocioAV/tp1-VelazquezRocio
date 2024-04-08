package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * La construcción de un objeto perteneciente a la clase Persona utilizando el constructor por
defecto. Una vez creado el objeto mostrar el mismo por la consola (se deben mostrar todos
los datos, incluyendo la edad y si es mayor de edad).
		 */
		Persona persona1= new Persona();
		ingresarDatosPersona(persona1);
		System.out.println("----PERSONA 1---- ");
		persona1.mostrarDatos();
		/*
		 * La construcción de un objeto perteneciente a la clase Persona utilizando el constructor
parametrizado. Una vez creado el objeto mostrar el mismo por la consola (se deben mostrar
todos los datos, incluyendo la edad y si es mayor de edad).
		 * 
		 */
		Scanner sc = new Scanner(System.in);
        System.out.print("DNI: ");
        String dni = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.next());
        System.out.print("Provincia: ");
        String provincia = sc.next();
        Persona persona2 = new Persona(dni, nombre, fechaNacimiento, provincia);
        System.out.println("----PERSONA 2---- ");
        persona2.mostrarDatos();
        
        /*
         * La construcción de un objeto perteneciente a la clase Persona utilizando el constructor que
lleva como parámetros el dni, nombre y fecha de nacimiento. Una vez creado el objeto
mostrar el mismo por la consola (se deben mostrar todos los datos, incluyendo la edad y si
es mayor de edad).
         * 
         */
        
        System.out.print("DNI: ");
         dni = sc.next();
        System.out.print("Nombre: ");
        nombre = sc.next();
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        fechaNacimiento = LocalDate.parse(sc.next());
        Persona persona3 = new Persona(dni, nombre, fechaNacimiento);
        System.out.println("----PERSONA 3---- ");
        persona3.mostrarDatos();
	
	}
	
	public static void ingresarDatosPersona( Persona persona) {
		Scanner sc = new Scanner(System.in);
        System.out.print("DNI: ");
        String dni = sc.next();
        persona.setDni(dni);

        System.out.print("Nombre: ");
        String nombre = sc.next();
        persona.setNombre(nombre);

        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.next());
        persona.setFechaNac(fechaNacimiento);
        
        System.out.print("Provincia: ");
        String provincia = sc.next();
        persona.setProvincia(provincia);
    }
}
