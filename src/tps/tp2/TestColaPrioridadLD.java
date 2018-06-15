package tps.tp2;
/**@Autor Federico Parodi
* @Grupo 3
*/
import api.ColaPrioridadTDA;
import implementaciones.listas.*;
import utilidades.*;
import java.util.Scanner;

@SuppressWarnings("resource")
public class TestColaPrioridadLD {

		public static void main(String[] args){
			Metodos m=new Metodos();
			
			ColaPrioridadTDA ColaPriori_a= new ColaPrioridadLD();
			ColaPrioridadTDA ColaPriori_b= new ColaPrioridadLD();
			ColaPrioridadTDA ColaPriori_c= new ColaPrioridadLD();
			ColaPrioridadTDA aux1= new ColaPrioridadLD();
			
			Scanner atr = new Scanner(System.in);
			
			ColaPriori_a.InicializarCola();
			ColaPriori_b.InicializarCola();
			ColaPriori_c.InicializarCola();
			aux1.InicializarCola();
			
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
			System.out.println("\n");
					
			
			
			System.out.println("#####Arranca Testeo#####");
			System.out.println("###Comprobar Identidad");
			aux=m.ComprobarIdentidad(ColaPriori_a, ColaPriori_b);
			System.out.println(aux);
			
			System.out.println("###Combinar Cola Prioridad");
			
			aux1=m.CombinarColasPrioridad(ColaPriori_a, ColaPriori_b);
			mostrar(aux1);
			
			System.out.println("\n");
			
	}
		public static void mostrar(ColaPrioridadTDA origen){
			Metodos m = new Metodos();
			
			ColaPrioridadTDA aux = new ColaPrioridadLD();
			aux.InicializarCola();
			m.CopiarColaPri(origen, aux);
			//m.InvertirPila(aux);

			while(!aux.ColaVacia()) {
				System.out.print(" " + aux.Primero());
				aux.Desacolar();
			}
		}

}
