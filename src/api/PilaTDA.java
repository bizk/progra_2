package api;

/**@Autores: Federico J. Parodi
@Grupo: 3
@TDA: Pila
@Definición: Estructura donde los elementos se recuperan según First in, Last out.
*/
public interface PilaTDA {
	
	/** @TAREA iniciar_pila
	* @PARAMETRO none
	* @PRECONDICION none
	* @DEVUELVE none
	* @POSTCONDICION pila_iniciada.**/
    void InicializarPila();

    /** @TAREA Agregar_valor_al_tope
	* @PARAMETRO1 valor_entero_a_acolar
	* @PRECONDICION pila_inicializada
	* @DEVUELVE none
	* @POSTCONDICION Nuevo_elemento_en_pila**/
    void Apilar(int x);
    
    /**@TAREA quitar_elemento_de_pila
	* @PARAMETRO none
	* @PRECONDICION Pila_inicializada
	* @PRECONDICION Pila_no_vacia
	* @DEVUELVE none
	* @POSTCONDICION Tope_eliminado**/
    void Desapilar();

    /**@TAREA Verificar_Pila_vacia
 	@PARAMETRO none
 	@PRECONDICION Pila_inicializada
 	@DEVUELVE V_vacia_F_hay_elementos
 	@POSTCONDICION none**/ 
    boolean PilaVacia();

   /** @TAREA obtener_tope_pila
	* @PARAMETRO none
	* @PRECONDICION Pila_inicializada
	* @PRECONDICION Pila_no_vacia
	* @DEVUELVE Ultimo_entero
	* @POSTCONDICION none**/
    int Tope();
}

