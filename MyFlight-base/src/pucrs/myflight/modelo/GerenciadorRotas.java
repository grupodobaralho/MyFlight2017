package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {

	private ArrayList<Rota> rotas;

	public GerenciadorRotas() {
		rotas = new ArrayList<>();
	}

	public void adicionar(Rota rota) {
		rotas.add(rota);
	}

	public ArrayList<Rota> listarTodas() {
		return rotas;
	}

	public ArrayList<Rota> buscarPorOrigem(Aeroporto orig) {
		ArrayList<Rota> lista = new ArrayList<>();
		for (Rota a : rotas) {
			a.getOrigem().equals(orig);
		}
		return lista;
	}

}
