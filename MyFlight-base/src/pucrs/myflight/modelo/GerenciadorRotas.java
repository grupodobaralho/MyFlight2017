package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	// Ordenando por Comparable que usa o compareTo da classe Rota
	// public void ordenaNomeCia(){
	// Collections.sort(rotas);
	// }

	// Interface Comparator, q pode comparar por diferentes critérios,
	// diferentemente do Comparable
	public void ordenaCia() {
		rotas.sort((Rota r1, Rota r2) -> r1.getCia().getNome().compareTo(r2.getCia().getNome()));
	}

	public void ordenaOrigem() {
		rotas.sort((Rota r1, Rota r2) -> r1.getOrigem().getNome().compareTo(r2.getOrigem().getNome()));
	}

	public void ordenaOrigemCia() {
		rotas.sort( (r1,r2) -> (!r1.getOrigem().getNome().equals(r2.getOrigem().getNome()))    ?
		                          r1.getOrigem().getNome().compareTo(r2.getOrigem().getNome()) :
		                          r1.getCia().getNome().compareTo(r2.getCia().getNome())    );
//		rotas.sort((Rota r1, Rota r2) -> {
//			// posso fazer compareTo == 0?
//			if (r1.getOrigem().getNome().equals(r2.getOrigem().getNome()) {
//				r1.getCia().getNome().compareTo(r2.getCia().getNome());
//			} else {
//				r1.getCia().getNome().compareTo(r2.getCia().getNome());
//			}
//		});
	}

	// Usando método estático da interface Comparator para comparar:
	public void ordenaNomeCiaStatic() {
		rotas.sort(Comparator.comparing(a -> a.getCia().getNome()));
	}

}
