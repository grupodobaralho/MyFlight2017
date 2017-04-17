package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Voo {

	public enum Status {
		CONFIRMADO, ATRASADO, CANCELADO
	};

	private LocalDateTime datahora;
	private Status status;

	public Voo(LocalDateTime datahora) {
		this.datahora = datahora;	
		this.status = Status.CONFIRMADO;
	}

	public LocalDateTime getDataHora() {
		return datahora;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public abstract Duration getDuracao();	
	public abstract Rota getRota();

	@Override
	public String toString() {
		return "Voo [datahora=" + datahora + ", status=" + status + " Duracao= "+ getDuracao()+"]\n";
	}
}
