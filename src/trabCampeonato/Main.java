package trabCampeonato;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	/*
	 * A sa�da deve apresentar a classifica��o das equipes por meio dos n�meros de identifica��o que devem estar ordenados segundo os crit�rios: 
	 * a) maior quantidade de pontos; 
	 * b) maior diferen�a de gols; 
	 * c) maior quantidade de gols marcados. 
	 * d) Caso haja empate nos 3 crit�rios, a equipe com menor identifica��o num�rica deve ser mostrada primeiro.
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Campeonato campeonato = new Campeonato();
		
		//cria um objeto Scanner para receber o input dos jogos
		Scanner linha = new Scanner(System.in);
		//Bloco Try Catch para caso d� a excess�o de n�o achar o arquivo
		try {
			//pegar o arquivo de texto para ter o input
			URL url = Main.class.getResource("jogos.txt"); //Pega a URL do arquivo, desde que ele esteja no projeto
			linha = new Scanner(new File(url.getPath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Ler o n�mero de times para cria��o da Array da Tabela do Campeonato
		int nroDeTimes = Integer.parseInt(linha.nextLine().trim());
		
		//enquanto tiver mais linhas, avaliar a partida:
		while (linha.hasNext()) {
			String partida = linha.nextLine();
			campeonato.avalia(partida);
		}
		
		//Transfere do Mapa para uma Array para ordena��o
		TimeCamp[] tabela = new TimeCamp[nroDeTimes];
		int tempcount = 0;
		for(Map.Entry<String, TimeCamp> map : campeonato.getMapaTimes().entrySet()){
			tabela[tempcount] = map.getValue();
			tempcount++;
		}
		
		System.out.println(Arrays.toString(tabela));
		
		MergeSorter sorter = new MergeSorter();
		sorter.mergeSort(tabela);
		System.out.println(Arrays.toString(tabela));
	}
}

