package implementaciones.listas;

import api.ConjuntoTDA;
/**
@Autores: Gonzalo Bacigalupe
@Grupo: 3 
@Costo de cada uno de los métodos de la implementación
Inicializar: constante
Agregar: Lineal
Sacar: lineal
Pertenece: lineal
Elegir: Constante.
**/

public class ConjuntoLD implements ConjuntoTDA {

	Nodo c;
	@Override
	public void InicializarConjunto() {
		c=null;

	}

	@Override
	public boolean ConjuntoVacio() {
		
		return (c==null);
	}

	@Override
	public void AgregarConjunto(int x) {
		if (!this.PerteneceConjunto(x)) {
			Nodo aux=new Nodo();
			aux.info=x;
			aux.sig=c;
			c=aux;
		}

	}

	@Override
	public int ElegirConjunto() {
		return c.info;
	}

	@Override
	public void SacarConjunto(int x) {
		if(c!=null) {
			if(c.info==x) {
				c=c.sig;
			} else {
				Nodo aux=c;
				while(aux.sig!=null&&aux.sig.info!=x)
					aux=aux.sig;
				if (aux.sig!=null)
					aux.sig=aux.sig.sig;
			}
		}
	}

	@Override
	public boolean PerteneceConjunto(int x) {
		Nodo aux = c;
		while((aux!=null)&&(aux.info!=x)) {
			aux=aux.sig;
		}
		return (aux!=null);
	}

}
