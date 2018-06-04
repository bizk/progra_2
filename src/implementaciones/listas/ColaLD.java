/**
	@Autores: Federico J. Parodi
	@Grupo: 3
	@Costos de la implementación 
 			*Cola con Listas dinámicas
 			*InicializarCola: Constante
 			*Acolar: Constante
 			*Desacolar: Constante
 			*Primero: Constante
 			*ColaVacía: Constante*/



package implementaciones.listas;

import api.ColaTDA;

public class ColaLD implements ColaTDA {
Nodo primero;
Nodo ultimo;
	@Override
	public void InicializarCola() {//Costo Constante
		primero=null;
		ultimo=null;

	}

	@Override
	public void Acolar(int x) {//Costo Constante
		Nodo aux = new Nodo();
		aux.info=x;
		aux.sig=null;
		if(ultimo!=null) {
			ultimo.sig=aux;
		}
		ultimo=aux;
		if(primero==null) {
			primero= ultimo;
		}

	}

	@Override
	public void Desacolar() {//Costo Constante
		primero=primero.sig;
		if(primero==null) {
			ultimo=null;
		}
			

	}

	@Override
	public boolean ColaVacia() {//Costo Constante
		return primero==null;
	}

	@Override
	public int Primero() {//Costo Constante
		return primero.info;
	}

}
