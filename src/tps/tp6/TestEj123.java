package tps.tp6;

import api.GrafoTDA;
import api.ConjuntoTDA;
import implementaciones.listas.*;
import implementaciones.arreglos.*;
import utilidades.Metodos;
/*Autor: Federico Parodi
 * Grupo 3*/
public class TestEj123 {
	public static void main(String[] args) {
		GrafoTDA G = new GrafoMA();
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
		System.out.println("Eliminaremos la arista del nodo 1 al nodo 3");
		G.EliminarArista(1, 3);
		mostrarg(G);
		System.out.println("Eliminaremos el nodo 2");
		G.EliminarVertice(2);
		mostrarg(G);
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
}
