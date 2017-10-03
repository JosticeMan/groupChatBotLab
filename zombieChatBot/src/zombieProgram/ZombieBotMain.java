package zombieProgram;

import java.util.Scanner;

//Zombie is the main bot's identity 
//Topics: Food(Justin Yau)/Past Life (Zhehao lin)/Small talk (Coby)/Zombie Jokes (Sunny Kwong)

public class ZombieBotMain {

	//Static means independent of instances. This chat bot represents the program itself. When the program runs and you
	//want to access the state of the program, then you need to put an handle on it (identifer). In this case, it's chat bot.
	//By making it a chatbot handle, it can be accessed everywhere. 
	
	//It is public static because it allows other classes to access the information of the public class independent from other instances. 
	//Shows you the current state of the program. 
	public static ZombieBot chatbot = new ZombieBot();
	
	public static void main(String[] args) {
		
		chatbot.startTalking();

	}

	/** 
	 * Looks through the string for any string mentioned in the array
	 * @param input - The phrase that you want to input
	 * @param arr - The array of strings you want to search for
	 * @return - Returns the first string that is found within the input
	 */
	public static String containsString(String input, String[] arr) {
		
		for(int i = 0; i < arr.length; i++)
		{
			if(findKeyword(input, arr[i], 0) >= 0)
			{
				return arr[i];
			}
		}
		return "";
	}
	
	/**
	 * Chooses & prints a random phrase from a String Array
	 * @param arr - String Array that contains random phrases
	 */
	public static void randomText(String[] arr) {
		
		print(arr[((int) (Math.random() * arr.length))]);
		
	}
	
	private static Scanner inputSource = new Scanner(System.in);
	  
	  /**Returns index of the keyword in the search string after startPosition where keyword is isolated and has no negations. 
	    *Returns -1 if keyword is not found. 
	  */
	public static int findKeyword(String searchString, String keyword, int startPos) {
		  searchString = searchString.toLowerCase();
		  keyword = keyword.toLowerCase();
		  //Finds the first position after start position
		  int psn = searchString.indexOf(keyword, startPos);
		  
		  //Keep searching until keyword is found with no negations and is isolated 
		  while(psn >= 0)
		  {
			  if(keywordIsIsolated(psn, keyword, searchString) && noNegations(searchString, psn))
			  {
				  return psn;
			  }
			  else
			  {
				  //Looks for the next occurrence
				  psn = searchString.indexOf(keyword, psn + 1);
			  }
		  }
		  return -1;
		  
	}
	  
	public static boolean keywordIsIsolated(int pos, String keyword, String s){
		  
		  if(s.length() == keyword.length())
			{
				return true;
			}
			else if(pos == 0) 
			{
				return s.substring(pos + keyword.length(), pos + (keyword.length() + 1)).compareTo("a") < 0;
			}
			else if(pos == (s.length() - keyword.length()))
			{
				return s.substring(pos - 1, pos).compareTo("a") < 0;
			}
			else
			{
				return s.substring(pos + keyword.length(), pos + (keyword.length() + 1)).compareTo("a") < 0 && s.substring(pos - 1, pos).compareTo("a") < 0;
			}
	}
 
	  
	public static boolean noNegations(String s, int pos) {
			
		if(pos == 0 || pos < 3)
		{
			return true;
		}
		else
		{
			if(pos < 4)
			{
				return !(s.substring(pos - 3, pos - 1).equalsIgnoreCase("no"));
			}
			else
			{
				return !(s.substring(pos - 3, pos - 1).equalsIgnoreCase("no") || s.substring(pos - 4, pos - 1).equalsIgnoreCase("not"));
			}
		}
	}
	  
	  
	public static String getInput(){
		  return inputSource.nextLine();
	  }
	  
	public static void print(String s){
		  multiLinePrint(s);
	  }
	  
	public static void multiLinePrint(String s){
		  String printString = "";
		  int cutoff = 55;
		  //this while loop last as long as there are words left in the original String
		  while(s.length() > 0){

			  String currentCut = "";
			  String nextWord = "";

			  //while the current cut is still less than the line length 
			  //AND there are still words left to add
			  while(currentCut.length()+nextWord.length() < cutoff && s.length() > 0){
		
				//add the next word
			    currentCut += nextWord;
				 
				//remove the word that was added from the original String
			    s = s.substring(nextWord.length());
				 
				//identify the following word, exclude the space
				int endOfWord = s.indexOf(" ");
			
				 //if there are no more spaces, this is the last word, so add the whole thing
				 if(endOfWord == -1) {
					 endOfWord = s.length()-1;//subtract 1 because index of last letter is one les than length
				 }
			
				 //the next word should include the space
				 nextWord = s.substring(0,endOfWord+1);
			}

		  	  printString +=currentCut+"\n";

		  }
	
		  System.out.print(printString);
	  }

	public static int getIntegerInput() {
		 print("Please enter an integer.");
		 String integerString = getInput();
		 boolean isInteger = false;
		 int value = 0;
		 while(!isInteger){
			 try{
				 value = Integer.parseInt(integerString);
				 //will not continue if an error above is thrown
				 isInteger = true;//exits loop if entry is valid
			 }catch(NumberFormatException e){
				 print("You must enter an integer. You better try again.");
				 integerString = getInput();
			 }
		 }
		 return value;
	 }
	 
}