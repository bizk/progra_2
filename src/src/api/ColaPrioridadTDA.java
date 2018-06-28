package api;
/**@Autores: Federico J. Parodi
@Grupo: 3
@TDA: Cola Prioridad
@Definición: Cola cuyos elementos tienen asignados una determinada prioridad, que los ordena primero por ésta característica (de mayor prioridad a menor prioridad) y luego, entre elementos con la misma prioridad, como FIFO
*/
public interface ColaPrioridadTDA {
	
	/** @TAREA iniciar_cola_con_prioridad
		* @PARAMETRO none
		* @PRECONDICION none
		* @DEVUELVE none
		* @POSTCONDICION Cola_prioridad_iniciada.**/
	public void InicializarCola();
    
	/** @TAREA Acolar_con_prioridad
	* @PARAMETRO1 valor_entero_a_acolar
	* @PARAMETRO2 nivel_prioridad
	* @PRECONDICION Cola_inicializada
	* @DEVUELVE none
	* @POSTCONDICION Nuevo_elemento_en_cola**/
    public void AcolarPrioridad(int x, int prioridad);
    
    /**@TAREA quitar_elemento_de_cola
	* @PARAMETRO none
	* @PRECONDICION Cola_inicializada
	* @PRECONDICION Cola_no_vacia
	* @DEVUELVE none
	* @POSTCONDICION Primer_elemento_eliminado**/
    public void Desacolar();
    
    /** @TAREA obtener_primer_elemento_cola
	* @PARAMETRO none
	* @PRECONDICION Cola_inicializada
	* @PRECONDICION Cola_no_vacia
	* @DEVUELVE Primer_entero
	* @POSTCONDICION none**/ 
    public int Primero();
    
    /**@TAREA Verificar_cola_vacia
 	@PARAMETRO none
 	@PRECONDICION Cola_inicializada
 	@DEVUELVE V_vacia_F_hay_elementos
 	@POSTCONDICION none**/
    public boolean ColaVacia(); 
    
    /**@QUEHACEESTO**/
    public int Prioridad();
}
