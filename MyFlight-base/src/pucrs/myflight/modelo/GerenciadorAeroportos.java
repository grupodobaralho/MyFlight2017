package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeroportos {
	
	private ArrayList<Aeroporto> aeroportos;
	
	public GerenciadorAeroportos(){
		aeroportos = new ArrayList<>();
		
	}
	
	public void adicionar(Aeroporto aero){
		aeroportos.add(aero);
	}
	
	public ArrayList<Aeroporto> listarTodos(){
		return aeroportos;
	}
	
	public Aeroporto buscarPorCodigo(String cod){
		for(Aeroporto a : aeroportos){
			if(a.getCodigo().equals(cod))
				return a;
		}
		return null;
	}

}
