import java.util.*;

public class Vertice {
	int valor;
	ArrayList<Vertice> adyacentes = new ArrayList<Vertice>();
	
	public Vertice(int n) {
		valor = n;
	}
	
	public void addAdyacentes(Vertice v) {
		adyacentes.add(v);
	}
	public ArrayList<Vertice> getAdyacentes () {
		return adyacentes;
	}
	
	public int getValor () {
		return valor;
	}
}
