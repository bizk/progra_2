package api;

/**@author Federico Parodi**/
public interface ConjuntoTDA {
	/** @TAREA iniciar Conjunto
	* @PARAMETRO none
	* @PRECONDICION none
	* @DEVUELVE none
	* @POSTCONDICION Conjunto iniciado.**/
	void InicializarConjunto();
	
	/** @TAREA Determinar si el conjunto es vacio
	* @PARAMETRO none
	* @PRECONDICION Conjunto Inicializado
	* @DEVUELVE V si vacio, F si no vacio
	* @POSTCONDICION none.**/
	boolean ConjuntoVacio();
	
	/** @TAREA Agregar elemento al conjunto
	* @PARAMETRO Entero
	* @PRECONDICION Conjunto Inicializado
	* @DEVUELVE none
	* @POSTCONDICION Elemento agregado.**/
	void AgregarConjunto(int x);
	
	/** @TAREA Obtener un elemento cualquiera del conjunto
	* @PARAMETRO none
	* @PRECONDICION Conjunto Inicializado, no vacío.
	* @DEVUELVE Entero
	* @POSTCONDICION none**/
	int ElegirConjunto();
	
	/** @TAREA Sacar un elemento dado del conjunto
	* @PARAMETRO Entero
	* @PRECONDICION Conjunto Inicializado, no vacio.
	* @DEVUELVE none
	* @POSTCONDICION Elemento indicado queda eliminado si es encontrado.**/
	void SacarConjunto(int x);
	
	/** @TAREA Determina si un elemento pertenece al conjunto
	* @PARAMETRO Entero
	* @PRECONDICION Conjunto Inicializado.
	* @DEVUELVE V si encuentra, F si no encuentra.
	* @POSTCONDICION none**/
	boolean PerteneceConjunto();
}
