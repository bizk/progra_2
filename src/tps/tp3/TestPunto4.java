package tps.tp3;

import java.util.Scanner;

import api.ColaPrioridadTDA;
import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;
import implementaciones.arreglos.*;
import utilidades.*;

public class TestPunto4 {
	public static void main(String[] args) {
		Metodos m = new Metodos();

		int num;
		int prioridad;
		//arranco diccionario multiple
		DiccionarioMultipleTDA dic_a = new DicMultipleA();// Defoinimos algunas pilas a probar
		
		ConjuntoTDA conjclaves = new ConjuntoTMA(); 
		conjclaves.InicializarConjunto();
		
		dic_a.InicializarDiccionario();
		
		//arranco cola Prioridad
		
		
		ColaPrioridadTDA ColaPriori_a= new ColaPrioridadDA();
		//ColaPrioridadTDA ColaPriori_b= new ColaPrioridadDA();
		//ColaPrioridadTDA ColaPriori_c= new ColaPrioridadDA();
		
		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in);
		
		ColaPriori_a.InicializarCola();
		//ColaPriori_b.InicializarCola();
		//ColaPriori_c.InicializarCola();
		System.out.println("Ingrese numeros y prioridad para la ColaPriori a");
		for (int i = 0; i < 5; i++){
			System.out.println("Ingrese numero");
			num = ln.nextInt();
			System.out.println("Ingrese Prioridad");
			prioridad =ln.nextInt();
			ColaPriori_a.AcolarPrioridad(num, prioridad);
		}
		
		System.out.println("##### MUESTRO COLA #####");
		mostrar(ColaPriori_a);
		System.out.println("\n");
		
		System.out.println("##### VALORES CLAVE DE PRIORIDAD #####");
		//linea 1279 de metodos.java
		//NOTA SI REPETIS PRIORIDADES LOS VALORES SE ASIGNAN A UNA MIMSA CLAVE
		dic_a=m.ColaADiccionarioValoresClave(ColaPriori_a);
		mostrardicmult(dic_a);
		
		
		
	}
	
	public static void mostrar(ColaPrioridadTDA origen){
		Metodos m = new Metodos();	
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		aux.InicializarCola();
		m.CopiarColaPri(origen, aux);
		//m.InvertirPila(aux);
		while(!aux.ColaVacia()) {
			System.out.print(" " + aux.Primero());
			aux.Desacolar();
		}
	}
	
	public static void mostrardicmult (DiccionarioMultipleTDA origen) {
		ConjuntoTDA aux=origen.Claves();
		while(!aux.ConjuntoVacio()) {
			System.out.print("Clave " + aux.ElegirConjunto() + ": ");
			mostrarconjunto(origen.Recuperar(aux.ElegirConjunto()));
			aux.SacarConjunto(aux.ElegirConjunto());
			}
	
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
}	