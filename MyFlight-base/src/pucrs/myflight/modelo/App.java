package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import pucrs.myflight.modelo.Voo.Status;

public class App {
	
	public static void main(String[] args) {

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// GERENCIADORES

		GerenciadorAeronaves gerAeronaves = new GerenciadorAeronaves();
		GerenciadorCias gerCias = new GerenciadorCias();
		GerenciadorAeroportos gerAeroportos = new GerenciadorAeroportos();
		GerenciadorRotas gerRotas = new GerenciadorRotas();
		GerenciadorVoos gerVoos = new GerenciadorVoos();

		// **********************************************************************************************************
		// Companhias Aéreas
		// Cada companhia possui um código e um nome:

		CiaAerea latam = new CiaAerea("JJ", "LATAM Linhas Aéreas");
		CiaAerea gol = new CiaAerea("G3", "Gol Linhas Aéreas SA");
		CiaAerea tap = new CiaAerea("TP", "TAP Portugal");
		CiaAerea azul = new CiaAerea("AD", "Azul Linhas Aéreas");		
		CiaAerea american = new CiaAerea("AA", "AmericanAirlines");
		CiaAerea airfrance = new CiaAerea("AF", "Air France");
		
		gerCias.adicionar(latam);
		gerCias.adicionar(gol);
		gerCias.adicionar(tap);
		gerCias.adicionar(azul);
		gerCias.adicionar(american);
		gerCias.adicionar(airfrance);
		

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Aeronaves
		// As aeronaves são identificadas por um código, uma descrição e uma
		// capacidade de passageiros:

		Aeronave boeing733_300 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave boeing737_700 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave airbusA380 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave boeing767_400 = new Aeronave("764", "Boeing 767-400", 304);
		Aeronave boeing747_8 = new Aeronave("747", "Boeing 747-8", 386);
		Aeronave airbusA330 = new Aeronave("330", "Airbus A330-203", 293);
				
		gerAeronaves.adicionar(boeing733_300);
		gerAeronaves.adicionar(boeing737_700);
		gerAeronaves.adicionar(airbusA380);
		gerAeronaves.adicionar(boeing767_400);
		gerAeronaves.adicionar(boeing747_8);
		gerAeronaves.adicionar(airbusA330);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Aeroportos
		// Os aeroportos possuem um código, um nome e uma localização geográfica
		// (latitude e longitude):

		Geo geo1 = new Geo(-29.9939, -51.1711);
		Geo geo2 = new Geo(-23.4356, -46.4731);
		Geo geo3 = new Geo(38.7742, -9.1342);
		Geo geo4 = new Geo(25.7933, -80.2906);
		Geo geo5 = new Geo(-20.2566, -40.2861);

		Aeroporto poa = new Aeroporto("POA", "Salgado Filho Intl Apt", geo1);
		Aeroporto gru = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", geo2);
		Aeroporto lis = new Aeroporto("LIS", "Lisbon", geo3);
		Aeroporto mia = new Aeroporto("MIA", "Miami International Apt", geo4);
		Aeroporto vix = new Aeroporto("VIX", "Eurico de Aguiar Salles", geo5);
		

		gerAeroportos.adicionar(poa);
		gerAeroportos.adicionar(gru);
		gerAeroportos.adicionar(lis);
		gerAeroportos.adicionar(mia);
		gerAeroportos.adicionar(vix);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Rotas
		// Uma rota é identificada por uma companhia aérea, aeroporto de origem,
		// aeroporto de destino e aeronave:

		Rota rota1 = new Rota(gol, gru, poa, boeing733_300);
		Rota rota2 = new Rota(gol, poa, gru, boeing733_300);
		Rota rota3 = new Rota(tap, mia, lis, airbusA380);
		Rota rota4 = new Rota(latam, gru, mia, boeing767_400);
		Rota rota5 = new Rota(american, vix, mia, boeing747_8);

		gerRotas.adicionar(rota1);
		gerRotas.adicionar(rota2);
		gerRotas.adicionar(rota3);
		gerRotas.adicionar(rota4);
		gerRotas.adicionar(rota5);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Voos
		// Um vôo é descrito por uma data e horário, duração, rota e estado
		// (confirmado, atrasado ou cancelado):
		LocalDateTime localDateTime1 = LocalDateTime.of(2016, 8, 10, 8, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, 8, 10, 15, 0);
		LocalDateTime localDateTime3 = LocalDateTime.of(2016, 8, 15, 12, 0);
		LocalDateTime localDateTime4 = LocalDateTime.of(2017, 7, 23, 1, 0);

		Duration duracao1 = Duration.ofMinutes(90);
		Duration duracao2 = Duration.ofMinutes(120);
		Duration duracao3 = Duration.ofMinutes(620);

		Voo voo1 = new Voo(rota2, localDateTime1, duracao1);
		voo1.setStatus(Status.ATRASADO);
		Voo voo2 = new Voo(rota4, localDateTime2, duracao2);
		voo2.setStatus(Status.CONFIRMADO);
		Voo voo3 = new Voo(rota3, localDateTime3, duracao2);
		voo3.setStatus(Status.CANCELADO);
		Voo voo4 = new Voo(rota5, localDateTime4, duracao3);
		voo4.setStatus(Status.CONFIRMADO);

		gerVoos.adicionar(voo1);
		gerVoos.adicionar(voo2);
		gerVoos.adicionar(voo3);
		gerVoos.adicionar(voo4);

		// ##########################################################################################################

		// ATIVIDADE - EXERCÍCIO PRÁTICO (1)

		// 1-Listar os dados de todos os vôos de um determinado aeroporto, a
		// partir do seu código
		ArrayList<Voo> listaVoos = new ArrayList<>(gerVoos.listarTodos());
		String codigo = "GRU";
		for (Voo a : listaVoos) {
			if (a.getRota().getOrigem().getCodigo().equals(codigo))
				System.out.println(a.toString());
		}

		// 2-Mostrar a geo-localização de todos os aeroportos que operam vôos de
		// uma determinada cia aérea
		// ArrayList<Rota> listaRotas = new ArrayList<>(gerRotas.listarTodas());
		// String codigo2 = "G3";
		// for (Rota r : listaRotas) {
		// if (r.getCia().getCodigo().equals(codigo2))
		// System.out.println(r.getDestino().getLocal().toString() +
		// r.getOrigem().getLocal().toString());
		// }

		// DESAFIO
		ArrayList<Rota> listaRotas = new ArrayList<>(gerRotas.listarTodas());
		ArrayList<Aeroporto> aeroAux = new ArrayList<>();
		String codigo2 = "G3";
		for (Rota r : listaRotas) {
			if (r.getCia().getCodigo().equals(codigo2)) {
				Aeroporto loc1 = r.getDestino();
				Aeroporto loc2 = r.getOrigem();
				if (!aeroAux.contains(loc1)) {
					aeroAux.add(loc1);
				}
				if (!aeroAux.contains(loc2)) {
					aeroAux.add(loc2);
				}
			}
		}
		if (!aeroAux.isEmpty()) {
			for (Aeroporto a : aeroAux) {
				System.out.println(a.toString());
			}
		} else {
			System.out.println("Geo Localizações não existentes!");
		}

		// 3-Listar as cias aéreas que utilizam um determinado tipo de avião	
		ArrayList<CiaAerea> aeronavesAux = new ArrayList<>();
		String oaviao = "733";
		for (Rota r : listaRotas) {
			if (r.getAeronave().getCodigo().equals(oaviao)) {
				if (!aeronavesAux.contains(r.getCia())) {
					aeronavesAux.add(r.getCia());
				}
			}
		}
		if (!aeronavesAux.isEmpty()) {
			for (CiaAerea cia : aeronavesAux) {
				System.out.println(cia.getNome());
			}
		} else {
			System.out.println("Não existem companhias que utlizam a Aeronave Informada!");
		}		
		
		
		System.out.println("\n\n\n");
		
		
		
		
		// ##########################################################################################################
		//MAIS EXERCÍCIOS
		
		//1 - Operar um relatório de uso de aeroporto/   <nome aeroporto>  <numero de voos>  ordenar por número de voos
		
		
		//2 - Calcular a distancia entre dois aeroportos informados
		
		

	}
	
	
}
