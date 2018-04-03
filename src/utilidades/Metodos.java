package utilidades;

import api.*;
import implementaciones.arreglos.*;

public class Metodos {
	class Pilas_metodos extends implementaciones.arreglos.Pilas {		
		Pilas origen = new Pilas();
		Pilas destino = new Pilas();
		
		void PasarPila(PilaTDA origen, PilaTDA destino) {
		     while(!origen.PilaVacia()) {
	            destino.Apilar(origen.Tope());
	            origen.Desapilar();
	        }
	    }

	    public void CopiarPila(PilaTDA origen, PilaTDA destino) {
		        PilaTDA aux = new Pilas();
		        aux.InicializarPila();
		        PasarPila(origen, destino);
		        PasarPila(destino, aux);
		        destino =  aux;
		    }

		    public void InvertirPila(PilaTDA origen) {
		        PilaTDA aux = new Pilas();
		        aux.InicializarPila();

		        PasarPila(origen, aux);
	        origen = aux;
	    }

	    public int ContarElemPila(PilaTDA origen) {
	        int x = 0;
	        while (!origen.PilaVacia()) {
	            x++;
	            origen.Desapilar();
	        }
	        return x;
		}

		    public int SumarElemPIla(PilaTDA origen) {
		    int x = 0;
	        while(!origen.PilaVacia()) {
	            x += origen.Tope();
	            origen.Desapilar();
	        }
	        return x;
		}

		public double PromedioElemPila(PilaTDA origen) {
			int x = SumarElemPIla(origen);
		    int y = ContarElemPila(origen);
	        return(x/y);
		}
	}
	
	class Colas {
	    public void CopiarCola(ColaTDA origen, ColaTDA destino) {
	        while(!origen.ColaVacia()) {
	            destino.Acolar(origen.Primero());
	            origen.Desacolar();
	        }
	    }

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

	    public void CompararFinal(ColaTDA ct1, ColaTDA ct2) {
	        int y = 0, x = 0;
	        while (!ct1.ColaVacia()) {
	            x = ct1.Primero();
	            ct1.Desacolar();
	        }
	        while (!ct2.ColaVacia()) {
	            y = ct2.Primero();
	            ct2.Desacolar();
	        }
	        if (y == x) {
	            System.out.println("Son iguales!");
	        } else {
	            System.out.println("Son diferentes!");
	        }
	    }

	    public void ColaCapicua(ColaTDA o) {
	        ColaTDA aux = new ColaPI();
	        aux.InicializarCola();
	        
	        CopiarCola(o, aux);
	        InvertirColaPila(aux);
	        while (!o.ColaVacia() && (o.Primero() == aux.Primero())) {
	            o.Desacolar();
	            aux.Desacolar();
	        }

	        if (o.Primero() == aux.Primero()) {
	            System.out.println("Es capicua");
	        } else {
	            System.out.println("No son capicua");
	        }
	    }

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

	    public void ComprobarIdentidad (ColaPrioridadTDA CP1, ColaPrioridadTDA CP2) {
	        CP1.InicializarCola();
	        CP2.InicializarCola(); //Inicialisamos las dos colas.

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
