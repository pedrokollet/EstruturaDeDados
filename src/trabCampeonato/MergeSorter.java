package trabCampeonato;

@SuppressWarnings("rawtypes")
public class MergeSorter {

	public MergeSorter() {

	}

	// Método construtor do sorter
	public void mergeSort(TimeCamp[] a) { 
		TimeCamp[] tmp = new TimeCamp[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
	}

	private void mergeSort(TimeCamp[] a, TimeCamp[] tmp, int esquerda, int direita) {
		if (esquerda < direita) {
			int meio = (esquerda + direita) / 2;
			mergeSort(a, tmp, esquerda, meio);
			mergeSort(a, tmp, meio + 1, direita);
			merge(a, tmp, esquerda, meio + 1, direita);
		}
	}

	private void merge(TimeCamp[] a, TimeCamp[] tmp, int esquerda, int direita, int pontaDireita) {
		int pontaEsquerda = direita - 1;
		int k = esquerda;
		int num = pontaDireita - esquerda + 1;

		/*
		 *	Regras da Ordenação:
		 *	Fazer o sort da array, comparando os pontos 
		 *	em caso de empate, comparar saldo de gols
		 *	em caso de empate, comparar total de gols
		 *	em caso de novo empate, comparar a menor ID 
		 */
		while (esquerda <= pontaEsquerda && direita <= pontaDireita) {
			if (a[esquerda].getPontos() > a[direita].getPontos()) { //caso o time1 tenha mais pontos que o time2, se mantém na esquerda
				tmp[k] = a[esquerda];
				k++;
				esquerda++;
			}else if (a[esquerda].getPontos() == a[direita].getPontos() 
					&& a[esquerda].getSaldo() > a[direita].getSaldo()){ //caso time1 tenha mais saldo que o time2, se mantém na esquerda
				tmp[k] = a[esquerda];
				k++;
				esquerda++;
			}else if (a[esquerda].getPontos() == a[direita].getPontos() 
					&& a[esquerda].getSaldo() == a[direita].getSaldo()
					&& a[esquerda].getTotalGols() > a[direita].getTotalGols()){ //caso time1 tenha mais total de gols que o time2, se mantém na esquerda
				tmp[k] = a[esquerda];
				k++;
				esquerda++;
			}else if (a[esquerda].getSaldo() == a[direita].getSaldo() 
					&& a[esquerda].getPontos() == a[direita].getPontos() 
					&& a[esquerda].getTotalGols() == a[direita].getTotalGols()
					&& Integer.parseInt(a[esquerda].getId()) < Integer.parseInt(a[direita].getId())){ //caso time1 tenha um ID menor que o time2, se mantém na esquerda
				tmp[k] = a[esquerda];
				k++;
				esquerda++;
			}
			else { //caso final, o time 1: não tem mais pontos, não tem mais saldo de gols, não tem Total de Gols maior, e não tem um ID Menor, então time2 vai para a esquerda
				tmp[k] = a[direita];
				k++;
				direita++;
			}
		}

		while (esquerda <= pontaEsquerda) { 
			tmp[k] = a[esquerda];
			k++;
			esquerda++;
		}

		while (direita <= pontaDireita) {
			tmp[k] = a[direita];
			k++;
			direita++;
		}

		for (int i = 0; i < num; i++, pontaDireita--) {
			a[pontaDireita] = tmp[pontaDireita];
		}
	}
}
