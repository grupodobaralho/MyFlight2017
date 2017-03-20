package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {

	private ArrayList<Rota> rotas;

	public GerenciadorRotas() {
    	 
		rotas = new ArrayList<>();
    	 	 
     }
	
	public void adicionar(Rota aviao) {

		rotas.add(aviao);
	}

	public ArrayList<Rota> listarTodas() {

		return rotas;

	}

	public Rota buscaporOrigem(Aeroporto orig) {

		for (Rota r : rotas) {
			if (r.getOrigem().equals(orig))
				return r;
		}
		return null;
	}

}

	

