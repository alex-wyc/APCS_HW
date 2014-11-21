import java.util.*;
import java.io.*;

public class WordSear {
	
	private char[][] board;
	private char[][] key;
	private ArrayList<String> AllEnglishWords = new ArrayList<String>();
	private String[] wordList;
	private Random randgen = new Random();

	public WordSear(int len, int width) {
		
		board = new char[len][width];
		key = new char[len][width];
		loadWords();
		genWordList((randgen.nextInt(5) - 2) + len * width * 3 / (100)); // Decent amount of real words, 3/5 of the board should contain legit letters, average word length = approx. 5. +/- 2 word count jff
		fillBoard(); // TO BE IMPLEMENTED LATER
	
	}

	public WordSear() {

		this(10,10);
	}

	/**
	<h3>To String Method</h3>
	Returns a string containing the entire board and wordbank, intake = none.
	*/

	public String ToString() {

		String str = new String();

		for (int i = 0 ; i < board.length ; i++) {
			for (int a = 0 ; a < board[i].length ; a++) {
				str = str + board[i][a] + " ";
			}

			str = str + "\n\n";
		}

		str = str + "\nWord Bank:\n";
		str = str + Arrays.toString(wordList);

		return str;
	}

	public void writeBoard(String path){
		
		try {
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			String line = "";

			for (int i = 0 ; i < board.length ; i++) {
				for (int a = 0 ; a < board[i].length ; a++) {
					line = line + board[i][a] + " ";
				}
				line = line + "\n";
				writer.println(line);
				line = "";
			}

			writer.println("\nWord Bank:\n");
			writer.println(Arrays.toString(wordList));

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Invalid Path!");
		} catch (IOException e) {
			System.out.println("Program crashed while writing");
		}
	}

	public void writeKey(String path){

		try {
			PrintWriter writer = new PrintWriter(path, "UTF-8");
			String line = "";

			for (int i = 0 ; i < key.length ; i++) {
				for (int a = 0 ; a < key[i].length ; a++) {
					line = line + key[i][a] + " ";
				}
				line = line + "\n";
				writer.println(line);
				line = "";
			}

			writer.println("\nWord Bank:\n");
			writer.println(Arrays.toString(wordList));

			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Invalid Path!");
		} catch (IOException e) {
			System.out.println("Program crashed while writing");
		}

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

	private boolean addCheck(String word, int x, int y, int xinc, int yinc) {
		for (int a = 0 ; a < word.length() ; a++) {
			if (!(word.charAt(a) == board[y + yinc*a][x + xinc*a] || board[y + yinc*a][x + xinc*a] == 0)) {
				return false;
			}
		}
		return true;
	}

	private void add(String word, int x, int y, int xinc, int yinc) {
		for(int b = 0 ; b < word.length() ; b++) {
			board[y + yinc*b][x + xinc*b] = word.charAt(b);
		}
	}
	
	/**
	<3>fillBoard Method</h3>
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
					
					x = randgen.nextInt(board[0].length);
					y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					
					while (!(addCheck(word,x,y,0,-1))) {
						x = randgen.nextInt(board[0].length);
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,0,-1);
				
					break;
				case 1: // going south
					
					x = randgen.nextInt(board[0].length);
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while(!(addCheck(word,x,y,0,1))) {
						x = randgen.nextInt(board[0].length);
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,0,1);

					break;

				case 2: // going east

					x = randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
	
					while (!(addCheck(word,x,y,1,0))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,1,0);

					break;

				case 3: // going west
					
					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom

					while (!(addCheck(word,x,y,-1,0))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,-1,0);
					
					break;

				case 4: // going north-east (you get the point)

					x = randgen.nextInt(board[0].length - word.length());
					y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addCheck(word,x,y,1,-1))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,1,-1);

					break;

				case 5: // going south-east

					x = randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addCheck(word,x,y,1,1))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,1,1);

					break;

				case 6: // going south-west

					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addCheck(word,x,y,-1,1))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,-1,1);
	
					break;

				case 7: // going north-west

					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addCheck(word,x,y,-1,-1))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					add(word,x,y,-1,-1);

					break;
			}
		}

		// Key generation
		keyGen();

		// Fill with random letters
		fillBoardRandom();
		
	}

	private void fillBoardRandom() {
		for (int i = 0 ; i < board.length ; i++){
			for (int a = 0 ; a < board[0].length ; a++) {
				if (board[i][a] == 0) {
					board[i][a] = (char)(97 + randgen.nextInt(26));
				}
			}
		}
	}

	private void keyGen() {
		for (int i = 0 ; i < board.length ; i++) {
			for (int a = 0 ; a < board[0].length ; a++) {
				if (board[i][a] == 0) {
					key[i][a] = '.';
				}
				else {
					key[i][a] = board[i][a];
				}
			}
		}
	}
}
