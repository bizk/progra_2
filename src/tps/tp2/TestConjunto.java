package tps.tp2;

import api.ConjuntoTDA;
import implementaciones.arreglos.ConjuntoTMA;
import utilidades.Metodos;

import java.util.Scanner;

class TestConjunto {
	public static void main(String [] args) {
		ConjuntoTDA conjunto_a = new ConjuntoTMA();
		ConjuntoTDA conjunto_b = new ConjuntoTMA();
		ConjuntoTDA conjunto_c = new ConjuntoTMA();
		
		Metodos m = new Metodos();
		
		int num;
		
		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
			
		conjunto_a.InicializarConjunto();
		conjunto_b.InicializarConjunto();
		conjunto_c.InicializarConjunto();
		
		System.out.println("### TEST: Conjunto ###");
		// Punto 3
		if(conjunto_a.ConjuntoVacio()){
			System.out.println("El conjunto es vacio");
		} else {
			System.out.println("El conjunto NO es vacio");
		}
		
		System.out.println("Ingrese numeros para el conjunto A");
		for (int i = 0; i < 5; i++) {
			num = ln.nextInt();
			conjunto_a.AgregarConjunto(num);
		}
		mostrar(conjunto_a);
		
		if(conjunto_a.ConjuntoVacio()){
			System.out.println("El conjunto es vacio");
		} else {
			System.out.println("El conjunto NO es vacio");
		}

		System.out.println("Ingrese numeros para el conjunto B");
		for (int i = 0; i < 6; i++) {
			num = ln.nextInt();
			conjunto_b.AgregarConjunto(num);
		}
		mostrar(conjunto_b);
		
		System.out.print("Elegir un numero del conjunto B para sacar: ");
		num = ln.nextInt();
		conjunto_b.SacarConjunto(num);
		mostrar(conjunto_b);
		
		System.out.print("Elegir un numero del conjunto B para ver si pertenece: ");
		num = ln.nextInt();
		if(conjunto_b.PerteneceConjunto(num)){
			System.out.println("El numero " + num + " pertenece al conjunto.");
		} else {
			System.out.println("El numero " + num + " NO pertenece al conjunto.");
		}
		
		System.out.print("Sacamos un num del conjunto A: ");
		num = conjunto_a.ElegirConjunto();
		System.out.println(num);
		System.out.print("Original: ");
		mostrar(conjunto_a);
		conjunto_a.SacarConjunto(num);
		System.out.print("Despues: ");
		mostrar(conjunto_a);
		

		// Punto 4
		System.out.println("\n\n @PUNTO 4");
		
		// A
		System.out.println("Copiar conjunto a -> c: ");
		m.CopiarConjunto(conjunto_a, conjunto_c);
		System.out.print("Conjunto A: ");
		mostrar(conjunto_a);
		System.out.print("Conjunto C: ");
		mostrar(conjunto_c);
		
		// B
	}
	
	public static void mostrar(ConjuntoTDA origen) {
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