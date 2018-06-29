package utilidades;

/* @Autores Carlos S. Yanzon, Federico Parodi, Santiago Salvioli, Gonzalo Bacigalupe, Santiago Cerfoglio
@Grupo 3
*/

import api.*;
import implementaciones.arreglos.*;
import implementaciones.listas.*;

public class Metodos {

	/**
	 * @TAREA Pasar contenido de una pila a otra en orden inverso
	 * @PARAMETRO pila original
	 * @PARAMETRO pila destino
	 * @PRECONDICON Ambas pilas iniciadas
	 * @POSTCONDICON Se pierde la pila original
	 * @COSTO Lineal
	 **/
	public void PasarPila(PilaTDA origen, PilaTDA destino) {
		while (!origen.PilaVacia()) {
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}

	/**
	 * @TAREA Copiar contenido de una pila a otra
	 * @PARAMETRO pila original
	 * @PARAMETRO pila destino
	 * @PRECONDICION Ambas pilas iniciadas
	 * @POSTCONDICION none
	 * * @COSTO Lineal
	 **/
	public void CopiarPila(PilaTDA origen, PilaTDA destino) {// Fedejp corregido
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		PasarPila(origen, aux);
		while (!aux.PilaVacia()) {
			origen.Apilar(aux.Tope());
			destino.Apilar(aux.Tope());
			aux.Desapilar();
		}

	}

	/**
	 * @TAREA Invertir el contenido de una pila
	 * @PARAMETRO pila original
	 * @PRECONDICIOn pila iniciada
	 * @POSTCONDICON la pila original se devuelve invertida
	 * * @COSTO Lineal
	 **/
	public void InvertirPila(PilaTDA origen) {
		PilaTDA aux = new Pilas();
		aux.InicializarPila();

		PasarPila(origen, aux);
		// origen = aux;
		CopiarPila(aux, origen);
	}

	/**
	 * @TAREA Contar la cantidad de elementos de una pila
	 * @PARAMETRO pila a contar
	 * @PRECONDICION pila iniciada
	 * @DEVUELVE integer que representa la cantidad de elementos
	 * @POSTCONDICION none
	 * * @COSTO Lineal
	 **/
	public int ContarElemPila(PilaTDA origen) {
		int x = 0;
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		// Agrego funcion para no perder pila original -Fedejp
		while (!origen.PilaVacia()) {
			x++;
			aux.Apilar(origen.Tope());
			origen.Desapilar();
		}
		while (!aux.PilaVacia()) {
			origen.Apilar(aux.Tope());
			aux.Desapilar();
		}

		return x;
	}

	/**
	 * @TAREA Sumar los elementos de una pila
	 * @PARAMETRO pila a sumar
	 * @PRECONDICION pila iniciada
	 * @DEVUELVE integer que representa la suma de los elementos
	 * @POSTCONDICION none
	 * * @COSTO Lineal
	 **/
	public int SumarElemPIla(PilaTDA origen) {
		int x = 0;
		// Agrego funcion para no perder pila original -Fedejp
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		CopiarPila(origen, aux);
		
		while (!aux.PilaVacia()) { // mientras que la pila tenga elementos
			x += aux.Tope(); // se suma el valor del tope a x
			aux.Desapilar(); // desapila en origen
		}
		
		return x;
	}

	/**
	 * @TAREA Calcular promedio de los elementos de una pila
	 * @PARAMETRO pila a promediar
	 * @PRECONDICION pila iniciada
	 * @DEVUELVE double que representa el promedio de los elementos
	 * @POSTCONDICION none
	 * * @COSTO Lineal (por la utilizaciÃ³n de mÃ©todos con costo lineal)
	 **/
	public float PromedioElemPila(PilaTDA origen) {
		float z;
		float x = SumarElemPIla(origen); // x es la suma de elementos que devuelve el metodo
		float y = ContarElemPila(origen); // y es la cantidad de elementos que devuelve el metodo
		z = x/y;
		return (z); // se devuelve la divisiÃ³n
	}

	//TP 3 - 1.A Cerfoglio (29/05/2018)
		/**@TAREA comprobar si una pila es capicua
		* @PARAMETRO PilaTDA
		* @PRECONDICON Pila inicializada
		* @POSTCONDICON None
	 * * @COSTO Lineal
		**/
	public boolean EsCapicua (PilaTDA P){
		boolean capi = true, par;
		int cant, mitad;
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		PilaTDA aux2 = new Pilas();
		aux2.InicializarPila();
		CopiarPila(P, aux);
		PasarPila(aux, aux2);
		CopiarPila(P, aux);
		cant = ContarElemPila(aux);
		mitad = cant / 2;
		
		par = (cant % 2 == 0);
		while(mitad > 0){
			aux.Apilar(aux2.Tope());
			aux2.Desapilar();
			mitad--;
		}
		if(!par){
			aux2.Desapilar();
		}
		while(!aux2.PilaVacia()){
			if(aux2.Tope() != aux.Tope()){
				capi = false;
			}
			aux2.Desapilar();
			aux.Desapilar();
		}
		return capi;
	}

	//TP 3 - 1.B Cerfoglio (30/05/2018) - Corregido por Parodi
		/**@TAREA eliminar elementos repetidos
		* @PARAMETRO PilaTDA
		* @PRECONDICON Pila Inicializada
		* @POSTCONDICON Se eliminan las repeticiones, pero se respeta el orden original
	 * * @COSTO Lineal
		**/
	public void EliminarElemRepetidos(PilaTDA P){
	PilaTDA aux = new Pilas();
		aux.InicializarPila();
		PasarPila(P,aux);
		PilaTDA aux2 = new Pilas();
		aux2.InicializarPila();
		
		while(!aux.PilaVacia()){
			if(!PertenecePila(aux.Tope(), aux2))
				aux2.Apilar(aux.Tope());
			aux.Desapilar();
		}
		CopiarPila(aux2, P);
		
	}

	//TP 3 - 1.C Cerfoglio (30/05/2018)
		/**@TAREA repartir pila en dos mitades
		* @PARAMETRO PilaTDA
		* @PRECONDICON Pila inicializada, cantidad de elementos 0 o par
		* @POSTCONDICON Pila original almacena la primer mitad, pila devuelta con la segunda
		* @DEVUELVE PilaTDA 
	 * * @COSTO Lineal
		
		**/
	public PilaTDA DividirPila(PilaTDA P){
		int cant;
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		PilaTDA M1 = new Pilas();
		M1.InicializarPila();
		PilaTDA M2 = new Pilas();
		M2.InicializarPila();
		PasarPila(P, aux);
		
		cant = ContarElemPila(aux);
		for(int i = 0; i < cant / 2; i++){
			M1.Apilar(aux.Tope());
			aux.Desapilar();
		}
		for(int i = (cant / 2); i < cant; i++){
			M2.Apilar(aux.Tope());
			aux.Desapilar();
		}
		CopiarPila(M1,P);
		return M2;
	}
	private boolean PertenecePila(int a, PilaTDA P)
	{
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		CopiarPila(P,aux);
		boolean pertenece=false;
		while(!pertenece&&!aux.PilaVacia()){
			if(aux.Tope()==a)
				pertenece=true;
			aux.Desapilar();
		}
		return pertenece;
	}

	//TP 3 - 1.D Cerfoglio (31/05/2018)
		/**@TAREA generar conjunto de elementos repetidos en pila
		* @PARAMETRO Pila 
		* @PRECONDICON Pila inicializada
		* @POSTCONDICON None
	 * * @COSTO Lineal
		**/
	public ConjuntoTDA ElementosRepetidos (PilaTDA P){
			ConjuntoTDA repetidos = new ConjuntoUA(); 
			repetidos.InicializarConjunto();
			ConjuntoTDA aux = new ConjuntoUA(); 
			aux.InicializarConjunto();
			PilaTDA Paux = new Pilas();
			Paux.InicializarPila();
			CopiarPila(P,Paux);
			while (!Paux.PilaVacia()){
				if (!aux.PerteneceConjunto(Paux.Tope())){
					aux.AgregarConjunto(Paux.Tope());
				}
				else{
					repetidos.AgregarConjunto(Paux.Tope());
				}
				Paux.Desapilar();
			}
			return repetidos;
		}

	/**
	 * @TAREA Copiar una cola en otra
	 * @PARAMETRO cola original
	 * @PARAMETRO cola destino
	 * @PRECONDICON Ambas colas iniciadas
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public void CopiarCola(ColaTDA origen, ColaTDA destino) {// Cambio para que no se pierda la cola original -Fedejp
		ColaTDA aux = new ColaLD();
		aux.InicializarCola();
		while (!origen.ColaVacia()) {
			destino.Acolar(origen.Primero());
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		while (!aux.ColaVacia()) {
			origen.Acolar(aux.Primero());
			aux.Desacolar();
		}
	}

	/**
	 * @TAREA Pasar una cola a otra
	 * @PARAMETRO cola original, Cola destino
	 * @PRECONDICON ambas Colas iniciadas
	 * @POSTCONDICON Se pierde la cola original
	 * * @COSTO Lineal
	 **/
	public void PasarCola(ColaTDA origen, ColaTDA destino) {
		while (!origen.ColaVacia()) {
			destino.Acolar(origen.Primero());
			origen.Desacolar();
		}
	}

	/**
	 * @TAREA Invertir una Cola con pilas auxiliares
	 * @PARAMETRO cola original
	 * @PRECONDICON Cola iniciada
	 * @POSTCONDICON La cola se devolvera invertida
	 * * @COSTO Lineal
	 **/
	public void InvertirColaPila(ColaTDA origen) { // usando pilas auxiliares
		PilaTDA p = new PilaLD();
		p.InicializarPila();
		while (!origen.ColaVacia()) {
			p.Apilar(origen.Primero());
			origen.Desacolar();
		}
		while (!p.PilaVacia()) {
			origen.Acolar(p.Tope());
			p.Desapilar();
		}
	}

	/**
	 * @TAREA Contar elementos de una cola
	 * @PARAMETRO cola original
	 * @PRECONDICON Cola iniciada
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public int ContarElemCola(ColaTDA origen) {
		int cont = 0;
		ColaTDA aux = new ColaPI();
		aux.InicializarCola(); //NUEVOOOO!!! 
		while (!origen.ColaVacia()) {
			cont++;
			aux.Acolar(origen.Primero());
			origen.Desacolar();
		}
		CopiarCola(aux, origen);
		return cont;
	}

	/**
	 * @TAREA Invertir una Cola SIN pilas auxiliares
	 * @PARAMETRO cola original
	 * @PRECONDICON Cola iniciada
	 * @POSTCONDICON La cola se devolverÃƒÂ¯Ã‚Â¿Ã‚Â½ invertida
	 * * @COSTO Polinomico
	 **/
	public void InvertirColaSola(ColaTDA origen) {
		ColaTDA aux = new ColaPI();
		ColaTDA aux2 = new ColaPI();
		aux.InicializarCola();
		aux2.InicializarCola();
		while(!origen.ColaVacia()) {
				if(aux.ColaVacia() && aux2.ColaVacia()) {
						aux.Acolar(origen.Primero());
						origen.Desacolar();
					} else if(aux.ColaVacia() && !aux2.ColaVacia()) {
			 				aux.Acolar(origen.Primero());
			 				origen.Desacolar();
						while(!aux2.ColaVacia()) {
							aux.Acolar(aux2.Primero());
							aux2.Desacolar();
						}
					} 
					else if (!aux.ColaVacia() && aux2.ColaVacia()){
						aux2.Acolar(origen.Primero());
						origen.Desacolar();
						while(!aux.ColaVacia()) {
							aux2.Acolar(aux.Primero());
							aux.Desacolar();
						}
					}
		}
		
				if(aux.ColaVacia()) {
					CopiarCola(aux2, origen);
						}
						else {
							CopiarCola(aux, origen);
					}	
	}
	/*
	 * public void InvertirColaSola(ColaTDA o) { // Este no pude hacerlo ColaTDA aux
	 * = new ColaTDAI(); ColaTDA aux2 = new Colas(); aux.InicializarCola();
	 * aux2.InicializarCola();
	 * 
	 * aux2.Acolar(o.Primero()); o.Desacolar(); while(!o.ColaVacia()) {
	 * aux.Acolar(o.Primero()); o.Desacolar(); } o = aux; }
	 */

	/**
	 * @TAREA Comparar el final de dos colas
	 * @PARAMETRO cola nro1
	 * @PARAMETRO Cola nro2
	 * @PRECONDICON Colas iniciadas
	 * @POSTCONDICON none
	 * @DEVUELVE Verdadero si los finales coinciden, Falso si no
	 * * @COSTO Lineal
	 **/
	public boolean CompararFinal(ColaTDA c1, ColaTDA c2) {// editado para que no se pierdan las colas y se ajuste a la
															// consigna -Fedejp
		ColaTDA aux1 = new ColaPU();
		ColaTDA aux2 = new ColaPU();
		aux1.InicializarCola();
		aux2.InicializarCola();
		int x = ContarElemCola(c1);
		int fin = ContarElemCola(c2);
		boolean iguales = true;
		CopiarCola(c1, aux1);
		CopiarCola(c2, aux2);
		while (x > fin) {// hasta que aux1 tenga la misma cantidad de elementos que aux2
			aux1.Desacolar();// se desacola el primero
			x--;
		}
		while (!aux1.ColaVacia() && iguales) {// Mientras que las colas tengan elementos y sean iguales
			if (aux1.Primero() != aux2.Primero())// Si los primeros son distintos
				iguales = false;// dejan de ser iguales
			else {// si los primeros son iguales
				aux1.Desacolar(); // paso al siguiente valor
				aux2.Desacolar();
			}
		}
		return iguales; // devuelvo segun corresponde
	}

	/*
	 * int y = 0, x = 0; ColaTDA aux =new ColaPU(); ColaTDA aux2 =new ColaPU();
	 * aux.InicializarCola(); aux2.InicializarCola(); CopiarCola(ct1,aux);
	 * CopiarCola (ct2,aux); while (!aux.ColaVacia()) { x = aux.Primero();
	 * aux.Desacolar(); } while (!aux2.ColaVacia()) { y = aux2.Primero();
	 * aux2.Desacolar(); } if (y == x) { System.out.println("Son iguales!"); } else
	 * { System.out.println("Son diferentes!"); } }
	 */
	/**
	 * @TAREA Verificar si la cola es capicua
	 * @PARAMETRO cola nro1
	 * @PRECONDICON Cola iniciada
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public void ColaCapicua(ColaTDA o) {// Editado para que no se pierda la cola original -Fedejp
		ColaTDA aux = new ColaPI();
		ColaTDA auxinv = new ColaPI();
		aux.InicializarCola();
		auxinv.InicializarCola();
		CopiarCola(o, aux);
		CopiarCola(o, auxinv);
		InvertirColaPila(auxinv);
		while (!aux.ColaVacia() && (aux.Primero() == auxinv.Primero())) {
			aux.Desacolar();
			auxinv.Desacolar();
		}

		if (auxinv.Primero() == aux.Primero()) {
			System.out.println("Es capicua");
		} else {
			System.out.println("No son capicua");
		}
	}

	/**
	 * @TAREA Verificar si una cola es inversa de otra
	 * @PARAMETRO cola nro1
	 * @PARAMETRO cola nro2
	 * @PRECONDICON Colas iniciadas
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public void ColaCompararInverso(ColaTDA cp1, ColaTDA cp2) {
		int iguales = 1;
		ColaTDA aux1 = new ColaPU();
		ColaTDA aux2 = new ColaPU();
		aux1.InicializarCola();
		aux2.InicializarCola();
		CopiarCola(cp1, aux1);
		CopiarCola(cp2, aux2);
		InvertirColaPila(aux2);
		while (iguales == 1 && !aux1.ColaVacia() && !aux2.ColaVacia()) {
			iguales = 0;
			if (aux1.Primero() == aux2.Primero()) {
				iguales = 1;
			}
			aux1.Desacolar();
			aux2.Desacolar();
		}
		if (aux1.ColaVacia() && aux2.ColaVacia() && iguales == 1) {
			System.out.println("Una cola es inversa de la otra");
		} else {
			System.out.println("No son inversas");
		}
	}

	// TP 3 - 2.A. -Carlos S. Yanzon (11/04/2018)

	/**
	 * @TAREA Eliminar de la cola la repeticion de elementos
	 * @PARAMETRO cola nro1
	 * @PRECONDICON Colas iniciadas
	 * @POSTCONDICON La cola quedara sin elemento repetidos
	 * * @COSTO Polinomico
	 **/
	public void ColaEliminarRepeticiones(ColaTDA cp1){
		ColaTDA destino = new ColaLD(); 
		destino.InicializarCola();
		ConjuntoTDA valores = new ConjuntoLD(); 
               valores.InicializarConjunto();
		while (!cp1.ColaVacia()){
			if (!valores.PerteneceConjunto(cp1.Primero())){
				valores.AgregarConjunto(cp1.Primero());
				destino.Acolar(cp1.Primero());
			}
			cp1.Desacolar();
		}
		CopiarCola(destino,cp1);
	}

	// TP 3 - 2.B. -Carlos S Yanzon (11/04/2018) -Corregido por FParodi (21/05/18)
	/**
	 * @TAREA Partir una cola dos mitades M1 y M2 de elementos consecutivos
	 * @PARAMETRO cola a partir, dos colas para guardar las mitades
	 * @PRECONDICON Colas iniciadas, cantidad de elementos par
	 * @POSTCONDICON La cola original se pierde, las dos mitades se llenan
	 * * @COSTO Lineal
	 **/
	public void ColaPartir(ColaTDA cp1, ColaTDA M1, ColaTDA M2) {
		int x = ContarElemCola(cp1);
		int cont = 0;
		while (!cp1.ColaVacia()) {// mientras que la cola tenga elementos
			if (cont < (x / 2))// Si se iteraron menos de la mitad de la cantidad de elementos de la cola
				M1.Acolar(cp1.Primero()); // se agregan a la primer mitad
			else
				M2.Acolar(cp1.Primero()); // se agregan a la segunda
			cp1.Desacolar();
			cont++;
		}
	}

	/*
	 * ColaTDA M1 = new ColaPU(); //Al ser los ultimos los que sacamos sera la
	 * primer parte ColaTDA M2 = new ColaPI(); //Al ser los primeros los que sacamos
	 * sera la segunda parte
	 * 
	 * //Copiamos ambas colas CopiarCola(cp1, M1); CopiarCola(cp1, M2);
	 * 
	 * int x = ContarElemCola(cp1)/2; //Partimos la cantidad de elementos a la mitad
	 * 
	 * //Recorremos i hasta llegar a la mitad de elementos //En "TEORIA", vamos
	 * desacolando ambas hasta desacolar la mitad de cada una //Como sacamos los
	 * elementos en una del primero y en la otra del ultimo nos deberian quedar dos
	 * //mitades diferentes if (ContarElemCola(cp1)%2 == 0 ) { //Si tenemos
	 * elementos par for(int i = 0; i < x; i++) { M1.Desacolar(); M2.Desacolar(); }
	 * } else { System.out.
	 * println("Lo sentimos no se puede partir por que no tenemos un numero par de elementos."
	 * ); } }
	 */
	/**
	 * @TAREA Genera una cola con las repeticiones de elementos 
	 * @PARAMETRO cola origen, cola para mostrar los repetidos.
	 * @PRECONDICON Colas iniciadas
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public void ColaGenerarRepetidos(ColaTDA cp1, ConjuntoTDA repeticiones) {
		ColaTDA aux = new ColaPI();
		ColaTDA aux2 = new ColaPI();
		ColaTDA aux3 = new ColaPI();
		
		aux.InicializarCola();
		aux2.InicializarCola();
		aux3.InicializarCola();
		
		
		CopiarCola(cp1, aux); // Copiamos los elementos de la cola 1 a aux para no perderla
								// Funciona igual que el otro

		while (!aux.ColaVacia()) {
			CopiarCola(aux, aux2);
			// Copiamos aux a aux2 ya que vamos a ir moviendo de numero en numero
			// Es decir como vamos a comparar al primero de l de aux y luego lo desacolamos
			// para comparar
			// Al siguiente numero.
			while (!aux2.ColaVacia()) { // Hasta que no llegemos al final de aux 2 no paramos
				aux2.Desacolar(); // Desacolamos el primero ya que es el primero
				if (aux.Primero() == aux2.Primero()) { // Cualquier repeticion la copiamos
					aux3.Acolar(aux2.Primero());
				} else { // Mientras que aca la vamos acolando
					//aux2.Desacolar(); !!!!ESTA LINEA NO VAAA
				}
			}
			aux.Desacolar(); // Desacolamos aux para comparar el siguiente numero
		}
		while (!aux3.ColaVacia()) {
			repeticiones.AgregarConjunto(aux3.Primero());
			aux3.Desacolar();
		}
	}
	/**
	 * @TAREA Copia una Cola prioridad en otra
	 * @PARAMETRO cola origen, cola destino.
	 * @PRECONDICON Colas iniciadas
	 * @POSTCONDICON none
	 * * @COSTO Lineal
	 **/
	public void CopiarColaPri(ColaPrioridadTDA origen, ColaPrioridadTDA destino) {
		ColaPrioridadTDA aux = new ColaPrioridadDA();
		aux.InicializarCola();
		while (!origen.ColaVacia()) {
			aux.AcolarPrioridad(origen.Primero(), origen.Prioridad());
			origen.Desacolar();
		}
		while (!aux.ColaVacia()) {
			destino.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			origen.AcolarPrioridad(aux.Primero(), aux.Prioridad());
			aux.Desacolar();
		}
	}

	/**
	 * @TAREA Combinar colas con prioridad, donde los elementos de la primera
	 *        tendrÃƒÂ¯Ã‚Â¿Ã‚Â½n mÃƒÂ¯Ã‚Â¿Ã‚Â½s prioridad que los de la segunda
	 * @PARAMETRO cola nro1, de mayor prioridad
	 * @PARAMETRO cola nro2
	 * @PRECONDICON Colas iniciadas
	 * @DEVUELVE ColaPrioridad combinada.
	 * @POSTCONDICON Las colas originales se pierden ARREGLAR
	 * * @COSTO Lineal
	 **/
	public ColaPrioridadTDA CombinarColasPrioridad(ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {

		/*
		 * //Inicializamos ambas colas CP1.InicializarCola(); CP2.InicializarCola();
		 * 
		 * //Creamos la cola auxiliar y la inicializamos 
		 */
		ColaPrioridadTDA destino = new ColaPrioridadLD();
		destino.InicializarCola();

		// Ya que la primer cola tiene prioridad realizamos el proceso hasta que esta se
		// vacie
		while (!CP1.ColaVacia()) {
			if (CP1.Prioridad() >= CP2.Prioridad()) { // Si la cola 1 tiene mayor prioridad o es igual, la acolamos
														// primero
				destino.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
				CP1.Desacolar();
			} else { // Si no acolamos la cola 2
				destino.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
				CP2.Desacolar();
			}
		}

		// if (!CP2.ColaVacia()) { //Si salimos de la cola 1 pero nos quedo data en la
		// segunda
		while (!CP2.ColaVacia()) { // Cargamos el resto de la info hasta que nos quedemos sin la misma
			destino.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
			CP2.Desacolar();
		}
		return destino;
		// }
	}

	/**
	 * @TAREA Verificar que dos colas prioridad sean identicas
	 * @PARAMETRO cola prioridad nro1
	 * @PARAMETRO cola prioridad nro2
	 * @PRECONDICON Colas prioridad iniciadas
	 * @POSTCONDICON Las colas se pierden ARREGLAR ESTO
	 * @COSTO Lineal
	 **/
	public boolean ComprobarIdentidad(ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {
		ColaPrioridadDA aux1 = new ColaPrioridadDA();
		ColaPrioridadDA aux2 = new ColaPrioridadDA();
		aux1.InicializarCola();
		aux2.InicializarCola();
		
		CopiarColaPri(CP1, aux1);
		CopiarColaPri(CP2, aux2);
		boolean iguales = true;

		while (iguales && !aux1.ColaVacia() && !aux2.ColaVacia()) {
			if (aux1.Primero() != aux2.Primero() || aux1.Prioridad() != aux2.Prioridad())
				iguales = false;
			aux1.Desacolar();
			aux2.Desacolar();
		}
		return iguales;

		/*
		 * while (!aux1.ColaVacia() && !aux2.ColaVacia() && aux1.Primero() ==
		 * aux2.Primero() && aux1.Prioridad() == aux2.Prioridad()) { aux1.Desacolar();
		 * //Mientras ninguna termine antes que la otra, sus numeros y sus prioridades
		 * sean iguales aux2.Desacolar(); // vamos desacolando. }
		 * 
		 * if (CP1.Primero() != CP2.Primero()) { //Chequeamos que no haya salido por
		 * numeros diferentes System.out.println("Son distintas"); } else { if
		 * (CP1.Prioridad() != CP2.Prioridad()) { //Chequeamos que no haya salido por
		 * prioridades diferentes System.out.println("Son distintas"); } else {
		 * //Chequeamos que ambas colas esten vacias if (!CP1.ColaVacia() &&
		 * CP2.ColaVacia()) { //La cola 1 no termino, pero la 2 si
		 * System.out.println("Son distintas"); } else if (CP1.ColaVacia() &&
		 * !CP2.ColaVacia()) { //La cola 2 no termino, pero la 1 si.
		 * System.out.println("Son distintas"); } else { //Si no.... //Son iguales!
		 * System.out.println("Son iguales!"); } } }
		 */
	}

	/**
	 * @TAREA Copiar un conjunto en otro
	 * @PARAMETROS: Conjunto Origen, Conjunto destino
	 * @precondicion: conjuntos inicializados
	 * @POSTCONDICION:
	 *  @COSTO Lineal
	 **/
	public ConjuntoTDA CopiarConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
		PilaTDA aux = new Pilas();
		aux.InicializarPila();
		while (!origen.ConjuntoVacio()) {// se pasan todos los elementos de un conjunto a una pila auxiliar
			aux.Apilar(origen.ElegirConjunto());
			origen.SacarConjunto(origen.ElegirConjunto());
		}
		while (!aux.PilaVacia()) { // se agregan a los dos conjuntos en simultaneo desde la pila
			destino.AgregarConjunto(aux.Tope());// de esta forma, los conjuntos son copias exactas en elementos y orden
			origen.AgregarConjunto(aux.Tope());
			aux.Desapilar();
		}
		return destino;
	}

	// TP 2 - 6. Federico Parodi
	/**
	 * @TAREA Encontrar la interseccion entre dos conjuntos.
	 * @PARAMETRO Conjunto 1, Conjunto 2.
	 * @PRECONDICION Conjuntos inicializados
	 * @POSTCONDICION none
	 * @DEVUELVE ConjuntoTDA con los elementos que estan en ambos conjuntos.
	 *  @COSTO Lineal
	 **/
	public ConjuntoTDA InterseccionConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
		ConjuntoTDA aux1 = new ConjuntoUA();
		ConjuntoTDA inter = new ConjuntoUA();
		aux1.InicializarConjunto();
		inter.InicializarConjunto();
		CopiarConjunto(C1, aux1);
		while (!aux1.ConjuntoVacio()) {
			if (C2.PerteneceConjunto(aux1.ElegirConjunto())) {
				inter.AgregarConjunto(aux1.ElegirConjunto());
			}
			aux1.SacarConjunto(aux1.ElegirConjunto());
		}
		return inter;
	}

	/**
	 * @TAREA Encontrar la union entre dos conjuntos.
	 * @PARAMETRO Conjunto 1, Conjunto 2.
	 * @PRECONDICION Conjuntos inicializados
	 * @POSTCONDICION none
	 * @DEVUELVE ConjuntoTDA con los elementos que estan en uno u otro conjunto.
	 *  @COSTO Lineal
	 **/
	public ConjuntoTDA UnionConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
		ConjuntoTDA aux1 = new ConjuntoUA();
		ConjuntoTDA aux2 = new ConjuntoUA();
		ConjuntoTDA uni = new ConjuntoUA();
		aux1.InicializarConjunto();
		aux2.InicializarConjunto();
		uni.InicializarConjunto();
		CopiarConjunto(C1, aux1);
		CopiarConjunto(C2, aux2);
		while (!aux1.ConjuntoVacio()) {
			uni.AgregarConjunto(aux1.ElegirConjunto());
			aux1.SacarConjunto(aux1.ElegirConjunto());
		}
		while (!aux2.ConjuntoVacio()) {
			if (!uni.PerteneceConjunto(aux2.ElegirConjunto())) {
				uni.AgregarConjunto(aux2.ElegirConjunto());
			}
			aux2.SacarConjunto(aux2.ElegirConjunto());
		}
		return uni;
	}

