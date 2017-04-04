package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

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

		VooDireto voo1 = new VooDireto(localDateTime1, rota2);
		voo1.setStatus(Status.ATRASADO);
		VooDireto voo2 = new VooDireto(localDateTime2, rota4);
		voo2.setStatus(Status.CONFIRMADO);
		VooDireto voo3 = new VooDireto(localDateTime3, rota3);
		voo3.setStatus(Status.CANCELADO);
		VooDireto voo4 = new VooDireto(localDateTime4, rota5);
		voo4.setStatus(Status.CONFIRMADO);

		gerVoos.adicionar(voo1);
		gerVoos.adicionar(voo2);
		gerVoos.adicionar(voo3);
		gerVoos.adicionar(voo4);

		// ##########################################################################################################

		// ATIVIDADE - EXERCÍCIO PRÁTICO (1)

		// 1-Listar os dados de todos os vôos de um determinado aeroporto, a
		// partir do seu código
		System.out.print(
				"\n\n### EXERCÍCIO LISTAR OS DADOS DE TODOS OS VOOS DE UM DETERMINADO AEROPORTO A PARTIR DO SEU CODIGO ### \n\n");
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
		System.out.print(
				"\n\n### EXERCÍCIO MOSTRAR A GEO LOCALIZACAO DE TODOS AEROPORTOS QUE OPERAM VOOS DE UMA DETERMINADA CIA AEREA ### \n\n");
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
		System.out.print("\n\n### EXERCÍCIO LISTAR AS CIAS AEREAS QUE UTILIZAM UM DETERMINADO TIPO DE AVIAO ### \n\n");
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

		// ##########################################################################################################
		// MAIS EXERCÍCIOS

		// 1 - Operar um relatório de uso de aeroporto/ <nome aeroporto> <numero
		// de voos> ordenar por número de voos
		System.out.print("\n\n### EXERCÍCIO RELATÓRIO DE USO AEROPORTO: ###\n\n");
		ArrayList<AeroportoRel> listaAeroRel = new ArrayList<>();
		ArrayList<Aeroporto> listaAeroporto = new ArrayList<>(gerAeroportos.listarTodos());
		for (Aeroporto a : listaAeroporto) {
			listaAeroRel.add(new AeroportoRel(a));
		}
		for (Voo v : listaVoos) {
			Aeroporto origem = v.getRota().getOrigem();
			Aeroporto destino = v.getRota().getDestino();
			for (AeroportoRel a : listaAeroRel) {
				if (a.getAeroporto().equals(origem)) {
					a.setNumeroDeVoos(a.getNumeroDeVoos() + 1);
				}
				if (a.getAeroporto().equals(destino)) {
					a.setNumeroDeVoos(a.getNumeroDeVoos() + 1);
				}
			}
		}
		Comparator<AeroportoRel> bynumeroDeVoos = (a1, a2) -> Integer.compare(a1.getNumeroDeVoos(),
				a2.getNumeroDeVoos());
		listaAeroRel.stream().sorted(bynumeroDeVoos).forEach(e -> System.out
				.println("<" + e.getAeroporto().getNome() + " =>" + "<Numero de Voos: " + e.getNumeroDeVoos() + ">"));

		// 2 - Calcular a distancia entre dois aeroportos informados
		System.out.print("\n\n### EXERCÍCIO CALCULAR DISTANCIA ENTRE DOIS AEROPORTOS INFORMADOS ### \n\n");
		Aeroporto um = gerAeroportos.buscarPorCodigo("POA");
		Aeroporto dois = gerAeroportos.buscarPorCodigo("VIX");
		double R = 6371.01;
		double lat1 = um.getLocal().getLatitude();
		double lat2 = dois.getLocal().getLatitude();
		double latDistance = Math.toRadians(lat1) - Math.toRadians(lat2);
		double lonDistance = Math.toRadians(um.getLocal().getLongitude()) - Math.toRadians(dois.getLocal().getLongitude());
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters
	    distance = Math.pow(distance, 2) + Math.pow(0, 2);	    
		
		System.out.println("A distancia do:    "+um.getNome()+"\npara o:    "+dois.getNome()+
							"\ne de: "+ (int)Math.sqrt(distance) + " metros");
		
		// ##########################################################################################################
		// EXERCÍCIOS DE HERANCA
//		
//		System.out.print("\n\n### EXERCICIO DE HERANCA ### \n\n");
//		System.out.println("2 - A modelagem não esta legal... podiamos usar Voo como classe estatica\n");
//		
//		Voo vooTeste = new VooEscalas(rota1, localDateTime1, duracao1, rota2);
//		vooTeste.setStatus(Status.ATRASADO);
//		//vooTeste.getRotaFinal(); Não Posso pois Voo não encherga as filhas
//		System.out.println("#Testando Voo/VooEscalas#\n" + vooTeste.toString()+"\n"); 
//		//Porém o toString printa  o toString do VooEscalas por causa do @Override
//		
//		VooEscalas vooEscalasTeste = new VooEscalas(rota1, localDateTime1, duracao1, rota2);
//		vooEscalasTeste.setStatus(Status.ATRASADO);
//		System.out.println("#Testando VooEscalas/VooEscalas#\n" + vooEscalasTeste.toString()+"\n"); 
//		//tenho acesso direto aos métodos da classe vooEscalasTeste
//		
//		
//		ArrayList<Rota> escalas = new ArrayList<>();
//		escalas.add(rota1);
//		escalas.add(rota2);
//		escalas.add(rota3);
//		VooVariasEscalas vooVariasEscalasTeste = new VooVariasEscalas(rota1, localDateTime1, duracao1, escalas);
//		vooVariasEscalasTeste.setStatus(Status.ATRASADO);
//		System.out.println("#Testando VooVariasEscalas/VooVariasEscalas#\n" + vooVariasEscalasTeste.toString()+"\n"); 
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
