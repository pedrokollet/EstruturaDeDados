package QuickSort;

import java.util.Arrays;

public class Main {

	/*
	 * Considere um vetor com N elemento. Inicialmente escolhe-se um elemento
	 * que ser� colocado em sua posi��o final por meio de um processo de
	 * parti��o. Este processo tamb�m realoca os elementos de tal maneira que os
	 * menores que o pov� ficar�o antes deste e os maiores ou iguais ap�s. Com
	 * isso s�o formadas 2 regi�es, sobre os quais se aplica QuickSort
	 * recursivamente, caso possua mais de um elemento. Ao final, todos os
	 * elementos ter�o sido piv�s e o vetor estar� ordenado. O algoritmo �
	 * sens�vel ao piv� escolhido, pois se este ficar num extremo, haver� mais
	 * trabalho para ordenar.
	 */

	public static void quickSort(int[] vetor, int inicio, int fim) {
		if (vetor == null || vetor.length == 0) {
			return;
		}

		// condi��o final, caso o inicio seja maior ou igual ao fim
		if (inicio >= fim) {
			return;
		}

		// selecionar pivo
		int posPivo = inicio + (fim - inicio) / 2;
		int vlrPivo = vetor[posPivo];

		// selecionar os pivos da direita e esquerda
		int i = inicio, j = fim;

		// enquanto i <= j (enquanto n�o se cruzarem)
		while (i <= j) {
			// enquanto n�o acha valor menor, vai pra direita
			while (vetor[i] < vlrPivo) {
				i++;
			}

			// enquanto n�o acha valor maior, vai pra esquerda
			while (vetor[j] > vlrPivo) {
				j--;
			}

			// troca de lugar as posi��es
			if (i <= j) {
				int temp = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = temp;
				i++;
				j--;
			}
		}

		// chamar recursivamente as duas partes
		if (inicio < j) {
			quickSort(vetor, inicio, j);
		}
		if (fim > i) {
			quickSort(vetor, i, fim);
		}
	}

	public static int particao(int[] vetor, int inicio, int fim) {

		// step 2 - selecionar os piv�s da esquerda e direita
		int esquerda = inicio + 1;
		int direita = fim;

		// step 3 - enquanto os piv�s n�o se cruzarem
		while (esquerda <= direita) {
			while (esquerda <= direita && vetor[esquerda] < vetor[inicio]) {
				esquerda++;
			}

			while (esquerda <= direita && vetor[direita] >= vetor[inicio]) {
				direita--;
			}

			if (esquerda <= direita)
				troca(vetor, esquerda, direita);
		}
		troca(vetor, inicio, direita);

		return direita;
	}

	public static void quickSorter(int vetor[], int inicio, int fim) {
		if (inicio < fim) {
			int pos = particao(vetor, inicio, fim);
			quickSorter(vetor, inicio, pos - 1);
			quickSorter(vetor, pos + 1, fim);
		}
	}

	public static void troca(int[] vetor, int p1, int p2) {
		int aux = vetor[p1];
		vetor[p1] = vetor[p2];
		vetor[p2] = aux;
	}

	public static void main(String[] args) {
		int vetor[] = { 40, 50, 30, 60, 70, 10, 20, 80 };
		System.out.println(Arrays.toString(vetor));
		quickSorter(vetor, 0, 8 - 1);
		System.out.println(Arrays.toString(vetor));
	}

}
