package tps.tp4;
import java.util.Scanner;

/** @Autor Santiago Salvioli
@Grupo 3
*/
import api.ABBTDA;
import api.ColaPrioridadTDA;
import implementaciones.arreglos.*;
import implementaciones.listas.*;
import utilidades.*;

public class TestPunto1y2 {
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
		
		System.out.println("Ingrese numero a eliminar");
		num = atr.nextInt();
		arbol_a.EliminarElem(num);
		System.out.println("####MUESTRO ARBOL IN ORDER ####");
		//m.postOrder(arbol_a);
		//m.preOrder(arbol_a);
		m.inOrder(arbol_a);
		
	}

}





		