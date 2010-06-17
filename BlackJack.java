import java.io.IOException;

public class BlackJack implements InteracaoJogador{
	private double minAposta=1, maxAposta=100;
	public static int numJogadores=1;
	public static BlackJack bj = new BlackJack();
	
	public char fazerJogada(Jogador jogador){
		System.out.println("Opções do Jogador " + jogador.getId());
		System.out.println("(P)edir\n(F)icar\n(D)ividir\n(S)eguro\nF(i)nalizar\n");
		char c = 'E'; // erro 
		try{
			c = Character.toUpperCase((char)System.in.read());
			switch(c){
		  	case 'P': 
		  		System.out.println("Nova carta: " + jogador.pedirCarta().toString());
		  		System.out.println("Valor da mão: " + jogador.getMao().getValor());
		  		break;
		  	case 'F':
		  		System.out.println("Valor da mão: " + jogador.getMao().getValor());
		  		break;		  		
		  	case 'D':
		  		break;
		  	case 'S':
		  		break;
		  	case 'I':
		  		System.out.println("Obrigado por participar Jogador: " + jogador.getId());
		  		System.out.println("Tome seu dinheiro R$" + jogador.getTotal());
		  		break;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return c;
	}
	
	public static void main(String[] args) {
    Jogador jogadores[] = new Jogador[numJogadores];
    for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(i, bj);
    
    Banca banca = new Banca();
    banca.setJogadores(jogadores);
 	}
}