	/**
	 * @TAREA Encontrar la diferencia entre dos conjuntos.
	 * @PARAMETRO Conjunto 1(minuendo) , Conjunto 2(sustraendo).
	 * @PRECONDICION Conjuntos inicializados
	 * @POSTCONDICION none
	 * @DEVUELVE ConjuntoTDA con los elementos que estan en C1 menos los que
	 *           estÃƒÂ¯Ã‚Â¿Ã‚Â½n en C2.
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA DiferenciaConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
		ConjuntoTDA aux1 = new ConjuntoUA();
		ConjuntoTDA aux2 = new ConjuntoUA();
		ConjuntoTDA aux3 = new ConjuntoUA();
		aux1.InicializarConjunto();
		aux2.InicializarConjunto();
		aux3.InicializarConjunto();
		CopiarConjunto(C1, aux1);
		CopiarConjunto(C2, aux2);
		while (!aux2.ConjuntoVacio()) {
			if (aux1.PerteneceConjunto(aux2.ElegirConjunto())) {
				aux1.SacarConjunto(aux2.ElegirConjunto());
			} else {
				aux3.AgregarConjunto(aux2.ElegirConjunto());
			}
			aux2.SacarConjunto(aux2.ElegirConjunto());
		}
		while(!aux1.ConjuntoVacio()) {
			aux3.AgregarConjunto(aux1.ElegirConjunto());
			aux1.SacarConjunto(aux1.ElegirConjunto());
		}
		return aux3;
	}

	// TP 3 - 5.A. Carlos Santiago YANZON -BIZK (14/04/2018)
	/**
	 * @return 
	 * @TAREA Generar un dicconario multiple en base a dos diccionarios multiples D1
	 *        y D2
	 * @PARAMETRO diccionario 1 y 2
	 * @PRECONDICON Diccionarios iniciados.
	 * @POSTCONDICON 1 Diccionario multiple
	 *  @COSTO Polinomico
	 **/
	public DiccionarioMultipleTDA UnificarDicMultiples(DiccionarioMultipleTDA D01, DiccionarioMultipleTDA D02) {
		DiccionarioMultipleTDA dic = new DicMultipleA();
		dic.InicializarDiccionario();

		ConjuntoTDA clavesd01 = new ConjuntoTMA();
		ConjuntoTDA clavesd02 = new ConjuntoTMA();
		clavesd01.InicializarConjunto();
		clavesd02.InicializarConjunto();

		ConjuntoTDA valoresd01 = new ConjuntoTMA();
		ConjuntoTDA valoresd02 = new ConjuntoTMA();
		valoresd01.InicializarConjunto();
		valoresd02.InicializarConjunto();

		// Obtenemos todas las claves de cada conjunto
		CopiarConjunto(D01.Claves(), clavesd01);
		CopiarConjunto(D02.Claves(), clavesd02);
		/*
		 * clavesd01 = D01.claves(); clavesd02 = D02.claves();
		 */

		int clave, valor;
		// obtenemos los valores de dichas claves
		while (!clavesd01.ConjuntoVacio()) { // Recorremos todas las claves
			clave = clavesd01.ElegirConjunto(); // Sacamaos una clave
			CopiarConjunto(D01.Recuperar(clave), valoresd01); // Con esa clave obtenemos el conjunto de valores
			// valoresd01 = D01.Recuperar(clave);
			while (!valoresd01.ConjuntoVacio()) { // Recorremos el conjunto de valores
				valor = valoresd01.ElegirConjunto(); // Obtenemos un valor
				dic.Agregar(clave, valor); // Agregamos la clave y el valor
				valoresd01.SacarConjunto(valor); // Eliminamos el valor
			} // Una vez recorrimos todos los valores
			clavesd01.SacarConjunto(clave); // eliminamos esa clave asi podemos acceder a la siguiente
		}

		while (!clavesd02.ConjuntoVacio()) { // Recorremos todas las claves
			clave = clavesd02.ElegirConjunto(); // Sacamaos una clave
			CopiarConjunto(D02.Recuperar(clave), valoresd02); // Con esa clave obtenemos el conjunto de valores
			// valoresd02 = D02.Recuperar(clave);
			while (!valoresd02.ConjuntoVacio()) { // Recorremos el conjunto de valores
				valor = valoresd02.ElegirConjunto(); // Obtenemos un valor
				dic.Agregar(clave, valor); // Agregamos la clave y el valor
				valoresd02.SacarConjunto(valor); // Eliminamos el valor
			} // Una vez recorrimos todos los valores
			clavesd02.SacarConjunto(clave); // eliminamos esa clave asi podemos acceder a la siguiente
		}
		
		return dic;
	}

