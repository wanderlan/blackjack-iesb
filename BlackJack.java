import java.io.IOException;
import java.util.Scanner;

public class BlackJack implements UIJogador{
	static double minAposta=1, maxAposta=100;
	static int numJogadores = 1;
	static int numBaralhos = 8;
	static double creditoInicial=1000;
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
		    System.out.println("\nFaça sua aposta Jogador " + i);
				System.out.println("Valor mínimo R$" + minAposta + ", valor máximo R$" + maxAposta);
		    aposta = sc.nextDouble();
		    if((aposta>=minAposta)&(aposta<=maxAposta)&(aposta<=jogadores[i].getTotal())) 
		    	break;
		    else
		    	System.out.println("Aposta inválida, entre um outro valor.");
	    }
			jogadores[i].setAposta(aposta);
    }
	}
	
	public void fazerJogada(){
    for(int i=0; i<jogadores.length; i++)
  		if(jogadores[i].getMao().getValor()==21) return;
		if(banca.getMao().getValor()==21) return;
    	
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
					  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValorReal());
					  		if((jogadores[i].getMao().getValor()>0) & (jogadores[i].getMao().getValor()<21)) continua=true;
					  		break;
					  	case 'F':
					  		System.out.println("Valor da mão: " + jogadores[i].getMao().getValorReal());
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
			if(banca.getMao().getValor()==21) return;
		}
	}
	
  public void mostrarCartas(){
		System.out.println("Carta da banca: " + banca.getMao().get(0).toString());
    for(int i=0; i<jogadores.length; i++){
    	System.out.println("\nCartas do jogador " + i);
    	Mao maoJogador = jogadores[i].getMao();
   		System.out.print(maoJogador.mostrar());
  		System.out.println("\nValor da mão: " + maoJogador.getValorReal());
  		if(maoJogador.IsBlackJack()) System.out.println("***BLACKJACK***");
    }
  }
	
  public void pagarApostas(){
		System.out.print("O vencedor da rodada foi: ");
  	int vencedor;
		try {
			vencedor = banca.pagarApostas();
			System.out.println("o jogador " + vencedor);
			System.out.println("Total do jogador " + vencedor + ": R$" + jogadores[vencedor].getTotal());
		} catch (BJException e) {
			System.out.println(e.getMessage());
			System.out.println("Total da Banca: R$" + banca.getTotal());
		}
		System.out.println("Mão da Banca: " + banca.getMao().mostrar());
		System.out.println("Valor da mão da Banca: " + banca.getMao().getValorReal());
		if(banca.getMao().IsBlackJack()) System.out.println("***BLACKJACK***");
  }
	
  static public void configurarParametros(){
    Scanner sc = new Scanner(System.in);
  	System.out.println("***Configurações Iniciais***");
		System.out.println("Informe número de jogadores, escolha 1 inicialmente: ");
    numJogadores = sc.nextInt();
		System.out.println("Informe valor mínimo da aposta: ");
    minAposta = sc.nextDouble();
		System.out.println("Informe valor máximo da aposta: ");
    maxAposta = sc.nextDouble();
		System.out.println("Informe número de baralhos, 8 é um número adequado: ");
    numBaralhos = sc.nextInt();
		System.out.println("Informe crédito inicial para os jogadores em R$: ");
    creditoInicial = sc.nextDouble();
  }
  
	public static void main(String[] args) {
    BlackJack.configurarParametros();   
    Jogador jogadores[] = new Jogador[numJogadores];
  	for(int i=0; i<jogadores.length; i++)
    	jogadores[i] = new Jogador(creditoInicial); 

    Banca banca = new Banca(jogadores);

  	BlackJack bj = new BlackJack(banca, jogadores);
  
  	while(banca.temAlguemJogando()){
      bj.fazerAposta();
	    banca.darCartas();
	   	bj.mostrarCartas();
	   	bj.fazerJogada();
	    if(banca.temAlguemJogando()){ 
	    	bj.pagarApostas();
	    	System.out.println("\n***PRÓXIMA RODADA***");
	    }
    }
    System.out.println("FIM DE JOGO");
 	}
}
