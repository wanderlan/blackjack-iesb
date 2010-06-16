public class Baralho {
	public static final int tamanho = Valor.values().length * Naipe.values().length;
	private Carta cartas[] = new Carta[tamanho];

	public Baralho() {
		super();
		for(Naipe naipe : Naipe.values())
			for(Valor valor : Valor.values())
				cartas[(naipe.ordinal()*Valor.values().length) + valor.ordinal()] = new Carta(naipe, valor);
	}
	
	public Carta GetCarta(int i){
		return cartas[i];		
	}
}
