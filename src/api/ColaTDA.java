package api;

/** @definicion **/
public interface ColaTDA {
    /**@TAREA Inicializa la colla
     * @PARAMETROS -
     * @DEVUELVE -**/
    void InicializarCola();

    /**@TAREA Agrega un valor al final de la cola.
     * @PARAMETROS un numero del tipo integer.
     * @DEVUELVE -**/
    void Acolar(int x);

    /**@TAREA Elimina el primer valor de la cola.
     * @PARAMETROS -
     * @DEVUELVE -**/
    void Desacolar();

    /**@TAREA verifica si la cola esta vacia o no.
     * @PARAMETROS -
     * @DEVUELVE TRUE: Si no tiene datos / FALSE: Si los tiene.**/
    boolean ColaVacia();


    /**@TAREA Devuelve el primer valor de la cola.
     * @PARAMETROS -
     * @DEVUELVE Valor numerico de tipo INTEGER**/
    int Primero();
}
