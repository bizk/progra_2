package api;
/**@Autores: Federico J. Parodi
@Grupo: 3
@TDA: Grafo
@Definición: Conjunto de elementos llamados nodos unidos por aristas con peso. Representan redes.
*/
public interface GrafoTDA {
	/** @TAREA iniciar Grafo
	* @PARAMETRO none
	* @PRECONDICION none
	* @DEVUELVE none
	* @POSTCONDICION Grafo iniciado.
	* */
	void InicializarGrafo();
	
	/** @TAREA Agregar Vértice
	* @PARAMETRO Entero
	* @PRECONDICION Grafo inicializado, nodo con el valor no existente
	* @DEVUELVE none
	* @POSTCONDICION Nodo agregado
	* */
	void AgregarVertice(int v);
	/** @TAREA Eliminar un vértice
	* @PARAMETRO Entero
	* @PRECONDICION Grafo inicializado, Nodo con el valor existe
	* @DEVUELVE none
	* @POSTCONDICION Vertice eliminado
	* */
	void EliminarVertice(int v);
	/** @TAREA Devolver los vertices de un grafo
	* @PARAMETRO none
	* @PRECONDICION Grafo inicializado
	* @DEVUELVE none
	* @POSTCONDICION none
	* */
	ConjuntoTDA Vertices();
	/** @TAREA Agregar una arista desde el nodo 1 al 2.
	* @PARAMETRO Vertice 1, vertice 2, entero del peso de la arista
	* @PRECONDICION Grafo inicializado, nodos con los valores existan y arista no existente
	* @DEVUELVE none
	* @POSTCONDICION Arista creada
	* */
	void AgregarArista(int v1, int v2, int peso);
	/** @TAREA Eliminar una arista desde el nodo 1 al 2.
	* @PARAMETRO Vertice 1, vertice 2
	* @PRECONDICION Grafo inicializado, nodos con los valores existan
	* @DEVUELVE none
	* @POSTCONDICION Arista Eliminada
	* */
	void EliminarArista(int v1, int v2);
	/** @TAREA Verificar si existe una arista desde el nodo 1 al 2.
	* @PARAMETRO Vertice 1, vertice 2
	* @PRECONDICION Grafo inicializado, nodos con los valores existen
	* @DEVUELVE True si la hay, False si no.
	* @POSTCONDICION none
	* */
	boolean ExisteArista(int v1, int v2);
	/** @TAREA Verificar el peso de una arista que va del nodo 1 al nodo 2
	* @PARAMETRO Vertice 1, vertice 2
	* @PRECONDICION Grafo inicializado, nodos con los valores existan y arista existente
	* @DEVUELVE entero
	* @POSTCONDICION none
	* */
	int PesoArista(int v1, int v2);
}
