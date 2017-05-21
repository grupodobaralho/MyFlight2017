package pucrs.myflight.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCias {

	private ArrayList<CiaAerea> empresas;	

	public GerenciadorCias() {
		empresas = new ArrayList<>();	
		carregaDados();
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

	public void carregaDados() {
		Path path = Paths.get("Files/airlines.dat");	
		try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
			sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
			String header = sc.nextLine(); // pula cabeçalho
			String cod, nome;
			  while ((sc.hasNext())) {	
				  cod = sc.next();
				  nome = sc.next();
				  CiaAerea cia = new CiaAerea(cod, nome);
				  empresas.add(cia);
			  }
			}
			catch (IOException x) {
			  System.err.format("Erro de E/S: %s%n", x);
			}
		
	}

}
