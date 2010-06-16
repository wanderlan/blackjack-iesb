public enum Naipe {
  ESPADAS("Espadas"), PAUS("Paus"), COPAS("Copas"), OUROS("Ouros");
  private String valor;

 	private Naipe(String valor){
 		this.valor = valor;	
 	}
 	
	@Override
	public String toString(){
		return this.valor;
	}
  
}