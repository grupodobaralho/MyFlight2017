package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import pucrs.myflight.modelo.Voo.Status;

public class App {

	public static void main(String[] args) {

		Scanner type = new Scanner(System.in);
		GerenciadorAeronaves gerAeronaves = new GerenciadorAeronaves();
		GerenciadorAeroportos gerAeroportos = new GerenciadorAeroportos();
		GerenciadorCias gerCias = new GerenciadorCias();
		GerenciadorRotas gerRotas = new GerenciadorRotas();
		GerenciadorVoos gerVoos = new GerenciadorVoos();

		CiaAerea latam = new CiaAerea("JJ", "LATAM Linhas A�reas");
		CiaAerea gol = new CiaAerea("G3", "Gol Linhas A�reas SA");
		CiaAerea tap = new CiaAerea("TP", "TAP Portugal");
		CiaAerea azul = new CiaAerea("AD", "Azul Linhas A�reas");

		gerCias.adicionar(latam);
		gerCias.adicionar(gol);
		gerCias.adicionar(tap);
		gerCias.adicionar(azul);

		// **********************************************************************************************************
		// Aeronaves
		// As aeronaves s�o identificadas por um c�digo, uma descri��o e uma
		// capacidade de passageiros:

		Aeronave boeing733_300 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave boeing737_700 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave airbusA380 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave boeing767_400 = new Aeronave("764", "Boeing 767-400", 304);

		gerAeronaves.adicionar(boeing733_300);
		gerAeronaves.adicionar(boeing737_700);
		gerAeronaves.adicionar(airbusA380);
		gerAeronaves.adicionar(boeing767_400);

		// **********************************************************************************************************
		// Aeroportos
		// Os aeroportos possuem um c�digo, um nome e uma localiza��o geogr�fica
		// (latitude e longitude):

		Geo geo1 = new Geo(-29.9939, -51.1711);
		Geo geo2 = new Geo(-23.4356, -46.4731);
		Geo geo3 = new Geo(38.7742, -9.1342);
		Geo geo4 = new Geo(25.7933, -80.2906);

		Aeroporto poa = new Aeroporto("POA", "Salgado Filho Intl Apt", geo1);
		Aeroporto gru = new Aeroporto("GRU", "S�o Paulo Guarulhos Intl Apt", geo2);
		Aeroporto lis = new Aeroporto("LIS", "Lisbon", geo3);
		Aeroporto mia = new Aeroporto("MIA", "Miami International Apt", geo4);

		gerAeroportos.adicionar(poa);
		gerAeroportos.adicionar(gru);
		gerAeroportos.adicionar(lis);
		gerAeroportos.adicionar(mia);

		// **********************************************************************************************************
		// Rotas
		// Uma rota � identificada por uma companhia a�rea, aeroporto de origem,
		// aeroporto de destino e aeronave:

		Rota rota1 = new Rota(gol, gru, poa, boeing733_300);
		Rota rota2 = new Rota(gol, poa, gru, boeing733_300);
		Rota rota3 = new Rota(tap, mia, lis, airbusA380);
		Rota rota4 = new Rota(latam, gru, mia, boeing767_400);

		gerRotas.adicionar(rota1);
		gerRotas.adicionar(rota2);
		gerRotas.adicionar(rota3);
		gerRotas.adicionar(rota4);

		// **********************************************************************************************************
		// Voos
		// Um v�o � descrito por uma data e hor�rio, dura��o, rota e estado
		// (confirmado, atrasado ou cancelado):
		LocalDateTime localDateTime1 = LocalDateTime.of(2016, Month.AUGUST, 10, 8, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, Month.AUGUST, 10, 15, 0);
		LocalDateTime localDateTime3 = LocalDateTime.of(2016, Month.AUGUST, 15, 12, 0);

		Duration duracao1 = Duration.ofMinutes(90);
		Duration duracao2 = Duration.ofMinutes(120);

		Voo voo1 = new Voo(rota2, localDateTime1, duracao1);
		voo1.setStatus(Status.ATRASADO);
		Voo voo2 = new Voo(rota4, localDateTime2, duracao2);
		voo2.setStatus(Status.CONFIRMADO);
		Voo voo3 = new Voo(rota3, localDateTime3, duracao2);
		voo3.setStatus(Status.CANCELADO);

		gerVoos.adicionar(voo1);
		gerVoos.adicionar(voo2);
		gerVoos.adicionar(voo3);

		// Consulta 1

		ArrayList<Voo> lista = new ArrayList<>(gerVoos.listarTodos());
		System.out.println("Informe o c�digo:");
		String codigo = type.nextLine();
		for (Voo v : lista) {
			if (v.getRota().getOrigem().getCodigo().equals(codigo)) {
				System.out.println(v.toString());

			}

		}

		//Consulta 2
		
		
		
		
		
	}

}
