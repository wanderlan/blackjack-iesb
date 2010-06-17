import java.util.ArrayList;

public class Mao {
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	
	public void add(Carta carta) {
    mao.add(carta);
	}

	public int getValor(){
		int valor=0, ases=0;
		
		for(int i=0, v; i<mao.size(); i++){
	    valor += v = mao.get(i).getValor().getValor();
	    if(v==1) ases++;
		}
		if((valor<21) & (ases!=0) & ((valor+(ases*10))<=21))
			return valor+(ases*10);
		else
			return valor;
	}
	
	public boolean IsBlackJack(){
		return (mao.size()==2) & (getValor()==21);
	}
}
