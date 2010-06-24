import java.io.IOException;
import java.util.Scanner;

public class BlackJack implements InteracaoJogador{
	private double minAposta=1, maxAposta=100;
	public static int numJogadores=1;
	public static BlackJack bj = new BlackJack();
	
	public char fazerJogada(Jogador jogador){
		System.out.println("Opções do Jogador " + jogador.getId());
		System.out.println("(P)edir\n(F)icar\n(D)ividir\n(S)eguro\nF(i)nalizar\n");
		char c = 'E'; // erro 
		try{
			if(jogador.getTotal()==0)
				c = 'I';
			else
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
	
	public void fazerAposta(Jogador jogador){
    Scanner sc = new Scanner(System.in);
    double aposta;
    
    while(true){
	    System.out.println("Faça sua aposta Jogador " + jogador.getId());
			System.out.println("Valor mínimo R$" + minAposta + ", valor máximo R$" + maxAposta);
	    aposta = sc.nextDouble();
	    if((aposta>=minAposta)&(aposta<=maxAposta)) 
	    	break;
	    else
	    	System.out.println("Aposta inválida, entre um outro valor.");
    }
		jogador.setAposta(aposta);
	}
	
	public static void main(String[] args) {
    Jogador jogadores[] = new Jogador[numJogadores];
    for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(i, bj); 

    Banca banca = new Banca();
    banca.setJogadores(jogadores);
    
    BlackJack bj = new BlackJack();
    for(int i=0; i<jogadores.length; i++)
    	bj.fazerAposta(jogadores[i]);
    for(int i=0; i<jogadores.length; i++)
    	bj.fazerJogada(jogadores[i]);
   
 	}
}
