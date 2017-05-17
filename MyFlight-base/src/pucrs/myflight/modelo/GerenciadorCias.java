package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	private ArrayList<String> listadeEmpresa;
	
	

	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia) {

		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {

		return empresas;

	}

	public CiaAerea buscaporCodigo(String cod) {

		for (CiaAerea c : empresas) {
			if (c.getCodigo().equals(cod))
				return c;
		}
		return null;
	}

	public CiaAerea buscaporNome(String nome) {

		for (CiaAerea c : empresas) {
			if (c.getNome().equals(nome))
				return c;
		}
		return null;
	}

	public void carregaDados() throws IOException {
		Path path = Paths.get("MyFlight2017/Files/airlines.dat");
		try (BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset())) {
			String linha = null;
			 br.readLine();
			while ((linha = br.readLine()) != null) {
				String[] dados = linha.split(";");
				CiaAerea nova = new CiaAerea(dados[0], dados[1]);

			}
		} catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}

	}

}
