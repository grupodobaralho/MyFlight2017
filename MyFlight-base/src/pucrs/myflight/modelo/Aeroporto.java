package pucrs.myflight.modelo;

public class Aeroporto implements Comparable<Aeroporto> {
	private String codigo;
	private String nome;
	private Geo loc;

	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public Geo getLocal() {
		return loc;
	}

	public String toString() {
		return "Aeroporto [codigo=" + codigo + ", nome=" + nome + ", loc=" + loc + "]";
	}

	public int compareTo(Aeroporto outro) {

		return getNome().compareTo(outro.getNome());
	}
}
