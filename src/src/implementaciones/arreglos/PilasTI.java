/**
	@Autores:Santiago Cerfoglio
	@Grupo:
	@Costo de cada uno de los métodos de la implementación* 
* Pila Tope al Inicio 
*InicializarPila :Constante
*Apilar:  Lineal 
*Desapilar:  Lineal 
*Tope:Constante 
*PilaVacía: Constante*/




package implementaciones.arreglos;

import api.PilaTDA;

public class PilasTI implements PilaTDA{
	int a[];
	int indice;

	public void InicializarPila(){
		a = new int [100];
		indice = 0;
	}

	public void Apilar(int x){
		for(int i = indice - 1; i >= 0; i--)
			a[i + 1] = a[i];
		a[0] = x;
		indice++;
	}

	public void Desapilar(){
		for(int i = 0; i < indice; i++)
			a[i]= a[i + 1];
		indice--;
	}

	public boolean PilaVacia(){
		return (indice == 0);
	}

	public int Tope(){
		return a[0];
	}
}