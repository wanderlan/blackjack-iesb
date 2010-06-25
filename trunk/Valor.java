public enum Valor {
  AS("Ás"), _2("2"), _3("3"), _4("4"), _5("5"), _6("6"), _7("7"), _8("8"), _9("9"), _10("10"), 
  VALETE("Valete"), DAMA("Dama"), REI("Rei");
  
  private String valor;

 	private Valor(String valor){
 		this.valor = valor;	
 	}
 	
	@Override
	public String toString(){
		return this.valor;
	}
	
	public int getValor(){
		if(valor=="Ás") return 1;
		if(valor=="2")  return 2;
		if(valor=="3")  return 3;
		if(valor=="4")  return 4;
		if(valor=="5")  return 5;
		if(valor=="6")  return 6;
		if(valor=="7")  return 7;
		if(valor=="8")  return 8;
		if(valor=="9")  return 9;
		if(valor=="10") return 10;
		if(valor=="Valete") return 10;
		if(valor=="Dama")   return 10;
		if(valor=="Rei")    return 10;
		return 0;
	}
}
