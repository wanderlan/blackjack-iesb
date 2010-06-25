public class Integrante {
	protected Mao mao = new Mao();
	private double total = 0;

	public Mao getMao(){
	  return mao;	
	}

	public void setMao(Mao mao) {
		this.mao = mao;
	}
	
	public void addTotal(double valor){
		total += valor;
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}

	public void limparMao(){
		mao.clear();
	}

}
