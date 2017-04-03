package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {
	private LocalDateTime datahora;
	private Status status;

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	public Voo(LocalDateTime datahora) {
		this.status = Status.CONFIRMADO;
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
		return "Voo [datahora=" + datahora + ", status=" + status + "]";
	}

}