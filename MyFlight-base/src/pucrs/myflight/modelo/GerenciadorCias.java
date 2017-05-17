package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class GerenciadorCias {

	private ArrayList<CiaAerea> empresas;
	private ArrayList<String> listaEmpresas;

	public GerenciadorCias() {
		empresas = new ArrayList<>();
		listaEmpresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia) {
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas() {
		return empresas;
	}

	public CiaAerea buscarPorCodigo(String cod) {
		for (CiaAerea a : empresas) {
			if (a.getCodigo().equals(cod))
				return a;
		}
		return null;
	}

	public CiaAerea buscarNome(String nome) {
		for (CiaAerea a : empresas) {
			if (a.getNome().equals(nome))
				return a;
		}
		return null;
	}

	public void carregaDados() throws IOException {
		Path path = Paths.get("Files/airlines.dat");
		
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
			  String line = null;
			 // reader.readLine()
			  while ((line = reader.readLine()) != null) {
			    System.out.println("Linha: "+line);
			    //String[] dados = linha.split(";");
			    //CiaAerea nova = new CiaAerea(dados[0], dados[1]);
			  }
			}
			catch (IOException x) {
			  System.err.format("Erro de E/S: %s%n", x);
			}
		
	}

}
