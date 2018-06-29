package tps.tp4;
import java.util.Scanner;

/** @Autor Santiago Salvioli
@Grupo 3
*/
import api.ABBTDA;
import api.ColaPrioridadTDA;
import api.ConjuntoTDA;
import implementaciones.arreglos.*;
import implementaciones.listas.*;
import utilidades.*;
/*Autor: Gonzalo Bacigalupe, Santiago Salvioli
 * Grupo 3*/
public class TestPunto3 {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		
		ABBTDA arbol_a=new ABB();
		arbol_a.InicializarArbol();
		int num;
		int num2;
		int i;
		boolean a;
		
		Scanner atr = new Scanner(System.in);
		System.out.println("Ingrese numero");
		for(i=0;i<5;i++) {
			
		num = atr.nextInt();
		arbol_a.AgregarElem(num);
		}
		System.out.println("####MUESTRO ARBOL IN ORDER ####");
		m.inOrder(arbol_a);
		
		//ARRANCA TESTEO MISTICO
		
		//TEST 3-A
		System.out.println("#### EXISTE ELEMENTO? ####");
		System.out.println("Ingrese numero a comprobar");
		num = atr.nextInt();
		a=m.existeElementoABB(num, arbol_a);
		if(a==true) {
			System.out.println("EXISTE");
		}else {
		System.out.println("NO EXISTE");
		}
		
		
		//TEST 3-B
		System.out.println("#### ES HOJA? ####");
		System.out.println("Ingrese numero a comprobar");
		num = atr.nextInt();
		a=m.ElemenHoja(num, arbol_a);
		if(a==true) {
			System.out.println("ES HOJA");
		}else {
		System.out.println("NO ES HOJA");
		}
		
		
		//TEST 3-C
		System.out.println("#### PROFUNDIDAD ####");
		System.out.println("Ingrese numero a comprobar");
		num = atr.nextInt();
		num2=m.Profundidad(num, arbol_a);
		System.out.println("La profundidad es:"+num2);
		
		//TEST 3-D
		System.out.println("#### MENOR DEL ABB ####");
		num2=m.Menor(arbol_a);
		System.out.println("El menor es:"+num2);
		
		//TEST 3-E
		System.out.println("#### CANTIDAD DE ELEMENTOS ####");
		num2=m.CantElementos(arbol_a);
		System.out.println("La cantidad de elementos es:"+num2);
		
		//TEST 3-F
		System.out.println("#### SUMA DE ELEMENTOS ####");
		num2=m.SumaElementos(arbol_a);
		System.out.println("La suma de elementos da:"+num2);
		
		
		//TEST 3-G //REVISAR
		System.out.println("#### CANTIDAD DE HOJAS ####");
		num2=m.ContarCantidadDeHojas(arbol_a);
		System.out.println("La cantidad de hojas es:"+num2);
		
		//TEST3-H 
		System.out.println("#### ALTURA DE UN ABB #####");
		num2=m.CalcularAlturaABB(arbol_a);
		System.out.println("La altura es:"+num2);
		
		//TEST3-K
		System.out.println("Cantidad de elementos en el nivel 2 del arbol es: "+ m.ElementosNivelABB(arbol_a, 2));
		
		//TEST3-M
		System.out.println("###CONJUNTO DE ELEMENTOS MAYORES A K###");
		System.out.println("Ingrese numero a comprobar");
		num = atr.nextInt();
		System.out.println("Conjunto:");
		mostrar(m.ConjuntoElementosMayoresKABB(arbol_a, num));
		
		System.out.println("###Test finalizado###");
		
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