import java.util.*;
import java.io.*;

public class Exec {

	public static void main(String[] args) {

		WordSearch ws = new WordSearch();
		ws.writeKey("KEY.txt");

		InteractiveSolver IS = new InteractiveSolver(ws.getBoard(),ws.getWordList());

		IS.Solve();
	}
}
