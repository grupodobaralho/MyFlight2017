package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
	
	private ArrayList<Rota> rotas;

	public VooEscalas(LocalDateTime datahora) {
		super(datahora);
		// TODO Auto-generated constructor stub		
	}
	
	public void adicionarRotas(Rota rota) {
		rotas.add(rota);
	}

	@Override
	public Duration getDuracao() {		
//		double alo = Geo.distancia(rota.getOrigem().getLocal(), rota.getDestino().getLocal());		
//		return Duration.ofSeconds((long)((alo/805+0.5)*3600));
		return null;
	}

	@Override
	public Rota getRota() {
		if(!rotas.isEmpty())
			return rotas.get(0);
		return null;
		// TODO Auto-generated method stub		
	}
	
	public ArrayList<Rota> getRotas() {
		return rotas;
	}

	@Override
	public String toString() {	
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nVooEscalas [rotas=" + rotas.toString() + "]");	
		return str.toString();	
	}	

}
