package cl.inacap.audiomulax;

import java.util.Arrays;
import java.util.List;

import cl.inacap.audiomulaxmodelo.dto.InstrumentoMusical;
import cl.inacap.audiomulaxmodelo.dto.Venta;
import cl.inacap.audiomulaxmodelo.dto.Guitarra;
import cl.inacap.audiomulax.util.ConsolaUtil;
import cl.inacap.audiomulaxmodelo.dao.InstrumentoMusicalDAO;
import cl.inacap.audiomulaxmodelo.dao.VentaDAO;
import cl.inacap.audiomulaxmodelo.dto.Bateria;

public class Start {
	static ConsolaUtil cu = new ConsolaUtil(); //Se crea el objeto de tipo ConsolaUtils (Utilizado para el ingreso y validaci�n de datos).
	static InstrumentoMusicalDAO daoInstrumentoMusical = new InstrumentoMusicalDAO(); //Creaci�n de objeto de tipo InstrumentosMusicalesDAO.
	static VentaDAO daoVentas = new VentaDAO();
	
	//Menu de navegaci�n.
	public static boolean menu() { 
		boolean continuar = true;
		System.out.println("1. Registrar Instrumento Musical");
		System.out.println("2. Mostrar Instrumentos Musicales");
		System.out.println("3. Vender Instrumentos Musicales");
		System.out.println("4. Mostrar Ventas Realizadas");
		System.out.println("5. Anular Venta");
		System.out.println("0. Salir");
		switch (cu.validarString()) {
		case "1":
			registrarInstrumentoMusical();
			break;
		case "2":
			mostrarInstrumentosMusicales();
			break;
		case "3":
			venderInstrumentosMusicales();
				break;
		case "4":
			mostrarVentasRealizadas();
			break;
		case "5":
			anularVenta();
			break;
		case "0":
			continuar = false;
			break;
		default:
			System.out.println("Opcion incorrecta");
			break;
		}
		return continuar;	
	}
	
