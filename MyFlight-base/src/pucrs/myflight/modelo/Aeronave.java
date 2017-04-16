package pucrs.myflight.modelo;

public class Aeronave implements Contavel, Imprimivel {

	private String codigo;
	private String descricao;
	private int capacidade;
	private int cont = 0;

	public Aeronave(String codigo, String descricao, int capacidade) {
		cont++; // número de objetos criados
		this.codigo = codigo;
		this.descricao = descricao;
		this.capacidade = capacidade;

	}

	public int getCapacidade() {
		return capacidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;

	}

	public String toString() {
		return "Aeronave [codigo=" + codigo + ", descricao=" + descricao + ", capacidade=" + capacidade + "]";
	}

	public void imprimir() {
		System.out.println(codigo + " - " + descricao);

	}

	
	public int objetosCriados() {

		return cont;
	}
}
