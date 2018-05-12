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
	
	class Colas {	//Creo que deberiamos poner esto en otro archivo. No me acuerdo que dijo la profe -Fedejp
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
		 * @POSTCONDICON La cola se devolverï¿½ invertida**/
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
		 * @POSTCONDICON La cola se devolverï¿½ invertida**/
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
	
	    /* # # # # # # # # # # # # # # # # # # # # # # # # # 
	     *					 BANDERA
	     # # # # # # # # # # # # # # # # # # # # # # # # # */ 
	    
	    //Aca va lo del tp 3 punto 2, no se si tendria que ir en otro archivo, pero bueno, -BIZK	    
	   //TP 3 - 2.A. -BIZK (11/04/2018)
	    
	    /**@TAREA Eliminar de la cola la repeticion de elementos
		 * @PARAMETRO cola nro1
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON La cola quedara sin elemento repetidos**/
	    public void ColaEliminarRepeticiones(ColaTDA cp1) {
	    	ColaTDA aux = new ColaPI();
	    	ColaTDA aux2 = new ColaPI();
	    	ColaTDA aux3 = new ColaPI();
	    	CopiarCola(cp1, aux); //Copiamos los elementos de la cola 1 a aux para no perderla
	    	while(!aux.ColaVacia()) {
	    		CopiarCola(aux, aux2); 
	    		//Copiamos aux a aux2 ya que vamos a ir moviendo de numero en numero
	    		//Es decir como vamos a comparar al primero de l de aux y luego lo desacolamos para comparar 
	    		//Al siguiente numero. 
		    	while(!aux2.ColaVacia()) { //Hasta que no llegemos al final de aux 2 no paramos
		    		aux3.Acolar(aux2.Primero());  //Acolamos el primero, ya que tecnicamente esle numero que vamos a comaprar
		    		aux2.Desacolar(); //Y lo desacolamos de aux2 para no borrarlo.
		    		if(aux.Primero() == aux2.Primero()) { //Cualquier otra repeticion la salteamos 
		    			aux2.Desacolar();
		    		} else { //Mientras que aca la vamos acolando
		    			aux3.Acolar(aux2.Primero());
		    		}
		    	}
		    	CopiarCola(aux3, aux); //Pasamos aux3 donde tiene los elementos repetidos de aux borrados como el nuevo aux
		    	aux.Desacolar(); //Desacolamos aux para comparar el siguiente numero
	    	}
	    }
	
	   //TP 3 - 2.B. -BIZK (11/04/2018)
	    /**@TAREA Partir una cola dos mitades M1 y M2 de elementos consecutivos
		 * @PARAMETRO cola nro1
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON 2 Colas que seran las mitades de la cola 1**/
	    public void ColaPartir(ColaTDA cp1) {
	    	ColaTDA M1 = new ColaPU(); //Al ser los ultimos los que sacamos sera la primer parte
	    	ColaTDA M2 = new ColaPI(); //Al ser los primeros los que sacamos sera la segunda parte
	    	
	    	//Copiamos ambas colas
	    	CopiarCola(cp1, M1);
	    	CopiarCola(cp1, M2);
	    	
	    	int x = ContarElemCola(cp1)/2; //Partimos la cantidad de elementos a la mitad
	    	
	    	//Recorremos i hasta llegar a la mitad de elementos
	    	//En "TEORIA", vamos desacolando ambas hasta desacolar la mitad de cada una
	    	//Como sacamos los elementos en una del primero y en la otra del ultimo nos deberian quedar dos
	    	//mitades diferentes
	    	if (ContarElemCola(cp1)%2 == 0 ) { //Si tenemos elementos par 
		    	for(int i = 0; i < x; i++) {
		    		M1.Desacolar();
		    		M2.Desacolar();
		    	}
	    	} else {
	    		System.out.println("Lo sentimos no se poede partir por que no tenemos un numero par de elementos.");
	    	}
	    }
	
	    /**@TAREA Genera una cola con las repeticiones de elementos
`		 * @PARAMETRO cola nro1
	 	 * @PRECONDICON Colas iniciadas
	 	 * @POSTCONDICON nueva cola con colas generadas**/
	 	public void ColaGenerarRepetidos(ColaTDA cp1) {
	 		ColaTDA aux = new ColaPI();
	 	   	ColaTDA aux2 = new ColaPI();
	 	   	ColaTDA aux3 = new ColaPI();
	 	   	CopiarCola(cp1, aux); //Copiamos los elementos de la cola 1 a aux para no perderla
	 	   						  //Funciona igual que el otro
	 	    
	 	   	while(!aux.ColaVacia()) {
	 	   		CopiarCola(aux, aux2); 
	 	   		//Copiamos aux a aux2 ya que vamos a ir moviendo de numero en numero
	 	   		//Es decir como vamos a comparar al primero de l de aux y luego lo desacolamos para comparar 
	 	   		//Al siguiente numero. 
	 	    	while(!aux2.ColaVacia()) { //Hasta que no llegemos al final de aux 2 no paramos
		    		aux2.Desacolar(); //Desacolamos el primero ya que es el primero
		    		if(aux.Primero() == aux2.Primero()) { //Cualquier repeticion la copiamos	 
	 	    			aux3.Acolar(aux2.Primero());
	 	    		} else { //Mientras que aca la vamos acolando
 		    			aux2.Desacolar();
	 		   		}
	 		   	}
	 		   	aux.Desacolar(); //Desacolamos aux para comparar el siguiente numero
	 	   	}
	 	}
	}
	
	class ColaPrioirdad {
		public ColaPrioridadTDA CopiarColaPri(ColaPrioridadTDA origen) {
			ColaPrioridadTDA aux = new ColaPrioridadDA();
			ColaPrioridadTDA aux2 = new ColaPrioridadDA();
			aux.InicializarCola();
			aux2.InicializarCola();
			while(!origen.ColaVacia()) {
				aux.AcolarPrioridad(origen.Primero(), origen.Prioridad());
				origen.Desacolar();
			}
			while(!aux.ColaVacia()) {
				aux2.AcolarPrioridad(aux.Primero(), aux.Prioridad());
				origen.AcolarPrioridad(aux.Primero(), aux.Prioridad());
				aux.Desacolar();
			}
			
			return aux2;
			
		}
		
		/**@TAREA Combinar colas con prioridad, donde los elementos de la primera tendrï¿½n mï¿½s prioridad que los de la segunda
		 * @PARAMETRO cola nro1, de mayor prioridad
		 * @PARAMETRO cola nro2
		 * @PRECONDICON Colas iniciadas
		 * @POSTCONDICON Checkear si la cola se pierde**/
	    public void CombinarColasPrioridad (ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {

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
	class Conjunto {
		/**@PARAMETROS: Conjunto Origen, Conjunto destino
		 * @precondicion: conjuntos inicializados
		 * @POSTCONDICION: **/
		public ConjuntoTDA CopiarConjunto(ConjuntoTDA origen, ConjuntoTDA destino) {
			PilaTDA aux = new Pilas();
			aux.InicializarPila();
			while(!origen.ConjuntoVacio()) {
				aux.Apilar(origen.ElegirConjunto());
				origen.SacarConjunto(origen.ElegirConjunto());
			}
			while(!aux.PilaVacia()) {
				destino.AgregarConjunto(aux.Tope());//de esta forma, los conjuntos son copias exactas en elementos y orden
				origen.AgregarConjunto(aux.Tope());
				aux.Desapilar();
			}
			return destino;
    }
		//TP 2 - 6. Federico Parodi
		/**@TAREA Encontrar la interseccion entre dos conjuntos.
		 * @PARAMETRO Conjunto 1, Conjunto 2.
		 * @PRECONDICION Conjuntos inicializados
		 * @POSTCONDICION none
		 * @DEVUELVE ConjuntoTDA con los elementos que estan en ambos conjuntos.**/
		public ConjuntoTDA InterseccionConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
			ConjuntoTDA aux1 = new ConjuntoUA();
			ConjuntoTDA inter = new ConjuntoUA();
			aux1.InicializarConjunto();
			inter.InicializarConjunto();
			CopiarConjunto(C1, aux1);
			while(!aux1.ConjuntoVacio()) {
				if(C2.PerteneceConjunto(aux1.ElegirConjunto())) {
					inter.AgregarConjunto(aux1.ElegirConjunto());
				}
				aux1.SacarConjunto(aux1.ElegirConjunto());
			}
			return inter;
		}
		
		/**@TAREA Encontrar la union entre dos conjuntos.
		* @PARAMETRO Conjunto 1, Conjunto 2.
		 * @PRECONDICION Conjuntos inicializados
		 * @POSTCONDICION none
		 * @DEVUELVE ConjuntoTDA con los elementos que estan en uno u otro conjunto.**/
		public ConjuntoTDA UnionConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
			ConjuntoTDA aux1 = new ConjuntoUA();
			ConjuntoTDA aux2 = new ConjuntoUA();
			ConjuntoTDA uni = new ConjuntoUA();
			aux1.InicializarConjunto();
			aux2.InicializarConjunto();
			uni.InicializarConjunto();
			CopiarConjunto(C1, aux1);
			CopiarConjunto(C1, aux2);
			while(!aux1.ConjuntoVacio()) {
				uni.AgregarConjunto(aux1.ElegirConjunto());
				aux1.SacarConjunto(aux1.ElegirConjunto());
			}
			while(!aux2.ConjuntoVacio()) {
				if(!uni.PerteneceConjunto(aux2.ElegirConjunto())) {
					uni.AgregarConjunto(aux2.ElegirConjunto());
				}
				aux2.SacarConjunto(aux2.ElegirConjunto());
			}
			return uni;
		}
		/**@TAREA Encontrar la diferencia entre dos conjuntos.
		 * @PARAMETRO Conjunto 1(minuendo) , Conjunto 2(sustraendo).
		 * @PRECONDICION Conjuntos inicializados
		 * @POSTCONDICION none
		 * @DEVUELVE ConjuntoTDA con los elementos que estan en C1 menos los que estï¿½n en C2.**/

		public ConjuntoTDA DiferenciaConjunto(ConjuntoTDA C1, ConjuntoTDA C2) {
			ConjuntoTDA aux1 = new ConjuntoUA();
			ConjuntoTDA aux2 = new ConjuntoUA();
			aux1.InicializarConjunto();
			aux2.InicializarConjunto();
			CopiarConjunto(C1, aux1);
			CopiarConjunto(C1, aux2);
			while(!aux2.ConjuntoVacio()) {
				if(aux1.PerteneceConjunto(aux2.ElegirConjunto())) {
					aux1.SacarConjunto(aux2.ElegirConjunto());
				}
				aux2.SacarConjunto(aux2.ElegirConjunto());
			}
			return aux1;
			
		}
	}
	class Diccionario {
		//TP 3 - 5.A. Carlos Santiago YANZON -BIZK (14/04/2018)
	    /**@TAREA Generar un dicconario multiple en base a ods diccionarios multiples D1 y D3
		 * @PARAMETRO diccionario 1 y 2
		 * @PRECONDICON Diccionarios iniciados.
		 * @POSTCONDICON 1 Diccionario multiple
		**/
		public void UnificarDicMultiples(DiccionarioMultipleTDA D01, DiccionarioMultipleTDA D02) {
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
			clavesd01 = D01.claves();
			clavesd02 = D02.claves();
			
			
			int clave, valor;
			//obtenemos los valores de dichas claves
			while(!clavesd01.ConjuntoVacio()) { //Recorremos todas las claves
				clave = clavesd01.ElegirConjunto();  //Sacamaos una clave
				valoresd01 = D01.Recuperar(clave); //Con esa clave obtenemos el conjunto de valores
				while(!valoresd01.ConjuntoVacio()) { //Recorremos el conjunto de valores
					valor = valoresd01.ElegirConjunto(); // Obtenemos un valor
					dic.Agregar(clave, valor); //Agregamos la clave y el valor
					valoresd01.SacarConjunto(valor); //Eliminamos el valor
				} //Una vez recorrimos todos los valores 
				clavesd01.SacarConjunto(clave); //eliminamos esa clave asi podemos acceder a la siguiente
			}
			
			while(!clavesd02.ConjuntoVacio()) { //Recorremos todas las claves
				clave = clavesd02.ElegirConjunto();  //Sacamaos una clave
				valoresd02 = D02.Recuperar(clave); //Con esa clave obtenemos el conjunto de valores
				while(!valoresd02.ConjuntoVacio()) { //Recorremos el conjunto de valores
					valor = valoresd02.ElegirConjunto(); // Obtenemos un valor
					dic.Agregar(clave, valor); //Agregamos la clave y el valor
					valoresd02.SacarConjunto(valor); //Eliminamos el valor
				} //Una vez recorrimos todos los valores 
				clavesd02.SacarConjunto(clave); //eliminamos esa clave asi podemos acceder a la siguiente
			}			
		}
	
		//TP 3 - 5.B. //ESTA NO PUDE AUNQU CROE QUE ES LO MISMO QUE EL D.
	    /**@TAREA Generar un dicconario multiple en base a los elementos en comun de los diccionarios multiples D1 y D3
		 * @PARAMETRO diccionario 1 y 2
		 * @PRECONDICON Diccionarios iniciados.
		 * @POSTCONDICON 1 Diccionario multiple
		 * 
		 * ESTE NO LO ENTENDI BIEN.
		**/
		
		//TP 3 - 5.C. -Carlos Santiago YANZON -BIZK (14/04/2018)
	    /**@TAREA Generar un dicconario multiple en base a dos diccionarios multiples D1 y D3 el cual tendra
	     * 		  todos los valores de las claves en comun
		 * @PARAMETRO diccionario 1 y 2
		 * @PRECONDICON Diccionarios iniciados.
		 * @POSTCONDICON 1 Diccionario multiple
		**/
		public void DicMultClavesComun(DiccionarioMultipleTDA D01, DiccionarioMultipleTDA D02) {
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
			clavesd01 = D01.claves();
			
			int clave1, clave2, valor1, valor2;
			ConjuntoTDA valconj01 = new ConjuntoTMA();
			ConjuntoTDA valconj02 = new ConjuntoTMA();
			
			//obtenemos los valores de dichas claves
			while(!clavesd01.ConjuntoVacio()) {
				clavesd02 = D02.claves(); //Reinicioamos las claves de claves02 para recorrerlas todas
				clave1 = clavesd01.ElegirConjunto(); //Sacamos una clave de clavesd01
				while(!clavesd02.ConjuntoVacio()) { //Recorremos todas las claves de d02
					clave2 = clavesd02.ElegirConjunto(); //Sacamos una clave de clavesd02
					if(clave1 == clave2) { //Si son iguales procedemos a unificar todo
						valconj01 = D01.Recuperar(clave1); //Obtenemos todos los valores de la clave
						while(!valconj01.ConjuntoVacio()) { //REcorremos todos los valores
							valor1 = valconj01.ElegirConjunto(); //Elegimos un valor al azar
							valor2 = valconj02.ElegirConjunto();
							dic.Agregar(clave1, valor1); //Agregamos el primer valor
							dic.Agregar(clave2, valor2); //Agruegamos ambos valores
						}
					} //Si no, decidimos seguir comparando todas las claves2 con esa clave
					clavesd02.SacarConjunto(clave2);
				}//Volvemos a hacer lo mismo hasta quedarnos sin claves en clavd01
				
				clavesd01.SacarConjunto(clave1); //eliminamos esa clave asi podemos acceder a la siguiente
			}		
		}
	
		//TP 3 - 5.C. Carlos Santiago YANZON -BIZK (14/04/2018)
	    /**@TAREA Generar un dicconario multiple en base a dos diccionarios multiples D1 y D3 el cual tendra
	     * 		  todos los valores de las claves en comun
		 * @PARAMETRO diccionario 1 y 2
		 * @PRECONDICON Diccionarios iniciados.
		 * @POSTCONDICON 1 Diccionario multiple
		**/
		public void DicMultClavesYValComun(DiccionarioMultipleTDA D01, DiccionarioMultipleTDA D02) {
			DiccionarioMultipleTDA dic = new DicMultipleA(); //Definimos el diccionario donde guardaremos todo
			dic.InicializarDiccionario();
			
			//Obtenemos los conjuntos de claves
			ConjuntoTDA clavesd01 = new ConjuntoTMA();
			ConjuntoTDA clavesd02 = new ConjuntoTMA();
			clavesd01.InicializarConjunto();
			clavesd02.InicializarConjunto();
			
			//Obtenemos los conjuntos de valores
			ConjuntoTDA valoresd01 = new ConjuntoTMA();
			ConjuntoTDA valoresd02 = new ConjuntoTMA();
			valoresd01.InicializarConjunto();
			valoresd02.InicializarConjunto();
			
			//Obtenemos todas las claves del primer conjunto
			clavesd01 = D01.claves();
			
			//Definimos los enteros
			int clave1, clave2, valor1, valor2;
			
			//Obtenemos una clave
			while(!clavesd01.ConjuntoVacio()) { //Recorremos todas las claves de d01
				clavesd02 = D02.claves(); //Reiniciamos las claves de d02	
				clave1 = clavesd01.ElegirConjunto(); //Elegimos una clave de d01				
				while(!clavesd02.ConjuntoVacio()) { //Para cada clave de d01 recorremos todas las de d02
					clave2 = clavesd02.ElegirConjunto(); //Elegimos una clav de d02	
					if(clave1 == clave2) { //Si ambas claves son iguales
						valoresd01 = D01.Recuperar(clave1); //recuperamos todos los valores de dicha ckave en d01				
						while(!valoresd01.ConjuntoVacio()) { //Recorremos todos los valores de la clave en d01
							valor1 = valoresd01.ElegirConjunto(); //Obtenemos el primer valor
							valoresd02 = D02.Recuperar(clave2); //obtenemos todos los valores del conjunto d02 este se reinicia
																//ya que lo recorreremos uno por uno y tendremos qu ehacerlo para
																//cada valor de la clave en d01
							while(!valoresd02.ConjuntoVacio()) {
								valor2 = valoresd02.ElegirConjunto(); //Elegimos un valor			
								if(valor1 == valor2) {
									dic.Agregar(clave1, valor1); //Si son iguales agregamos la clave y dicho valor.
								}
								valoresd02.SacarConjunto(valor2); //Lo quitamos para seguir buscando
							}
							valoresd01.SacarConjunto(valor1); //Lo sacamos del conjunto.
						}
					}
					clavesd02.SacarConjunto(clave2); //Quitamos la clave para seguir recorriendo el vector.
				}	
				clavesd01.SacarConjunto(clave1); //Vamos vaciando el conjunto de claves
			}
			
		}
	}
	class ABB {	//ABB NO TIENE VALORES REPETIDOS
		//TP4 3-A gonza 05/05/18
		/**@TAREA determinar si un elemento esta o no en el AB
		 * @PARAMETRO arbol 
		 * @PRECONDICON arbol inicializado
		 * @POSTCONDICON none
		 * @DEVUELVE true or false**/
		public boolean existeElementoABB(int elemen,ABBTDA arbol) {
			if(arbol.ArbolVacio()) {
				return false;
			}
			else if(arbol.Raiz()==elemen) {
				return true;
			}
			else if(arbol.Raiz()>elemen) {
				return existeElementoABB(elemen,arbol.HijoIzq());
			}
			else {
				return existeElementoABB(elemen,arbol.HijoDer());
			}
		}
	
	
	//TP4 3-b gonza 05/05/18
	/**@TAREA dado un elemento determinar si es una hoja del ABB
	 * @PARAMETRO arbol 
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE true or false**/
	public boolean ElemenHoja(int elemen,ABBTDA arbol) {
		if(arbol.ArbolVacio()) {
			return false;
		}
		else {
			if(arbol.Raiz()==elemen){
				if (arbol.HijoDer().ArbolVacio()&&arbol.HijoIzq().ArbolVacio()){
					return true;					
				}
				else
					return false;				
			}
			else {
				if(arbol.Raiz()>elemen) {
					return ElemenHoja(elemen,arbol.HijoIzq());
				}
					else
						return ElemenHoja(elemen,arbol.HijoDer());			
			}
		}
	}
	
	
	//TP4 3-c gonza 05/05/18
		/**@TAREA dado un elemento calcular su profundidad en el ABB
		 * @PARAMETRO arbol 
		 * @PRECONDICON arbol inicializado
		 * @POSTCONDICON none
		 * @DEVUELVE profundidad **/ // prof: cantidad de niveles del arbol empieza en 0
	public int Profundidad(int elemen, ABBTDA arbol) {//preguntar si existe elemento como precondicion
		if (arbol.ArbolVacio()) {
			return 0;
		}
		else if(arbol.Raiz()==elemen) {
			return 0;
		}
		else if(arbol.Raiz()>elemen) {
			return (1 + Profundidad(elemen,arbol.HijoIzq()));
		}
		else {
			return (1 + Profundidad(elemen,arbol.HijoDer()));
		}
	}
	
	
	
	//TP4 3-d gonza 05/05/18 //Arreglado por Fede
	/**@TAREA obtener el valor del menor elelemnto de un ABB
	 * @PARAMETRO arbol 
	 * @PRECONDICON arbol inicializado y no vac�o
	 * @POSTCONDICON none
	 * @DEVUELVE valor**/
	public int Menor(ABBTDA a) {//mirar la implementacio
		if (a.HijoIzq().ArbolVacio()) { //si el hijo izquierdo esta vac�o
			return a.Raiz(); //es el valor mas bajo
		}
		else {
			return Menor(a.HijoIzq()); //busca el valor mas bajo en el hijo izquierdo
		}
	}
	}
	
	
	//TP4 3-e gonza 08/05/18 
	/**@TAREA calcular la cantidad de elementos que tiene un ABB
	 * @PARAMETRO arbol 
	 * @PRECONDICON arbol inicializado
	 * @POSTCONDICON none
	 * @DEVUELVE cant**/
	public int CantElementos(ABBTDA arbol) {
		if(arbol.ArbolVacio())
			return 0;
		else {
			return (1 + CantElementos(arbol.HijoIzq()) + CantElementos(arbol.HijoDer()));
		}
	}
	
	
	//TP4 3-f gonza 08/05/18 //segun el profesor va a asi
		/**@TAREA calcular la suma de elementos que contiene un ABB
		 * @PARAMETRO arbol 
		 * @PRECONDICON arbol inicializado
		 * @POSTCONDICON none
		 * @DEVUELVE suma**/
	public int SumaElementos (ABBTDA arbol){
		if (arbol.ArbolVacio())
			return 0;
		else
		{
			return (arbol.Raiz() + SumaElementos(arbol.HijoIzq()) + SumaElementos(arbol.HijoDer()));
		}
	}
}
