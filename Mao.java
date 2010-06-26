import java.util.ArrayList;

public class Mao extends ArrayList<Carta>{
	private static final long serialVersionUID = 1L;

	// Devolve o valor da mão
	public int getValorReal(){
		int valor=0, ases=0;
		
		for(int i=0, v; i<size(); i++){
	    valor += v = get(i).getValor().getValor();
	    if(v==1) ases++;
		}
		if((valor<21) & (ases!=0) & ((valor+(ases*10))<=21))
		  valor+=(ases*10);
		return valor;
	}
	
	// Devolve o valor da mão, mas se o valor for maior que 21 devolve -1
	public int getValor(){
		int valor=getValorReal();
		if(valor<=21)
			return valor;
		else
			return -1;
	}
	
	// Devolve se a mão tem um BlackJack
	public boolean IsBlackJack(){
		return (size()==2) & (getValor()==21);
	}

	// Devolve um string com as cartas da mão
	public String mostrar(){
		String mostra="";
		for(int i=0; i<size(); i++){
			mostra += get(i).toString();
			if(i!=size()-1) mostra += ", ";
		}
		return mostra;
	}
}
