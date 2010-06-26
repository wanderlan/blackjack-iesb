public class Banca extends Integrante {
	private Monte monte = new Monte();
	private int jogadoresAtivos = 0;
	private Jogador jogadores[]; 
	
	// Cria a banca e atribui o array de jogadores na banca 
	public Banca(Jogador jogadores[]){
		setJogadores(jogadores);
		jogadoresAtivos=jogadores.length;
	}
	
	// Remove logicamente um jogador
	public void finalizarJogador(int i){
	  jogadoresAtivos--;
	  jogadores[i].setAtivo(false);
	}
	
	// Devolve true se há jogadores ativos
	public boolean temAlguemJogando(){
		return jogadoresAtivos>0;
	}
	
	// Limpa as mãos dos jogadores e da banca
	public void iniciarJogada(){
  	mao.clear();
		for(int j=0; j<jogadores.length; j++)
			jogadores[j].limparMao();
  }
  
	// Dá as cartas no início da jogada
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

	// Dá a próxima carta do monte
	public Carta darProximaCarta() {
		return monte.getCarta();
	}

	// Faz a jogada da banca
	public void pegarCartas() {
		while(mao.getValorReal() < 17) 
			mao.add(monte.getCarta());
	}

	// Devolve os jogadores cadastrados na banca
	public Jogador[] getJogadores() {
		return jogadores;
	}

	// Atribui o array de jogadores para a banca e informa a banca dentro de cada jogador
	public void setJogadores(Jogador[] jogadores) {
		for(int i=0; i<jogadores.length; i++)
			jogadores[i].setBanca(this);
		this.jogadores = jogadores;
	}

	// Debita as apostas dos jogadores quando a banca ganha 
	public void debitarApostas(){
		for(int i=0; i<jogadores.length; i++)
		  if(jogadores[i].getAtivo())
		    jogadores[i].addTotal(-jogadores[i].getAposta());
	}
	
	// Define quem ganhou a aposta paga para quem ganhou e debita de quem perdeu
	// Gera uma BJException quando a banca ganha ou quando há empate ou quando não ha vencedores
	public int pagarApostas() throws BJException {
		int max=0, vencedor=-1, totalApostas=0;
		for(int i=0; i<jogadores.length; i++)
		  if(jogadores[i].getAtivo()){
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
					debitarApostas();
					throw new BJException("A Banca leva tudo");
				}
				else
					throw new BJException("Empate da Banca com o jogador " + vencedor);
		}
		else
			if(mao.getValor()!=-1){
				addTotal(totalApostas);
				debitarApostas();
				throw new BJException("A Banca leva tudo");
			}
			else
				throw new BJException("Ninguém ganhou"); 
		return vencedor;  
	}
}
