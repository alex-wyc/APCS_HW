import java.util.*;
import java.io.*;

public class WordSearch {
	
	private char[][] board;
	private char[][] key;
	private ArrayList<String> AllEnglishWords = new ArrayList<String>();
	private String[] wordList;
	private Random randgen = new Random();
	private final String wordDistribution = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbccccccccccccccccccccccccccccdddddddddddddddddddddddddddddddddddddddddddeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeffffffffffffffffffffffgggggggggggggggggggghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiijjkkkkkkkkllllllllllllllllllllllllllllllllllllllllmmmmmmmmmmmmmmmmmmmmmmmmnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooopppppppppppppppppppqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttuuuuuuuuuuuuuuuuuuuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwwwwwwwwwwwwwwwxxyyyyyyyyyyyyyyyyyyyyz";

	// Real representation from http://en.wikipedia.org/wiki/Letter_frequency

	public WordSearch(int len, int width, boolean willScan, String dictPath) {
		
		board = new char[len][width];
		key = new char[len][width];
		wordList = new String[(randgen.nextInt(5) - 2) + len * width * 3 / (100)];

		if (willScan) {
			scanWordFromUser();
		}
		
		else {
			loadWords(dictPath);
			genWordList(); // Decent amount of real words, 3/5 of the board should contain legit letters, average word length = approx. 5. +/- 2 word count jff
		}
		fillBoard(); // TO BE IMPLEMENTED LATER
	
	}

	public WordSearch() {

		this(10,10,false,"/usr/share/dict/words");
	}

	/*
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

	/*
	Intake = none
	Output = none
	Takes all lower-case only english words from /usr/share/dict/words and puts them into ArrayList AllEnglishWords.
	*/

	private void loadWords(String path){

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
				if (isAllLowerCase(line) && line.length() < board.length && line.length() < board[0].length) {
					AllEnglishWords.add(line);
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
			System.exit(0);
		} catch (IOException E) {
			System.out.println("Program crashed while reading file");
			System.exit(0);
		}
	}

	private void scanWordFromUser() {

		System.out.println("You have chosen to enter the words on you own!");
		System.out.println("Please enter lower case English words only!");
		System.out.println("Type 'HELP' for help! (If you want to enter the actual word, type 'help')");
		System.out.println("To end your buffer stream, type 'END_OF_TRANSMISSION'");
		Scanner sc = new Scanner(System.in);
		String line = "";
		int counter = 0;

		while (!line.equals("END_OF_TRANSMISSION")) {

			if (counter == wordList.length) {
				System.out.println("You've done enough!");
				break;
			}

			if (line.equals("END_OF_TRANSMISSION")) {
				break;
			}

			else if (line.equals("HELP")) {
				System.out.println("Type the word you desire to enter, please use only lower case English characters");
				System.out.println("Each newline will mark a new word, to end input, type 'END_OF_TRANSMISSION'");
				System.out.println("Note that you can not enter words longer than the length of the board.");
			}
			
			else if (isAllLowerCase(line) && line.length() < board.length && line.length() < board[0].length) {
				wordList[counter] = line;
				counter++;
			}

			else {
				System.out.println("INVALID WORD!!");
			}

			System.out.print("> ");
			line = sc.nextLine();
		}

		wordList = Arrays.copyOfRange(wordList,1,counter);
		System.out.println(Arrays.toString(wordList));

		return;
	}

	/*
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

	/*
	Intake = none
	Output = none
	Select a random set of words from AllEnglishWords with size equal to the parameter
	and puts them into wordList.
	*/

	private void genWordList() {
		
		int index;

		for (int i = 0 ; i < wordList.length ; i++) {
			index = randgen.nextInt(AllEnglishWords.size());
			wordList[i] = AllEnglishWords.get(index);
		}
	}

	private boolean addWord(String word, int x, int y, int xinc, int yinc) {
		for (int a = 0 ; a < word.length() ; a++) {
			if (!(word.charAt(a) == board[y + yinc*a][x + xinc*a] || board[y + yinc*a][x + xinc*a] == 0)) {
				return false;
			}
		}
		add(word,x,y,xinc,yinc);
		return true;
	}

	private void add(String word, int x, int y, int xinc, int yinc) {
		for(int b = 0 ; b < word.length() ; b++) {
			board[y + yinc*b][x + xinc*b] = word.charAt(b);
		}
	}
	
	/*
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
					
					while (!(addWord(word,x,y,0,-1))) {
						x = randgen.nextInt(board[0].length);
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}
									
					break;
				case 1: // going south
					
					x = randgen.nextInt(board[0].length);
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while(!(addWord(word,x,y,0,1))) {
						x = randgen.nextInt(board[0].length);
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					break;

				case 2: // going east

					x = randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
	
					while (!(addWord(word,x,y,1,0))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
					}

					break;

				case 3: // going west
					
					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom

					while (!(addWord(word,x,y,-1,0))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length); // top and bottom padding to make sure things don't go kaboom
					}
					
					break;

				case 4: // going north-east (you get the point)

					x = randgen.nextInt(board[0].length - word.length());
					y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addWord(word,x,y,1,-1))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					break;

				case 5: // going south-east

					x = randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addWord(word,x,y,1,1))) {
						x = randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

					break;

				case 6: // going south-west

					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addWord(word,x,y,-1,1))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}
	
					break;

				case 7: // going north-west

					x = word.length() + randgen.nextInt(board[0].length - word.length());
					y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom

					while (!(addWord(word,x,y,-1,-1))) {
						x = word.length() + randgen.nextInt(board[0].length - word.length());
						y = word.length() + randgen.nextInt(board.length - word.length()); // top and bottom padding to make sure things don't go kaboom
					}

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
					board[i][a] = wordDistribution.charAt(randgen.nextInt(1000));
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
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Program crashed while writing");
			System.exit(0);
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
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Program crashed while writing");
			System.exit(0);
		}

	}
}
