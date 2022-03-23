import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 * 
 * @author jaimejp
 * @version 1.0	
 */
public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		ArrayList<Ordenador> lista = new ArrayList();

		lista.add(new Portatil("SW10", "Pentium IV", "512 kb", 2.70, 2));
		lista.add(new Portatil("SW20", "Pentium VII", "1500", 1.70, 4));
		lista.add(new Sobremesa("XS99", "Pentium IV", "1Gb", "2.1Ghz", 17));
		lista.add(new Sobremesa("XS88", "Pentium V", "2Gb", "3.1Ghz", 15));
		Scanner teclado = new Scanner(System.in);
		int opcion;
		do {
			System.out.println();
			System.out.println("--------MEN�--------");
			System.out.println("1-Visualizar ordenadores");
			System.out.println("2-A�adir ordenador");
			System.out.println("3-Grabar ordenadores");
			System.out.println("4-Calcular factura");
			System.out.println("5-Finalizar");
			System.out.println("Introducir opcion: ");
			opcion = teclado.nextInt();
			while ((opcion < 1) || (opcion > 5)) {
				System.out.println("Error en opci�n");
				System.out.print("Introducir opci�n: ");
				opcion = teclado.nextInt();
			}
			switch (opcion) {
				case 1:
					visualizar(lista);
					break;
				case 2:
					anadir(lista);
					break;
				case 3:
					grabar(lista);
					break;
				case 4:
					calcular(lista);
					break;
			}
		} while (opcion != 5);
		System.out.println("-----------------");
		System.out.println("-------FIN-------");
		System.out.println("-----------------");

	}
	/**
	 * 
	 * @param lista
	 */
	public static void visualizar(ArrayList<Ordenador> lista) {
		for (Ordenador orde : lista) {
			System.out.println(orde);
		}
	}
	/**
	 * 
	 * @param lista
	 */
	public static void anadir(ArrayList<Ordenador> lista) {

		String ref, procesador, memoria, velocidad;
		double peso;
		int autonomia, tamano, tipo;
		boolean existente = false;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce referencia: ");
		ref = teclado.next();
		existente = buscarCodigo(lista, ref);
		while (existente == true) {
			System.out.println("Ya existe un ordenador con esa referencia");
			System.out.print("Introduce otra: ");
			ref = teclado.next();
			existente = buscarCodigo(lista, ref);
		}
		System.out.print("Procesador: ");
		procesador = teclado.next();
		System.out.print("Memoria: ");
		memoria = teclado.next();
		System.out.print("Tipo de ordenador(Portatil(1) o Sobremesa(2)): ");
		tipo = teclado.nextInt();
		while (tipo != 1 && tipo != 2) {
			System.out.print("Tipo invalido, introduzca otro");
			System.out.print("(Portatil(P) o Sobremesa(SM)): ");
			tipo = teclado.nextInt();
		}
		if (tipo == 1) {
			System.out.print("Peso: ");
			peso = teclado.nextDouble();
			System.out.print("Autonomia: ");
			autonomia = teclado.nextInt();
			lista.add(new Portatil(ref, procesador, memoria, peso, autonomia));
		} else {
			System.out.print("Velocidad: ");
			velocidad = teclado.next();
			System.out.print("Tama�o: ");
			tamano = teclado.nextInt();
			lista.add(new Sobremesa(ref, procesador, memoria, velocidad, tamano));
		}
		System.out.println("Anadido");
	}
	/**
	 * 
	 * @param lista
	 * @param ref
	 * @return
	 */
	public static boolean buscarCodigo(ArrayList<Ordenador> lista, String ref) {

		for (Ordenador aux : lista) {

			if (aux.getRef().equalsIgnoreCase(ref)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param lista
	 */
	public static void calcular(ArrayList<Ordenador> lista) {
		String ref;
		double precio;
		boolean existente = false;
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce referencia: ");
		ref = teclado.next();
		existente = buscarCodigo(lista, ref);
		while (existente == false) {
			System.out.println("No existe un ordenador con esa referencia");
			System.out.print("Introduce otra: ");
			ref = teclado.next();
			existente = buscarCodigo(lista, ref);
		}
		Iterator<Ordenador> it = lista.iterator();
		while (it.hasNext()) {
			Ordenador orde = it.next();
			if (ref.equalsIgnoreCase(orde.getRef())) {
				if (orde instanceof Portatil) {
					precio = ((Portatil) orde).calcular();
					System.out.println(orde.toString());
					System.out.println("Precio sin IVA: " + precio);
					System.out.println("Precio con IVA: " + (precio * 1.21));
				} else if (orde instanceof Sobremesa) {
					precio = ((Sobremesa) orde).calcular();
					System.out.println(orde.toString());
					System.out.println("Precio sin IVA: " + precio);
					System.out.println("Precio con IVA: " + (precio * 1.21));
				}
			}
		}

	}
	/**
	 * 
	 * @param lista
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void grabar(ArrayList<Ordenador> lista)
			throws ClassNotFoundException, FileNotFoundException, IOException {

		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Ordenadores.dat"));

		salida.writeObject(lista);
		salida.close();
	}

}
