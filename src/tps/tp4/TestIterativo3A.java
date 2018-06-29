package tps.tp4;

import java.util.Scanner;

import api.ABBTDA;
import implementaciones.listas.ABB;
import utilidades.Metodos;

public class TestIterativo3A {
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
		System.out.println("Ingrese numero a Verificar si existe");
		num = atr.nextInt();
		
		if(m.PerteneceABBIt(arbol_a,num)) {
			System.out.println("El numero existe");
		}
		else
			System.out.println("El numero no existe");
	}
}
