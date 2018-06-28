package api;
/**@Autores: Carlos S. Yanzon
@Grupo: 3
@TDA: Diccionario Múltiple
@Definición: Cada valor que se ingresa a la estructura tiene asociada una clave, y éstas claves pueden tener asociadas muchos valores organizadas en un conjunto
*/
public interface DiccionarioMultipleTDA {

	/** @TAREA Inicializar el dicccionario multiple.
	* @PARAMETRO NONE
	* @PRECONDICION NONE
	* @DEVUELVE NONE
	* @POSTCONDICION Diccionario multiple inicializado.
	* */
	void InicializarDiccionario();
	
	/** @TAREA Agrega un valor y/o una clave si esta no existe.
	* @PARAMETRO Clave y valor.
	* @PRECONDICION Diccionario Inicializado y el valor no debe existir.
	* @DEVUELVE NONE.
	* @POSTCONDICION Clave con un valor agregado, o una nueva clave inicializada.
	* */
	void Agregar(int clave, int valor);
	
	/** @TAREA Elimina toda una clave.
	* @PARAMETRO Clave a eliminar.
	* @PRECONDICION Diccionario Inicializado.
	* @DEVUELVE NONE
	* @POSTCONDICION Diccionario sin dicha clave.
	* */
	void Eliminar(int clave);

	/** @TAREA Elimina un valor de una clave y/o la clave si esta tiene 1 solo valor.
	* @PARAMETRO Clave y valor a eliminar.
	* @PRECONDICION Diccionario Inicializado.
	* @DEVUELVE NONE
	* @POSTCONDICION Clave sin dicho valor, o diccionario sin clave si este valor era el unico.
	* */
	void EliminarValor(int clave, int valor);
	
	/** @TAREA Devuelve todos los valores de una clave.
	* @PARAMETRO Clave a visualisar.
	* @PRECONDICION Diccionario Inicializado.
	* @DEVUELVE Todos los valore.
	* @POSTCONDICION NONE.
	* */
	ConjuntoTDA Recuperar(int clave);
	
	/** @TAREA Devuelve todas las claves de un conjunto.
	* @PARAMETRO NONE
	* @PRECONDICION Diccionario Inicializado.
	* @DEVUELVE Todas las claves.
	* @POSTCONDICION NONE
	* */
	ConjuntoTDA Claves();
}
