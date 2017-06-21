import java.util.ArrayList;

public class Grafo {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();

	public void addVertice (Vertice v) {
		vertices.add(v);
	}

	/**
	 * Dado un vertice de  destino, busca el camino MAS Corto desde el vertice 0
	 * @return
	 */
	public void BFS (Vertice dest) {
		
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
		
		// Boolean encontrado
		boolean encontrado = false;
		
		while(!fila.isEmpty() && !encontrado) {

			//Pido los adyacentes al primero de la fila
			ArrayList<Vertice> adyacentes = vertices.get(fila.get(0)).getAdyacentes();

			//Itero los adyacentes y pregunto si es igual a destino
			for (int i = 0; i < adyacentes.size(); i++) {
				if(adyacentes.get(i).getValor() == dest.getValor()) {
					
					padres.set(dest.getValor(), fila.get(0));
					encontrado = true;
					// Encontrado!
					System.out.println(padres);
					imprimir(padres, dest);
				}
				else {
					
					if(padres.get(adyacentes.get(i).getValor()) != 0) {
						
						padres.set(adyacentes.get(i).getValor(), fila.get(0));
					}
					
					// Sino lo encuentro agrego el adyaccente a la fila
					fila.add(adyacentes.get(i).getValor());
				}
			}
			//Una vez que itero los adyacentes, remuevo de la fila y continuo
			fila.remove(0);
		}
	
		

	}
	
	/**
	 * Imprimi Camino Mas Corto
	 * @param padres
	 * @param dest
	 */
	public void imprimir (ArrayList<Integer> padres, Vertice dest) {

		//*************Imprimir camino**************
		Integer index = dest.getValor();
		while(index != 0) {
			System.out.println(vertices.get(index).getValor());
			index = padres.get(index);
		}
		// Origen
		System.out.println(vertices.get(0).getValor());
		//***************************************
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
		Vertice v7 = new Vertice(7);
		Vertice v8 = new Vertice(8);

		// Agrego sus adyacentes
		v0.addAdyacentes(v1);
		v0.addAdyacentes(v2);
		v0.addAdyacentes(v4);
		
		v1.addAdyacentes(v3);
		v1.addAdyacentes(v4);
		
		v2.addAdyacentes(v4);
		v2.addAdyacentes(v5);

		v3.addAdyacentes(v7);
		
		v4.addAdyacentes(v5);
		
		v5.addAdyacentes(v6);
		v5.addAdyacentes(v8);
		
		v6.addAdyacentes(v3);
		v6.addAdyacentes(v4);
		v6.addAdyacentes(v7);
		
		v8.addAdyacentes(v6);
		v8.addAdyacentes(v7);

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
		grafo.addVertice(v7);
		grafo.addVertice(v8);
		


		// Desde el v0 al v5 hay conexión - Es true!
		grafo.BFS(v8);

	}
}
