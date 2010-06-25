import java.io.IOException;
import java.util.Scanner;

public class BlackJack implements UIJogador{
	private final double minAposta=1, maxAposta=100;
	private Banca banca;
	private Jogador[] jogadores;
	
	public BlackJack(Banca banca, Jogador[] jogadores){
		this.banca = banca;
		this.jogadores = jogadores;
	}
	
	public void fazerAposta(){
    Scanner sc = new Scanner(System.in);
    double aposta;
    
    for(int i=0; i<jogadores.length; i++){
	    while(true){
		    System.out.println("Faça sua aposta Jogador " + jogadores[i].getId());
				System.out.println("Valor mínimo R$" + minAposta + ", valor máximo R$" + maxAposta);
		    aposta = sc.nextDouble();
		    if((aposta>=minAposta)&(aposta<=maxAposta)) 
		    	break;
		    else
		    	System.out.println("Aposta inválida, entre um outro valor.");
	    }
			jogadores[i].setAposta(aposta);
    }
	}
	
	public void fazerJogada(){
    for(int i=0; i<jogadores.length; i++){
			System.out.println("\nOpções do Jogador " + jogadores[i].getId());
			System.out.println("(P)edir\n(F)icar\n(D)ividir\n(S)eguro\nF(i)nalizar\n");
			char c = 'E'; // erro 
			try{
				if(jogadores[i].getTotal()==0)
					c = 'I';
				else
					c = Character.toUpperCase((char)System.in.read());
				switch(c){
			  	case 'P': 
			  		System.out.println("Nova carta: " + jogadores[i].pedirCarta().toString());
			  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValor());
			  		break;
			  	case 'F':
			  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValor());
			  		break;		  		
			  	case 'D':
			  		break;
			  	case 'S':
			  		break;
			  	case 'I':
			  		System.out.println("Obrigado por participar Jogador: " + jogadores[i].getId());
			  		System.out.println("Tome seu dinheiro R$" + jogadores[i].getTotal());
			  		break;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
    }
	}
	
  public void mostrarCartas(){
		System.out.println("Carta da banca: " + banca.getMao().get(0).toString());
    for(int i=0; i<jogadores.length; i++){
    	System.out.println("\nCartas do jogador " + i);
    	Mao maoJogador = jogadores[i].getMao();
    	for(int j=0; j<maoJogador.size(); j++){
    		System.out.print(maoJogador.get(j).toString());
    		if(j!=maoJogador.size()-1) System.out.print(", ");
    	}
  		System.out.println("\nValor da mão: " + maoJogador.getValor());
    }
  }
	
	public static void main(String[] args) {
  	final int numJogadores = 1;
    Jogador jogadores[] = new Jogador[numJogadores];

  	for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(i); 

    Banca banca = new Banca(jogadores);
    
    BlackJack bj = new BlackJack(banca, jogadores);
    
    bj.fazerAposta();
    banca.darCartas();
   	bj.mostrarCartas();
   	bj.fazerJogada();
   
 	}
}
