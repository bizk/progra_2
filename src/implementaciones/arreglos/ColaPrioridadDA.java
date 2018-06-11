
/**@Autores: Santiago Salvioli
	@Grupo: 3
	@Costo de cada uno de los métodos de la implementación
	 ColaPrioridad de Dos Arreglos
*InicializarColaPrioridad: Constante 
*AcolarPrioridad: Lineal (2.n) 
*Desacolar: Constante 
*Primero: Constante 
*ColaVacía:Constante 
*Prioridad:Constante
*/
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
		int j = indice;
		for( ;j>0 && prioridades[j-1] >= prioridad; j--) {
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