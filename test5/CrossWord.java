import java.util.*;
import java.io.*;

public class CrossWord {

	private char[][] board;
	
	public CrossWord() {
		board = new char[9][12];

		board[2][2] = 'C';
		board[2][9] = 'R';
		board[3][1] = 'O';
		board[3][2] = 'H';
		board[3][5] = 'B';
		board[3][7] = 'T';
		board[3][8] = 'H';
		board[3][9] = 'E';
		board[3][10] = 'N';
		board[4][1] = 'F';
		board[4][2] = 'A';
		board[4][3] = 'L';
		board[4][4] = 'S';
		board[4][5] = 'E';
		board[4][7] = 'R';
		board[4][9] = 'A';
	}

	public void printWordsInRow(int rowNum) {
		int position = 0;
		ArrayList<String> words = new ArrayList<String>();
		String currentWord = "";

		while (position < board[rowNum].length) {

			if (board[rowNum][position] == '\u0000') {

				if (currentWord.length() > 1) {
					words.add(currentWord);
					currentWord = "";
				}

				else {
					currentWord = "";
				}
			}

			else {
				currentWord = currentWord + new StringBuilder().append(board[rowNum][position]);
			}
			System.out.println(currentWord);
			position++;
		}

		if (words.size() == 0) {
			System.out.println("FALSE");
			return;
		}
		for (int i = 0 ; i < words.size() ; i++) {
			System.out.println(words.get(i));
			return;
		}
	}

	public static void main(String[] args) {
		CrossWord cw = new CrossWord();

		System.out.println("Row 3:");
		cw.printWordsInRow(3);
		System.out.println("Row 4:");
		cw.printWordsInRow(4);
		System.out.println("Row 5:");
		cw.printWordsInRow(0);
	}
}
