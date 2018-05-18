package api;

public interface ABBTDA {
//Creada por Federico J.Parodi - 4.05.2018
	/** @TAREA Devolver la raiz del arbol
	* @PARAMETRO none
	* @PRECONDICION Arbol inicializado y no vacío
	* @DEVUELVE Entero
	* @POSTCONDICION none.**/
	public int Raiz();
	
	/** @TAREA Devolver hijo izquierdo del arbol seleccionado
	* @PARAMETRO none
	* @PRECONDICION Arbol inicializado y no vacio
	* @DEVUELVE ABBTDA
	* @POSTCONDICION none**/
	public ABBTDA HijoIzq();
	
	/** @TAREA Devolver hijo derecho del arbol seleccionado
	* @PARAMETRO none
	* @PRECONDICION Arbol inicializado y no vacio
	* @DEVUELVE ABBTDA
	* @POSTCONDICION none**/
	public ABBTDA HijoDer();
	
	/** @TAREA Devolver verdadero o falso según el árbol esté vacío
	* @PARAMETRO none
	* @PRECONDICION Arbol inicializado
	* @DEVUELVE Boolean
	* @POSTCONDICION none**/
	public boolean ArbolVacio();
	
	/** @TAREA Iniciar Arbol
	* @PARAMETRO none
	* @PRECONDICION none
	* @DEVUELVE none
	* @POSTCONDICION Arbol creado**/
	public void InicializarArbol();
	
	/** @TAREA Agregar elemento a un árbol
	* @PARAMETRO Entero
	* @PRECONDICION Arbol inicializado
	* @DEVUELVE none
	* @POSTCONDICION Elemento agregado**/
	public void AgregarElem(int x);
	
	/** @TAREA Eliminar un elemento de un arbol
	* @PARAMETRO Entero
	* @PRECONDICION Arbol inicializado, Elemento perteneciente al árbol.
	* @DEVUELVE none
	* @POSTCONDICION Elemento eliminado del arbol.**/
	public void EliminarElem(int x);
	
}
