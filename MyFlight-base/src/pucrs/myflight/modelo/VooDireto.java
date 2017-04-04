package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooDireto extends Voo {
	
	private Rota rota;

	public VooDireto(LocalDateTime datahora, Rota rota) {
		super(datahora);
		this.rota = rota;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Duration getDuracao() {
		return null;
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
