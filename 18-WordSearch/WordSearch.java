import java.util.*;
import java.io.*;

public class WordSearch {
	
	private char[][] board;
	private ArrayList<String> AllEnglishWords = new ArrayList<String>();
	private String[] wordList;
	private Random randgen = new Random();

	public WordSearch(int len, int width) {
		
		board = new char[len][width];
		loadWords();
		genWordList((randgen.nextInt(5) - 2) + len * width * 3 / (100)); // Decent amount of real words, 3/5 of the board should contain legit letters, average word length = approx. 5. +/- 2 word count jff
		fillBoard(); // TO BE IMPLEMENTED LATER
	
	}

	public WordSearch() {

		board = new char[10][10];
		loadWords();
		genWordList(3 + (randgen.nextInt(5) - 2)); // Refer to ln 10
		fillBoard();

	}

	/**
	<h3>To String Method</h3>
	Returns a string containing the entire board and wordbank, intake = none.
	*/

	public String ToString() {

		String str = new String();

		for (int i = 0 ; i < board.length ; i++) {
			for (int a = 0 ; a < board[i].length ; a++) {
				str = str + board[i][a];
			}

			str = str + "\n";
		}

		str = str + "\nWord Bank:\n";
		str = str + Arrays.toString(wordList);

		return str;
	}
	/**
	<h3>loadWords Method</h3>
	Intake = none
	Output = none
	Takes all lower-case only english words from /usr/share/dict/words and puts them into ArrayList AllEnglishWords.
	*/

	private void loadWords(){

		try {
			BufferedReader br = new BufferedReader(new FileReader("/usr/share/dict/words"));
			String line;
			while ((line = br.readLine()) != null) {
				if (isAllLowerCase(line) && line.length() < board.length && line.length() < board[0].length) {
					AllEnglishWords.add(line);
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		} catch (IOException E) {
			System.out.println("Program crashed while reading file");
		}
	}

	/**
	<h3>isAllLowerCase Method</h3>
	Intake = word
	Output = boolean representing if it is comprised only of lowercase characters
	*/

	private boolean isAllLowerCase(String word) {

		int asciiVal;

		for (int i = 0 ; i < word.length() ; i++) {
			asciiVal = (int)(word.charAt(i)); // ascii value of char at index i
			if (!(asciiVal > 96 && asciiVal < 123)) { // 97 = 'a' ; 122 = 'z'
				return false;
			}
		}

		return true;
	}

	/**
	<h3>genWordList Method</h3>
	Intake = size of wordList
	Output = none
	Select a random set of words from AllEnglishWords with size equal to the parameter
	and puts them into wordList.
	*/

	private void genWordList(int size) {
		
		wordList = new String[size];
		int index;

		for (int i = 0 ; i < size ; i++) {
			index = randgen.nextInt(AllEnglishWords.size());
			wordList[i] = AllEnglishWords.get(index);
		}
	}

	/**
	<h3>fillBoard Method</h3>
	Intake = none
	Output = none
	Fills the board according to wordList and randomizes the rest of the board
	*/

	private void fillBoard() {

		int direction, x, y;
		// x goes left to right
		// y goes up to down

		for (int i = 0 ; i < wordList.length ; i++) {
			direction = randgen.nextInt(8);
			x = 0; // b/c the compiler was being dumb
			y = 0; // b/c the compiler was being dumb
			boolean Check = false;
			String word = wordList[i];
			
			switch(direction) {
				case 0: // going north (up)
					
					while (!(Check)) {
						boolean good = true;
						x = randgen.nextInt(board[0].length);
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y-a][x] || board[y-a][x] == 0)) {
								good = false;
								break;
							}		
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y-b][x] = word.charAt(b);
					}

					break;
				case 1: // going south
					while (!(Check)) {
						boolean good = true;
						x = randgen.nextInt(board[0].length);
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y+a][x] || board[y+a][x] == 0)) {
								good = false;
								break;
							}		
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y+b][x] = word.charAt(b);
					}

					break;

				case 2: // going east

					while (!(Check)) {
						boolean good = true;
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y][x+a] || board[y][x+a] == 0)) {
								good = false;
								break;
							}		
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y][x+b] = word.charAt(b);
					}

					break;

				case 3: // going west

					while (!(Check)) {
						boolean good = true;
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y][x-a] || board[y][x-a] == 0)) {
								good = false;
								break;
							}
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y][x-b] = word.charAt(b);
					}

					break;

				case 4: // going north-east (you get the point)

					while (!(Check)) {
						boolean good = true;
						x = randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y-a][x+a] || board[y-a][x+a] == 0)) {
								good = false;
								break;
							}
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y-b][x+b] = word.charAt(b);
					}

					break;

				case 5: // going south-east
					while (!(Check)) {
						boolean good = true;
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y+a][x+a] || board[y+a][x+a] == 0)) {
								good = false;
								break;
							}		
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y+b][x+b] = word.charAt(b);
					}

					break;

				case 6: // going south-west

					while (!(Check)) {
						boolean good = true;
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y+a][x-a] || board[y+a][x-a] == 0)) {
								good = false;
								break;
							}
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y+b][x-b] = word.charAt(b);
					}

					break;

				case 7: // going north-west

					while (!(Check)) {
						boolean good = true;
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
						for (int a = 0 ; a < word.length() ; a++) {
							if (!(word.charAt(a) == board[y-a][x-a] || board[y-a][x-a] == 0)) {
								good = false;
								break;
							}
						}
						Check = good;
					}

					for(int b = 0 ; b < word.length() ; b++) {
						board[y-b][x-b] = word.charAt(b);
					}

					break;
			}
		}

		for (int i = 0 ; i < board.length ; i++){
			for (int a = 0 ; a < board[0].length ; a++) {
				if (board[i][a] == 0) {
					board[i][a] = (char)(97 + randgen.nextInt(26));
				}
			}
		}
	}
}
