package tps.tp3;
/** @Autor Santiago Salvioli
@Grupo 3
*/
import java.util.Scanner;

import api.ConjuntoTDA;
import implementaciones.listas.ConjuntoLD;
import utilidades.Metodos;

class TestConjunto {
	public static void main(String [] args) {
		ConjuntoTDA A = new ConjuntoLD();
		ConjuntoTDA B = new ConjuntoLD();
		Metodos M = new Metodos();
		int num, bandera;
		boolean banderabooleana;
		Scanner ln = new Scanner(System.in); // Creamos un objeto para leer info
		
		A.InicializarConjunto();
		B.InicializarConjunto();
		
		System.out.println("### TEST: Conjuntos TP3 ###");		
		
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
		
		System.out.println("Conjunto simetria sin operaciones: ");
		ConjuntoTDA conjaux = new ConjuntoLD();
		
		//no anda este
		/*conjaux.InicializarConjunto();
		conjaux = M.DiferenciaSimetricaSinOperaciones(A, B);
		mostrar(conjaux);*/
		
		conjaux.InicializarConjunto();
		conjaux = M.DiferenciaSimetricaConOperaciones(A, B);
		mostrar(conjaux);
		
		//NO ANDA
		/*banderabooleana = M.VerificarIgualdadconjuntos(A, B);
		if(banderabooleana){
			System.out.println("Son Iguales!");
		} else {
			System.out.println("Son diferentes");
		}*/
		
		num = M.ContarConjunto(A);
		System.out.println(num);
		mostrar(A);
		
		System.out.println("####### FIN DEL PROGRAMA #######");
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
