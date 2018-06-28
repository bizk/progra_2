package implementaciones.arreglos;

import api.DiccionarioSimpleTDA;
import api.ConjuntoTDA;


/**
@Autores: Carlos S. Yanzon
@Grupo: 3 
@Costo de cada uno de los métodos de la implementación
*DiccionarioSimple 
*Inicializar diccionario: Constante 
*Agregar: Lineal 
*Eliminar: Lineal 
*EliminarValor: - 
*Recuperar: Lineal 
*Claves: Lineal 
**/

public class DicSimpleA implements DiccionarioSimpleTDA {
	
	class Elemento {
		int clave;
		int valor;
	}
	
	Elemento[] elementos;
	int cant;
	
	public void InicializarDiccionario() {
		cant = 0;
		elementos = new Elemento[100];
	}
	
	public void Agregar(int clave, int valor) {
		int pos = Clave2Indice(clave);
		if (pos == -1) {
			pos = cant;
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant++;
		}
		elementos[pos].valor = valor;
	}
	
	private int Clave2Indice(int clave) {
		int i = cant-1;
		while(i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;
	}
	
	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if(pos != -1) {
			elementos[pos] = elementos[cant-1];
			cant--;
		}
	}
	
	
	public int Recuperar(int clave) {
		int pos = Clave2Indice(clave);
		return elementos[pos].valor;
	}
	
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new ConjuntoUA();
		c.InicializarConjunto();
		
		for(int i = 0; i < cant; i++) {
			c.AgregarConjunto(elementos[i].clave);
		}
		return c;
	}


}