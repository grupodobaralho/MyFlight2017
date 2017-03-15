package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorRotas {
	
	private ArrayList<Rota> rotas;
	
	public GerenciadorRotas(){
		rotas = new ArrayList<>();
	}
	
	public void adicionar(Rota rota){
		rotas.add(rota);
	}
	
	public ArrayList<Rota> listarTodas(){
		return rotas;
	}
//	
//	public Aeronave buscarPorCodigo(Aeroporto orig){
//		for(Aeroporto a : aeronaves){
//			if(a.getCodigo().equals(cod))
//				return a;
//		}
//		return null;
//	}
	
		

}
