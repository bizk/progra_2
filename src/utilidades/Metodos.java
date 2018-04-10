package utilidades;

import api.*;
import implementaciones.arreglos.*;

public class Metodos {
	class Pilas_metodos extends implementaciones.arreglos.Pilas {		
		Pilas origen = new Pilas();
		Pilas destino = new Pilas();
		
		/**@TAREA Pasar contenido de una pila a otra en orden inverso
		 * @PARAMETRO pila original
		 * @PARAMETRO pila destino
		 * @PRECONDICON Ambas pilas iniciadas
		 * @POSTCONDICON Se pierde la pila original**/
		void PasarPila(PilaTDA origen, PilaTDA destino) {
		     while(!origen.PilaVacia()) {
	            destino.Apilar(origen.Tope());
	            origen.Desapilar(); 
	        }
	    }
		/**@TAREA Copiar contenido de una pila a otra
		 * @PARAMETRO pila original
		 * @PARAMETRO pila destino
		 * @PRECONDICION Ambas pilas iniciadas
		 * @POSTCONDICION Se pierde la pila original**/
	    public void CopiarPila(PilaTDA origen, PilaTDA destino) {
		        PilaTDA aux = new Pilas();
		        aux.InicializarPila();
		        PasarPila(origen, aux); 
		        PasarPila(aux, destino);
		       // destino =  aux; Lo saco pq esto no queda bien, cambie los parametros de las dos PasarPila para que la ultima quede en destino
		        //OJO, creo que no se puede perder la pila original- Fedejp
	    }
	    /**@TAREA Invertir el contenido de una pila
	     * @PARAMETRO pila original
	     * @PRECONDICIOn pila iniciada
	     * @POSTCONDICON la pila original se devuelve invertida**/
		    public void InvertirPila(PilaTDA origen) {
		        PilaTDA aux = new Pilas();
		        aux.InicializarPila();

		        PasarPila(origen, aux);
	        //origen = aux;
		        CopiarPila(aux,origen);
	    }
		    /**@TAREA Contar la cantidad de elementos de una pila
		     * @PARAMETRO pila a contar
		     * @PRECONDICION pila iniciada
		     * @DEVUELVE integer que representa la cantidad de elementos
		     * @POSTCONDICION none**/
	    public int ContarElemPila(PilaTDA origen) {
	        int x = 0;
	        PilaTDA aux = new Pilas();
	        aux.InicializarPila();
	      //Agrego funcion para no perder pila original -Fedejp
	        while (!origen.PilaVacia()) {
	            x++;
	            aux.Apilar(origen.Tope());
	            origen.Desapilar();
	        }
	        while(!aux.PilaVacia()) {
	        	origen.Apilar(aux.Tope());
	        	aux.Desapilar();
	        }
	        
	        return x;
		}
	    
	    /**@TAREA Sumar los elementos de una pila
	     * @PARAMETRO pila a sumar
	     * @PRECONDICION pila iniciada
	     * @DEVUELVE integer que representa la suma de los elementos
	     * @POSTCONDICION Se pierden los datos de la pila**/
		    public int SumarElemPIla(PilaTDA origen) {
		    int x = 0;
		  //Agrego funcion para no perder pila original -Fedejp
		    PilaTDA aux = new Pilas();
	        aux.InicializarPila();
	        while(!origen.PilaVacia()) {
	            x += origen.Tope();
	            aux.Apilar(origen.Tope());
	            origen.Desapilar();
	        }
	        while(!aux.PilaVacia()) {
	        	origen.Apilar(aux.Tope());
	        	aux.Desapilar();
	        }
	        return x;
		}
		    /**@TAREA Calcular promedio de los elementos de una pila
		     * @PARAMETRO pila a promediar
		     * @PRECONDICION pila iniciada
		     * @DEVUELVE double que representa el promedio de los elementos
		     * @POSTCONDICION none**/
		public double PromedioElemPila(PilaTDA origen) {
			int x = SumarElemPIla(origen);
		    int y = ContarElemPila(origen);
	        return(x/y);
		}
	}
	
