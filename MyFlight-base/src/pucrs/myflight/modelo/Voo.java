package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Voo {

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime datahora;

	public Voo(LocalDateTime datahora) {

		this.datahora = datahora;

	}

	public abstract Rota getRota();

	public LocalDateTime getDatahora() {

		return datahora;
	}

	public abstract Duration getDuracao();

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status novo) {
		this.status = novo;
	}

	public String toString() {
		return "Voo [datahora=" + datahora + ", duracao=" + duracao + ", rota=" + rota + ", status=" + status + "]";
	}
}
