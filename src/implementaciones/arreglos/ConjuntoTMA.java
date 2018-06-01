/** Costos implementación
 *  Tamaño Máximo Acotado (TMA)
*InicializarConjunto:  Constante
*Agregar:  Constante
*Sacar:  Constante
*Pertenece:  Constante
*Elegir:  Constante*/

package implementaciones.arreglos;

import api.ConjuntoTDA;
/**@Author Federico Parodi **/
public class ConjuntoTMA implements ConjuntoTDA {
	int vector[]; 
	int indice;
	public void InicializarConjunto() {//El conjunto es un vector de N posiciones que puede almacenar datos de 0 a N-1
		 vector=new int[100];
		 indice=0;
		 for( ;indice<100;indice++) {
			 vector[indice]=0; //Que el vector contenga un 0 en la posicion X indica que el valor X no pertenece al conjunto
		 }
	}

	public boolean ConjuntoVacio() {
		boolean vacio=true;
		indice=0;
		while(indice<100&&vacio){//El conjunto está vacío siempre y cuando todo el contenido del vector sea 0s y el índice llegue a la posición N-1
			if(vector[indice]!=0) {
				vacio=false;
			}
			indice++;
		}
		return vacio;
	}

	public void AgregarConjunto(int x) {
		/*if(x>=100)
			System.out.println("El valor debe estar entre 0 y 99");
		else No recuerdo si hay que comprobar que el valor pueda entrar al conjunto o se puede suponer*/
		indice=x;
		vector[indice]=1;

	}

	public int ElegirConjunto() {
		indice=0;	//No hago que directamente devuelva el índice pq quizá es una posición vacía
		while(indice<100&&vector[indice]==0)
			indice++; //devolverá el primer valor del conjunto
		return indice;
	}


	public void SacarConjunto(int x) {
		indice=x;
		vector[indice]=0;

	}

	public boolean PerteneceConjunto(int x) {
		if(vector[x]==1) {
			return true;
		}
		else {
			return false;
		}
		
	}



}
