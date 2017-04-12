package pucrs.myflight.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class GerenciadorVoos {

	private ArrayList<Voo> voos;

	public GerenciadorVoos() {
		voos = new ArrayList<>();
	}

	public void adicionar(Voo voo) {
		voos.add(voo);
	}

	public ArrayList<Voo> listarTodos() {
		return voos;
	}

	public ArrayList<Voo> buscarData(LocalDate data) {
		ArrayList<Voo> lista = new ArrayList<>();
		for (Voo a : voos) {
			if (data.equals(a.getDataHora().toLocalDate())) {
				lista.add(a);
			}
		}
		return lista;
	}	
	
	//http://stackoverflow.com/questions/369512/how-to-compare-objects-by-multiple-fields
	public void ordenaDataHora() {
		voos.sort(Comparator.comparing(a -> a.getDataHora()));
	}
	
	public void ordenaDataHoraDuracao() {
		voos.sort(Comparator.comparing((Voo a) -> a.getDataHora()).thenComparing((Voo a) -> a.getDuracao()));
	}

}
