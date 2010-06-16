public enum Valor {
  AS(1), _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), _10(10), VALETE(10), DAMA(10), REI(10); 
  private int valor;

 	private Valor(int valor){
 		this.valor = valor;	
 	}
 	
	@Override
	public String toString(){
		return Integer.toString(this.valor);
	}
}
