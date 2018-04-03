package api;

/** @definicion **/
public interface PilaTDA {
    /**@TAREA Inicializa la pila
     * @PARAMETROS -
     * @DEVUELVE -**/
    void InicializarPila();

    /**@TAREA Agrega un valor a lo mas alto de la pila.
     * @PARAMETROS un numero del tipo integer.
     * @DEVUELVE -**/
    void Apilar(int x);
    
 
    /**@TAREA Elimina el ultimo valor de la pila.
     * @PARAMETROS -
     * @DEVUELVE -**/
    void Desapilar();

    /**@TAREA verifica si la pila esta vacia o no.
     * @PARAMETROS -
     * @DEVUELVE TRUE: Si no tiene datos / FALSE: Si los tiene.**/
    boolean PilaVacia();

    /**@TAREA Devuelve el ultimo valor de la pila.
     * @PARAMETROS -
     * @DEVUELVE Valor numerico de tipo INTEGER**/
    int Tope();
}

