package pucrs.myflight.modelo;

public class AeroportoRel {
	private Aeroporto aero;
	private int cont;

	public AeroportoRel(Aeroporto aero, int cont) {
		this.aero = aero;
		this.cont = cont;
	}

	public Aeroporto getAero() {
		return aero;
	}

	public void setAero(Aeroporto aero) {
		this.aero = aero;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public String toString() {
		return "AeroportoRel [aero=" + aero + ", cont=" + cont + "]";
	}

}
