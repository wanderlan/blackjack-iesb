public class Monte {
	private int c=0;
	private Baralho baralhos[] = new Baralho[BlackJack.numBaralhos];
  private Carta cartas[] = new Carta[BlackJack.numBaralhos*Baralho.tamanho];
  
	public Monte() {
		super();
		int k=0;
		for(int i=0; i<baralhos.length; i++){
			baralhos[i] = new Baralho();
			for(int j=0; j<Baralho.tamanho; j++){
				cartas[k] = baralhos[i].GetCarta(j);
				k++;
			}
		}
	}

	public void embaralhar() {
		Carta temp;
		for(int i=0; i<cartas.length; i++){
			int j = (int)Math.round(Math.random()*(cartas.length-1));
			temp=cartas[j];
			cartas[j]=cartas[i];
			cartas[i]=temp;
		}
		c=0;
	}

	public Carta getCarta() {
		return cartas[c++];
	}
}
