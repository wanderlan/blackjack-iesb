import java.io.IOException;

public class BlackJack implements InteracaoJogador{
	private double minAposta=1, maxAposta=100;
	public static int numJogadores=1;
	public static BlackJack bj = new BlackJack();
	
	public void fazerJogada(Jogador jogador){
		System.out.println("Opções do Jogador " + jogador.getId());
		System.out.println("(P)edir\n(F)icar\n(D)ividir\n(S)eguro\nF(i)nalizar\n");
		try{
			char c = (char)System.in.read();
			switch (c) {
		  	case 'p': case 'P' : 
		  		System.out.println(jogador.pedirCarta().toString());
		  		
		  		
			}
		}catch(IOException e){e.printStackTrace();}
	}
	
	public static void main(String[] args) {
    Jogador jogadores[] = new Jogador[numJogadores];
    for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(i, bj);
    
    Banca banca = new Banca();
    banca.setJogadores(jogadores);
 
	}
}
