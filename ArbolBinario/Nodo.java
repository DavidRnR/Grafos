
public class Nodo {
		int valor;
		Nodo izq;
		Nodo der;
		
		public Nodo (int v) {
			valor = v;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

		public Nodo getIzq() {
			return izq;
		}

		public void setIzq(Nodo izq) {
			this.izq = izq;
		}

		public Nodo getDer() {
			return der;
		}

		public void setDer(Nodo der) {
			this.der = der;
		}
		
		
}
