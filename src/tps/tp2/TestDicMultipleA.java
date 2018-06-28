package tps.tp2;

/* @Autor Carlos S. Yanzon
@Grupo 3
*/

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import implementaciones.arreglos.*;
import implementaciones.listas.*;
import utilidades.*;

import java.util.Scanner;

class TestDicMultipleA {
	public static void main(String[] args) {
		DiccionarioMultipleTDA dic_a = new DicMultipleA(); // Defoinimos algunas pilas a probar
		ConjuntoTDA conjclaves = new ConjuntoTMA(); 
		conjclaves.InicializarConjunto();
		dic_a.InicializarDiccionario();

		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
												// del teclado
		int valor, clave;
		
		System.out.println("### TEST: Diccionario MULTIPLE A ###");
		System.out.println("Ingrese valor y clave para el diccionario multiple: ");
		for (int i = 1; i <= 5; i++) {
			System.out.print("-V: ");
			valor = ln.nextInt();
			System.out.print("-C: ");
			clave = ln.nextInt();
			//clave = i;
			dic_a.Agregar(clave, valor);
		}
		System.out.println("Diccionario A: ");
		mostrardicmult(dic_a);
		
		System.out.println("Elegir una clave para eliminar: ");
		System.out.print("-C: ");
		clave = ln.nextInt();
		dic_a.Eliminar(clave);
		System.out.println("Resultado: ");
		mostrardicmult(dic_a);
		
		System.out.println("Elegir un valor de una clave a eliminarr: ");
		System.out.print("-V: ");
		valor = ln.nextInt();
		System.out.print("-C: ");
		clave = ln.nextInt();
		dic_a.EliminarValor(clave, valor);
		System.out.println("Resultado: ");
		mostrardicmult(dic_a);
		
		System.out.print("Recuperar valores a partir de una clave: ");
		clave = ln.nextInt();
		conjclaves = dic_a.Recuperar(clave);
		mostrarconjunto(conjclaves);

		System.out.print("Recuperar un conjunto con las claves del diccionario: ");
		conjclaves = dic_a.Claves();
		mostrarconjunto(conjclaves);
	}
	
	public static void mostrarconjunto(ConjuntoTDA origen) {
		ConjuntoTDA aux = new ConjuntoLD();
		
		Metodos m = new Metodos();
		
		aux.InicializarConjunto();
		
		int x;
		m.CopiarConjunto(origen, aux);
		while(!aux.ConjuntoVacio()){
			x = aux.ElegirConjunto();
			System.out.print(" " + x);
			aux.SacarConjunto(x);
		}
		System.out.println(" ");
	}
	public static void mostrardicmult (DiccionarioMultipleTDA origen) {
		ConjuntoTDA aux=origen.Claves();
		while(!aux.ConjuntoVacio()) {
			System.out.print("Clave " + aux.ElegirConjunto() + ": ");
			mostrarconjunto(origen.Recuperar(aux.ElegirConjunto()));
			aux.SacarConjunto(aux.ElegirConjunto());
			}
	}
}