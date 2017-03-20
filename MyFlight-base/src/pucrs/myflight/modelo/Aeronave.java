package pucrs.myflight.modelo;

public class Aeronave {
	private String codigo;
	private String descricao;
	private int capacidade;

	public Aeronave(String codigo, String descricao, int capacidade) {
		this.codigo = codigo;
		this.descricao = descricao;

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
}
