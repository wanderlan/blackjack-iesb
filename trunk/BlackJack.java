public class BlackJack implements InteracaoJogador{
	private double minAposta=1, maxAposta=100;
	public static int numJogadores=1;
	public static BlackJack bj = new BlackJack();
	
	public void perguntarJogador(){
		
	}
	
	public static void main(String[] args) {
    Jogador jogadores[] = new Jogador[numJogadores];
    for(int i=0; i<jogadores.length; i++)
    	jogadores[0] = new Jogador(bj);
    
    Banca banca = new Banca();
    banca.setJogadores(jogadores);
 
	}
}
