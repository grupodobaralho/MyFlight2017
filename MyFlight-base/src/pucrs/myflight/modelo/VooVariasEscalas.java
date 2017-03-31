package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo {
	
	ArrayList<Rota> escalas;

	public VooVariasEscalas(Rota rota, LocalDateTime datahora, Duration duracao, ArrayList<Rota> rotas) {
		super(rota, datahora, duracao);
		this.escalas = rotas;
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Rota> getEscalas(){
		return escalas;
	}

	@Override
	public String toString() {		
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("VooVariasEscalas [escalas=\n");
		for(Rota a : escalas){
			str.append(a + "\n");	
		}	
		str.append("]");	
		return str.toString();		
	}	
}
