import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * This ReverseSong class 
 * Prints out a song from a text file 'song.txt'
 * and prints it out in reverse order
 * @author Abraham Fong
 */
public class ReverseSong{
	
	static ArrayList<String> lines = new ArrayList<>();
	static String song = "song.txt";	
	
	public static void main(String args[]) {
		
		File songToFlip = new File(song);

		ArrayList<String> song = saveSongInArrayList(songToFlip);//save the song into an arraylist
		String sentences = createSentences(song);//flip the order of the words 
		String finalSong = reverseSentence(sentences); //spell each words backwards
		
		System.out.println("Here's your song: \n");
		System.out.println(sentences);

		System.out.println("Here's your backwards song:");
		System.out.println(finalSong);
		
	}
		
	public static ArrayList saveSongInArrayList(File f) {	
		//read in each line from the file and save each word 
		//to an array list of string objects
		File file = f; 
		ArrayList <String> songLinesInArrayList = new ArrayList<>();

		try {
			//created bufferedreader to read in file contents
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			//loop through each line and save into a temporary array
			while((line = reader.readLine()) != null) {
				
				//add new line after each stanza of the song
				//save into array each word of the line
				line += " \n";
				String[] info = line.split(" "); 
				
				
				//save each word in the array into an array list of strings 
				int size = info.length;
				for(i=0; i < size; i++) {
					if(i != size) {
						songLinesInArrayList.add(info[i]);			
					}
				}
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return songLinesInArrayList;
	}//end method savesonginarray
	
	public static String  createSentences(ArrayList<String> wordsInArrayList) {
		//start with empty string
		String lineWithWordsBackwards = " ";
		
		//loop through each word in the ArrayList
		//and build one long ass string 
		for(String w : wordsInArrayList) {
			lineWithWordsBackwards += w + " ";	
		}
		return lineWithWordsBackwards;
	}


	public static String reverseSentence(String words) {
		//begin with empty string	
		String wordsInReverse = "";
		
		//get the length of the word we're reversing
		//so we can start at the end
		int length = words.length() -1;
		
		//rebuild the word starting from the last character
		while(length >= 0) {
			Character c = words.charAt(length);
			wordsInReverse += c;
			length--;
		}		
		return wordsInReverse;
	}
	
}//end class 
