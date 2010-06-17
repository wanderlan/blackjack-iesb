public class Banca extends Integrante {
	private Monte monte = new Monte();
	private Jogador jogadores[]; 
	
	public void darCartas() {
		monte.embaralhar();
		mao.add(monte.getCarta());
		mao.add(monte.getCarta());
		for(int j=0; j<jogadores.length; j++){
			jogadores[j].getMao().add(monte.getCarta());
			jogadores[j].getMao().add(monte.getCarta());
		}
  }

	public void darProximaCarta() {
		for(int j=0; j<jogadores.length; j++)
			jogadores[j].getMao().add(monte.getCarta());
	}

	public void pegarProximaCarta() {
		mao.add(monte.getCarta());
	}

	public Jogador[] getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador[] jogadores) {
		this.jogadores = jogadores;
	}

	public void perguntarAoJogador() {

	}

	public void completarJogo() {

	}
}
