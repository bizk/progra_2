package implementaciones.arreglos;

import api.PilaTDA;

public class PilaLD implements PilaTDA {
	Nodo primero;
	@Override
	public void InicializarPila() {//Costo Constante
		primero=null;
	}

	@Override
	public void Apilar(int x) {//Costo Constante
		Nodo aux= new Nodo();
		aux.info= x;
		aux.sig=primero;
		primero=aux;

	}

	@Override
	public void Desapilar() {//Costo Constante
		primero=primero.sig;
	}

	@Override
	public boolean PilaVacia() {//Costo Constante
		return (primero==null);
	}

	@Override
	public int Tope() {//Costo Constante
		return primero.info;
	}

}
