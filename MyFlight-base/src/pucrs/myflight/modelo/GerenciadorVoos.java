package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorVoos {
	
	private ArrayList<Voo> voos;
	
	public GerenciadorVoos(){
		
	}
	
	public void adicionar(Voo voo){
		voos.add(voo);
	}
	
	public ArrayList listarTodos(){
		return voos;
	}
	
	//FALTA O M�TODO buscarData

}
