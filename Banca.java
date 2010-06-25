public class Banca extends Integrante {
	private Monte monte = new Monte();
	private Jogador jogadores[]; 
	
	public Banca(Jogador jogadores[]){
		setJogadores(jogadores);
	}
	
	public void iniciarJogada(){
  	mao.clear();
		for(int j=0; j<jogadores.length; j++)
			jogadores[j].limparMao();
  }
  
	public void darCartas() {
		monte.embaralhar();
		mao.add(monte.getCarta());
		mao.add(monte.getCarta());
		for(int j=0; j<jogadores.length; j++){
			jogadores[j].getMao().add(monte.getCarta());
			jogadores[j].getMao().add(monte.getCarta());
		}
  }

	public Carta darProximaCarta() {
		return monte.getCarta();
	}

	public void pegarProximaCarta() {
		if(mao.getValor() < 17) 
			mao.add(monte.getCarta());
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		for(int i=0; i<jogadores.length; i++)
			jogadores[i].setBanca(this);
		this.jogadores = jogadores;
	}

	public int pagarApostas() {
		int max=0, vencedor=-1, totalApostas=0;
		for(int i=0; i<jogadores.length; i++){
			totalApostas+=jogadores[i].getAposta();
			int v = jogadores[i].getMao().getValor();
			if((v<=21) & (v>max)){
				max=v;
				vencedor=i;
			}
		}
		Mao maoVencedor = jogadores[vencedor].getMao();
		if(maoVencedor.getValor()>mao.getValor())
			if(maoVencedor.IsBlackJack())
				jogadores[vencedor].addTotal(jogadores[vencedor].getAposta()*1.5);
			else
				jogadores[vencedor].addTotal(jogadores[vencedor].getAposta());
		else{
			addTotal(totalApostas);
			vencedor=-1;
		}	
		return vencedor;  
	}
}
