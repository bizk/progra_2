package implementaciones.arreglos;

import api.DiccionarioMultipleTDA;
import api.ConjuntoTDA;

/**@author Carlos Santiago Yanzon (BIZK) 13/04/2018*/
class DicMultipleA implements DiccionarioMultipleTDA {

	class Elemento {
		int clave;
		int [] valores;
		int cantValores;
	}
	
	Elemento[] elementos;
	int cantClaves;
	
	private int Clave2Indice(int clave) {
		int i = cantClaves-1;
		while(i >= 0 && elementos[i].clave!=clave) {
			i--;
		}
		return i;
	}
	
	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores-1;
		while(i>=0 && e.valores[i] != valor) {
			i--;
		}
		return i;
	}
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		int cantClaves = 0;
	}

	public void Agregar(int clave, int valor) {
		int posC = Clave2Indice(clave);
		if (posC == -1) {
			posC = cantClaves;
			elementos[posC] = new Elemento();
			elementos[posC].clave = clave;
			elementos[posC].cantValores = 0;
			elementos[posC].valores = new int[100];
			cantClaves++;
		}
		
		Elemento e = elementos[posC];
		int posV = Valor2Indice(e, valor);
		if (posV == -1) {
			e.valores[e.cantValores] = valor;
			e.cantValores++;
		}
	}

	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if(pos != - 1) {
			elementos[pos] = elementos[cantClaves -1];
			cantClaves--;
		}
	}

	public void EliminarValor(int clave, int valor) {
		int posC = Clave2Indice(clave);
		if(posC != -1) {
			Elemento e = elementos[posC];
			int posV = Valor2Indice(e, valor);
			if(posV != -1) {
				e.valores[posV] = e.valores[e.cantValores-1];
				e.cantValores--;
				if(e.cantValores==0) {
					Eliminar(clave);
				}
			}
		}
	}

	public ConjuntoTDA Recuperar(int clave) {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		
		int pos = Clave2Indice(clave);
		if(pos != -1) {
			Elemento e = elementos[pos];
			for(int i = 0; i<e.cantClaves; i++) {
				c.Agregar(elementos[i].clave);
			}
		}
		
		return c;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		
		for(int i = 0; i<cantClaves; i++) {
			c.Agregar(elementos[i].clave);
		}
		
		return c;
	}	
}