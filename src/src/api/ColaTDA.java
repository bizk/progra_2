package api;

/**@Autores: Federico J. Parodi
@Grupo: 3
@TDA: Cola
@Definición: Estructura donde los elementos se recuperan como First in, First out.
*/
public interface ColaTDA {
    
	/** @TAREA iniciar_cola
		* @PARAMETRO none
		* @PRECONDICION none
		* @DEVUELVE none
		* @POSTCONDICION Cola_iniciada.**/
	void InicializarCola();
	
	/** @TAREA Agregar_valor_al_principio
	* @PARAMETRO1 valor_entero_a_acolar
	* @PRECONDICION Cola_inicializada
	* @DEVUELVE none
	* @POSTCONDICION Nuevo_elemento_en_cola**/
    void Acolar(int x);

    /**@TAREA quitar_elemento_de_cola
	* @PARAMETRO none
	* @PRECONDICION Cola_inicializada
	* @PRECONDICION Cola_no_vacia
	* @DEVUELVE none
	* @POSTCONDICION Primer_elemento_eliminado**/
    void Desacolar();

    /**@TAREA Verificar_cola_vacia
 	@PARAMETRO none
 	@PRECONDICION Cola_inicializada
 	@DEVUELVE V_vacia_F_hay_elementos
 	@POSTCONDICION none**/
    boolean ColaVacia();

    /** @TAREA obtener_primer_elemento_cola
	* @PARAMETRO none
	* @PRECONDICION Cola_inicializada
	* @PRECONDICION Cola_no_vacia
	* @DEVUELVE Primer_entero
	* @POSTCONDICION none**/ 
    int Primero();
}
