package tps.tp6;

import api.GrafoTDA;
import api.ConjuntoTDA;
import implementaciones.listas.*;
import utilidades.Metodos;

public class TestPunto456789 {
	public static void main(String[] args) {
		Metodos m = new Metodos();
		GrafoTDA G = new GrafoLA();
		G.InicializarGrafo();
		G.AgregarVertice(1);
		G.AgregarVertice(2);
		G.AgregarVertice(3);
		G.AgregarVertice(4);
		G.AgregarVertice(5);
		G.AgregarArista(1, 2, 10);
		G.AgregarArista(1, 3, 20);
		G.AgregarArista(1, 4, 50);
		G.AgregarArista(2, 1, 42);
		G.AgregarArista(2, 2, 10);
		G.AgregarArista(4, 5, 70);
		G.AgregarArista(3, 1, 5);
		G.AgregarArista(3, 5, 89);
		G.AgregarArista(5,1, 40);
		G.AgregarArista(5, 2, 90);
		mostrarg(G);
		System.out.println("Punto 4: Los adyacentes dobles de 1 son:");
		mostrar(m.GAdyacentesDobles(G, 1));
		System.out.println("Punto 5: El mayor costo de una arista saliente de 1 es: "+ m.GAristaMay(G, 1));
		System.out.println("Punto 6: Los predecesores de 1 son:");
		mostrar(m.GPredecesores(G, 1));
		System.out.println("Punto 7: El conjunto de vértices aislados del grafo es:");
		mostrar(m.GVertAislados(G));
		System.out.println("Punto 8: Los puentes entre 1 y 5 son:");
		mostrar(m.GPuentes(G, 1, 5));
		System.out.println("Punto 9: El grado del vertice 1 es: "+ m.GGradoVert(G, 1));
		
		
		
	}
	private static void mostrarg(GrafoTDA G) {
		Metodos m = new Metodos();
		ConjuntoTDA vert = G.Vertices();
		ConjuntoTDA aux = new ConjuntoLD();
		m.CopiarConjunto(vert, aux);
		System.out.println("El grafo se mostrará de la siguiente forma:");
		System.out.println("Valor vértice");
		System.out.println("	--(Peso arista)->Vertice destino");
		while(!vert.ConjuntoVacio()) {
			System.out.println("" + vert.ElegirConjunto()+":");
			while(!aux.ConjuntoVacio()) {
				if(G.ExisteArista(vert.ElegirConjunto(), aux.ElegirConjunto())) {
					System.out.println("	--("+G.PesoArista(vert.ElegirConjunto(), aux.ElegirConjunto())+")->"+ aux.ElegirConjunto());
				}
				aux.SacarConjunto(aux.ElegirConjunto());
			}
			m.CopiarConjunto(G.Vertices(), aux);
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		
	}
	public static void mostrar(ConjuntoTDA origen) {
		ConjuntoTDA aux = new ConjuntoLD();
		
		Metodos m = new Metodos();
		
		aux.InicializarConjunto();
		
		int x;
		m.CopiarConjunto(origen, aux);
		if(aux.ConjuntoVacio())
			System.out.println("El conjunto está vacío");
		while(!aux.ConjuntoVacio()){
			x = aux.ElegirConjunto();
			System.out.print(" " + x);
			aux.SacarConjunto(x);
		}
		System.out.println(" ");
	}
}