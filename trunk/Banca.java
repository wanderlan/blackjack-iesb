public class Banca extends Integrante {
	private Monte monte = new Monte();
	private int jogadoresAtivos = 0;
	private Jogador jogadores[]; 
	
	public Banca(Jogador jogadores[]){
		setJogadores(jogadores);
		jogadoresAtivos=jogadores.length;
	}
	
	public void finalizarJogador(int i){
	  jogadoresAtivos--;
	  jogadores[i].setAtivo(false);
	}
	
	public boolean temAlguemJogando(){
		return jogadoresAtivos>0;
	}
	
	public void iniciarJogada(){
  	mao.clear();
		for(int j=0; j<jogadores.length; j++)
			jogadores[j].limparMao();
  }
  
	public void darCartas() {
		limparMao();
		monte.embaralhar();
		mao.add(monte.getCarta());
		mao.add(monte.getCarta());
		for(int j=0; j<jogadores.length; j++){
			jogadores[j].limparMao();
			jogadores[j].getMao().add(monte.getCarta());
			jogadores[j].getMao().add(monte.getCarta());
		}
  }

	public Carta darProximaCarta() {
		return monte.getCarta();
	}

	public void pegarProximaCarta() {
		if(mao.getValorReal() < 17) 
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

	public int pagarApostas() throws BJException {
		int max=0, vencedor=-1, totalApostas=0;
		for(int i=0; i<jogadores.length; i++){
			totalApostas+=jogadores[i].getAposta();
			int v = jogadores[i].getMao().getValor();
			if(v>max){
				max=v;
				vencedor=i;
			}
		}
		if(vencedor!=-1){
			Mao maoVencedor = jogadores[vencedor].getMao();
			if(maoVencedor.getValor()>mao.getValor())
				if(maoVencedor.IsBlackJack())
					jogadores[vencedor].addTotal(jogadores[vencedor].getAposta()*1.5);
				else
					jogadores[vencedor].addTotal(jogadores[vencedor].getAposta());
			else
				if(maoVencedor.getValor()<mao.getValor()){
					addTotal(totalApostas);
					throw new BJException("A Banca leva tudo"); // banca
				}
				else
					throw new BJException("Empate da Banca com o jogador " + vencedor);
		}
		else
			if(mao.getValor()!=-1){
				addTotal(totalApostas);
				throw new BJException("A Banca leva tudo"); // banca
			}
			else
				throw new BJException("Ninguém ganhou"); // banca
		return vencedor;  
	}
}
