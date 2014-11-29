import java.util.*;
import java.io.*;

public class InteractiveSolver {

	// INSTANCE VARS

	private char[][] board;
	private String[] wordList;
	private String[] Direction = {"north","northeast","east","southeast","south","southwest","west","northwest"};
	private boolean allSet = false;

	// CONSTRUCTORS
	
	public InteractiveSolver(char[][] newBoard, String[] newWordList) {
		board = newBoard;
		wordList = newWordList;
	}

	// FUNCTIONS

	public void Solve() {
	
		Scanner sc = new Scanner(System.in);
		int xi = -1, yi = -1, wordLength = -1;
		int xinc = 0, yinc = 0;
		String direction;

		while (!(allSet)) {
			clearScreen();

			winCheck();

			System.out.println(ToString());
			
			System.out.println("Pick a starting coordinate, note that x goes left to right, y goes up to down");
			while (xi < 0 || xi >= board[0].length) {
				System.out.print("Starting x is: ");
				xi = Integer.parseInt(sc.nextLine());

			}

			while (yi < 0 || yi >= board.length) {
				System.out.print("Starting y is: ");
				yi = Integer.parseInt(sc.nextLine());
			}

			System.out.println("In which direction?");
			direction = sc.nextLine();

			while (!(Arrays.asList(Direction).contains(direction))) {
				System.out.println(direction);
				System.out.println("That's not a valid direction!");
				System.out.println("Valid directions include: " + Arrays.toString(Direction).substring(1,69));
				System.out.println("Please enter a valid direction: ");
				direction = sc.nextLine();
			}

			switch (direction) {
				case "north":
					yinc = -1;
					break;
				case "northeast":
					xinc = 1;
					yinc = -1;
					break;
				case "east":
					xinc = 1;
					break;
				case "southeast":
					xinc = 1;
					yinc = 1;
					break;
				case "south":
					yinc = 1;
					break;
				case "southwest":
					yinc = 1;
					xinc = -1;
					break;
				case "west":
					xinc = -1;
					break;
				case "northwest":
					xinc = -1;
					yinc = -1;
					break;
			}

			System.out.println("How long is this word you're thinking of?");
			wordLength = Integer.parseInt(sc.nextLine());

			if (xi + wordLength*xinc >= 0 && xi + wordLength*xinc <= board[0].length && yi + wordLength*yinc >= 0 && yi + wordLength*yinc <= board.length) {
				
				String testWord = getWord(xi, yi, wordLength, xinc, yinc);
				
				System.out.println(testWord);

				if (withinSearch(testWord)) {
					replace(testWord,strikeThrough(testWord));
					System.out.println("Good job!");
				}

				else {
					System.out.println("Sorry, that is not within the word bank! Try again!");
				}

			}

			else {
				System.out.println("That word would go off the board! Try again!");
			}
			
			xi = -1;
			yi = -1;
			wordLength = -1;
			xinc = 0;
			yinc = 0;

			sc.nextLine();

			//System.out.println("YAY");
			//break;
		}
	}

	public String ToString() {

		String str = "";

		for (int i = 0 ; i < board.length ; i++) {
			str = str + String.format("%02d", i) + " ";
			for (int a = 0 ; a < board[i].length ; a++) {
				str = str + board[i][a] + "  ";
			}

			str = str + "\n\n";
		}

		str = str + "   ";

		for (int a = 0 ; a < board[0].length ; a++) {
			str = str + String.format("%02d", a) + " ";
		}

		str = str + "\n\nWord Bank:\n";
		str = str + Arrays.toString(wordList);

		return str;
	}


	public void winCheck() {

		allSet = true;

		for (String word : wordList) {
			if (!(word.contains("\u0336"))) {
				allSet = false;
			}
		}
	}

	public String getWord(int x, int y, int length, int xinc, int yinc) {

		String out = "";

		for (int i = 0 ; i < length ; i++) {
			out = out + board[y + i*yinc][x + i*xinc];
		}

		return out;
	}

	public boolean withinSearch(String test) {
		
		for (String element : wordList) {
			if (element.equals(test)) {
				return true;
			}
		}

		return false;
	}

	private void replace(String original, String replacement) {
		
		for (int i = 0 ; i < wordList.length ; i++) {
			if (wordList[i].equals(original)) {
				wordList[i] = replacement;
				return;
			}
		}
	}

	private void clearScreen() {
		System.out.println("\033\143");
	}

	private String strikeThrough(String original) {
		String out = "";

		for (String letter : original.split("")) {
			out = out + letter + "\u0336";
		}

		return out;
	}

	private void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {}
	}
}
