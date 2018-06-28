package implementaciones.listas;

import api.ABBTDA;
/**
@Autores:Federico J. Parodi	
@Grupo:3
@Costo Raiz: Constante, HijoIzq: Constante, HijoDer: Constante, ArbolVac�o: Constante, InicializarArbol: Constante, AgregarElemento: Recursivo, EliminarElemento: Recursivo.
**/

public class ABB implements ABBTDA {
	NodoABB raiz;
	@Override
	public int Raiz() {
		return raiz.info;
	}

	@Override
	public ABBTDA HijoIzq() {
		return raiz.hijoIzq;
	}

	@Override
	public ABBTDA HijoDer() {
	
		return raiz.hijoDer;
	}

	@Override
	public boolean ArbolVacio() {
		return (raiz==null);
	}

	@Override
	public void InicializarArbol() {
		raiz=null;

	}

	@Override
	public void AgregarElem(int x) {
		if(raiz==null) { //Si el arbol es vac�o
			raiz=new NodoABB();
			raiz.info= x;
			raiz.hijoIzq = new ABB();
			raiz.hijoIzq.InicializarArbol();
			raiz.hijoDer = new ABB();
			raiz.hijoDer.InicializarArbol();
		}
		else if (raiz.info > x) { //Si el arbol no es vac�o y x es mayor que la raiz
			raiz.hijoIzq.AgregarElem(x); //Se llama al hijo izquierdo y se lo busca agregar en �l
		}
		else if (raiz.info < x) { //Si el arbol no es vac�o y x es menor que la ra�z
			raiz.hijoDer.AgregarElem(x);
		}
	}

	@Override
	public void EliminarElem(int x) {
		if (raiz!= null) {
			if(raiz.info==x && raiz.hijoIzq.ArbolVacio() && raiz.hijoDer.ArbolVacio()) { //Si encontr� una hoja
				raiz = null; //La elimino
			}
			else if(raiz.info==x && !raiz.hijoIzq.ArbolVacio()) { //Si encontr� el valor pero hay arboles a la izq
				raiz.info=this.mayor(raiz.hijoIzq); //reemplazo el valor con el mayor valor del hijo izquierdo
				raiz.hijoIzq.EliminarElem(raiz.info); //Elimino el valor repetido desde el hijo izquierdo (Si tomo la raiz, va a "cometer suicidio")
			}
			else if (raiz.info==x && !raiz.hijoDer.ArbolVacio()) { //Si encontr� el valor pero hay �rboles a la der
				raiz.info=this.menor(raiz.hijoDer); //reemplazo el valor con el menor valor del hijo derecho
				raiz.hijoDer.EliminarElem(raiz.info);//Elimino el valor repetido desde el hijo derecho (Para no suicidarlo)
			}
			else if (raiz.info<x) {//el valor es mayor que la raiz del arbol donde me posiciono
				raiz.hijoDer.EliminarElem(x);//Paso al hijo derecho y vuelvo a llamar al m�todo para que eval�e igualdad.
			}
			else { //el valor es menor que la raiz del arbol donde me posiciono
				raiz.hijoIzq.EliminarElem(x); //same
			}
		}

	}
	
	private int mayor (ABBTDA a) {
		if (a.HijoDer().ArbolVacio()) { //si el hijo derecho est� vac�o
			return a.Raiz(); //es el valor mas alto
		}
		else { 
			return mayor(a.HijoDer()); //busca el valor mas alto en el hijo derecho
		}
	}
	private int menor (ABBTDA a) {
		if (a.HijoIzq().ArbolVacio()) { //si el hijo izquierdo esta vac�o
			return a.Raiz(); //es el valor mas bajo
		}
		else {
			return menor(a.HijoIzq()); //busca el valor mas bajo en el hijo izquierdo
		}
	}
}

