package api;

/**@Autores: Carlos S. Yanzon
@Grupo: 3
@TDA: Diccionario Múltiple
@Definición: Cada valor que se ingresa a la estructura tiene asociada una clave, y éstas claves pueden tener asociadas un único valor
*/
public interface DiccionarioSimpleTDA {
	/** @TAREA iniciar Diccionario Simple
	* @PARAMETRO none
	* @PRECONDICION none
	* @DEVUELVE none
	* @POSTCONDICION Conjunto iniciado.
	* */
	void InicializarDiccionario();
	
	/** @TAREA Agregar clave a Diccionario Simple
	* @PARAMETRO Clave, y valor.
	* @PRECONDICION Diccionario inicializado
	* @DEVUELVE none
	* @POSTCONDICION Diccionario con un conjunto agregado.
	* */
	void Agregar(int clave, int valor);
	
	/** @TAREA Eliminar clave de Diccionario Simple.
	* @PARAMETRO Clave a eliminar.
	* @PRECONDICION Conjunto inicializada.
	* @DEVUELVE none
	* @POSTCONDICION Conjunto sin dicha clave.
	* */
	void Eliminar(int clave);
	
	/** @TAREA Recuperar valor a partir de clave de Diccionario Simple
	* @PARAMETRO Clave.
	* @PRECONDICION Diccionario inicializado y clave perteneciente a este.
	* @DEVUELVE valor asociado a la clave.
	* @POSTCONDICION none
	* */
	int Recuperar(int clave);
	
	/** @TAREA Generar un conjunto con las claves del Diccionario Simple
	* @PARAMETRO Diccionario Simple
	* @PRECONDICION Diccionario inicializado
	* @DEVUELVE ConjuntoTDA
	* @POSTCONDICION none
	* */
	ConjuntoTDA Claves();
}