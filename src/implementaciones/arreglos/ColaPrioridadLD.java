/** Costos de la implementacion
 *  Cola Prioridad con Listas dinámicas
*InicializarColaPrioridad: Constante
*AcolarPrioridad:  Lineal
*Desacolar:  Constante
*Primero:  Constante
*ColaVacía: Constante
*Prioridad: Constante*/

package implementaciones.arreglos;

import api.ColaPrioridadTDA;

public class ColaPrioridadLD implements ColaPrioridadTDA {
	NodoPrioridad MayorPrioridad;
	@Override
	public void InicializarCola() { //Costo Constante
		MayorPrioridad=null;

	}

	@Override
	public void AcolarPrioridad(int x, int prioridad) { //Costo lineal
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info= x;
		nuevo.prioridad= prioridad;
		if(MayorPrioridad==null||nuevo.prioridad>MayorPrioridad.prioridad) {
			nuevo.siguiente=MayorPrioridad;
			MayorPrioridad=nuevo;
		}
		else {
			NodoPrioridad aux = MayorPrioridad;
			while(aux.siguiente!=null && aux.siguiente.prioridad >= nuevo.prioridad) {
				aux=aux.siguiente;
			}
			nuevo.siguiente=aux.siguiente;
			aux.siguiente=nuevo;
		}

	}

	@Override
	public void Desacolar() { //Costo Constante
		MayorPrioridad=MayorPrioridad.siguiente;

	}

	@Override
	public int Primero() {//Costo Constante
		return MayorPrioridad.info;
	}

	@Override
	public boolean ColaVacia() {//Costo Constante
		return MayorPrioridad==null;
	}

	@Override
	public int Prioridad() {//Costo Constante
		return MayorPrioridad.prioridad;
	}

}
