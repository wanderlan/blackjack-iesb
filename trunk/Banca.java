public class Banca extends Integrante {
	private Monte monte = new Monte();
	private Jogador jogadores[]; 
	
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

	public void perguntarAosJogadores() {
		for(int j=0; j<jogadores.length; j++)
			jogadores[j].fazerJogada();
	}

	public void completarJogo() {

	}
}
