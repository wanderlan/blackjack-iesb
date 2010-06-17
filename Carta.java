public class Carta {
	private Naipe naipe;
	private Valor valor;
	
	public Naipe getNaipe() {
		return naipe;
	}

	public Valor getValor() {
		return valor;
	}

	public Carta(Naipe naipe, Valor valor) {
		super();
		this.naipe = naipe;
		this.valor = valor;
	}
	
	public String toString(){
		return valor.toString() + " de " + naipe.toString();
	}
}
