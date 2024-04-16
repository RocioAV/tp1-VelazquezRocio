package ar.edu.unju.fi.ejercicio18.main;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	private static Scanner sc;
	private static List<Pais> paises;
	private static List<DestinoTuristico> destinos;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		boolean ingresoCorrecto = false;
		do {
			try {
				byte op=0;
				precargaPaises();
				destinos= new ArrayList<>();
					do {
						System.out.println("---MENU---");
						System.out.println("-1 Alta Destino Turistico");
						System.out.println("-2 Mostrar todos los Destinos Turisticos");
						System.out.println("-3 Modificar el pais de un Destino TUristico");
						System.out.println("-4 Limpiar el ArrayList de destinos turisticos");
						System.out.println("-5 Eliminar un destino turistico");
						System.out.println("-6 MOstrar destinos turisticos ordenados por nombre");
						System.out.println("-7 Mostrar todos los paises");
						System.out.println("-8 Mostrar destinos turisticos por pais determinado");
						System.out.println("-9 SALIR");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							agregarDestinoTuristico();break;
						case 2:
							listarDestinos();break;
						case 3:
							modificarPaisDeDestinoT();break;
						case 4:
							limpiarArray();
							break;
						case 5:
							eliminarDestinoTuristico();break;
						case 6:
							mostrarPorNombre();break;
						case 7:
							listarpaises();break;
						case 8:
							mostrarDestinosPorPais();break;
						case 9:
							System.out.println("FIN DEL PROGRAMA-- <3 --");
							ingresoCorrecto=true;
							break;
						default:
							System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
							break;
						}
						
					} while (op != 9);
					
				}catch(InputMismatchException e) {
					System.err.println("Error: Ingresa una opción válida (número).");
			        sc.next(); 
				}
	} while (!ingresoCorrecto);


	}
	
	
	/**
	 * Precarga de paises
	 */
	public static void precargaPaises() {
		if (paises == null){
			paises= new ArrayList<>();
		}
		paises.add(new Pais("01", "Groenlandia"));
		paises.add(new Pais("02", "Argentina"));
		paises.add(new Pais("03", "Mexico"));
		paises.add(new Pais("04", "Colombia"));
		paises.add(new Pais("05", "Canada"));
		paises.add(new Pais("06", "Ecuador"));
		paises.add(new Pais("07", "Estados Unidos"));
	}
	/**
	 * Alta a un destino turistico, se lo agrega al array "destinos"
	 */
	public static void agregarDestinoTuristico() {
		sc = new Scanner(System.in);
		DestinoTuristico destino = new DestinoTuristico();
		try {
		System.out.println("Ingrese codigo del destino: ");
		destino.setCodigo(sc.next());
		sc.nextLine();
		System.out.println("Ingrese nombre del destino: ");
		destino.setNombre(sc.nextLine());
		
		
		 while(true) {
	            try {
	                System.out.println("Ingrese precio: ");
	                destino.setPrecio(sc.nextFloat());
	                break;
	            } catch (InputMismatchException e) {
	                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
	                sc.next(); 
	            }
	       }
		 
		 while(true) {
	            try {
	                System.out.println("Ingrese la cantidad de días de visita: ");
	                destino.setCantDias(sc.nextInt());
	                break;
	            } catch (InputMismatchException e) {
	                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
	                sc.next(); 
	            }
	        }
		 
		 while (true) {
	            System.out.println("Ingrese código del país: ");
	            String codigoP = sc.next();
	            Pais pais = buscarPais(codigoP);
	            if (pais != null) {
	                destino.setPais(pais);
	                break;
	            } else {
	                System.err.println("No se ha encontrado el país con el código proporcionado.Ingrese nuevamente");
	            }
	        }
		 destinos.add(destino);
		} catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	    }
	}
	
	/**
	 * buscar un pais en el arraylist
	 * @param codigo
	 * @return objeto Pais
	 */
	public static Pais buscarPais(String codigo) {
		Pais paisEncontrado =null;
		for(Pais pais:paises) {
			if(pais.getCodigo().compareToIgnoreCase(codigo)==0) {
				paisEncontrado=pais;
				break;
			}
		}
		return paisEncontrado;
	}
	/**
	 * lista los destinos turisticos
	 */
	public static void listarDestinos() {
		if(!destinos.isEmpty()) {
			System.out.println("-----DESTINOS TURISTICOS-----");
			destinos.forEach(d->System.out.println(d));
		}else {
			System.err.println("LISTA DE DESTINOS TURISTICOS VACIA");
		}
		
	}
	/**
	 * LISTA LOS PAISES
	 */
	public static void listarpaises() {
		if(!paises.isEmpty()) {
			System.out.println("-----PAISES-----");
			paises.forEach(d->System.out.println(d));
		}
		
	}
	
	/**
	 * Modificar el pais de un destino turistico
	 */
	public static void modificarPaisDeDestinoT() {
		sc= new Scanner(System.in);
		boolean encontrado=false;
		if(!destinos.isEmpty()) {
			System.out.println("Ingrese codigo del destino turistico a modificar");
			String codigo=sc.next();
			for(DestinoTuristico dt:destinos) {
				if(dt.getCodigo().compareToIgnoreCase(codigo)==0) {
					System.out.println("---DESTINO ENCONTRADO---");
					encontrado=true;
					while (true) {
			            System.out.println("Ingrese código del nuevo país: ");
			            String codigoP = sc.next();
			            Pais paisNuevo = buscarPais(codigoP);
			            if (paisNuevo != null) {
			                dt.setPais(paisNuevo);
			                encontrado=true;
			                System.out.println("Destino modificado: " + dt);
			                break;
			            } else {
			                System.err.println("No se ha encontrado el país con el código proporcionado.Ingrese nuevamente");
			            }
			        }
					break;
				}
			}
			if(!encontrado) {
				System.err.println("El destino no se ha encontrado");
			}
		}else {
			System.err.println("--- NO SE HA DADO DE ALTA NINGUN DESTINO ---");
		}
		
	}
	/**
	 * LIMPIEZA DEL ARRAYLIST DE DESTINOS TURISTICOS
	 */
	public static void limpiarArray() {
		System.out.println("------Limpiando-----");
		destinos.clear();
		System.out.println("----LIMPIEZA COMPLETA----");
	}
	/**
	 * Eliminar un destino turistico con iterator
	 */
	public static void eliminarDestinoTuristico() {
		sc=new Scanner(System.in);
		if(!destinos.isEmpty()) {
			System.out.println("Ingrese codigo del destino a eliminar: ");
			String codigo= sc.next();
			boolean eliminado = false;
			Iterator<DestinoTuristico> iterator= destinos.iterator();
			while(iterator.hasNext()) {
				DestinoTuristico dt= iterator.next();
				if(dt.getCodigo().compareToIgnoreCase(codigo)==0) {
					iterator.remove();
					eliminado=true;
					System.out.println("DESTINO TURISTICO ELIMINADO CORRECTAMENTE");
				}
			}
			if(!eliminado) {
				System.err.println("xxxx-NO SE HA ENCONTRADO EL DESITNO-xxxx");
			}
		}else {
			System.err.println("--- NO SE HA DADO DE ALTA NINGUN DESTINO ---");
		}
		
		
	}
	/**
	 * MOSTRAR DESTINOS ORDENADOS POR NOMBRE
	 */
	public static void mostrarPorNombre() {
		if (!destinos.isEmpty()) {
			System.out.println("-----DESTINOS TURISTICOS-----");
			destinos.sort(Comparator.comparing(DestinoTuristico::getNombre));
			for (DestinoTuristico dt : destinos) {
		        System.out.println(dt);
			}
		}else {
			System.err.println("LA LISTA DE DESTINOS TURISTICOS ESTA VACIA");
		}
			
	}
	
	/**
	 * MOSTRAR DESTINOS TURISTICOS QUE PERTENECEN A UN PAIS
	 */
	public static void mostrarDestinosPorPais() {
		sc= new Scanner(System.in);
		boolean hay=false;
		if(!destinos.isEmpty()) {
			while (true) {
	            System.out.println("Ingrese código del pais a buscar destinos: ");
	            String codigoP = sc.next();
	            Pais paisNuevo = buscarPais(codigoP);
	            if (paisNuevo != null) {
	            	for(DestinoTuristico dt:destinos) {
	        			if(dt.getPais().getCodigo().compareToIgnoreCase(codigoP)==0) {
	        				System.out.println(dt);
	        				hay=true;
	        			}
	        		}
	            	if(!hay) {
	            		System.err.println("No existen destinos turisticos que coincidan con el codigo de pais");
	            	}
	            break;
	            } else {
	                System.err.println("No se ha encontrado el país con el código proporcionado.Ingrese nuevamente");
	            }
	        }
		}else {
			System.err.println("--NO SE HA DADO DE ALTA NINGUN DESITNO--");
		}
		
		
	}
}
