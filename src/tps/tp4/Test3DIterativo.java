package tps.tp4;

import java.util.Scanner;

import api.ABBTDA;
import implementaciones.listas.ABB;
import utilidades.Metodos;

public class Test3DIterativo {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		
		ABBTDA arbol_a=new ABB();
		arbol_a.InicializarArbol();
		int num;
		int i;
		Scanner atr = new Scanner(System.in);
		System.out.println("Ingrese numero");
		for(i=0;i<5;i++) {
			
		num = atr.nextInt();
		arbol_a.AgregarElem(num);
		
		}
		System.out.println("####MUESTRO ARBOL IN ORDER ####");
		m.inOrder(arbol_a);
		System.out.println("El menor valor es: " + m.MinimoIterativo(arbol_a));
	}
}
