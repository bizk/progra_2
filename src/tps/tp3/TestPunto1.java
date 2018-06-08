package tps.tp3;

import api.ConjuntoTDA;
import api.PilaTDA;
import implementaciones.arreglos.*;
import utilidades.*;
/**
 * @Autor Parodi, Federico
 * @Fecha 08/06/2018*/
public class TestPunto1 {
	public static void main(String[] args) {
		Metodos m = new Metodos();

		PilaTDA pila_a = new Pilas(); // Definimos algunas pilas a probar
		PilaTDA pila_b = new Pilas();
		PilaTDA pila_c = new Pilas();
		ConjuntoTDA C1 = new ConjuntoLD();
		
		pila_a.InicializarPila();
		pila_b.InicializarPila();
		pila_c.InicializarPila();
		
		pila_a.Apilar(1);
		pila_a.Apilar(2);
		pila_a.Apilar(3);
		pila_a.Apilar(2);
		pila_a.Apilar(1);
		
		pila_b.Apilar(1);
		pila_b.Apilar(2);
		pila_b.Apilar(3);
		pila_b.Apilar(4);
		
		System.out.println("Inciso A: ");
		mostrar(pila_a);
		System.out.println("Es capicua? ");
		if(m.EsCapicua(pila_a)){
			System.out.println("Si ");
		}else{
			System.out.println("No ");
		}
		mostrar(pila_b);
		System.out.println("Es capicua? ");
		if(m.EsCapicua(pila_b)){
			System.out.println("Si ");
		}else{
			System.out.println("No ");
		}
		
		
		pila_a.Apilar(4);
		pila_a.Apilar(5);
		pila_a.Apilar(4);
		
		System.out.println("Inciso B: Eliminar repeticiones de la pila");
		mostrar(pila_a);
		m.EliminarElemRepetidos(pila_a);
		System.out.println("Eliminados: ");
		mostrar(pila_a);
		
		
		pila_b.Apilar(5);
		pila_b.Apilar(6);
		pila_b.Apilar(7);
		pila_b.Apilar(8);
		System.out.println("Inciso C: Repartir una pila en dos mitades");
		mostrar(pila_b);
		pila_c=m.DividirPila(pila_b);
		System.out.println("Mitad 1: ");
		mostrar(pila_b);
		System.out.println("Mitad 2: ");
		mostrar(pila_c);
		
		pila_a.Apilar(1);
		pila_a.Apilar(1);
		pila_a.Apilar(2);
		pila_a.Apilar(3);
		pila_a.Apilar(8);
		pila_a.Apilar(3);
		pila_a.Apilar(5);
		
		System.out.println("Inciso D: Devolver un conjunto con los elementos repetidos de una pila");
		mostrar(pila_a);
		System.out.println("Elementos Repetidos");
		C1=m.ElementosRepetidos(pila_a);
		mostrarC(C1);
		
		
		
		
		
	}
	public static void mostrar(PilaTDA origen) {
		Metodos m = new Metodos();

		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		m.CopiarPila(origen, aux);
		m.InvertirPila(aux);

		while (!aux.PilaVacia()) {
			System.out.print(" " + aux.Tope());
			aux.Desapilar();
		}
		System.out.println("");
	}
	public static void mostrarC(ConjuntoTDA origen) {
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
}
