package implementaciones.arreglos;

import api.ColaPrioridadTDA;

public class ColaPrioridadDA implements ColaPrioridadTDA {
	int[] elementos;
	int[] prioridades;
	int indice;
	
	public void InicializarCola() {
		elementos = new int [100];
		prioridades = new int [100];
		indice = 0;
	}
	
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;//Ultimo lugar, donde agregaría el elemento
		for(; j>0 && prioridades[j-1] >= prioridad; j--) {//Mientras la prioridad del elemento del array sea mayor a la del elemento que quiero agregar, sigo el ciclo
			elementos[j] = elementos[j-1];
			prioridades[j] = prioridades[j-1];
		}
		elementos[j] = x;
		prioridades[j] = prioridad;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	}
	
	public int Primero() {
		return elementos[indice-1];
	}
	
	public boolean ColaVacia() {
		return(indice == 0);
	}
	
	public int Prioridad() {
		return prioridades[indice-1];
	}
}
