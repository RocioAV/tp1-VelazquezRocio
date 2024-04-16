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
		Scanner sc = new Scanner(System.in);
		boolean ingresoCorrecto = false;
		do {
			try {
			
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
					
					switch (op) {
					case 1:
						Jugador jugador = generarJugador();
						jugadores.add(jugador);
						System.out.println("----SE HA DADO DE ALTA EL JUGADOR " + jugador.getNombre() +" ----");
						break;
					case 2:
						mostrarJugador(jugadores);
						break;
					case 3:
						if (jugadores.isEmpty()) {
							System.err.println("------No se ha dado de alta ningun jugador-------");
						}else
							mostrarPorApellido(jugadores);
						break;
					case 4:
						modificarJugador( jugadores);
						break;
					case 5:
						eliminarJugador(jugadores);
						break;
					case 6:
						System.out.println("----------------------------------------------------");
						System.out.println("Existe una cantidad de "+ jugadores.size()+" jugadores dados de alta");
						System.out.println("----------------------------------------------------");
						break;
					case 7:
						cantidadPorNacionalidad( jugadores);break;
					case 8:
						System.out.println("FIN DEL PROGRAMA-- <3 --");
						ingresoCorrecto=true;
						break;
						
					default:
						System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
						break;
					}
					
				} while (op != 8);
			}catch(InputMismatchException e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		} while (!ingresoCorrecto);
			
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
	/**
	 * MOSTRAR UN JUGADOR ESPECIFICO
	 * @param jugadores
	 */
	public static void mostrarJugador(ArrayList<Jugador> jugadores) {
		Scanner sc = new Scanner(System.in);
		if(!jugadores.isEmpty()) {
			System.out.println("Ingrese al nombre del jugador a mostrar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a mostrar");
			String apellido = sc.next();
			
			boolean encontrado= false;
			for (Jugador jugador : jugadores) {
				if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
					encontrado= true;
					mostrarDatos(jugador);
				}
			}
			if(encontrado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}
		}else {
			System.err.println("---NO SE HA DADO DE ALTA NINGUN JUGADOR---");
		}
		
	}
	/**
	 * mostrar datos 
	 * @param jugador
	 */
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
	
	/**
	 * MOSTRAR JUGADORES ORDENADOS POR APELLIDO
	 * @param jugadores
	 */
	public static void mostrarPorApellido(ArrayList<Jugador> jugadores) {
			jugadores.sort(Comparator.comparing(Jugador::getApellido));
			for (Jugador jugador : jugadores) {
		        mostrarDatos(jugador);
		    }
		
	}
	
	/**
	 * MODIFICA UN JUGADOR, SE LO BUSCA POR NOMBRE Y APELLIDO
	 * @param jugadores
	 */
	public static void modificarJugador(ArrayList<Jugador> jugadores) {
		
		Scanner sc= new Scanner(System.in);
		if(!jugadores.isEmpty()) {
			System.out.println("Ingrese al nombre del jugador a modificar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a modificar");
			String apellido = sc.next();
			
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
			if(modificado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}
		}else {
			System.err.println("---NO SE HA DADO DE ALTA NINGUN JUGADOR---");
		}
		
	}
	
	/**
	 * elimina un jugador con su nombre y apellido, mediante un iterator
	 * @param jugadores
	 */
	public static void eliminarJugador(ArrayList<Jugador> jugadores) {
		Scanner sc= new Scanner(System.in);
		boolean eliminado=false;
		if (!jugadores.isEmpty()) {
			System.out.println("Ingrese al nombre del jugador a eliminar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a eliminar");
			String apellido = sc.next();
			
			Iterator<Jugador> iterator= jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador jugador= iterator.next();
				if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
					iterator.remove();
					eliminado=true;
					System.out.println("JUGADOR ELIMINADO CORRECTAMENTE");
				}
			}
			if(eliminado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}	
		}else {
			System.err.println("---NO SE HA DADO DE ALTA NINGUN JUGADOR---");
		}
		
		
		
	}
	
	/**
	 * cuenta la cantidad de jugadores existentes segun nacionalidad
	 * @param jugadores
	 */
	public static void cantidadPorNacionalidad( ArrayList<Jugador> jugadores) {
		Scanner sc= new Scanner(System.in);
		if(!jugadores.isEmpty()) {
			System.out.println("Ingrese nacionalidad: ");
			String nac=sc.next();
			int cant=0;
			for (Jugador jugador : jugadores) {
				if(jugador.getNacionalidad().compareToIgnoreCase(nac)==0) {
					cant++;
				}
			}
			if (cant==0) {
				System.err.println("No existe jugadores de la nacionalidad buscada");
			}else {
				System.out.println("La cantidad de jugadores de nacionalidad "+ nac+ " es de: "+ cant);
			}
		}else {
			System.err.println("---NO SE HA DADO DE ALTA A NINGUN JUGADOR---");
		}
		
	}
	
	/**
	 * parseo de fecha str a LocalDate
	 * @param fechaStr
	 * @return
	 */
    public static LocalDate parsearFecha(String fechaStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaStr, formatter);
    }
}
