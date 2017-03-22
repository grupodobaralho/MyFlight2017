package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

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

		gerCias.adicionar(latam);
		gerCias.adicionar(gol);
		gerCias.adicionar(tap);
		gerCias.adicionar(azul);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Aeronaves
		// As aeronaves são identificadas por um código, uma descrição e uma
		// capacidade de passageiros:

		Aeronave boeing733_300 = new Aeronave("733", "Boeing 737-300", 140);
		Aeronave boeing737_700 = new Aeronave("73G", "Boeing 737-700", 126);
		Aeronave airbusA380 = new Aeronave("380", "Airbus Industrie A380", 644);
		Aeronave boeing767_400 = new Aeronave("764", "Boeing 767-400", 304);

		gerAeronaves.adicionar(boeing733_300);
		gerAeronaves.adicionar(boeing737_700);
		gerAeronaves.adicionar(airbusA380);
		gerAeronaves.adicionar(boeing767_400);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Aeroportos
		// Os aeroportos possuem um código, um nome e uma localização geográfica
		// (latitude e longitude):

		Geo geo1 = new Geo(-29.9939, -51.1711);
		Geo geo2 = new Geo(-23.4356, -46.4731);
		Geo geo3 = new Geo(38.7742, -9.1342);
		Geo geo4 = new Geo(25.7933, -80.2906);

		Aeroporto poa = new Aeroporto("POA", "Salgado Filho Intl Apt", geo1);
		Aeroporto gru = new Aeroporto("GRU", "São Paulo Guarulhos Intl Apt", geo2);
		Aeroporto lis = new Aeroporto("LIS", "Lisbon", geo3);
		Aeroporto mia = new Aeroporto("MIA", "Miami International Apt", geo4);

		gerAeroportos.adicionar(poa);
		gerAeroportos.adicionar(gru);
		gerAeroportos.adicionar(lis);
		gerAeroportos.adicionar(mia);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Rotas
		// Uma rota é identificada por uma companhia aérea, aeroporto de origem,
		// aeroporto de destino e aeronave:

		Rota rota1 = new Rota(gol, gru, poa, boeing733_300);
		Rota rota2 = new Rota(gol, poa, gru, boeing733_300);
		Rota rota3 = new Rota(tap, mia, lis, airbusA380);
		Rota rota4 = new Rota(latam, gru, mia, boeing767_400);

		gerRotas.adicionar(rota1);
		gerRotas.adicionar(rota2);
		gerRotas.adicionar(rota3);
		gerRotas.adicionar(rota4);

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// Voos
		// Um vôo é descrito por uma data e horário, duração, rota e estado
		// (confirmado, atrasado ou cancelado):
		LocalDateTime localDateTime1 = LocalDateTime.of(2016, 8, 10, 8, 0);
		LocalDateTime localDateTime2 = LocalDateTime.of(2016, 8, 10, 15, 0);
		LocalDateTime localDateTime3 = LocalDateTime.of(2016, 8, 15, 12, 0);

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

		// ##########################################################################################################

		
		// ATIVIDADE - EXERCÍCIO PRÁTICO (1)
		
		//1-Listar os dados de todos os vôos de um determinado aeroporto, a partir do seu código
		ArrayList<Voo> lista1 = new ArrayList<>(gerVoos.listarTodos());		
		String codigo = "GRU";
		for(Voo a : lista1) {
			if (a.getRota().getOrigem().getCodigo().equals(codigo))
				System.out.println(a.toString());
		}
		
		
		//2-Mostrar a geo-localização de todos os aeroportos que operam vôos de uma determinada cia aérea
//		ArrayList<Rota> lista2 = new ArrayList<>(gerRotas.listarTodas());
//		String codigo2 = "G3";
//		for (Rota r : lista2) {
//			if (r.getCia().getCodigo().equals(codigo2))
//				System.out.println(r.getDestino().getLocal().toString() + r.getOrigem().getLocal().toString());
//		}
		
		//DESAFIO
		ArrayList<Rota> lista2 = new ArrayList<>(gerRotas.listarTodas());
		ArrayList<Geo> geoAux = new ArrayList<>();
		String codigo2 = "G3";
		for(Rota r : lista2) {
			if (r.getCia().getCodigo().equals(codigo2)){
				Geo loc1 = r.getDestino().getLocal();
				Geo loc2 = r.getOrigem().getLocal();
				if(!geoAux.contains(loc1)){
					geoAux.add(loc1);
				}
				if(!geoAux.contains(loc2)){
					geoAux.add(loc2);
				}
			}
		}
		if(!geoAux.isEmpty()){
			for(Geo a : geoAux) {
				System.out.println(a.toString());
			}
		} else {
			System.out.println("Geo Localizações não existentes!");
		}
			
		
		//3-Listar as cias aéreas que utilizam um determinado tipo de avião
		ArrayList<Rota> lista3 = new ArrayList<>(gerRotas.listarTodas());
		ArrayList<CiaAerea> aeronavesAux = new ArrayList<>();
		String oaviao = "733";
		for(Rota r : lista3){
			if(r.getAeronave().getCodigo().equals(oaviao)){
				if(!aeronavesAux.contains(r.getCia())){
					aeronavesAux.add(r.getCia());
				}				
			}
		}
		if(!aeronavesAux.isEmpty()){
			for(CiaAerea cia : aeronavesAux) {
				System.out.println(cia.getNome());
			}
		} else {
			System.out.println("Não existem companhias que utlizam a Aeronave Informada!");
		}	

	}
}
