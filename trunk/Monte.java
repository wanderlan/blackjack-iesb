public class Monte {
	private int tamanho=8, c=0;
	private Baralho baralhos[] = new Baralho[tamanho];
  private Carta cartas[] = new Carta[tamanho*Baralho.tamanho];
  
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
		for(int i=0, j; i<cartas.length%2; i++){
			j = (int)Math.round(Math.random()*cartas.length);
			temp=cartas[j];
			cartas[j]=cartas[i];
			cartas[i]=temp;
		}
		c=0;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Carta getCarta() {
		return cartas[c++];
	}
}
