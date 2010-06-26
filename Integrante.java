// Classe abstrata pai da Banca e do Jogador
abstract public class Integrante {
	protected Mao mao = new Mao();
	protected double total = 0;

	// Devolve a mao
	public Mao getMao(){
	  return mao;	
	}

	// Atribui uma mao ao integrante
	public void setMao(Mao mao) {
		this.mao = mao;
	}
	
	// Adiciona o valor total
	public void addTotal(double valor){
		total += valor;
	}
	
	// Devolve o valor total
	public double getTotal(){
		return total;
	}
	
	// Atribui um valor ao total
	public void setTotal(double total) {
		this.total = total;
	}

	// Limpa a mão do integrante
	public void limparMao(){
		mao.clear();
	}

}
