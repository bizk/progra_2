package implementaciones.listas;

import api.ConjuntoTDA;
import api.DiccionarioSimpleTDA;


/**@Autores: Gonzalo Bacigalupe
@Grupo: 3
@Costo de cada uno de los métodos de la implementación
*  Diccionario Simple con Listas dinámicas
*InicializarDiccionario: Constante
*Agregar:  Lineal
*Eliminar: Lineal
*Eliminar Valor: - 
*Recuperar: lineal
*Claves: Lineal*/

public class DiccionarioSimpleLD implements DiccionarioSimpleTDA {
	
	class NodoClave{
	    int clave;
	    int valor;
	    NodoClave sigClave;
	  }
		  
		  NodoClave origen;
		  
		  public void InicializarDiccionario(){
		    origen=null;
		  }
		  
		  public void Agregar(int clave,int valor){
		    NodoClave nc=Clave2NodoClave(clave);
		    if(nc==null){
		      nc=new NodoClave();
		      nc.clave=clave;
		      nc.sigClave=origen;
		      origen=nc;
		    }
		    nc.valor=valor;
		  }
		  
		  private NodoClave Clave2NodoClave(int clave){
		    NodoClave aux=origen;
		    while(aux!=null && aux.clave!=clave){
		      aux=aux.sigClave;
		    }
		    return aux;
		  }
		  
		  public void Eliminar(int clave){
		    if(origen!=null)
		    {
		      if(origen.clave==clave)
		      {
		        origen=origen.sigClave;
		      }
		      else
		      {
		        NodoClave aux=origen;
		        while(aux.sigClave!=null && aux.sigClave.clave!=clave){
		          aux=aux.sigClave;
		        }
		        if(aux.sigClave!=null){
		          aux.sigClave=aux.sigClave.sigClave;
		        }
		      }
		    }
		 	}
		    
		  public int Recuperar(int clave){
		    NodoClave n=Clave2NodoClave(clave);
		    return n.valor;
		   }
		    
		  public ConjuntoTDA Claves(){
		    ConjuntoTDA c= new ConjuntoLD();
		    c.InicializarConjunto();
		      
		    NodoClave aux=origen;
		    while(aux!=null){
		      c.AgregarConjunto(aux.clave);
		      aux=aux.sigClave;
		    }
		    return c;
		  }  
}