	//Proceso de registro del instrumento musical.
	public static void registrarInstrumentoMusical() {
		
		//Proceso de validaci�n del precio del intrumento.
		int valor;
		do {
			
			System.out.println("Ingrese el precio de instrumento que desea agregar");
			valor = cu.validarInt();
			if (valor < 100000) {
				System.out.println("El precio que ingreso es demasiado bajo, ingreselo nuevamente");
			}
			
		} while (valor < 100000);
		
		//Proceso de validaci�n de la marca del instrumento.
		String marca;
		List<String> marcasValidas = Arrays.asList("tama", "gibson", "esp", "maxtone", "pearl", "fender"); //Lista de tipo String llamada MarcasValidas que almacena 6 elementos.
		do {
			
			System.out.println("Escriba la marca del instrumento (Tama; Gibson; ESP; Maxtone; Pearl; Fender)");
			marca = cu.validarString().toLowerCase();
			
		} while (marcasValidas.contains(marca) == false); //El m�todo contains retorna un boolean dependiendo de que el par�metro ingresado est� o no en la lista, en otras palabras si la marca del instrumento no est� en la lista el programa no se sale del bucle.
		
		//Proceso de validaci�n del tipo de instrumento.
		String tipoInstrumento;
		do {
			
			System.out.println("Escriba el tipo de instrumento (Guitarra; Bateria)");
			tipoInstrumento = cu.validarString();
			
		} while (!tipoInstrumento.equalsIgnoreCase("Guitarra") && tipoInstrumento.equalsIgnoreCase("Bateria") == false); //! y ==false son lo mismo.
		
		if (tipoInstrumento.equalsIgnoreCase("Guitarra")) { //C�digo a ejecutar si el instrumento es una guitarra.
			
			int cantidadCuerdas;
			do {
				
				System.out.println("Ingrese la cantidad de cuerdas de la guitarra");
				cantidadCuerdas = cu.validarInt();
				if (cantidadCuerdas < 6) {
					System.out.println("La cantidad de cuerdas no puede ser menor que 6, ingrese la cantidad de cuerdas nuevamente");
				}	
				
			} while (cantidadCuerdas < 6);
			
			System.out.println("�La guitarra tiene puente flotante? (Si/No)");
			String respuesta = cu.validarString().toLowerCase();
			boolean puenteFlotante = true;
			while (respuesta.equals("si") == false && !respuesta.equals("no")) {
				System.out.println("Su respuesta no fue valida, responda nuevamente");
				System.out.println("�La guitarra es tiene puente flotante? (Si/No)");
				respuesta = cu.validarString().toLowerCase();
			}
			
			if (respuesta.equals("si")) {
				puenteFlotante = true;
			}
			else {
				puenteFlotante = false;
			}
			
			//Proceso de creaci�n del objeto de tipo Guitarra.
			Guitarra g = new Guitarra();
			g.setValor(valor);
			g.setMarca(marca);
			g.setCantidadDeCuerdas(cantidadCuerdas);
			g.setPuenteFlotante(puenteFlotante);
			InstrumentoMusical im = g; //Variable de tipo InstrumentoMusical que almacena objeto de tipo Guitarra (Esto puede suceder porque la clase Guitarra hereda de la clase InstrumentoMusical).
			
			daoInstrumentoMusical.save(im); //El c�digo de �ste m�todo a�ade el objeto reci�n creado a la lista. 
			
		}
		else { //C�digo a ejecutar si el instrumento es una bateria.
			
			int cantidadTambores;
			do {
				
				System.out.println("Ingrese la cantidad de tambores de la bateria");
				cantidadTambores = cu.validarInt();
				if (cantidadTambores < 2) {
					System.out.println("La cantidad de tambores no puede ser menor que 2, ingrese la cantidad de tambores nuevamente");
				}	
				
			} while (cantidadTambores < 2);
			
			System.out.println("�La bateria es el�ctrica? (Si/No)");
			String respuesta = cu.validarString().toLowerCase();
			boolean esElectrica = true;
			
			while (respuesta.equals("si") == false && !respuesta.equals("no")) {
				System.out.println("Su respuesta no fue valida, responda nuevamente");
				System.out.println("�La bateria es el�ctrica? (Si/No)");
				respuesta = cu.validarString().toLowerCase();
			}
			
			if (respuesta.equals("si")) {
				esElectrica = true;
			}
			else {
				esElectrica = false;
			}
			
			//Proceso de creaci�n del objeto de tipo bateria.
			Bateria b = new Bateria();
			b.setValor(valor);
			b.setMarca(marca);
			b.setCantidadDeTambores(cantidadTambores);
			b.setEsElectrica(esElectrica);
			
			InstrumentoMusical im = b; //Variable de tipo InstrumentoMusical que almacena objeto de tipo Bateria (Esto puede suceder porque la clase Bateria hereda de la clase InstrumentoMusical).
			daoInstrumentoMusical.save(im); //El c�digo de �ste m�todo a�ade el objeto reci�n creado a la lista. 
		}		
	}
	
	
	public static void mostrarInstrumentosMusicales() {
		
		List<InstrumentoMusical> existentes = daoInstrumentoMusical.getAll();
		
		/*Iterador V1.
		Existentes.forEach(System.out::println);*/
		
		/*Iterador V2
		Existentes.forEach(im -> {
			System.out.println(im);
		});*/
		
		/*Iterador V3.
		for (InstrumentoMusical im : Existentes) {
			System.out.println(im);
		}*/
		
		/*Iterador V4.
		for (int i = 0; i < Existentes.size(); i++) {
			System.out.println(Existentes.get(i));
		}*/
		
		//Iterador V5.
		if (existentes.isEmpty() == false) {
			existentes.forEach(im -> { //Aca se esta recorriendo la lista de instrumentos.
				if (im instanceof Guitarra) { //Aqui pregunta si la variable im es una instancia de la clase Guitarra.
					Guitarra g = (Guitarra) im; //Casting, DownCasting (El instrumento se convierte a guitarra).
					System.out.println("Marca: " + g.getMarca() + " Cantidad de cuerdas: " + g.getCantidadDeCuerdas()); //Se imprime en pantalla todos los atributos.
				}
				if (im instanceof Bateria) { //Aqui pregunta si la variable im es una instancia de la clase Bateria.
					Bateria b = (Bateria) im; //Casting, DownCasting (El instrumento se convierte a bateria).
					System.out.println("Marca: " + b.getMarca() + " Cantidad de tambores: " + b.getCantidadDeTambores()); //Se imprime en pantalla todos los atributos.
				}
			});
		}
		else {
			System.out.println("No hay instrumentos que mostrar");
		}

		
	}
	
