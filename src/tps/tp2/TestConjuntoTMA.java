package tps.tp2;

import api.ConjuntoTDA;
import implementaciones.arreglos.ConjuntoTMA;
import utilidades.Metodos;

import java.util.Scanner;

class TestConjuntoTMA {
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
		
		System.out.println("### TEST: Conjunto TMA ###");
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
		
		//PUNTO 6
		System.out.print("\nConjunto A: ");
		mostrar(conjunto_a);
		System.out.print("Conjunto B: ");
		mostrar(conjunto_b);
		//Interseccion
		conjunto_c.InicializarConjunto();
		conjunto_c = m.InterseccionConjunto(conjunto_a, conjunto_b);
		System.out.print(" Interseccion: ");
		mostrar(conjunto_c);
		
		//Union
		conjunto_c.InicializarConjunto();
		conjunto_c = m.UnionConjunto(conjunto_a, conjunto_b);
		System.out.print(" Union: ");
		mostrar(conjunto_c);
		
		//Diferencia
		conjunto_c.InicializarConjunto();
		conjunto_c = m.DiferenciaConjunto(conjunto_a, conjunto_b);
		System.out.print(" Diferencia: ");
		mostrar(conjunto_c);

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

 