package tps.tp3;

import api.ConjuntoTDA;
import api.ColaTDA;
import implementaciones.arreglos.*;
import utilidades.*;

/**
 * @Autor Bacigalupe, Gonzalo
 * @Fecha /06/2018*/

public class TestPunto2{
	public static void main(String[] args) {
		Metodos m=new Metodos();
		
		ColaTDA cola_a= new ColaPI();
		ColaTDA cola_b= new ColaPI();
		ColaTDA cola_c= new ColaPI();
		ColaTDA cola_aux= new ColaPI();
		ColaTDA cola_M1= new ColaPI();
		ColaTDA cola_M2= new ColaPI();
		
		ConjuntoTDA c1= new ConjuntoLD();
		
		cola_a.InicializarCola();
		cola_b.InicializarCola();
		cola_c.InicializarCola();
		cola_M1.InicializarCola();
		cola_M2.InicializarCola();
		cola_aux.InicializarCola();
		
		cola_a.Acolar(1);
		cola_a.Acolar(2);
		cola_a.Acolar(3);
		cola_a.Acolar(2);
		cola_a.Acolar(1);
		
		
		cola_b.Acolar(1);
		cola_b.Acolar(2);
		cola_b.Acolar(3);
		cola_b.Acolar(4);
		cola_b.Acolar(5);
		cola_b.Acolar(6);
		cola_b.Acolar(7);
		cola_b.Acolar(8);
		
		System.out.println("Inciso A:Eliminar las repeticiones de una cola ");
		mostrar(cola_a);
		m.ColaEliminarRepeticiones(cola_a);
		System.out.println("Eliminados: ");
		mostrar(cola_a);
		
		
		/*
		System.out.println("Inciso b: Repartir una cola en dos mitades");
		mostrar(cola_b);
		cola_c= m.ColaPartir(cola_b, cola_M1, cola_M2);
		System.out.println("Mitad 1: ");
		mostrar(cola_b);
		System.out.println("Mitad 2: ");
		mostrar(cola_b);
		
		
		System.out.println("Inciso C: Devolver un conjunto con los elementos repetidos de una cola");
		mostrar(cola_a);
		System.out.println("Elementos repetidos");
		//	C1=m.ElementosRepetidos(pila_a);
		mostrarC(c1);
		
		*/

	
	}	
	public static void mostrar(ColaTDA origen) {
		Metodos m = new Metodos();

		ColaTDA aux = new ColaLD();
		aux.InicializarCola();
		m.CopiarCola(origen, aux);

		while (!aux.ColaVacia()) {
			System.out.print(" " + aux.Primero());
			aux.Desacolar();
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