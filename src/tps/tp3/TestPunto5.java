package tps.tp3;
/** @Autor Santiago Yanzon
@Grupo 3
*/
import java.util.Scanner;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import implementaciones.listas.*;
import utilidades.Metodos;

class TestPunto5 {
	public static void main (String[] args) {
		DiccionarioMultipleTDA D1 = new  DiccionarioMultipleLD();
		DiccionarioMultipleTDA D2 = new  DiccionarioMultipleLD();
		DiccionarioMultipleTDA aux = new DiccionarioMultipleLD();
		
		Metodos m = new Metodos();
		
		int clave, valor;
		
		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in);
		
		D1.InicializarDiccionario();
		D2.InicializarDiccionario();
		
		System.out.println("### TEST: Punto 5 TP3 DICCIONARIOS ###");		
		System.out.println("Ingrese numeros para el diccionario D1: ");
		for (int i = 0; i < 5; i++) {
			/**System.out.print("-V: ");
			valor = ln.nextInt();
			System.out.print("-C: ");
			clave = ln.nextInt();
			**/
			clave = 3;
			valor = i;
			D1.Agregar(clave, valor);
		}
		mostrar(D1);

		System.out.println("Ingrese numeros para el diccionario D2: ");
		for (int i = 2; i < 7; i++) {
			/**
			System.out.print("-V: ");
			valor = ln.nextInt();
			System.out.print("-C: ");
			clave = ln.nextInt();
			*/
			clave = i;
			valor = i;
			D2.Agregar(clave, valor);
		}
		mostrar(D2);
 
		System.out.println("Inciso 5.1.a: Claves tanto de D1 o D2 con sus respectivos elementos: ");
		aux.InicializarDiccionario();
		aux = m.UnificarDicMultiples(D1, D2);
		mostrar(aux);
		System.out.println("Inciso 5.1.b: Claves de D1 y D2	solo con elementos comunes: ");
		aux.InicializarDiccionario();
		aux = m.DiccionarioElemComun(D1, D2);
		mostrar(aux);

		System.out.println("Inciso 5.1.c: Claves comunes de D1 y D2	con todos sus respectivos elementos: ");
		aux.InicializarDiccionario();
		aux = m.DicMultClavesComun(D1, D2);
		mostrar(aux);
		
		System.out.println("Inciso 5.1.d: Claves comunes de D1 y D2	Solo con elementos comunes: ");
		aux.InicializarDiccionario();
		aux = m.DicMultClavesYValComun(D1, D2);
		mostrar(aux);

		System.out.println("El programa finalizacion bien.");
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
	
}
