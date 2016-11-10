package exerciciosPraticos;

import java.util.ArrayList;
import java.util.List;

public class HackerRank {

	static int sum(int[] numbers) {
		int numNum = numbers[0];
		int returnSum = 0;
		for (int i = 1; i <= numNum; i++) {
			returnSum = returnSum + numbers[i];
		}
		return returnSum;
	}

	static String[] buildSubsequences(String s) {
		List<String> returnStr = new ArrayList<String>();
		String out;
		String sb = new String(s);
		for (int i = 0; i < sb.length(); i++) {
			out = "";
			out = sb.substring(i, i + 1);
			returnStr.add(out);
			for (int j = i + 1; j < sb.length(); j++) {
				out += sb.substring(j, j + 1);
				returnStr.add(out);
			}
			if (sb.length() - i > 2) {
				out = sb.substring(i, i + 1);
				for (int j = i + 2; j < sb.length(); j++) {
					out += sb.substring(j, j + 1);
					returnStr.add(out);
				}
			}
		}
		String[] returnCase = new String[returnStr.size()];
		int count = 0;
		for (String irVet : returnStr) {
			returnCase[count] = irVet;
			count++;
		}
		return returnCase;
	}

	static long countMoves(int[] numbers) {
		long count = 0;
		int highNum = 0;
		int highNumPos = 0;
		boolean flag = false;

		while (!flag) {
			// Vê se são todos iguais continue;
			boolean testFlag = false;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[0] == numbers[i]) {
					testFlag = true;
				} else
					testFlag = false;
			}
			if (testFlag) {
				flag = true;
				continue;
			}
			highNum = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (highNum < numbers[i]) {
					highNum = numbers[i];
					highNumPos = i;
				}
			}

			for (int i = 0; i < numbers.length; i++) {
				if (i != highNumPos) {
					numbers[i] += 1;
				}
			}
			count++;
		}
		return count;
	}

	public static void count(int[] arr) {
		float neg = 0;
		float pos = 0;
		float zer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				pos += 1l;
			} else if (arr[i] < 0) {
				neg += 1l;
			} else {
				zer += 1l;
			}
		}
		System.out.println(pos / arr.length);
	}

	public void staircase(int n) {
		String sb = new String();
		for (int i = 0; i < n; i++) {
			sb = "";
			for (int j = 0; j < n - (i + 1); j++) {
				sb += " ";
			}
			for (int j = n - (i + 1); j < n; j++) {
				sb += "#";
			}
			System.out.println(sb);
		}
	}

	public static void militaryWatch(String time) {
		String horario = new String();
		if (Integer.parseInt(time.substring(0, 2)) == 12) {
			if (time.substring(8, 10).equals("PM")) {
				horario = "12" + time.substring(2, 8);
			} else {
				horario = "00" + time.substring(2, 8);
			}
		} else if (time.substring(8, 10).equals("PM")) {
			int temp = Integer.parseInt(time.substring(0, 2)) + 12;
			horario += temp + time.substring(2, 8);
		} else {
			horario += time.substring(0, 8);
		}
		System.out.println(horario);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int numbers[] = {2, 2, 4};
		// System.out.println(countMoves(numbers));
		// count();
		// militaryWatch("12:05:45AM");
		
	}

}
