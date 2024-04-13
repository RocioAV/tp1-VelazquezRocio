package ar.edu.unju.fi.ejercicio17.main;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;


public class Main {

	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner(System.in);
		ArrayList <Jugador> jugadores = new ArrayList();
		byte op=0;
		
		do {
			System.out.println("---MENU---");
			System.out.println("-1 Alta Jugador");
			System.out.println("-2 Mostrar los datos de un jugador");
			System.out.println("-3 Mostrar los jugadores ordenados por apellido");
			System.out.println("-4 Modificar los datos de un jugador");
			System.out.println("-5 Eliminar un jugaodor");
			System.out.println("-6 Mostrar cantidad total de jugadores");
			System.out.println("-7 mostrar la cantidad de jugadores segun nacionalidad");
			System.out.println("-8 SALIR");
			System.out.println("--------ingrese opcion-----------");
			op=sc.nextByte();
			
			menuReturn(op, jugadores);
			
		} while (op != 8);
		}catch(InputMismatchException e) {
			System.err.println("Error ingresa opcion valida");
		}finally {
	        System.out.println("Saliendo del programa...");
	    }
	}
	
	
	
	public static void menuReturn(byte op, ArrayList<Jugador> jugadores) {
		Scanner sc = new Scanner(System.in);
		switch (op) {
		case 1:
			Jugador jugador = generarJugador();
			jugadores.add(jugador);
			System.out.println("----SE HA DADO DE ALTA EL JUGADOR " + jugador.getNombre() +" ----");
			break;
		case 2:
			System.out.println("Ingrese al nombre del jugador a mostrar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a mostrar");
			String apellido = sc.next();
			boolean encontrado= mostrarJugador(nombre, apellido, jugadores);
			if(encontrado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}
			
			break;
		case 3:
			if (jugadores.isEmpty()) {
				System.err.println("------No se ha dado de alta ningun jugador-------");
			}else
				mostrarPorApellido(jugadores);
			break;
		case 4:
			System.out.println("Ingrese al nombre del jugador a modificar");
			String name = sc.next();
			System.out.println("INgrese el apellido del jugador a modificar");
			String lastName = sc.next();
			boolean modificado=modificarJugador(name, lastName, jugadores);
			if(modificado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}
			break;
		case 5:
			System.out.println("Ingrese al nombre del jugador a eliminar");
			String nomb1 = sc.next();
			System.out.println("INgrese el apellido del jugador a eliminar");
			String ap1 = sc.next();
			boolean eliminado=eliminarJugador(nomb1, ap1, jugadores);
			if(eliminado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}
			break;
		case 6:
			System.out.println("----------------------------------------------------");
			System.out.println("Existe una cantidad de "+ jugadores.size()+" jugadores dados de alta");
			System.out.println("----------------------------------------------------");
			break;
		case 7:
			System.out.println("Ingrese nacionalidad: ");
			String nac=sc.next();
			int cant= cantidadPorNacionalidad(nac, jugadores);
			if (cant==0) {
				System.err.println("No existe jugadores de la nacionalidad buscada");
			}else {
				System.out.println("La cantidad de jugadores de nacionalidad "+ nac+ " es de: "+ cant);
			}
			
			break;
		case 8:
			System.out.println("FIN DEL PROGRAMA-- <3 --");
			break;
		default:
			break;
		}
		
	}
	public static Jugador generarJugador() {
		Scanner sc = new Scanner(System.in);
		Jugador jugador = new Jugador();
		System.out.println("Ingrese nombre: ");
		jugador.setNombre(sc.next());
		System.out.println("Ingrese apellido: ");
		jugador.setApellido(sc.next());
		
		
		boolean fechaParseada = false;
	    while (!fechaParseada) {
	        System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy)");
	        String fechaNacStr = sc.next();
	        try {
	            LocalDate fechaNacimiento = parsearFecha(fechaNacStr);
	            jugador.setFechaNac(fechaNacimiento);
	            fechaParseada = true;
	        } catch (DateTimeParseException e) {
	            System.err.println("FORMATO SOLICITADO ERRONEO, INGRESE NUEVAMENTE.");
	            
	        }
	    }
	    System.out.println("Ingrese nacionalidad:  (argentina, boliviana, peruana etc)");
	    jugador.setNacionalidad(sc.next());
		
	    boolean estaturaValida = false;
	    while (!estaturaValida) {
	        try {
	            System.out.println("Ingrese estatura: (en centimetros)");
	            jugador.setEstatura(sc.nextInt());
	            estaturaValida = true; // 
	        } catch (InputMismatchException e) {
	            System.err.println("Error: Debes ingresar un valor numérico.");
	            sc.next();
	        }
	    }
		
	    boolean pesoValido = false;
	    while (!pesoValido) {
	        try {
	            System.out.println("Ingrese peso: ");
	            jugador.setPeso(sc.nextFloat());
	            pesoValido = true; // 
	        } catch (InputMismatchException e) {
	            System.err.println("Error: Debes ingresar un valor numérico (ej: 65,5 / 65).");
	            sc.next();
	        }
	    }
		
		boolean band = true;
		do {
			System.out.println("Ingrese posicion: delantero / medio / defensa / arquero");
			String pos= sc.next();
			if(pos.compareToIgnoreCase("delantero") == 0 || pos.compareToIgnoreCase("medio") == 0 || pos.compareToIgnoreCase("defensa") == 0
					|| pos.compareToIgnoreCase("arquero")== 0) {
				band=false;
				jugador.setPosicion(pos);
			}
		} while (band);
		
		return jugador;
	}
	public static boolean mostrarJugador(String nombre, String apellido, ArrayList<Jugador> jugadores) {
		boolean encontrado= false;
		for (Jugador jugador : jugadores) {
			if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
				encontrado= true;
				System.out.println("--------------------------------------");
				System.out.println("Nombre: " + jugador.getNombre());
	            System.out.println("Apellido: " + jugador.getApellido());
	            System.out.println("Edad: " + jugador.calcularEdad()+ " anios");
	            System.out.println("Fecha de nacimiento: " + jugador.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            System.out.println("Nacionalidad: " + jugador.getNacionalidad());
	            System.out.println("Estatura: " + jugador.getEstatura() + " cm");
	            System.out.println("Peso: " + jugador.getPeso() + " kg");
	            System.out.println("Posición: " + jugador.getPosicion());
	            System.out.println("--------------------------------------");
			}
		}
		return encontrado;
	}
	public static void mostrarDatos(Jugador jugador) {
		System.out.println("--------------------------------------");
		System.out.println("Nombre: " + jugador.getNombre());
        System.out.println("Apellido: " + jugador.getApellido());
        System.out.println("Edad: " + jugador.calcularEdad() + " anios");
        System.out.println("Fecha de nacimiento: " + jugador.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Nacionalidad: " + jugador.getNacionalidad());
        System.out.println("Estatura: " + jugador.getEstatura() + " cm");
        System.out.println("Peso: " + jugador.getPeso() + " kg");
        System.out.println("Posición: " + jugador.getPosicion());
        System.out.println("--------------------------------------");
	}
	public static void mostrarPorApellido(ArrayList<Jugador> jugadores) {
		jugadores.sort(Comparator.comparing(Jugador::getApellido));
		for (Jugador jugador : jugadores) {
	        mostrarDatos(jugador);
	    }
	}
	
	public static boolean modificarJugador(String nombre, String apellido, ArrayList<Jugador> jugadores) {
		Scanner sc= new Scanner(System.in);
		boolean modificado=false;
		for (Jugador jugador : jugadores) {
			if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
				byte op;
				System.out.println("¿Que desea modificar?");
				System.out.println("1-Estatura");
				System.out.println("2-Peso");
				System.out.println("3-Posicion");
				System.out.println("Ingrese opcion: ");
				op=sc.nextByte();
				switch (op) {
				case 1:
					 boolean estaturaValida = false;
					    while (!estaturaValida) {
					        try {
					            System.out.println("Ingrese estatura: (en centimetros)");
					            jugador.setEstatura(sc.nextInt());
					            estaturaValida = true; // 
					        } catch (InputMismatchException e) {
					            System.err.println("Error: Debes ingresar un valor numérico.");
					            sc.next();
					        }
					    }
					break;
				case 2:
					 boolean pesoValido = false;
					    while (!pesoValido) {
					        try {
					            System.out.println("Ingrese peso: ");
					            jugador.setPeso(sc.nextFloat());
					            pesoValido = true; // 
					        } catch (InputMismatchException e) {
					            System.err.println("Error: Debes ingresar un valor numérico (ej: 65,5 / 65).");
					            sc.next();
					        }
					    }		
					break;
				case 3:
					boolean band = true;
					do {
						System.out.println("Ingrese posicion: delantero / medio / defensa / arquero");
						String pos= sc.next();
						if(pos.compareToIgnoreCase("delantero") == 0 || pos.compareToIgnoreCase("medio") == 0 || pos.compareToIgnoreCase("defensa") == 0
								|| pos.compareToIgnoreCase("arquero")== 0) {
							band=false;
							jugador.setPosicion(pos);
						}
					} while (band);
					break;
				default:
					System.err.println("OPCION INCORRECTA");
					break;
				}
				modificado=true;
				mostrarDatos(jugador);
			}
		}
		
		return modificado;
	}
	public static boolean eliminarJugador(String nombre, String apellido, ArrayList<Jugador> jugadores) {
		boolean eliminado=false;
		Iterator<Jugador> iterator= jugadores.iterator();
		while(iterator.hasNext()) {
			Jugador jugador= iterator.next();
			if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
				iterator.remove();
				eliminado=true;
				System.out.println("JUGADOR ELIMINADO CORRECTAMENTE");
			}
		}
		
		return eliminado;
	}
	
	public static int cantidadPorNacionalidad(String nacionalidad, ArrayList<Jugador> jugadores) {
		int cant=0;
		for (Jugador jugador : jugadores) {
			if(jugador.getNacionalidad().compareToIgnoreCase(nacionalidad)==0) {
				cant++;
			}
		}
		
		return cant;
	}
    public static LocalDate parsearFecha(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaStr, formatter);
    }
}
