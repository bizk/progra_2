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
		for(int 1 = 0; i < indice; i++)
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