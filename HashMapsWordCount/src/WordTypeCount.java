import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class WordTypeCount {
	
	public static void main(String[] args) {
		//create HashMap to store String keys and Integer Values
		Map<String, Integer> myMap = new HashMap<>();
		
		createMap(myMap);//create map based on user input
		displayMap(myMap);//display map content
	}
	
	private static void createMap(Map<String, Integer> map) {
		
		//create scanner and get user input string 
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string:");
		String input = scan.nextLine();
		
		//split the sentence into different tokens 
		String[] tokens = input.split(" ");
		
		//process the input
		for (String token : tokens) {
			String word = token.toLowerCase();//turn each word to lower case
			
			//if the map contains the word
			if(map.containsKey(word)) {
				//is the word in the map?
				int count = map.get(word);//get current count
				map.put(word, count+1);//increment the count
			}else {
				// add new word with a count of 1 to map
				map.put(word, 1); 
			}	
		}
	}	

	//display map content
	private static void displayMap(Map<String, Integer> map) {
		Set<String> keys = map.keySet(); //get keys
		
		//sort keys
		TreeSet<String> sortedKeys = new TreeSet<>(keys);
		
		System.out.printf("%nMap contains: %nKey\t\tValue%n");
		
		//generate output for each key in map
		for (String key : sortedKeys) {
			System.out.printf("%-10s%10s%n", key, map.get(key));
		}
		
		System.out.printf("%nSize: %d%nisEmpty: %b%n", map.size(), map.isEmpty());
	}
}
