
public class Main {

	public static void main(String[] args) {
		Nodo raiz = new Nodo(2);
	
		Nodo na = new Nodo(7);
		raiz.setIzq(na);
		
		Nodo nb = new Nodo(2);
		na.setIzq(nb);
		
		Nodo nc = new Nodo(6);
		na.setDer(nc);
		
		Nodo nd = new Nodo(5);
		nc.setIzq(nd);
		
		Nodo ne = new Nodo(11);
		nc.setDer(ne);
		
		Nodo nf = new Nodo(5);
		raiz.setDer(nf);
		
		Nodo ng = new Nodo(9);
		nf.setDer(ng);
		
		Nodo ni = new Nodo(4);
		ng.setIzq(ni);
		
		getCantidadDescendientes(0,raiz);
	}
	
	public static int getCantidadDescendientes (int cant, Nodo n) {
		
		cant++;
		
		if(n.getDer() != null) {
			cant += getCantidadDescendientes(0, n.getDer());			
		}
		if(n.getIzq() != null)
			cant += getCantidadDescendientes(0, n.getIzq());
		
		// Seteo la cantidad -1 porque solo se cuentan los hijos y no el propio nodo
		n.setValor(cant-1);
		System.out.println(n.getValor());
		return cant;

	}
}
