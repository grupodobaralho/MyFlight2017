package pucrs.myflight.modelo;

public class AeroportoRel {
	
	private Aeroporto aeroporto;
	private int numeroDeVoos;
	
	public AeroportoRel(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
		this.numeroDeVoos = 0;
	}

	public int getNumeroDeVoos() {
		return numeroDeVoos;
	}

	public void setNumeroDeVoos(int numeroDeVoos) {
		this.numeroDeVoos = numeroDeVoos;
	}

	public Aeroporto getAeroporto() {
		return aeroporto;
	}

	@Override
	public String toString() {
		return "AeroportoRel [aeroporto=" + aeroporto + ", numeroDeVoos=" + numeroDeVoos + "]";
	}	

}
