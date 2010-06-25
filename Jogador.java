public class Jogador extends Integrante {
	private double aposta;
	private double total;
	private int id;
	private Banca banca;

	public Jogador(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}
	
	public void setBanca(Banca banca){
		this.banca = banca;
	}
	
	public void limparMao(){
		mao.clear();
	}

	public double getAposta() {
		return aposta;
	}

	public void setAposta(double aposta) {
		this.aposta = aposta;
		total += aposta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Carta pedirCarta() {
		Carta c = banca.darProximaCarta();
		mao.add(c);
		return c;
	}

	public void dividir() {

	}

	public void comprarSeguro() {

	}

	public void finalizar() {

	}
}
