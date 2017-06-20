import java.util.*;

public class Grafo {
	ArrayList<Vertice> vertices = new ArrayList<Vertice>();

	public void addVertice (Vertice v) {
		vertices.add(v);
	}

	/**
	 * Dado un vertice de  destino, da true/false si es encontrado desde el vertice 0
	 * @return
	 */
	public boolean BFS (Vertice dest) {

		// Usamos un ArrayList como Cola o Fila. Agrega al final y siempre remueve del principio
		ArrayList<Integer> fila = new ArrayList<Integer>();

		//Agregamos por primera vez el primer vertice
		fila.add(vertices.get(0).getValor());

		while(!fila.isEmpty()) {

			//Pido los adyacentes al primero de la fila
			ArrayList<Vertice> adyacentes = vertices.get(fila.get(0)).getAdyacentes();

			//Itero los adyacentes y pregunto si es igual a destino
			for (int i = 0; i < adyacentes.size(); i++) {
				if(adyacentes.get(i).getValor() == dest.getValor()) {

					// Encontrado!
					return true;
				}
				else {
					// Sino lo encuentro agrego el adyaccente a la fila
					fila.add(adyacentes.get(i).getValor());
				}
			}
			//Una vez que itero los adyacentes, remuevo de la fila y continuo
			fila.remove(0);
		}
		return false;
	}

	public static void main(String[] args) {

		// Creo los Vertices
		Vertice v0 = new Vertice(0);
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);
		Vertice v5 = new Vertice(5);

		// Agrego sus adyacentes
		v0.addAdyacentes(v1);
		v0.addAdyacentes(v2);
		v0.addAdyacentes(v3);

		v2.addAdyacentes(v3);
		v2.addAdyacentes(v4);

		v3.addAdyacentes(v5);

		// Creo el grafo
		Grafo grafo = new Grafo();

		// Agrego los vertices al grafo
		grafo.addVertice(v0);
		grafo.addVertice(v1);
		grafo.addVertice(v2);
		grafo.addVertice(v3);
		grafo.addVertice(v4);
		grafo.addVertice(v5);


		// Desde el v0 al v5 hay conexión - Es true!
		System.out.println(grafo.BFS(v5));

		// Ahora removemos los adyacentes al v3. Comentamos la línea 63.
		// Desde el v0 al v5 ahora no hay conexión. Es False!
		//		System.out.println(grafo.BFS(v5));

	}
}