	// TP 3 - 5.B. //ESTA NO PUDE AUNQU CROE QUE ES LO MISMO QUE EL D.
	// -Efectivamente, lo es. Fedejp
	/**
	 * @TAREA Generar un dicconario multiple en base a los elementos en comun de los
	 *        diccionarios multiples D1 y D2
	 * @PARAMETRO diccionario 1 y 2
	 * @PRECONDICON Diccionarios iniciados.
	 * @Devuelve 1 Diccionario multiple
	 **/
	public DiccionarioMultipleTDA DiccionarioElemComun (DiccionarioMultipleTDA D1, DiccionarioMultipleTDA D2) {
		
		return DicMultClavesYValComun(D1,D2);
	}
	
	// TP 3 - 5.C. -Carlos Santiago YANZON -BIZK (14/04/2018)
	/**
	 * @return 
	 * @TAREA Generar un dicconario multiple en base a dos diccionarios multiples D1
	 *        y D2 el cual tendra todos los valores de las claves en comun
	 * @PARAMETRO diccionario 1 y 2
	 * @PRECONDICON Diccionarios iniciados.
	 * @POSTCONDICON 1 Diccionario multiple
	 *  @COSTO Polinomico
	 **/
	public DiccionarioMultipleTDA DicMultClavesComun(DiccionarioMultipleTDA ORIGEN1, DiccionarioMultipleTDA ORIGEN2) {
		DiccionarioMultipleTDA dic = new DiccionarioMultipleLD();
		dic.InicializarDiccionario();

		DiccionarioMultipleTDA D01 = new DiccionarioMultipleLD();
		DiccionarioMultipleTDA D02 = new DiccionarioMultipleLD();
		D01.InicializarDiccionario();
		D02.InicializarDiccionario();
				
		ConjuntoTDA clavesd01 = new ConjuntoLD();
		ConjuntoTDA clavesd02 = new ConjuntoLD();
		clavesd01.InicializarConjunto();
		clavesd02.InicializarConjunto();
		ConjuntoTDA valoresd01 = new ConjuntoLD();
		ConjuntoTDA valoresd02 = new ConjuntoLD();
		valoresd01.InicializarConjunto();
		valoresd02.InicializarConjunto();
		
		int clave1, clave2, valor1, valor2;
		ConjuntoTDA valconj01 = new ConjuntoLD();
		ConjuntoTDA valconj02 = new ConjuntoLD();
		
		// obtenemos los valores de dichas claves
		clavesd01 = ORIGEN1.Claves();
		while (!clavesd01.ConjuntoVacio()) {
			clavesd02 = ORIGEN2.Claves(); // Reinicioamos las claves de claves02 para recorrerlas todas
			clave1 = clavesd01.ElegirConjunto(); // Sacamos una clave de clavesd01
			while (!clavesd02.ConjuntoVacio()) { // Recorremos todas las claves de d02
				clave2 = clavesd02.ElegirConjunto(); // Sacamos una clave de clavesd02
				if (clave1 == clave2) { // Si son iguales procedemos a unificar todo
					valconj01 = ORIGEN1.Recuperar(clave1); // Obtenemos todos los valores de la clave
					while (!valconj01.ConjuntoVacio()) { // REcorremos todos los valores
						valor1 = valconj01.ElegirConjunto(); // Elegimos un valor al azar
						dic.Agregar(clave1, valor1); // Agregamos el primer valor
						valconj01.SacarConjunto(valor1);
					}
					valconj02 = ORIGEN2.Recuperar(clave2); // Obtenemos todos los valores de la clave
					while (!valconj02.ConjuntoVacio()) { // REcorremos todos los valores
						valor2 = valconj02.ElegirConjunto();
						dic.Agregar(clave2, valor2); // Agruegamos ambos valores
						valconj02.SacarConjunto(valor2);
					}
				} // Si no, decidimos seguir comparando todas las claves2 con esa clave
				clavesd02.SacarConjunto(clave2);
			} // Volvemos a hacer lo mismo hasta quedarnos sin claves en clavd01
			clavesd01.SacarConjunto(clave1); // eliminamos esa clave asi podemos acceder a la siguiente
		}
		return dic;
	}

