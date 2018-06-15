package tps.tp3;
/**@Autor Federico Parodi
 * @Grupo 3
 */
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import api.DiccionarioSimpleTDA;
import implementaciones.listas.*;
import utilidades.Metodos;

public class TestPunto52 {
	public static void main (String[] args) {
		DiccionarioSimpleTDA DS = new DiccionarioSimpleLD();
		
		Metodos m = new Metodos();
		
		DS.Agregar(4994839, 10);
		DS.Agregar(7897554, 4);
		DS.Agregar(4768558, 5);
		DS.Agregar(4561225, 10);
		DS.Agregar(1245215, 5);
		DS.Agregar(4587445, 4);
		DS.Agregar(478552, 7);
		System.out.println("Diccionario simple:");
		mostrards(DS);
		System.out.println("Diccionario multiple:");
		mostrar(m.DiccionarioSimpleAMultiple(DS));
	}
	public static void mostrar(DiccionarioMultipleTDA original) {
		int x, y;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();
		ConjuntoTDA valores = new ConjuntoLD();
		valores.InicializarConjunto();
		
		claves = original.Claves();
		while(!claves.ConjuntoVacio()) {
			x = claves.ElegirConjunto();
			System.out.print("\n C " + x);
			valores = original.Recuperar(x);
			System.out.print(": ");
			while(!valores.ConjuntoVacio()) {
				y = valores.ElegirConjunto();
				System.out.print(y + " ");
				valores.SacarConjunto(y);
			}
			claves.SacarConjunto(x);
		}
		System.out.println("\n");
	}
	public static void mostrards(DiccionarioSimpleTDA original) {
		int x, y;
		ConjuntoTDA claves = new ConjuntoLD();
		claves.InicializarConjunto();

		claves = original.Claves();
		while(!claves.ConjuntoVacio()) {
			x = claves.ElegirConjunto();
			System.out.print("\n C " + x);
				System.out.print(": " + original.Recuperar(x));
			
			claves.SacarConjunto(x);
		}
		System.out.println("\n");
	}
	}

