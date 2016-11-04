package trabCampeonato;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Campeonato {
	//Classy/Smart Way (1 map com um objeto que agrupa os valores)
	Map<String, TimeCamp> mapaTimes;
	
	public Map<String, TimeCamp> getMapaTimes() {
		return mapaTimes;
	}

	//Classe que recebe cada partida e joga para a tabela
	public Campeonato(){
		mapaTimes = new HashMap();
	}
	
	public void avalia(String partida){
		//Quebra a linha em Strings, separado por
		String[] game = partida.split(" ");
		//game[0] = ID Time 1, game[1] = Gols Time 1
		//game[2] = ID Time 2, game[3] = Gols Time 2
		
		int ptTime1 = 0, ptTime2 = 0;
		int saldoTime1 = 0, saldoTime2 = 0;
		
		//Transforma String em int para atribuir os gols de cada time
		int golsTime1 = Integer.parseInt(game[1]), golsTime2 = Integer.parseInt(game[3]);
		
		//Saldos = gols do time - gols do adversário
		saldoTime1 = golsTime1 - golsTime2;
		saldoTime2 = golsTime2 - golsTime1;
		
		//Compara o saldo de gols para atribuir os pontos
		if (saldoTime1 > 0){			//Time 1 venceu
			ptTime1 = 3;
			ptTime2 = 0;
		} else if (saldoTime1 == 0){	//Empatou
			ptTime1 = 1;
			ptTime2 = 1;
		} else { 						//Time2 venceu
			ptTime1 = 0;
			ptTime2 = 3;
		}
		//Chama função de ajuste no mapa mapaTimes
		insereNoMapa(game[0], ptTime1, saldoTime1, golsTime1);
		insereNoMapa(game[2], ptTime2, saldoTime2, golsTime2);
	}
	
	public void insereNoMapa(String idTime, int pontos, int saldo, int gols){
		//Se o mapa já tiver o time de key idTime, então atualiza os valores baseado nos já existentes
		if (mapaTimes.containsKey(idTime)){	
			//mapa.get para pegar o endereço do objeto para manipulação dos valores
			mapaTimes.get(idTime).setPontos(mapaTimes.get(idTime).getPontos() + pontos);
			mapaTimes.get(idTime).setSaldo(mapaTimes.get(idTime).getSaldo() + saldo);
			mapaTimes.get(idTime).setTotalGols(mapaTimes.get(idTime).getTotalGols() + gols);
		} else { 
			//Se o time não existir na lista, cria um novo com os valores
			mapaTimes.put(idTime, new TimeCamp(idTime, pontos, saldo, gols));
		}
	}
}