	//Proceso de venta de los intrumentos.
	public static void venderInstrumentosMusicales() {
		List<InstrumentoMusical> instrumentosDisponibles = daoInstrumentoMusical.getAll(); //Esta instrucci�n trae la lista que almacena los instrumentos.
		
		if (instrumentosDisponibles.isEmpty() == false) {
			
			System.out.println("Ingrese el nombre del comprador");
			String nombreComprador = cu.validarString();
			
			System.out.println("Ingrese Rut del comprador");
			String rutComprador = cu.validarString();
			
			//Proceso de creaci�n del objeto Venta
			Venta venta = new Venta();
			venta.setNombreComprador(nombreComprador);
			venta.setRutComprador(rutComprador);
			
			
			
			String respuesta;
			do {
				System.out.println("�Que instrumentos desea comprar?");
				for (int i = 0; i < instrumentosDisponibles.size(); i++) { //Aca se esta recorriendo la lista de instrumentos (Tiene que ser un bucle for proque el usuario tiene que acceder al indice).
					
					InstrumentoMusical im = instrumentosDisponibles.get(i);
					System.out.print(i+"- ");
					if (im instanceof Guitarra) { //Aqui pregunta si la variable im es una instancia de la clase Guitarra.
						Guitarra g = (Guitarra) im; //Casting, DownCasting (El instrumento se convierte a guitarra).

						System.out.println("Marca: " + g.getMarca() + " Cantidad de cuerdas: " + g.getCantidadDeCuerdas()); //Se imprime en pantalla todos los atributos.
					}
					if (im instanceof Bateria) { //Aqui pregunta si la variable im es una instancia de la clase Bateria.
						Bateria b = (Bateria) im; //Casting, DownCasting (El instrumento se convierte a bateria).
						System.out.println("Marca: " + b.getMarca() + " Cantidad de tambores: " + b.getCantidadDeTambores()); //Se imprime en pantalla todos los atributos.
					}
				}
				int posicion = cu.validarInt(); //Aca se pide el instrumento que el comprador desea comprar.
				try { //Este try es necesario porque el usuario podria ingresar un indice que no existe.
					venta.getInstrumentos().add(instrumentosDisponibles.get(posicion)); //Utilizando el objeto Venta se trae la lista llamada Instrumentos y se le agrega el instrumento que seleccion� el usuario.
				} catch (Exception ex) {
					System.out.println("Posicion inexistente");
				}
				System.out.println("�Desea seguir agregando instrumentos? (Si/No)");
				respuesta = cu.validarString();
			} while (respuesta.equalsIgnoreCase("Si"));
			
			daoVentas.save(venta); //En esta instrucci�n se almacena la venta en la lista.
			int Total = 0; //Se crea la variable que sumar� los precios de la lista que esta en la clase venta.
			for (int i = 0; i < venta.getInstrumentos().size(); i++) { //Aca se recorre la lista de instrumentos que el usuario quiere comprar.
				Total+=venta.getInstrumentos().get(i).getValor(); //Utilizando el objeto Venta se trae la lista llamada Instrumentos y a cada objeto se le obtiene su atributo Valor y este es acumulado en la variable.
			}
			venta.setTotal(Total); //Se modifica el atributo Total.
			venta.setIVA((int)(Total * 0.19)); //Se modifica el atributo IVA (El atributo debe ser refundido porque el m�todo solo puede retornar datos de tipo int).
			venta.setTotalConIVA((int)(Total * 1.19));
			System.out.println("El total de la venta es: " + venta.getTotal()); //Se imprime el atributo Total.
			System.out.println("El IVA de la venta es: " + venta.getIVA()); //Se imprime el atributo IVA.
			System.out.println("La suma del total con el IVA es: " + venta.getTotalConIVA()); //Se imprime el atributo TotalConIVA.
			
		}
		else {
			System.out.println("No hay instrumentros disponibles para vender");
		}
		
	}

	//Proceso de impresi�n de ventas realizadas.
	public static void mostrarVentasRealizadas() {
	
		List<Venta> ventas = daoVentas.getAll(); //En esta instrucci�n se trae la lista con las ventas realizadas.
		if (ventas.isEmpty() == false) {
			ventas.forEach(System.out::println);
		}
		else {
			System.out.println("No hay ventas registradas en el sistema");
		}
		
	}
	
	public static void anularVenta() {
		List<Venta> ventas = daoVentas.getAll(); //Aca se traen todas las ventas realizadas.
		if (ventas.isEmpty() == false) {
			System.out.println("�Que venta desea eliminar?");
			for (int i = 0;i < ventas.size(); i++) {
				System.out.println(i + " - " + ventas.get(i)); //Aca se trae el toString de la venta.
			}
			try {
				int posicion = cu.validarInt();
				daoVentas.delete(posicion);
			} catch (Exception ex) {
				System.out.println("Posicion inexistente");
			}
		}
		else {
			System.out.println("No hay ventas que anular");
		}

	}

	public static void main(String[] args) {
		while(menu());
	}

}
