package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;

	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia) {

		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {

		return empresas;

	}

	public CiaAerea buscaporCodigo(String cod) {

		for (CiaAerea c : empresas) {
			if (c.getCodigo().equals(cod))
				return c;
		}
		return null;
	}

	public CiaAerea buscaporNome(String nome) {

		for (CiaAerea c : empresas) {
			if (c.getNome().equals(nome))
				return c;
		}
		return null;
	}

}
