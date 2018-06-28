package implementaciones.listas;

import api.ConjuntoTDA;
import api.GrafoTDA;
/**@Autores: Federico J. Parodi 
@Grupo: 3 
@Costo de cada uno de los métodos de la implementación
Inicializar: Constante
Agregar Vertice: Constante
Eliminar Vertice: Tanto como si se tiene en cuenta que EliminarAristaNodo es lineal como si no, es lineal. 
Vertices: Lineal
AgregarArista: Si se tiene en cuenta que Vert2Nodo es lineal, Lineal. Si no, Constante
EliminarArista: Si se tiene en cuenta que Vert2Nodo y EliminarAristaNodo son lineales, Lineal. Si no, Constante
ExisteArista: Tanto como si se tiene en cuenta que Vert2Nodo es lineal como si no,es Lineal.
PesoArista: Tanto como si se tiene en cuenta que Vert2Nodo es lineal como si no,es Lineal.
*/
public class GrafoLA implements GrafoTDA {
	NodoGrafo origen;
	@Override
	public void InicializarGrafo() {
		origen = null;

	}

	@Override
	public void AgregarVertice(int v) {
		//el vertice se inserta al inicio de la lista de nodos.
		NodoGrafo aux = new NodoGrafo();
		aux.nodo=v;
		aux.arista=null;
		aux.sigNodo=origen;
		origen=aux;
	}

	@Override
	public void EliminarVertice(int v) {
		//se recorre la lista de vértices para eliminar el nodo V y las aristas con este vértice.
		
		if(origen.nodo==v) {//si es el primer nodo
			origen=origen.sigNodo;
		}
		NodoGrafo aux=origen;
		while(aux!=null) {
			//remueve de aux todas las aristas hacia v
			this.EliminarAristaNodo(aux,v);
			if(aux.sigNodo!=null&&aux.sigNodo.nodo==v) {
				//si el siguiente nodo de aux es v, lo elimina.
				aux.sigNodo=aux.sigNodo.sigNodo;
			}
			aux=aux.sigNodo;
		}

	}
	private void EliminarAristaNodo(NodoGrafo nodo, int v) {
		NodoArista aux= nodo.arista;
		if(aux!=null) {
			//si la arista a eliminar es la primera
			if(aux.nodoDestino.nodo==v) {
				nodo.arista=aux.sigArista;
			}
			else {
				while(aux.sigArista!=null && aux.sigArista.nodoDestino.nodo!=v) {
					aux=aux.sigArista;
				}
				if(aux.sigArista!=null) {
					//quita la referencia a la arista hacia v
					aux.sigArista=aux.sigArista.sigArista;
				}
			}
		}
	}

	@Override
	public ConjuntoTDA Vertices() {
		ConjuntoTDA c = new ConjuntoLD();
		c.InicializarConjunto();
		NodoGrafo aux=origen;
		while(aux!=null) {
			c.AgregarConjunto(aux.nodo);
			aux=aux.sigNodo;
		}
		return c;
	}

	@Override
	public void AgregarArista(int v1, int v2, int peso) {
		NodoGrafo n1=Vert2Nodo(v1);
		NodoGrafo n2=Vert2Nodo(v2);
		//la nueva arista se inserta al inicio de la lista de nodos adyacentes del nodo origen
		NodoArista aux=new NodoArista();
		aux.etiqueta=peso;
		aux.nodoDestino=n2;
		aux.sigArista=n1.arista;
		n1.arista=aux;
	}
	private NodoGrafo Vert2Nodo(int v) {
		NodoGrafo aux=origen;
		while(aux!=null &&aux.nodo!=v) {
			aux=aux.sigNodo;
		}
		return aux;
	}
	
	@Override
	public void EliminarArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		EliminarAristaNodo(n1,v2);
	}

	@Override
	public boolean ExisteArista(int v1, int v2) {
		NodoGrafo n1= Vert2Nodo(v1);
		NodoArista aux = n1.arista;
		while(aux!=null && aux.nodoDestino.nodo!=v2) {
			aux=aux.sigArista;
		}
		//solo si encontro la arista buscada, aux no es null
		return aux!=null;
	}

	@Override
	public int PesoArista(int v1, int v2) {
		NodoGrafo n1 = Vert2Nodo(v1);
		NodoArista aux= n1.arista;
		while(aux.nodoDestino.nodo !=v2) {
			aux=aux.sigArista;
		}
		//Se encontró la arista entre los nodos
		return aux.etiqueta;
	}

}
