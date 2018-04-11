package implementaciones.arreglos;

import api.ConjuntoTDA;
/**@Author Federico Parodi **/
public class ConjuntoUA extends ColaPU implements ConjuntoTDA {
int vector[];
int indice;
	
	public void InicializarConjunto() {
		vector= new int[100];//Este tipo de conjunto es un vector con N posiciones, por lo que puede almacenar N elementos pero éstos pueden tomar cualquier valor
		indice=0;
	}

	public boolean ConjuntoVacio() {
		if(indice==0)
			return true;
		else
			return false;
	}
	
	public void AgregarConjunto(int x) {
		vector[indice]=x;
		indice++;
	}

	public int ElegirConjunto() {
		return vector[indice-1];//devuelve el ultimo elemento agregado al conjunto
	}

	public void SacarConjunto(int x) {
		int point=0;
		while(vector[point]!=x) {
			point++;
		}
		while(point<indice) {
			vector[point]=vector[point+1];
		}
		indice--;
	}
	
	public boolean PerteneceConjunto(int x) {
		boolean pertenece=false;
		int point=0;
		while(!pertenece&&point<indice) {//recorre el vector hasta el índice comparando los valores que almacena con el valor buscado
			if(vector[point]==x)
				pertenece=true;
			point++;
		}
		return pertenece;
	}

}
