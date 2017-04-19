package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
	
	private Rota rota;

	public VooDireto(LocalDateTime datahora, Rota rota) {
		super(datahora);
		this.rota = rota;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Duration getDuracao() {
		double alo = Geo.distancia(rota.getOrigem().getLocal(), rota.getDestino().getLocal());		
		return Duration.ofSeconds((long)((alo/805+0.5)*3600));
	}

	@Override
	public Rota getRota() {	
		return rota;
	}	
	
	@Override
	public String toString() {	
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nVooDireto [rota=" + rota + "]");	
		return str.toString();			
	}
}
