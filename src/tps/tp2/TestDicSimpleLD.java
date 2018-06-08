package tps.tp2;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;
import implementaciones.arreglos.ConjuntoTMA;
import implementaciones.listas.DiccionarioSimpleLD;
import utilidades.Metodos;

import java.util.Scanner;

class TestDicSimpleLD {
	public static void main(String[] args) {
		DiccionarioSimpleTDA dic_a = new DiccionarioSimpleLD(); // Defoinimos algunas pilas a probar

		dic_a.InicializarDiccionario();

		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
												// del teclado
		int valor, clave;
		
		System.out.println("### TEST: Diccionario SIMPLE A ###");
		System.out.println("Ingrese valor y clave para el diccionario simple: ");
		for (int i = 1; i <= 5; i++) {
			System.out.print("-V: ");
			valor = ln.nextInt();
			clave = ln.nextInt();
			//clave = i;
			dic_a.Agregar(clave, valor);
		}
		
		System.out.print("Elegir una clave del diccionario A para sacar: ");
		clave = ln.nextInt();
		dic_a.Eliminar(clave);
		
		System.out.print("Recuperar un valor a partir de una clave: ");
		clave = ln.nextInt();
		System.out.println(" " + dic_a.Recuperar(clave));

		System.out.print("Recuperar un conjunto con las claves del diccionario: ");
		ConjuntoTDA conjclaves = new ConjuntoTMA(); 
		conjclaves.InicializarConjunto();
		
		conjclaves = dic_a.Claves();
		mostrarconjunto(conjclaves);
	}
	
	public static void mostrarconjunto(ConjuntoTDA origen) {
		ConjuntoTDA aux = new ConjuntoTMA();
		
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
}