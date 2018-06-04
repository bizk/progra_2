package implementaciones.arreglos;

import api.ConjuntoTDA;
/**@Autores:Federico J Parodi	
	@Grupo:3
	@Costo de cada uno de los métodos de la implementación
	* *Conjunto Tamaño máximo no Acotado (UA) 
*InicializarConjunto: Constante 
*Agregar: Lineal 
*Sacar: Lineal
*Pertenece: Lineal 
*Elegir: Constante
 **/
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
		if (point==(indice-1))
			;//no hace nada pq solo es necesario decrementar el tamaño del vector
		else
			vector[point]=vector[indice-1];//reemplaza el valor a eliminar por el ultimo elemento agregado
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
