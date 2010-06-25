public class Jogador extends Integrante {
	private double aposta;
	private int id;
	private Banca banca;

	public Jogador(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
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