	class Colas {//Creo que deberiamos poner esto en otro archivo. No me acuerdo que dijo la profe -Fedejp
		/**@TAREA Copiar una cola en otra
		 * @PARAMETRO cola original
		 * @PARAMETRO cola destino
		 * @PRECONDICON Ambas colas iniciadas
		 * @POSTCONDICON none**/
		public void CopiarCola(ColaTDA origen, ColaTDA destino) {//Cambio para que no se pierda la cola original -Fedejp
	       ColaTDA aux = new ColaPU();
	       aux.InicializarCola();
			while(!origen.ColaVacia()) {
	            destino.Acolar(origen.Primero());
	            aux.Acolar(origen.Primero());
	            origen.Desacolar();
	        }
			while(!aux.ColaVacia()) {
				origen.Acolar(aux.Primero());
				aux.Desacolar(); 
			}
	    }
		/**@TAREA Invertir una Cola con pilas auxiliares
		 * @PARAMETRO cola original
		 * @PRECONDICON Cola iniciada
		 * @POSTCONDICON La cola se devolverá invertida**/
	    public void InvertirColaPila(ColaTDA origen) { // usando pilas auxiliares
	        PilaTDA p = new Pilas();
	        while (!origen.ColaVacia()) {
	            p.Apilar(origen.Primero());
	            origen.Desacolar();
	        }
	        while (!p.PilaVacia()){
	            origen.Acolar(p.Tope());
	            p.Desapilar();
	        }
	    }
	    /**@TAREA Contar elementos de una cola
		 * @PARAMETRO cola original
		 * @PRECONDICON Cola iniciada
		 * @POSTCONDICON none**/
	    public int ContarElemCola(ColaTDA origen) {
	    	int cont=0;
	    	ColaTDA aux = new ColaPI();
	    	while(!origen.ColaVacia()){
	    		cont++;
	    		aux.Acolar(origen.Primero());
	    		origen.Desacolar();
	    	}
	    	CopiarCola(aux,origen);
	    	return cont;
	    }
	    /**@TAREA Invertir una Cola SIN pilas auxiliares
		 * @PARAMETRO cola original
		 * @PRECONDICON Cola iniciada
		 * @POSTCONDICON La cola se devolverá invertida**/
	    public void InvertirColaSola(ColaTDA origen) {
	    	ColaTDA aux = new ColaPI();
	    	ColaTDA aux2 =new ColaPI();
	    	int cant=ContarElemCola(origen);
	    	int count=0;
	    	aux.InicializarCola();
	    	aux2.InicializarCola();
	    	while(cant!=0)
	    	{
	    		while(count<cant-1) {
	    			count++;
	    			aux.Acolar(origen.Primero());
	    			origen.Desacolar();
	    		}
	    		aux2.Acolar(origen.Primero());
	    		origen.Desacolar();
	    		count=0;
	    		cant--;
	    		CopiarCola(aux,origen);
	    	}
	    	CopiarCola(aux2,origen); //Si no me equivoco es lo que dijo la profe, revisar -Fedejp
	    	
	    }
	 /*   public void InvertirColaSola(ColaTDA o) { // Este no pude hacerlo
	        ColaTDA aux = new ColaTDAI();
	        ColaTDA aux2 = new Colas();
	        aux.InicializarCola();
	        aux2.InicializarCola();
	        
	        aux2.Acolar(o.Primero());
	        o.Desacolar();
	        while(!o.ColaVacia()) {
	            aux.Acolar(o.Primero());
	            o.Desacolar();
	        }
	        o = aux;
	    } */

	    /**@TAREA Comparar el final de dos colas
		 * @PARAMETRO cola nro1
		 * @PARAMETRO Cola nro2
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON none**/
	    public void CompararFinal(ColaTDA ct1, ColaTDA ct2) {//editado para que no se pierdan las colas -Fedejp
	        int y = 0, x = 0;
	        ColaTDA aux =new ColaPU();
	        ColaTDA aux2 =new ColaPU();
	        aux.InicializarCola();
	        aux2.InicializarCola();
	        CopiarCola(ct1,aux);
	        CopiarCola (ct2,aux);
	        while (!aux.ColaVacia()) {
	            x = aux.Primero();
	            aux.Desacolar();
	        }
	        while (!aux2.ColaVacia()) {
	            y = aux2.Primero();
	            aux2.Desacolar();
	        }
	        if (y == x) {
	            System.out.println("Son iguales!");
	        } else {
	            System.out.println("Son diferentes!");
	        }
	    }

