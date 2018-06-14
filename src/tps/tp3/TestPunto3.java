package tps.tp3;

import java.util.Scanner;

import api.*;
import implementaciones.arreglos.*;
import utilidades.Metodos;

class TestPunto3 {
	public static void main(String [] args) {
		ConjuntoTDA A = new ConjuntoLD();
		ConjuntoTDA B = new ConjuntoLD();
		Metodos M = new Metodos();
		int num;
		boolean banderabooleana;
		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
		
		A.InicializarConjunto();
		B.InicializarConjunto();
		
		System.out.println("### TEST: Punto 3 TP3 CONJUNTOS ###");		
		
		System.out.println("Ingrese numeros para el conjunto A");
		for (int i = 0; i < 5; i++) {
			num = ln.nextInt();
			A.AgregarConjunto(num);
		}
		mostrar(A);

		System.out.println("Ingrese numeros para el conjunto B");
		for (int i = 0; i < 5; i++) {
			num = ln.nextInt();
			B.AgregarConjunto(num);
		}
		mostrar(B);
		
		System.out.println("Inciso A.b: Diferencia simétrica de los conjuntos sin operaciones: ");
		ConjuntoTDA conjaux = new ConjuntoLD();
		conjaux.InicializarConjunto();
		conjaux = M.DiferenciaSimetricaSinOperaciones(A, B);
		mostrar(conjaux);
		
		System.out.println("Inciso A.c: Diferencia simétrica de los conjuntos con operaciones: ");
		conjaux.InicializarConjunto();
		conjaux = M.DiferenciaSimetricaConOperaciones(A, B);
		mostrar(conjaux);
		
		System.out.println("Inciso D:");
		banderabooleana = M.VerificarIgualdadconjuntos(A, B);
		if(banderabooleana){
			System.out.println("Son Iguales!");
		} else {
			System.out.println("Son diferentes");
		}
		
		num = M.ContarConjunto(A);
		System.out.println("Inciso E: Cantidad de elementos conjunto: " + num);
		mostrar(A);
		System.out.println("Inciso f:");
		System.out.println("Pila P:");
		PilaTDA P =new Pilas();
		P.InicializarPila();
		P.Apilar(1);
		P.Apilar(2);
		P.Apilar(3);
		P.Apilar(4);
		mostrarP(P);
		System.out.println("Cola C:");
		ColaTDA C =new ColaPU();
		C.InicializarCola();
		C.Acolar(1);
		C.Acolar(2);
		C.Acolar(3);
		C.Acolar(4);
		System.out.println("Elementos comunes:");
		mostrar(M.ConjuntoColaPila(C, P));
		
		System.out.println("Inciso G:");
		if(M.MismoPilaCola(P, C)) {
			System.out.println("Los elementos son los mismos");
		} else {
			System.out.println("Los elementos no son los mismos");
		}
		
		
		System.out.println("####### FIN DEL PROGRAMA #######");
	}
	public static void mostrarP(PilaTDA origen) {
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
	public static void mostrar(ConjuntoTDA origen) {
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