package tps.tp4;

import java.util.Scanner;

import api.ABBTDA;
import implementaciones.listas.ABB;
import utilidades.Metodos;
/*Autor: Federico Parodi
 * Grupo 3*/
public class TestPunto3I {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		
		ABBTDA arbol_a=new ABB();
		arbol_a.InicializarArbol();
		ABBTDA arbol_b=new ABB();
		arbol_b.InicializarArbol();
		int num;
		int num2;
		int i;
		boolean a;
		
		Scanner atr = new Scanner(System.in);
		System.out.println("Ingrese numero arbol A");
		for(i=0;i<5;i++) {
			
		num = atr.nextInt();
		arbol_a.AgregarElem(num);
		}
		System.out.println("Ingrese numero arbol B");
		for(i=0;i<5;i++) {
			
		num2 = atr.nextInt();
		arbol_b.AgregarElem(num2);
		}
		
		System.out.println("Los arboles tienen la misma forma?");
		if(m.CompararFormaABB(arbol_a,arbol_b)){
			System.out.println("Si");
		}
		else
			System.out.println("No");
		System.out.println("Los arboles son iguales?");
		if(m.CompararIguales(arbol_a,arbol_b)){
			System.out.println("Si");
		}
		else
			System.out.println("No");
	}
}
