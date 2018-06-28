/**
	@Autores: Federico J Parodi
	@Grupo: 3 
	@Costo de cada uno de los m�todos de la implementaci�n
	* *Colas Primero al �ltimo
*InicializarCola: Constante 
*Acolar: Lineal 
*Desacolar: Constante 
*Primero:Constante
*ColaVac�a: Constante
**/

package implementaciones.arreglos;

import api.ColaTDA;

public class ColaPU implements ColaTDA {
	int[] a;
	int indice;
		
	public void InicializarCola() {
		a = new int[100];
		indice = 0;
	}
	
	public void Acolar(int x) {
		for(int i = indice-1; i >= 0; i--) {
			a[i+1] = a[i];
		}
		a[0] = x;
		indice++;
	}
	
	public void Desacolar() {
		indice--;
	} 
	
	public boolean ColaVacia() {
		return(indice == 0);
	}
	
	public int Primero() {
		return a[indice-1];
	}	
}