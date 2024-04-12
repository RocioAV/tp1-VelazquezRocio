package ar.edu.unju.fi.ejercicio12.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Persona {
	private String nombre;
	private Calendar fechaNac;
	//CONSTRUCTORES
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Persona(String nombre, Calendar fechaNac) {
		this.nombre = nombre;
		this.fechaNac = fechaNac;
	}

	//METODOS
	public int calcularEdad() {
		int edad=0;
		Calendar hoy = Calendar.getInstance();
		edad = hoy.get(Calendar.YEAR)  - this.fechaNac.get(Calendar.YEAR);
		
		//saber si ya paso o no su cumple 
		if(hoy.get(Calendar.DAY_OF_YEAR) < this.fechaNac.get(Calendar.DAY_OF_YEAR)) {
			edad--;
		}
		return edad;
	}
	
	public String determinarSigno() {
		String signo="";
		int dia = this.fechaNac.get(Calendar.DAY_OF_MONTH);
        int mes = this.fechaNac.get(Calendar.MONTH) + 1;
		
        if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
            signo = "Aries";
        } else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
            signo = "Tauro";
        } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
            signo = "Géminis";
        } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
            signo = "Cáncer";
        } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
            signo = "Leo";
        } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
            signo = "Virgo";
        } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
            signo = "Libra";
        } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
            signo = "Escorpio";
        } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
            signo = "Sagitario";
        } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
            signo = "Capricornio";
        } else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            signo = "Acuario";
        } else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
            signo = "Piscis";
        } else {
            signo = "Fecha no válida";
        }
		
		return signo;
	}
	
	
	public String determinarEstacion() {
	    int dia = this.fechaNac.get(Calendar.DAY_OF_MONTH);
	    int mes = this.fechaNac.get(Calendar.MONTH) + 1; 
	    String estacion = "";

	    if ((mes == 9  && dia >= 21) || (mes == 10) || (mes == 12 && dia <= 20)) {
	        estacion = "Primavera";
	    } else if ((mes == 12 && dia >= 21) || (mes == 1) || (mes == 3 && dia <= 20)) {
	        estacion = "Verano";
	    } else if ((mes == 3 && dia >= 21) || (mes == 4) || (mes == 6 && dia <= 20)) {
	        estacion = "Otoño";
	    } else if ((mes == 6 && dia >= 21) || (mes == 7) || (mes == 9 && dia <= 20)  ) {
	        estacion = "Invierno";
	    } else {
	        estacion = "Fecha no válida";
	    }

	    return estacion;
	}
	
	public void mostrarDatos() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 System.out.println("Nombre: " + this.nombre);
	     System.out.println("Fecha de nacimiento: " + sdf.format(this.fechaNac.getTime()));
	     System.out.println("Edad: " + calcularEdad() + " años");
	     System.out.println("Signo del zodiaco: " + determinarSigno());
	     System.out.println("Estación: " + determinarEstacion());
	}

	//METODOS ACCESORES
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Calendar getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
}
