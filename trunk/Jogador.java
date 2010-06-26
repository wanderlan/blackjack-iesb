public class Jogador extends Integrante {
	private double aposta;
	private boolean ativo;
	private Banca banca;

	// Cria o jogador � d� um cr�dito inicial
	public Jogador(double creditoInicial) {
		super();
		ativo = true;
		total = creditoInicial;
	}

	// Devolve true se o jogador est� ativo	
	public boolean getAtivo() {
		return ativo;
	}

	// Define o jogador como ativo
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	// Define a banca em que o jogador est�
	public void setBanca(Banca banca){
		this.banca = banca;
	}
	
	// Devolve a aposta feita
	public double getAposta() {
		return aposta;
	}

	// Faz a aposta
	public void setAposta(double aposta) {
		this.aposta = aposta;
	}

	// Pede uma carta para a banca
	public Carta pedirCarta() {
		Carta c = banca.darProximaCarta();
		getMao().add(c);
		return c;
	}
}