	// TP 3 - 5.D. Yanzon (14/04/2018)
	/**
	 * @return 
	 * @TAREA Generar un dicconario multiple en base a dos diccionarios multiples D1
	 *        y D2 el cual tendra todos los valores de las claves en comun
	 * @PARAMETRO diccionario 1 y 2
	 * @PRECONDICON Diccionarios iniciados.
	 * @Devuelve 1 Diccionario multiple
	 * @Postcondicion none
	 * @COSTO polinomico
	 **/
	public DiccionarioMultipleTDA DicMultClavesYValComun(DiccionarioMultipleTDA D01, DiccionarioMultipleTDA D02) {
		DiccionarioMultipleTDA dic = new DicMultipleA(); // Definimos el diccionario donde guardaremos todo
		dic.InicializarDiccionario();
		
		// Obtenemos los conjuntos de claves
		ConjuntoTDA clavesd01 = new ConjuntoTMA();
		ConjuntoTDA clavesd02 = new ConjuntoTMA();
		clavesd01.InicializarConjunto();
		clavesd02.InicializarConjunto();

		// Obtenemos los conjuntos de valores
		ConjuntoTDA valoresd01 = new ConjuntoTMA();
		ConjuntoTDA valoresd02 = new ConjuntoTMA();
		valoresd01.InicializarConjunto();
		valoresd02.InicializarConjunto();

		// Obtenemos todas las claves del primer conjunto
		clavesd01 = D01.Claves();

		// Definimos los enteros
		int clave1, clave2, valor1, valor2;

		// Obtenemos una clave
		while (!clavesd01.ConjuntoVacio()) { // Recorremos todas las claves de d01
			clavesd02 = D02.Claves(); // Reiniciamos las claves de d02
			clave1 = clavesd01.ElegirConjunto(); // Elegimos una clave de d01
			while (!clavesd02.ConjuntoVacio()) { // Para cada clave de d01 recorremos todas las de d02
				clave2 = clavesd02.ElegirConjunto(); // Elegimos una clav de d02
				if (clave1 == clave2) { // Si ambas claves son iguales
					valoresd01 = D01.Recuperar(clave1); // recuperamos todos los valores de dicha ckave en d01
					while (!valoresd01.ConjuntoVacio()) { // Recorremos todos los valores de la clave en d01
						valor1 = valoresd01.ElegirConjunto(); // Obtenemos el primer valor
						valoresd02 = D02.Recuperar(clave2); // obtenemos todos los valores del conjunto d02 este se
															// reinicia
															// ya que lo recorreremos uno por uno y tendremos qu
															// ehacerlo para
															// cada valor de la clave en d01
						while (!valoresd02.ConjuntoVacio()) {
							valor2 = valoresd02.ElegirConjunto(); // Elegimos un valor
							if (valor1 == valor2) {
								dic.Agregar(clave1, valor1); // Si son iguales agregamos la clave y dicho valor.
							}
							valoresd02.SacarConjunto(valor2); // Lo quitamos para seguir buscando
						}
						valoresd01.SacarConjunto(valor1); // Lo sacamos del conjunto.
					}
				}
				clavesd02.SacarConjunto(clave2); // Quitamos la clave para seguir recorriendo el vector.
			}
			clavesd01.SacarConjunto(clave1); // Vamos vaciando el conjunto de claves
		}
		return dic;
	}

	
	// TP 3 - 3.a.b Salvioli (17/04/2018)
	/**
	 * @TAREA calcular diferencias simetricas sin operaciones
	 * @PARAMETRO conjunto
	 * @PRECONDICON inicializar conjunto
	 * @POSTCONDICON resultado diferencia simetrica
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA DiferenciaSimetricaSinOperaciones(ConjuntoTDA c1, ConjuntoTDA c2) {
		ConjuntoTDA ResultadoDifSimetrica = new ConjuntoLD();
		ConjuntoTDA aux1 = new ConjuntoLD();
		ConjuntoTDA aux2 = new ConjuntoLD();

		ResultadoDifSimetrica.InicializarConjunto();
		aux1.InicializarConjunto();
		aux2.InicializarConjunto();
		int elemento;

		CopiarConjunto(c1, aux1);
		CopiarConjunto(c2, aux2);

		
		while (!aux1.ConjuntoVacio()) {
			elemento = aux1.ElegirConjunto(); // toma un elemento
			if (!aux2.PerteneceConjunto(elemento)) { // Si el elemento pertenece a C1 y no a c2
				ResultadoDifSimetrica.AgregarConjunto(elemento); // Se agrega a la diferencia simetrica
			} else {
				aux2.SacarConjunto(elemento);
			}
			aux1.SacarConjunto(elemento);
		}

		while (!aux2.ConjuntoVacio()) {
			elemento = aux2.ElegirConjunto();
			ResultadoDifSimetrica.AgregarConjunto(elemento);
			aux2.SacarConjunto(elemento);
		}
		return ResultadoDifSimetrica;
	}

	// TP 3 - 3.c Salvioli (17/04/2018)
	/**
	 * @TAREA calcular diferencias simetricas con union, interceccion y diferencia
	 * @PARAMETRO conjunto
	 * @PRECONDICON iniciar conjunto
	 * @POSTCONDICON devolver diferemcia simetrica
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA DiferenciaSimetricaConOperaciones(ConjuntoTDA c1, ConjuntoTDA c2) {

		api.ConjuntoTDA ResDiferenciaSimetricaConOp = UnionConjunto(c1, c2);
		api.ConjuntoTDA auxInter = InterseccionConjunto(c1, c2);

		while (!auxInter.ConjuntoVacio()) {
			ResDiferenciaSimetricaConOp.SacarConjunto(auxInter.ElegirConjunto());
			auxInter.SacarConjunto(auxInter.ElegirConjunto());
		}

		/*
		 * while(!c1.ConjuntoVacio()) { int elemento=c1.ElegirConjunto() if (!c2.
		 * Pertenece(elemento)){ ResDiferenciaSimetricaConOp.UnionConjunto(elemento); }
		 * else { c2.DiferenciaConjunto(elemento); } c1.DiferenciaConjunto(elemento); }
		 * 
		 * while(!c2.ConjuntoVacio()){ int elemento = c2.ElegirConjunto();
		 * ResDiferenciaSimetricaConOp.UnionConjunto(elemento);
		 * c1.DiferenciaConjunto(elemento); //revisar
		 * 
		 * 
		 * }
		 * 
		 */
		return ResDiferenciaSimetricaConOp;
	}

	// TP 3 - 3.d Salvioli (17/04/2018)
	/**
	 * @TAREA verificar si dos conjuntos son iguales
	 * @PARAMETRO conjunto 1 y conjunto 2
	 * @PRECONDICON inicializar los conjuntos
	 * @Devuelve true o false
	 * @POSTCONDICION none 
	 * @COSTO Lineal
	 **/
	public boolean VerificarIgualdadconjuntos(ConjuntoTDA c1, api.ConjuntoTDA c2) {
		api.ConjuntoTDA Conjunto1 = new ConjuntoLD();
		api.ConjuntoTDA Conjunto2 = new ConjuntoLD();
		Conjunto1.InicializarConjunto();
		Conjunto2.InicializarConjunto();
		CopiarConjunto(c1, Conjunto1);
		CopiarConjunto(c2, Conjunto2);

		int x, a = 1;

		while (!Conjunto1.ConjuntoVacio() && a == 1) {
			x = Conjunto1.ElegirConjunto();
			if (!c2.PerteneceConjunto(x))
				a = 0;
			else {
				Conjunto1.SacarConjunto(x);
				Conjunto2.SacarConjunto(x);
			}
		}

		if (a == 1 && Conjunto2.ConjuntoVacio()) {
			return true;
		} else {
			return false;
		}
	}
	// TP 3 - 5.2. Cerfoglio (14/06/2018)
	/**
	 * @TAREA Crear un diccionario multiple a partir de un simple
	 * @PARAMETRO diccionario Simple
	 * @PRECONDICON diccionario inicializado
	 * @Devuelve Diccionario multiple
	 * @POSTCONDICION none 
	 * @COSTO Lineal
	 **/
    public DiccionarioMultipleTDA DiccionarioSimpleAMultiple(DiccionarioSimpleTDA D) {
        DiccionarioMultipleTDA dic = new DicMultipleA(); // Diccionario multiple donde se guarda
        dic.InicializarDiccionario();
       
        ConjuntoTDA clavesD = new ConjuntoTMA();
        clavesD.InicializarConjunto(); // Conjunto de claves del diccionario simple otorgado
       
        //Valores enteros
        int nota, dni;
       
        clavesD = D.Claves(); //Se agregan al conjunto todas las claves del Dic. Simple otorgado
        while(!clavesD.ConjuntoVacio()) {
            dni = clavesD.ElegirConjunto(); //Se elije una clave del conjunto
            nota = D.Recuperar(dni); //Se obtiene el valor asociado a la clave obtenida
            dic.Agregar(nota, dni); //Se agrega el dato al diccionario, teniendo a la nota como clave y al documento como valor
            clavesD.SacarConjunto(dni); //Se elimina la clave del conjunto para poder seguir buscando
        }
        return dic;
    }


	// TP4 3-A gonza 05/05/18
	/**
	 * @TAREA determinar si un elemento esta o no en el AB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE true or false
	 * @COSTO recursivo
	 **/
    public boolean existeElementoABB(int elemen, ABBTDA arbol) {
		if (arbol.ArbolVacio()) {
			return false;
		} else if (arbol.Raiz() == elemen) {
			return true;
		} else if (arbol.Raiz() > elemen) {
			return existeElementoABB(elemen, arbol.HijoIzq());
		} else {
			return existeElementoABB(elemen, arbol.HijoDer());
		}
	}

	// TP4 3-b gonza 05/05/18
	/**
	 * @TAREA dado un elemento determinar si es una hoja del ABB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE true or false
	 * @COSTO Recursivo
	 **/
    public boolean ElemenHoja(int elemen, ABBTDA arbol) {
		if (arbol.ArbolVacio()) {
			return false;
		} else {
			if (arbol.Raiz() == elemen) {
				if (arbol.HijoDer().ArbolVacio() && arbol.HijoIzq().ArbolVacio()) {
					return true;
				} else
					return false;
			} else {
				if (arbol.Raiz() > elemen) {
					return ElemenHoja(elemen, arbol.HijoIzq());
				} else
					return ElemenHoja(elemen, arbol.HijoDer());
			}
		}
	}

	// TP4 3-c gonza 05/05/18
	/**
	 * @TAREA dado un elemento calcular su profundidad en el ABB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE Integer profundidad
	 * @COSTO recursivo
	 **/ // prof: cantidad de niveles del arbol empieza en 0
    public int Profundidad(int elemen, ABBTDA arbol) {// preguntar si existe elemento como precondicion
		if (arbol.ArbolVacio()) {
			return 0;
		} else if (arbol.Raiz() == elemen) {
			return 0;
		} else if (arbol.Raiz() > elemen) {
			return (1 + Profundidad(elemen, arbol.HijoIzq()));
		} else {
			return (1 + Profundidad(elemen, arbol.HijoDer()));
		}
	}

	// TP4 3-d gonza 05/05/18 //Arreglado por Fede
	/**
	 * @TAREA obtener el valor del menor elelemnto de un ABB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado y no vacÃƒÂ­o
	 * @POSTCONDICON none
	 * @DEVUELVE valor
	 * @COSTO Recursivo
	 **/
    public int Menor(ABBTDA a) {// mirar la implementacio
		if (a.HijoIzq().ArbolVacio()) { // si el hijo izquierdo esta vacÃ­o
			return a.Raiz(); // es el valor mas bajo
		} else {
			return Menor(a.HijoIzq()); // busca el valor mas bajo en el hijo izquierdo
		}
	}

	// TP3 pto 3-e FedeP
	/**
	 * @TAREA Calcular elementos Conjunto
	 * @PARAMETRO ConjuntoTDA
	 * @PRECONDICON Conjunto inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE Integer
	 * @COSTO Recursivo
	 **/
	public int ContarConjunto(ConjuntoTDA c1) {
		ConjuntoTDA aux = new ConjuntoLD();
		int cont = 0;
		aux.InicializarConjunto();
		CopiarConjunto(c1, aux);
		while (!aux.ConjuntoVacio()) {
			cont++;
			aux.SacarConjunto(aux.ElegirConjunto());
		}
		return cont;
	}

	// Tp3 3-G FedeP
	/**
	 * @TAREA determinar los elementos de una pila P son los mismos que los de una
	 *        cola C
	 * @PARAMETRO Pila, Cola
	 * @PRECONDICON Ambas inicializadas
	 * @POSTCONDICON none
	 * @DEVUELVE true or false
	 * @COSTO Lineal
	 **/
	public boolean MismoPilaCola(PilaTDA P, ColaTDA C) {
		ConjuntoTDA Colaconjunto = new ConjuntoLD();
		ConjuntoTDA Pilaconjunto = new ConjuntoLD();
		PilaTDA auxp = new Pilas();
		ColaTDA auxc = new ColaPU();
		Colaconjunto.InicializarConjunto();
		Pilaconjunto.InicializarConjunto();
		auxp.InicializarPila();
		auxc.InicializarCola();
		CopiarPila(P, auxp);
		CopiarCola(C, auxc);
		while (!auxp.PilaVacia()) {
			Pilaconjunto.AgregarConjunto(auxp.Tope());
			auxp.Desapilar();
		}
		while (!auxc.ColaVacia()) {
			Colaconjunto.AgregarConjunto(auxc.Primero());
			auxc.Desacolar();
		}
		return (VerificarIgualdadconjuntos(Pilaconjunto, Colaconjunto));
	}

	// TP3 Pto 3-F Fedep
	/**
	 * @TAREA Generar conjunto a partir de colas y pilas
	 * @PARAMETRO ColaTDA,PilaTDA
	 * @PRECONDICON Cola y pila inicializada
	 * @POSTCONDICON none
	 * @DEVUELVE ConjuntoTDA
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA ConjuntoColaPila(ColaTDA C, PilaTDA P) {
		ConjuntoTDA Colaconjunto = new ConjuntoLD();
		ConjuntoTDA Pilaconjunto = new ConjuntoLD();
		PilaTDA auxp = new Pilas();
		ColaTDA auxc = new ColaPU();
		Colaconjunto.InicializarConjunto();
		Pilaconjunto.InicializarConjunto();
		auxp.InicializarPila();
		auxc.InicializarCola();
		CopiarPila(P, auxp);
		CopiarCola(C, auxc);
		while (!auxp.PilaVacia()) {
			Pilaconjunto.AgregarConjunto(auxp.Tope());
			auxp.Desapilar();
		}
		while (!auxc.ColaVacia()) {
			Colaconjunto.AgregarConjunto(auxc.Primero());
			auxc.Desacolar();
		}
		return InterseccionConjunto(Colaconjunto, Pilaconjunto);
	}
	// TP3 punto 4-A 27/04/18 gonza
		/**
		 * @TAREA generar diccionario multiple que recupere todas las prioridades de un
		 *        valor
		 * @PARAMETRO cola prioridad c
		 * @PRECONDICON Cola iniciada
		 * @devuelve un diccionario multiple
		 * @COSTO Lineal
		 **/
		public DiccionarioMultipleTDA ColaADiccionarioValoresClave(ColaPrioridadTDA C) {
			DiccionarioMultipleTDA dicAUX = new DicMultipleA();
			dicAUX.InicializarDiccionario();
			while (!C.ColaVacia()) {
				dicAUX.Agregar(C.Primero(), C.Prioridad());
				C.Desacolar();
			}
			return dicAUX;
		}



	// TP4 3-e gonza 08/05/18
	/**
	 * @TAREA calcular la cantidad de elementos que tiene un ABB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE cant
	 * @COSTO recursivo
	 **/
		public int CantElementos(ABBTDA arbol) {
			if (arbol.ArbolVacio())
				return 0;
			else {
				return (1 + CantElementos(arbol.HijoIzq()) + CantElementos(arbol.HijoDer()));
			}
		}

	// TP4 3-f gonza 08/05/18 //segun el profesor va a asi
	/**
	 * @TAREA calcular la suma de elementos que contiene un ABB
	 * @PARAMETRO arbol
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE integer
	 * @COSTO Recursivo
	 **/
		public int SumaElementos(ABBTDA arbol) {
			if (arbol.ArbolVacio())
				return 0;
			else {
				return (arbol.Raiz() + SumaElementos(arbol.HijoIzq()) + SumaElementos(arbol.HijoDer()));
			}
		}

	// TP 4 - 3.g Salvioli (09/05/2018)
	/**
	 * @TAREA calcular cantidad de hojas de un arbol
	 * @PARAMETRO arbol
	 * @PRECONDICON inicializar el arbol
	 * @POSTCONDICON valor cantidad de hojas
	 * @COSTO recursivo
	 **/
		public int ContarCantidadDeHojas (ABBTDA a){
			if (a.ArbolVacio())
				return 0;
			else{
				if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio())
					return 1;
				else
					return ContarCantidadDeHojas(a.HijoDer()) + ContarCantidadDeHojas(a.HijoIzq());
			}
		}

	// TP 4 - 3.h Salvioli (09/05/2018)
	/**
	 * @TAREA calcular altura arbol
	 * @PARAMETRO arbol
	 * @PRECONDICON inicializar el arbol
	 * @POSTCONDICON valor altura arbol
	 * @COSTO recursivo
	 **/
		public int CalcularAlturaABB(ABBTDA a) {
			if (a.ArbolVacio()) {
				return 0;
			}
			else if (a.HijoDer().ArbolVacio()&&a.HijoIzq().ArbolVacio())
			{
				return 0;
			}
			else {
				return 1 + Math.max(CalcularAlturaABB(a.HijoDer()),CalcularAlturaABB(a.HijoIzq()));
			}
		}
	// TP 4 - 3.l.i Salvioli (09/05/2018)
	/**
	 * @TAREA mostrar arbol por in order
	 * @PARAMETRO arbol
	 * @PRECONDICON
	 * @POSTCONDICON
	 **/
	public void inOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			inOrder(a.HijoIzq());
			System.out.println(a.Raiz());
			inOrder(a.HijoDer());
		}
	}

	// TP 4 - 3.l.ii Salvioli (09/05/2018)
	/**
	 * @TAREA mostrar arbol por pre order
	 * @PARAMETRO arbol
	 * @PRECONDICON
	 * @POSTCONDICON
	 **/
	public void preOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			System.out.println(a.Raiz());
			preOrder(a.HijoIzq());
			preOrder(a.HijoDer());
		}
	}

	// TP 4 - 3.l.iii Salvioli (09/05/2018)
	/**
	 * @TAREA mostrar arbol por post-order
	 * @PARAMETRO arbol
	 * @PRECONDICON
	 * @POSTCONDICON
	 **/
	public void postOrder(ABBTDA a) {
		if (!a.ArbolVacio()) {
			postOrder(a.HijoIzq());
			postOrder(a.HijoDer());
			System.out.println(a.Raiz());
		}
	}

	/*
	// TP 4 - 3.m Salvioli (17/04/2018)
	/**@TAREA Dado un valor k, arme un conjunto con todos los elementos del ABB que son
		mayores que k
	 * @PARAMETRO arbol binario y k
	 * @PRECONDICON iniciar conjunto
	 * @POSTCONDICON devolver Raiz
	**/
	/*
	public ConjuntoTDA MayoresAk(ABBTDA a,int k) {
		ConjuntoTDA r= new ConjuntoLD();
		r.InicializarConjunto () ;
		
		if(!a.ArbolVacio()){
			if(a.Raiz () > k) {
				r.AgregarConjunto(a.Raiz());
			}
		
			ConjuntoTDA rI = ConjuntoTDA(a.HijoIzq();
			ConjuntoTDA rD = nodos(a.HijoDer() );
		
			while(!rI.ConjuntoVacio()){
				int x = rI.ElegirConjunto();
				r.AgregarConjunto(x);
				r.SacarConjunto(x);
			}
			
			while(!rD.ConjuntoVacio ()){
				int x = rD.ElegirConjunto();
				r.AgregarConjunto(x);
				r.SacarConjunto(x);
			}
		}
		return r;
	}
	*/
	
	/**
	 * @TAREA Calcular conjunto de vertices Adyacentes Dobles del vértice
	 * @PARAMETRO Grafo, vértice
	 * @PRECONDICON Grafo inicializado, vertice pertenece al grafo
	 * @POSTCONDICON none
	 * @DEVUELVE ConjuntoTDA
	 * @COSTO polinómico
	 **/
	public ConjuntoTDA GAdyacentesDobles(GrafoTDA G, int v) {
		ConjuntoTDA Ady = new ConjuntoLD();
		ConjuntoTDA AdyD = new ConjuntoLD();
		ConjuntoTDA vert= G.Vertices();
		Ady.InicializarConjunto();
		AdyD.InicializarConjunto();
		while(!vert.ConjuntoVacio()) {
			if(G.ExisteArista(v, vert.ElegirConjunto())) { //Obtengo todos los adyacentes
				Ady.AgregarConjunto(vert.ElegirConjunto());
			}
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		CopiarConjunto(G.Vertices(), vert);
		while(!Ady.ConjuntoVacio()) { //Mientras que tenga vértices adyacentes
			while(!vert.ConjuntoVacio()) {
				if(G.ExisteArista(Ady.ElegirConjunto(), vert.ElegirConjunto())) {//Obtengo todos los adyacentes dobles {
					AdyD.AgregarConjunto(vert.ElegirConjunto());
				}
				vert.SacarConjunto(vert.ElegirConjunto());
			}
			CopiarConjunto(G.Vertices(), vert);
			Ady.SacarConjunto(Ady.ElegirConjunto());
		}
		return AdyD;
	}
	/**
	 * @TAREA Determinar el conjunto de predecesores de un vértice
	 * @PARAMETRO Grafo, vértice
	 * @PRECONDICON Grafo inicializado, vertice pertenece al grafo
	 * @POSTCONDICON none
	 * @DEVUELVE ConjuntoTDA
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA GPredecesores (GrafoTDA G, int v) {
		ConjuntoTDA vert = G.Vertices();
		ConjuntoTDA pred = new ConjuntoLD();
		while(!vert.ConjuntoVacio()) {
			if(G.ExisteArista(vert.ElegirConjunto(), v)) {
				pred.AgregarConjunto(vert.ElegirConjunto());
			}
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		return pred;
	}
	/**
	 * @TAREA Determinar el conjunto de puentes entre dos vértices
	 * @PARAMETRO Grafo, vértice 1, vértice 2
	 * @PRECONDICON Grafo inicializado, vertices pertenecen al grafo
	 * @POSTCONDICON none
	 * @DEVUELVE ConjuntoTDA
	 * @COSTO Lineal
	 **/
	public ConjuntoTDA GPuentes (GrafoTDA G, int v1, int v2) {
		ConjuntoTDA vert=G.Vertices();
		ConjuntoTDA puente= new ConjuntoLD();
		puente.InicializarConjunto();
		while(!vert.ConjuntoVacio()) {
			if(G.ExisteArista(v1, vert.ElegirConjunto())) {
				if(G.ExisteArista(vert.ElegirConjunto(), v2)) {
					puente.AgregarConjunto(vert.ElegirConjunto());
				}
			}
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		return puente;
	}
	/**
	 * @TAREA Determinar el costo de la arista saliente mayor
	 * @PARAMETRO Grafo, vértice 1
	 * @PRECONDICON Grafo inicializado, vertice pertenece al grafo
	 * @POSTCONDICON none
	 * @DEVUELVE integer
	 * @COSTO Lineal
	 **/
	public int GAristaMay(GrafoTDA G, int v) {
		int aristamay=-1;
		ConjuntoTDA vert = G.Vertices();
		while(!vert.ConjuntoVacio()) {
			if(G.ExisteArista(v, vert.ElegirConjunto())&& G.PesoArista(v, vert.ElegirConjunto())>aristamay) {
				aristamay=G.PesoArista(v, vert.ElegirConjunto());
			}
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		return aristamay;
	}
	/**
	 * @TAREA Determinar conjunto de vértices aislados
	 * @PARAMETRO Grafo
	 * @PRECONDICON Grafo inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE Conjunto
	 * @COSTO Polinomico
	 **/
	public ConjuntoTDA GVertAislados (GrafoTDA G) {
		ConjuntoTDA vert = G.Vertices();
		ConjuntoTDA vert2 = G.Vertices();
		ConjuntoTDA aisl = G.Vertices();
		while(!vert.ConjuntoVacio()) {
			while(!vert2.ConjuntoVacio()) {
				if(G.ExisteArista(vert.ElegirConjunto(), vert2.ElegirConjunto())||G.ExisteArista(vert2.ElegirConjunto(), vert.ElegirConjunto())) {
					aisl.SacarConjunto(vert.ElegirConjunto());
				}
				vert2.SacarConjunto(vert2.ElegirConjunto());
			}
			CopiarConjunto(G.Vertices(),vert2);
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		return aisl;
	}
	/**
	 * @TAREA Determinar el grado de un vértice
	 * @PARAMETRO Grafo, Vértice
	 * @PRECONDICON Grafo inicializado, Vertice perteneciente al grafo
	 * @POSTCONDICON none
	 * @DEVUELVE int
	 * @COSTO Lineal
	 **/
	public int GGradoVert(GrafoTDA G, int v) {
		int salientes=0, entrantes=0,grado;
		ConjuntoTDA vert=G.Vertices();
		while(!vert.ConjuntoVacio()) {
			if(G.ExisteArista(v, vert.ElegirConjunto())) {
				salientes++;
			}
			if(G.ExisteArista(vert.ElegirConjunto(), v)) {
				entrantes++;
			}
			vert.SacarConjunto(vert.ElegirConjunto());
		}
		grado=salientes-entrantes;
		return grado;
	}
	
	//TP4 Pto 3 K -FedeP
	/**
	 * @TAREA Determinar los elementos que están en un nivel X del árbol
	 * @PARAMETRO ABBTDA, int nivel
	 * @PRECONDICON Arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE integer
	 * @COSTO Recursivo
	 **/
	public int ElementosNivelABB(ABBTDA a, int x) {
		int alt=CalcularAlturaABB(a);
		int cant=0;
		if(a.ArbolVacio()||x>alt) {
			return cant;
		}
		else if (!a.ArbolVacio()&&alt==0) {
			return cant +1;
		}
		else {
			return ElementosNivelABB(a.HijoDer(),x-1)+ElementosNivelABB(a.HijoIzq(),x-1);
		}
				
	}
	//TP4 Punto3M Fedep
	/**
	 * @TAREA hacer un conjunto con los elementos mayores que k
	 * @PARAMETRO ABBTDA, int nivel
	 * @PRECONDICON Arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE ConjuntoTDA
	 * @COSTO Recursivo
	 **/
	public ConjuntoTDA ConjuntoElementosMayoresKABB(ABBTDA a, int x) {
		ConjuntoTDA may = new ConjuntoLD();
		may.InicializarConjunto();
		if(!a.ArbolVacio()) {
			if(a.Raiz()>x) {
				may.AgregarConjunto(a.Raiz());
			}
			ConjuntoTDA mayder=UnionConjunto(may, ConjuntoElementosMayoresKABB(a.HijoDer(),x));
			ConjuntoTDA mayizq= UnionConjunto(may, ConjuntoElementosMayoresKABB(a.HijoIzq(),x));
			return UnionConjunto(mayder,mayizq);
		}
		else
			return may;
		
	}
	
	//TP4 Punto 3D Iterativo
	/**
	 * @TAREA Encontrar el valor mínimo de un árbol de forma iterativa
	 * @PARAMETRO ABBTDA
	 * @PRECONDICON Arbol inicializado
	 * @POSTCONDICON SE PIERDE EL ARBOL
	 * @DEVUELVE Int
	 * @COSTO Lineal
	 **/
	public int MinimoIterativo(ABBTDA a) {
		ABBTDA izq = new ABB();
		ABBTDA der = new ABB();
		izq.InicializarArbol();
		der.InicializarArbol();
		izq = a.HijoIzq();
		der = a.HijoDer();
		int min = a.Raiz();
		while(!a.ArbolVacio()) {
			if (!izq.ArbolVacio()&&izq.Raiz() < a.Raiz()) {
				a = izq;
				izq = izq.HijoIzq();
				der = der.HijoDer();
				min = a.Raiz();
			} else if (!der.ArbolVacio() && der.Raiz() < a.Raiz()) {
				a = der;
				izq = izq.HijoIzq();
				der = der.HijoDer();
				min = a.Raiz();
			} else {
				return min;
			}
		}
		return min;
	}
	//TP4 Punto 3A ITERATIVO
	/**
	 * @TAREA Determinar si un elemento pertenece o no a un arbol
	 * @PARAMETRO ABBTDA, integer
	 * @PRECONDICON Arbol inicializado, valor
	 * @POSTCONDICON SE PIERDE EL ARBOL
	 * @DEVUELVE booleano
	 * @COSTO Lineal
	 **/
	public boolean PerteneceABBIt(ABBTDA a,int x) {
		ABBTDA izq = new ABB();
		ABBTDA der = new ABB();
		izq.InicializarArbol();
		der.InicializarArbol();
		boolean flag = true;
		while(flag && !a.ArbolVacio()) {
			izq = a.HijoIzq();
			der = a.HijoDer();
			if(x==a.Raiz())
				flag=false;
			else if(!der.ArbolVacio()&&x>a.Raiz()) {
				a=der;
			}
			else if(!izq.ArbolVacio()&&x<a.Raiz()) {
				a=izq;
			}
			else
				flag=false;
		}
		if(x==a.Raiz()) 
			return true;
		else
			return false;
	
	}
	//TP4 Punto 3C iterativo
	/**
	 * @TAREA Determinar la profundidad de un elemento en un árbol
	 * @PARAMETRO ABBTDA, integer
	 * @PRECONDICON Arbol inicializado, valor existente
	 * @POSTCONDICON SE PIERDE EL ARBOL
	 * @DEVUELVE integer
	 * @COSTO Lineal
	 **/
	public int ProfunidadIterativo(ABBTDA a, int elem) {
		ABBTDA izq = new ABB();
		ABBTDA der = new ABB();
		izq.InicializarArbol();
		der.InicializarArbol();
		izq = a.HijoIzq();
		der = a.HijoDer();
		int profundidad = 0;
		boolean flag=true;
		if(a.ArbolVacio()) {
			return 0;
		} else {
			while(!a.ArbolVacio()&&flag) {
				if (a.Raiz() == elem) {
					flag=false;
				} else if (!der.ArbolVacio() && der.Raiz() <= elem) {
					a = der;
					izq = a.HijoIzq();
					der = a.HijoDer();
					profundidad++;
				} else if (!izq.ArbolVacio() && izq.Raiz() >= elem) {
					a = izq;
					izq = a.HijoIzq();
					der = a.HijoDer();
					profundidad++;
				} else {
					flag=false;
				}
			}
				return profundidad;
		}
	}
	//Punto 4B Iterativo
	/**
	 * @TAREA Determinar si un elemento es una hoja de un arbol de forma iterativa
	 * @PARAMETRO ABBTDA, valor
	 * @PRECONDICON Arbol inicializado, valor perteneciente al arbol
	 * @POSTCONDICON SE PIERDE EL ARBOL
	 * @DEVUELVE Booleano
	 * @COSTO Lineal
	 **/
	public boolean HojaIterativo(ABBTDA a, int elem) {
		ABBTDA izq = new ABB();
		ABBTDA der = new ABB();
		izq.InicializarArbol();
		der.InicializarArbol();
		
		boolean flag=true;
		while(!a.ArbolVacio()&&flag) {
			izq = a.HijoIzq();
			der = a.HijoDer();
			if (a.Raiz() == elem) {
				flag=false;
			} else if (!izq.ArbolVacio() && a.Raiz() > elem) {
				a = izq;
			} else if (!der.ArbolVacio() && a.Raiz() < elem) {
				a = der;
			} else {
				flag = false;
			}
		}
		
		return (a.HijoDer().ArbolVacio()&&a.HijoIzq().ArbolVacio());
	}
	
}
