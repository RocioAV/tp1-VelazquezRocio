package ar.edu.unju.fi.ejercicio12.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;



public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
	        System.out.print("Ingrese el nombre de la persona: ");
	        String nombre = sc.nextLine();

	        System.out.print("Ingrese la fecha de nacimiento (formato DD/MM/AAAA): ");
	        String fechaNacimientoStr = sc.nextLine();

	        Calendar fechaNacimiento = parsearFecha(fechaNacimientoStr);

	        Persona persona = new Persona(nombre,fechaNacimiento);
	        
	        persona.mostrarDatos();

	    }

	    public static Calendar parsearFecha(String fechaStr) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	        Date fechaDate = null;
	        
	        try {
	            fechaDate = sdf.parse(fechaStr);
	        } catch (ParseException e) {
	            System.out.println("Formato de fecha incorrecto. Debe ser DD/MM/AAAA.");
	            System.exit(1);
	        }
	        Calendar fechaCalendar = Calendar.getInstance();
	        fechaCalendar.setTime(fechaDate);
	        return fechaCalendar;
	    }
}


