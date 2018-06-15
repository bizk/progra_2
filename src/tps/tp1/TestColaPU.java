package tps.tp1;
/** @Autor Gonzalo Bacigalupe
@Grupo 3
*/
import java.util.Scanner;

import api.ColaTDA;
import implementaciones.arreglos.ColaPU;
import utilidades.Metodos;

public class TestColaPU {
	public static void main (String[] args) {
		Metodos m = new Metodos();
		//COLAS A PROBAR
		ColaTDA cola_a = new ColaPU();
		ColaTDA cola_b = new ColaPU();
		ColaTDA cola_c = new ColaPU();

		cola_a.InicializarCola();
		cola_b.InicializarCola();
		cola_c.InicializarCola();
		
		@SuppressWarnings("resource")
		Scanner ln = new Scanner(System.in);

		//INGRESO POR TECLADO

		int num;
		
		System.out.println("### TEST cola PU1 ###");
		System.out.println("Ingrese 5 numeros para la cola A");
		for (int i = 0; i < 5; i++){
			num = ln.nextInt();
			cola_a.Acolar(num);
		}
		
		System.out.println("Ingrese 5 numeros para la cola B");
		for (int i = 0; i < 5; i++){
			num = ln.nextInt();
			cola_b.Acolar(num);
		}
		

		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");
		
		//PASAR COLA A OTRA

		System.out.println("\n Pasar de una cola a otra: ");
		System.out.println("\n Original: ");
		mostrar(cola_b);
		m.PasarCola(cola_b, cola_c);
		System.out.println("\n Procesada ");
		mostrar(cola_c);
		
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");

		//INVERTIR CONTENIDO DE LA COLA CON PILAS AUXILIARES

		System.out.print("\n Invertir cola con Pilas auxiliares: ");
		System.out.print("\n Original: ");
		mostrar(cola_a);
		m.InvertirColaPila(cola_a);
		System.out.print("\n Procesada:");
		mostrar(cola_a);
		
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");

		//INVERTIR CONTENIDO DE LA COLA SIN PILAS AUXILIARES

		System.out.print("\n Invertir cola sin Pilas auxiliares: ");
		System.out.print("\n Original: ");
		mostrar(cola_c);
		m.InvertirColaSola(cola_c);
		System.out.print("\n Procesada:");
		mostrar(cola_c);
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");

		//DETERMINAR SI EL FINAL DE LA COLA A COINCIDE CON LA COLA B

		System.out.print("\n Coincide el final de la Cola A con el de la Cola B?: ");
		System.out.print("\n Cola A: ");
		mostrar(cola_a);
		System.out.print("\n Cola B: ");
		mostrar(cola_c);
		System.out.print("\n Coincide? ");
		if(m.CompararFinal(cola_a, cola_c)){
			System.out.print(" Si");
		}
		else{
			System.out.print(" No");
		}
		
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");

		//COLA CAPICUA

		System.out.print("\n Cola es capicua?");
		System.out.print("\n Original");
		mostrar(cola_c);
		System.out.print("\n");
		m.ColaCapicua(cola_c);
		
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");

		//DETERMINAR SI COLA A ES INVERSA DE B

		System.out.print("\n La Cola A es la inversa de la Cola B?");
		System.out.print("\n Cola A: ");
		mostrar(cola_a);
		System.out.print("\n Cola B: \n");
		mostrar(cola_c);
		m.ColaCompararInverso(cola_a, cola_c);
		
		System.out.print("\n");
		System.out.print("\n -----------------");
		System.out.print("\n");
	}
	
	public static void mostrar(ColaTDA origen){
		Metodos m = new Metodos();
		ColaTDA aux = new ColaPU();
		
		aux.InicializarCola();
		m.CopiarCola(origen, aux);

		while(!aux.ColaVacia()) {
			System.out.print(" " + aux.Primero());
			aux.Desacolar();
		}
	}
}
