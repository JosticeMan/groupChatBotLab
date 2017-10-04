package zombieProgram;

public class ZombieBotCoby implements Topic {

	private String[] keywords;
	private String[] userOptions;
	private String[] goodbyeWords;
	private String secretWord;
	private boolean gameStarted = false;
	private boolean chatting;
	private int topicChosen;
	private String playerChoice;
	private String playerWeapon;
	
	public ZombieBotCoby() {
		String[] temp = {"social life","hobbies","person","people","games","technology"};
		keywords = temp;
		String[] temp2 = {"rock","paper","scissors"};
		userOptions = temp2;
		String[] temp3 = {"bye","goodbye","later",};
		goodbyeWords = temp3;
		secretWord = "vampires";
	}
	
	
	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ZombieBotMain.findKeyword(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void startChatting(String response) {
		ZombieBotMain.print("Hey. Let's have a conversation urrr! As you long as you feed me brainssssss afterwards. What do you want to talk about?");
		chatting = true;
		
		while(chatting) {
			response = ZombieBotMain.getInput();
			
			if(gameStarted) {
				if(isthereWord(userOptions,response)) {
					ZombieBotMain.print(getWinner(playerWeapon));
				}
			}
			
			if(isthereWord(goodbyeWords,response)) {
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
				
			if(isthereWord(keywords,response)) {
				ZombieBotMain.print(getResponse(topicChosen));
			}
			if(ZombieBotMain.findKeyword(response, secretWord, 0) >= 0) {
				ZombieBotMain.print("I hate vampires! Zombies are much cooler.");
			}
			else {
				ZombieBotMain.print("Errrr I don't get it. Can you say something that I can relate to?");
			}
		}
	}
	
	
	public boolean isthereWord(String[] list, String response) {
		for(int i = 0; i < list.length; i++) {
			if(ZombieBotMain.findKeyword(response, list[i], 0) >= 0) {
				if(list == keywords) {
					topicChosen = i;
				}
				if(list == userOptions) {
					playerWeapon = list[i];
				}
				return true;
			}
		}
		return false;
	}
	public String getWinner(String player) {
		//1 is rock; 2 is paper, 3 is scissors
		int zombieChoice = (int) ((Math.random() * 3) + 1);
		playerChoice = player.toLowerCase();
		gameStarted = false;
		if(zombieChoice == 1 && playerChoice == "paper") {
			return "I picked rock. You won.";
		}
		if(zombieChoice == 1 && playerChoice == "scissors") {
			return "I picked rock. I win! Now let me eat your brain!";
		}
		if(zombieChoice == 2 && playerChoice == "rock") {
			return "I picked paper. I win! Now let me eat your brain!";
		}
		if(zombieChoice == 2 && playerChoice == "scissors") {
			return "I picked paper. You won.";
		}
		if(zombieChoice == 3 && playerChoice == "rock") {
			return "I picked scissors. You won.";
		}
		if(zombieChoice == 3 && playerChoice == "paper") {
			return "I picked scissors. I won! Now let me eat your brain!";
		}
		return "It's a tie!";
	}
	
	
	public String getResponse(int keywordFound) {
		if(keywordFound == 0) {
			return "I don't...have a social life......all I do is sleepp.";
		}
		if(keywordFound == 1) {
			return "I like to eat BRAINS....durrrrr let me eat yours!";
		}
		if(keywordFound == 2 || keywordFound == 3) {
			return "My favorite people are uh smart people.....their brains are more delicious. Errrrr of course my least favorite people are....dumb people";
		}
		if(keywordFound == 4) {
			gameStarted = true;
			return "I love games. Lets play rock, paper, scissors! Type in your choice";
		}
		if(keywordFound == 5) {
			return "Technology? We don't use technology! When I was alive the only phone that was out was the first Nokia.";
		}
		return "I don't get what you're saying.";
	}
}