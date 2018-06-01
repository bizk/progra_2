/*Costos de la implementacion
*Pila Tope al Ultimo 
*InicializarPila : Constante
*Apilar: Constante 
*Desapilar: Constante 
*Tope: Constante 
*PilaVacía: Constante */

package implementaciones.arreglos;

import api.PilaTDA;

public class Pilas implements PilaTDA {
		int[] a; //Arreglo en donde se guarda la info
		int indice; //Variable donde se guarda la cantidad de elementos almacenados
		
		public void InicializarPila() {
			// TODO
			a = new int [100];
			indice = 0;
		}
		
		public void Apilar(int x) {
			a[indice] = x;
			indice++;
		}
		
		public void Desapilar() {
			indice--;
		}
		
		public boolean PilaVacia() {
			return (indice == 0);
		}
		
		public int Tope() {
			return a[indice-1];
		}
}