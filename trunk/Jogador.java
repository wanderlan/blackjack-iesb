public class Jogador extends Integrante {
	private double aposta;
	private double total;
	private Mao mao;
	private InteracaoJogador ui;

	public Jogador(InteracaoJogador ui) {
		super();
		this.ui = ui;
	}

	public Mao getMao() {
		return mao;
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}
	
	public void limparMao(){
		mao.clear();
	}

	public void fazerJogada(){
		ui.perguntarJogador();
	}
	
	public double getAposta() {
		return aposta;
	}

	public void setAposta(double aposta) {
		this.aposta = aposta;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void dividir() {

	}

	public void comprarSeguro() {

	}

	public void finalizar() {

	}
}
