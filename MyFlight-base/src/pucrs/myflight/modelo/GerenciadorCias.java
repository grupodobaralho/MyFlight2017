package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias(){
		empresas = new ArrayList<>();
	}
	
	public void adicionar(CiaAerea cia){
		empresas.add(cia);
		
	}
	
	public ArrayList<CiaAerea> listarTodas(){
		return empresas;
	}
	
	public CiaAerea buscarPorCodigo(String cod){
		for(CiaAerea a : empresas){
			if(a.getCodigo().equals(cod))
				return a;
		}
		return null;
	}
	
	public CiaAerea buscarNome(String nome){
		for(CiaAerea a : empresas){
			if(a.getNome().equals(nome))
				return a;
		}
		return null;
	}

}