	    /**@TAREA Verificar si la cola es capicua
		 * @PARAMETRO cola nro1
		 * @PRECONDICON Cola iniciada
		 * @POSTCONDICON none **/
	    public void ColaCapicua(ColaTDA o) {//Editado para que no se pierda la cola original -Fedejp
	        ColaTDA aux = new ColaPI();
	        ColaTDA auxinv =new ColaPI();
	        aux.InicializarCola();
	        auxinv.InicializarCola();
	        CopiarCola(o, aux);
	        CopiarCola(o,auxinv);
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

	    /**@TAREA Verificar si una cola es inversa de otra
		 * @PARAMETRO cola nro1
		 * @PARAMETRO cola nro2
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON Las colas se perderan ARREGLAR ESTO**/
	    public void ColaCompararInverso(ColaTDA cp1, ColaTDA cp2) {
	        int iguales = 1;
	        InvertirColaPila(cp2);
	        while (iguales == 1 && !cp1.ColaVacia() && !cp2.ColaVacia()) {
	            iguales = 0;
	            if (cp1.Primero() == cp2.Primero()) {
	                iguales = 1;
	            }
	            cp1.Desacolar();
	            cp2.Desacolar();
	        }
	        if (cp1.ColaVacia() && cp2.ColaVacia() && iguales == 1) {
	            System.out.println("Una cola es inversa de la otra");
	        } else {
	            System.out.println("No son inversas");
	        }
	    }
	}
	
	class ColaPrioirdad {
		
		/**@TAREA Combinar colas con prioridad, donde los elementos de la primera tendrán más prioridad que los de la segunda
		 * @PARAMETRO cola nro1, de mayor prioridad
		 * @PARAMETRO cola nro2
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON Checkear si la cola se pierde**/
	    public void CombinarColasPropiedades (ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {

	        //Inicializamos ambas colas
	        CP1.InicializarCola();
	        CP2.InicializarCola();

	        //Creamos la cola auxiliar y la inicializamos
	        ColaPrioridadTDA AUX = new ColaPrioridadDA();
	        AUX.InicializarCola();

	        //Ya que la primer cola tiene prioridad realizamos el proceso hasta que esta se vacie
	        while (!CP1.ColaVacia()) {
	            if (CP1.Prioridad() >= CP2.Prioridad()) { //Si la cola 1 tiene mayor prioridad o es igual, la acolamos primero
	                AUX.AcolarPrioridad(CP1.Primero(), CP1.Prioridad());
	                CP1.Desacolar();
	            } else { //Si no acolamos la cola 2
	                AUX.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
	                CP2.Desacolar();
	            }
	        }


	        if (!CP2.ColaVacia()) { //Si salimos de la cola 1 pero nos quedo data en la segunda
	            while (!CP2.ColaVacia()) { //Cargamos el resto de la info hasta que nos quedemos sin la misma
	                AUX.AcolarPrioridad(CP2.Primero(), CP2.Prioridad());
	                CP2.Desacolar();
	            }
	        }
	    }

	    /**@TAREA Verificar que dos colas sean identicas
		 * @PARAMETRO cola nro1
		 * @PARAMETRO cola nro2
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON Las colas se pierden ARREGLAR ESTO**/
	    public void ComprobarIdentidad (ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {
	      // ColaPrioridadDA AuxCP1 = new ColaPrioridadDA();
	      // ColaPrioridadDA AuxCP2 = new ColaPrioridadDA();
	       // Se pierden las colas ya que no tenemos el metodo de copiar
	    	// Por lo tanto con el metodo copiar podriamos pasar las colas originalres a un auxuliar
	       
	        while (!CP1.ColaVacia() && !CP2.ColaVacia() && CP1.Primero() == CP2.Primero() && CP1.Prioridad() == CP2.Prioridad()) {
	            CP1.Desacolar(); //Mientras ninguna termine antes que la otra, sus numeros y sus prioridades sean iguales
	            CP2.Desacolar(); // vamos desacolando.
	        }

	        if (CP1.Primero() != CP2.Primero()) { //Chequeamos que no haya salido por numeros diferentes
	            System.out.println("Son distintas");
	        } else {
	            if (CP1.Prioridad() != CP2.Prioridad()) { //Chequeamos que no haya salido por prioridades diferentes
	                System.out.println("Son distintas");
	            } else { //Chequeamos que ambas colas esten vacias
	                if (!CP1.ColaVacia() && CP2.ColaVacia()) { //La cola 1 no termino, pero la 2 si
	                    System.out.println("Son distintas");
	                } else if (CP1.ColaVacia() && !CP2.ColaVacia()) { //La cola 2 no termino, pero la 1 si.
	                    System.out.println("Son distintas");
	                } else { //Si no....
	                    //Son iguales!
	                    System.out.println("Son iguales!");
	                }
	            }
	        }
	    }
	}
}
