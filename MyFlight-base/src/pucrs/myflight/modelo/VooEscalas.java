package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo {
	
	private Rota rotaFinal;

	public VooEscalas(Rota rota, LocalDateTime datahora, Duration duracao, Rota rotaFinal) {
		super(rota, datahora, duracao);
		this.rotaFinal = rotaFinal;
		// TODO Auto-generated constructor stub		
	}
	
	public Rota getRotaFinal(){
		return rotaFinal;
	}
	
	@Override
	public String toString() {		
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nVooEscalas [rotaFinal=" + rotaFinal + "]");	
		return str.toString();			
	}
}
