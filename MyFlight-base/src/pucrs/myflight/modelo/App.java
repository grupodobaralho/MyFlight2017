//Hidden test
package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import pucrs.myflight.modelo.Voo.Status;

public class App {

	public static void main(String[] args) {

		GerenciadorAeronaves gerAeronaves = new GerenciadorAeronaves();
		GerenciadorAeroportos gerAeroportos = new GerenciadorAeroportos();
		GerenciadorCias gerCias = new GerenciadorCias();
		GerenciadorRotas gerRotas = new GerenciadorRotas();
		GerenciadorVoos gerVoos = new GerenciadorVoos();

		CiaAerea latam = new CiaAerea("JJ", "LATAM Linhas Aéreas");
		CiaAerea gol = new CiaAerea("G3", "Gol Linhas Aéreas SA");
		CiaAerea tap = new CiaAerea("TP", "TAP Portugal");
		CiaAerea azul = new CiaAerea("AD", "Azul Linhas Aéreas");
		CiaAerea american = new CiaAerea("AA", "American Airlines");
		CiaAerea airfrance = new CiaAerea("AF", "Air France");

		gerCias.adicionar(latam);
		gerCias.adicionar(gol);
		gerCias.adicionar(tap);
		gerCias.adicionar(azul);
		gerCias.adicionar(american);
		gerCias.adicionar(airfrance);

		// **********************************************************************************************************
		// Aeronaves
		// As aeronaves são identificadas por um código, uma descrição e uma
		// capacidade de passageiros:

		Aeronave boeing733_300 = new Aeronave("733", "Boeing 733-300", 140);
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

		// **********************************************************************************************************
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

		gerAeroportos.adicionar(vix);
		gerAeroportos.adicionar(poa);
		gerAeroportos.adicionar(gru);
		gerAeroportos.adicionar(lis);
		gerAeroportos.adicionar(mia);

		// **********************************************************************************************************
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

		// **********************************************************************************************************
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
		gerVoos.adicionar(voo4);

		gerVoos.adicionar(voo1);
		gerVoos.adicionar(voo2);
		gerVoos.adicionar(voo3);

		// Consulta 1

		ArrayList<Voo> listaVoo = new ArrayList<>(gerVoos.listarTodos());
		String codigo = "GRU";
		for (Voo v : listaVoo) {
			if (v.getRota().getOrigem().getCodigo().equals(codigo)) {
				System.out.println(v.toString());

			}

		}

		System.out.println();
		// Consult 2 //Desafio implementado
		ArrayList<Rota> lista2 = new ArrayList<>(gerRotas.listarTodas());
		ArrayList<Aeroporto> listaAux = new ArrayList<>();
		String codigo2 = "G3";

		for (Rota r : lista2) {
			if (r.getCia().getCodigo().equals(codigo2)) {
				Aeroporto aero1 = r.getDestino();
				Aeroporto aero2 = r.getOrigem();

				if (!listaAux.contains(aero1)) {
					listaAux.add(aero1);

					if (!listaAux.contains(aero2))
						listaAux.add(aero2);
				}
			}

		}
		if (!listaAux.isEmpty()) {
			for (Aeroporto a : listaAux) {

				System.out.println(a.toString());
			}
		} else
			System.out.println("Não existem resultados para sua pesquisa!");
		System.out.println();
		// Consulta 3 //Desafio implementado

		ArrayList<Rota> lista3 = new ArrayList<>(gerRotas.listarTodas());
		ArrayList<CiaAerea> aux = new ArrayList<>();

		String codAviao = "733";
		for (Rota r : lista3) {
			if (r.getAeronave().getCodigo().equals(codAviao)) {

				if (!aux.contains(r.getCia()))
					aux.add(r.getCia());

			}

		}
		if (!aux.isEmpty()) {
			for (CiaAerea c : aux) {

				System.out.println(c.getNome());
			}
		} else
			System.out.println("Não existem resultados para sua pesquisa!");

		// Consulta 4( relatorio de uso dos aeroportos)

		ArrayList<AeroportoRel> listaAero = new ArrayList<>();
		
		for(Voo v: listaVoo) {
			
			if(!listaAero.contains(v.getRota().getOrigem())) {
				
				
				
				
			}
				
			
		}
		

	}

}
