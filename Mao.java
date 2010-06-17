import java.util.ArrayList;

public class Mao {
	private ArrayList<Carta> mao = new ArrayList<Carta>();
	private int valor = 0;
	
	public void add(Carta carta) {
    mao.add(carta);
    valor += carta.getValor().getValor();
	}

	public int getValor(){
		return valor;
	}
}
