package tps.tp1;

import api.ColaPrioridadTDA;
//import api.PilaTDA;
import implementaciones.arreglos.*;
import utilidades.*;
import java.util.Scanner;

@SuppressWarnings("resource")

class TestColaConPrioridad{
	public static void main(String[] args){
		Metodos m=new Metodos();
		
		ColaPrioridadTDA ColaPriori_a= new ColaPrioridadDA();
		ColaPrioridadTDA ColaPriori_b= new ColaPrioridadDA();
		ColaPrioridadTDA ColaPriori_c= new ColaPrioridadDA();
		ColaPrioridadTDA aux1= new ColaPrioridadDA();
		ColaPrioridadTDA aux2= new ColaPrioridadDA();
		ColaPrioridadTDA aux3= new ColaPrioridadDA();
	
	
		Scanner atr = new Scanner(System.in);
		
		ColaPriori_a.InicializarCola();
		ColaPriori_b.InicializarCola();
		ColaPriori_c.InicializarCola();
		aux1.InicializarCola();
		aux2.InicializarCola();
		aux3.InicializarCola();
		
		
		
		int num;
		boolean aux;
		int prioridad;
		//el numero es mas alto, mayor prioridad
		
		System.out.println("Ingrese numeros y prioridad para la ColaPriori a");
		for (int i = 0; i < 5; i++){
			System.out.println("Ingrese numero");
			num = atr.nextInt();
			System.out.println("Ingrese Prioridad");
			prioridad =atr.nextInt();
			ColaPriori_a.AcolarPrioridad(num, prioridad);
		
		}
		mostrar(ColaPriori_a);
		System.out.println("\n");
		
		
		System.out.println("Ingrese numeros y prioridad para la ColaPriori b");
		for (int i = 0; i < 5; i++){
			System.out.println("Ingrese numero");
			num = atr.nextInt();
			System.out.println("Ingrese Prioridad");
			prioridad =atr.nextInt();
			ColaPriori_b.AcolarPrioridad(num, prioridad);
		}
		mostrar(ColaPriori_b);
		
		m.CopiarColaPri(ColaPriori_a, aux2);
		m.CopiarColaPri(ColaPriori_b, aux3);
		
		System.out.println("\n");
				
		
		
		System.out.println("#####Arranca Testeo#####");

		
	
		System.out.println("###Combinar Cola Prioridad");
		
		aux1=m.CombinarColasPrioridad(ColaPriori_a, ColaPriori_b);
		mostrar(aux1);
		
	
		System.out.println("\n");
		System.out.println("###Comprobar Identidad");
		aux=m.ComprobarIdentidad(aux2, aux3);                   //le mando las copias de la cola a y b
		System.out.println(aux);
		
	
		
		
		
		
		
		
		
		
		
		
		
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
	
}	

//ñeriare
