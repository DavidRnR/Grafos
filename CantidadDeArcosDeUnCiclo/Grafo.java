import java.util.ArrayList;

public class Grafo {
	private ArrayList<Vertice> vertices = new ArrayList<Vertice>();
	
	public void addVertice (Vertice v) {
		vertices.add(v);
	}

	/**
	 * Dado un Grafo con ciclo, recorre y cuenta cuantos arcos tiene el ciclo.
	 * @return
	 */
	public int cantidadDeArcosDeUnCiclo () {
		
		//Cantidad de Arcos
		int cantArcos = 0;
		
		// Creamos un arreglo de padres. 
		ArrayList<Integer> padres = new ArrayList<Integer>();
		
		//Incializamos el arreglo en -1. Ningún Vertice tiene padre asignado.
		for (int i = 0; i < vertices.size(); i++) {
			padres.add(-1);
		}

		// Usamos un ArrayList como Cola o Fila. Agrega al final y siempre remueve del principio
		ArrayList<Integer> fila = new ArrayList<Integer>();

		//Agregamos la primera vez el primer vertice
		fila.add(vertices.get(0).getValor());
		
			
		while(!fila.isEmpty()) {

			//Pido los adyacentes al primero de la fila
			ArrayList<Vertice> adyacentes = vertices.get(fila.get(0)).getAdyacentes();

			//Itero los adyacentes y pregunto si tiene padre
			for (int i = 0; i < adyacentes.size(); i++) {
				// Si tiene padre, hay ciclo!
				if(padres.get(adyacentes.get(i).getValor()) >  -1) {
					
					//Ciclo Encontrado!
					
					padres.set(adyacentes.get(i).getValor(),fila.get(0));
				
					return cantArcos = calcularCantidadArcos(padres, adyacentes.get(i).getValor(), fila.get(0));
				}
				else {	
						
						padres.set(adyacentes.get(i).getValor(), fila.get(0));
					
					// Sino lo encuentro agrego el adyacente a la fila
					fila.add(adyacentes.get(i).getValor());
				}
			}
			//Una vez que itero los adyacentes, remuevo de la fila y continuo
			fila.remove(0);
		}
		return cantArcos;
	}
	
	
	/**
	 * Calcular Cantidad de Arcos
	 * @param padres
	 * @param dest
	 */
	public int calcularCantidadArcos (ArrayList<Integer> padres, int origenCiclo, int padre) {
		int cant = 1;
		
		Integer index = padre;
		
		while(index != origenCiclo) {
			index = padres.get(index);
			cant++;
		}
		
	return cant;
	}


	public static void main(String[] args) {

		// Creo los Vertices
		Vertice v0 = new Vertice(0);
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);
		Vertice v5 = new Vertice(5);
		Vertice v6 = new Vertice(6);
	

		// Agrego sus adyacentes
		v0.addAdyacentes(v3);
		v3.addAdyacentes(v2);
		v2.addAdyacentes(v5);		
		v5.addAdyacentes(v4);		
		v4.addAdyacentes(v3);
		v2.addAdyacentes(v1);		
		v1.addAdyacentes(v6);
	
	

		// Creo el grafo
		Grafo grafo = new Grafo();

		// Agrego los vertices al grafo
		grafo.addVertice(v0);
		grafo.addVertice(v1);
		grafo.addVertice(v2);
		grafo.addVertice(v3);
		grafo.addVertice(v4);
		grafo.addVertice(v5);
		grafo.addVertice(v6);
		
		
		System.out.println(grafo.cantidadDeArcosDeUnCiclo());

	}
}
