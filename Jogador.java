public class Jogador extends Integrante {
	private double aposta;
	private boolean ativo;
	private Banca banca;

	public Jogador() {
		super();
		ativo = true;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setBanca(Banca banca){
		this.banca = banca;
	}
	
	public double getAposta() {
		return aposta;
	}

	public void setAposta(double aposta) {
		this.aposta = aposta;
	}

	public Carta pedirCarta() {
		Carta c = banca.darProximaCarta();
		getMao().add(c);
		return c;
	}

	public void dividir() {

	}

	public void comprarSeguro() {

	}

	public void finalizar() {

	}
}
