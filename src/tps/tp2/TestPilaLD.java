package tps.tp2;

/* @Autor Carlos S. Yanzon
@Grupo 3
*/

import api.PilaTDA;
import implementaciones.listas.PilaLD;
import utilidades.*;

import java.util.Scanner;

class TestPilaLD {
	public static void main(String[] args) {
		Metodos m = new Metodos();

		PilaTDA pila_a = new PilaLD(); // Defoinimos algunas pilas a probar
		PilaTDA pila_b = new PilaLD();
		PilaTDA pila_c = new PilaLD();

		pila_a.InicializarPila();
		pila_b.InicializarPila();
		pila_c.InicializarPila();

		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
												// del teclado
		int num;

		System.out.println("### TEST: pila lista dinamica ###");
		System.out.println("Ingrese numeros para la pila A");
		for (int i = 0; i < 5; i++) {
			num = ln.nextInt();
			pila_a.Apilar(num);
		}

		System.out.println("Ingrese numeros para la pila B)");
		for (int i = 0; i < 5; i++) {
			num = ln.nextInt();
			pila_b.Apilar(num);
		}

		System.out.println("\n Pasar de una pila a otra: "); // NOS INVIERTE LA
																// PILA
		m.PasarPila(pila_b, pila_c);
		mostrar(pila_a);
		mostrar(pila_c);

		System.out.println("\n Copiar una pila a otra: ");
		m.CopiarPila(pila_a, pila_b);
		mostrar(pila_a);
		mostrar(pila_b);

		System.out.print("\n Invertir pila ");
		System.out.print("\n Original: ");
		mostrar(pila_c);
		m.InvertirPila(pila_c);
		System.out.print("\n Despues:");
		mostrar(pila_c);

		System.out.print("\n Contar elementos de una pila: ");
		num = m.ContarElemPila(pila_a);
		System.out.println(num);
		mostrar(pila_a);

		System.out.print("\n Sumar elementos de una pila: ");
		num = m.SumarElemPIla(pila_a);
		System.out.println(num);
		mostrar(pila_a);
	}

	public static void mostrar(PilaTDA origen) {
		Metodos m = new Metodos();

		PilaTDA aux = new PilaLD();
		aux.InicializarPila();
		m.CopiarPila(origen, aux);
		m.InvertirPila(aux);

		while (!aux.PilaVacia()) {
			System.out.print(" " + aux.Tope());
			aux.Desapilar();
		}
	}

}