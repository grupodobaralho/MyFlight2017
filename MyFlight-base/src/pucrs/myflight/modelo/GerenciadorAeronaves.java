package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {

	private ArrayList<Aeronave> aeronaves;

	public GerenciadorAeronaves() {
		aeronaves = new ArrayList<>();
	}

	public void adicionar(Aeronave aviao) {
		aeronaves.add(aviao);
	}

	public ArrayList<Aeronave> listarTodas() {
		return aeronaves;
	}

	public Aeronave buscarPorCodigo(String cod) {
		for (Aeronave a : aeronaves) {
			if (a.getCodigo().equals(cod))
				return a;
		}
		return null;
	}

}
