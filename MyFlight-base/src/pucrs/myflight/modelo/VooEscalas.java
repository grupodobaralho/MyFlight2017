package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {

	private ArrayList<Rota> rotas;

	public VooEscalas(LocalDateTime datahora) {
		super(datahora);
		rotas =  new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public void adicionarRotas(Rota rota) {
		rotas.add(rota);
	}

	@Override
	public Duration getDuracao() {
		double seconds = 0;
		double alo;
		for (Rota r : rotas) {

			alo = (Geo.distancia(r.getOrigem().getLocal(), r.getDestino().getLocal()) / 805 + 0.5) * 3600;
			seconds = seconds + alo;
		}
		return Duration.ofSeconds((long) seconds);

	}

	@Override
	public Rota getRota() {
		if (!rotas.isEmpty())
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