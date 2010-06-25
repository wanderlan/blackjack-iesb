import java.util.ArrayList;

public class Mao extends ArrayList<Carta>{
	private static final long serialVersionUID = 1L;

/*	private ArrayList<Carta> mao = new ArrayList<Carta>();
	
	public void add(Carta carta) {
    mao.add(carta);
	}

	public void add(Carta carta) {
    mao.add(carta);
	}
*/
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
	
	public int getValor(){
		int valor=getValorReal();
		if(valor<=21)
			return valor;
		else
			return -1;
	}
	
	public boolean IsBlackJack(){
		return (size()==2) & (getValor()==21);
	}

	public String mostrar(){
		String mostra="";
		for(int i=0; i<size(); i++){
			mostra += get(i).toString();
			if(i!=size()-1) mostra += ", ";
		}
		return mostra;
	}
}
