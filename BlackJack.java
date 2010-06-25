import java.io.IOException;
import java.util.Scanner;

public class BlackJack implements UIJogador{
	final double minAposta=1, maxAposta=100;
	static final int numJogadores = 1;
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
		    System.out.println("Faça sua aposta Jogador " + i);
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
		Boolean continua=true; 
		while(continua){
			continua=false;
			banca.pegarProximaCarta();
	    for(int i=0; i<jogadores.length; i++)
	      if(jogadores[i].getAtivo()){
					System.out.println("\nOpções do Jogador " + i);
					System.out.println("(P)edir\n(F)icar\n(D)ividir\n(S)eguro\nF(i)nalizar");
					char c = 'E'; // erro 
					try{
						/*if(jogadores[i].getTotal()==0)
							c = 'I';
						else*/
							c = Character.toUpperCase((char)System.in.read());
						System.in.skip(100);
						switch(c){
					  	case 'P': 
					  		System.out.println("Nova carta: " + jogadores[i].pedirCarta().toString());
					  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValor());
					  		if(jogadores[i].getMao().getValor()!=-1) continua=true;
					  		break;
					  	case 'F':
					  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValor());
					  		break;		  		
					  	case 'D':
					  		break;
					  	case 'S':
					  		break;
					  	case 'I':
					  		System.out.println("Obrigado por participar Jogador: " + i);
					  		System.out.println("Tome seu dinheiro R$" + jogadores[i].getTotal());
					  		banca.finalizarJogador(i);
					  		break;
						}
					}catch(IOException e){
						e.printStackTrace();
					}
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
  		if(maoJogador.IsBlackJack()) System.out.println("***BLACKJACK***");
    }
  }
	
  public void pagarApostas(){
		System.out.print("O vencedor da rodada foi: ");
  	int vencedor;
		try {
			vencedor = banca.pagarApostas();
			System.out.println("o jogador " + vencedor);
			System.out.println("Total da jogador " + vencedor + " R$" + jogadores[vencedor].getTotal());
		} catch (BJException e) {
			System.out.println(e.getMessage());
			System.out.println("Total da Banca R$" + banca.getTotal());
		}
		System.out.println("Mão da banca: " + banca.getMao().getValor());
  }
	
	public static void main(String[] args) {
    Jogador jogadores[] = new Jogador[numJogadores];
  	for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(); 

    Banca banca = new Banca(jogadores);
    
    BlackJack bj = new BlackJack(banca, jogadores);
    
    while(banca.temAlguemJogando()){
      bj.fazerAposta();
	    banca.darCartas();
	   	bj.mostrarCartas();
	   	bj.fazerJogada();
	    if(banca.temAlguemJogando()) 
	    	bj.pagarApostas();
    }
    System.out.println("FIM DE JOGO");
 	}
}
