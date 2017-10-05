package zombieProgram;

public class ZombieBotCoby implements Topic {
	private String[] keywords;
	private String[] userOptions;
	private String[] goodbyeWords;
	private String[] topicWords;
	private String[] happyWords;
	private String[] angryWords;
	private String[] socialResponses;
	private String[] hobbyResponses;
	private String[] peopleResponses;
	private String[] technologyResponses;
	private String secretWord;
	private String playerChoice;
	private String playerWeapon;
	private String favoriteHobby;
	
	private boolean gameStarted = false;
	private boolean chatting;
	
	private int topicChosen;
	
	
	
	public ZombieBotCoby() {
		String[] temp = {"conversation","chat","smalltalk"};
		keywords = temp;
		String[] temp1 = {"social life","hobbies","hobby","person","people","games","technology"};
		topicWords = temp1;
		String[] temp2 = {"rock","paper","scissors"};
		userOptions = temp2;
		String[] temp3 = {"bye","goodbye","later","stop"};
		goodbyeWords = temp3;
		String[] temp4 = {"I don't...have a social life......all I do is sleepp.","We always have parties..we're already dead so we party all"
				+ " night long without having to go to sleep.","Zerrrr I don't have.. any friends."};
		socialResponses = temp4;
		String[] temp5 = {"I like to eat BRAINS....durrrrr let me eat yours!","Zurrr I've been sleeping..using almost all my time.", "I like"
				+ " to win as zombies in Plants Vs Zombies."};
		hobbyResponses = temp5;
		String[] temp6 = {"My favorite people are uh smart people.....their brains are rich and delicious.","Errrrr of course my least "
				+ "favorite people are....dumb people."};
		peopleResponses = temp6;
		String[] temp7 = {"Technology? We don't use technology! When I was alive the only phone that was out was the first Nokia.", "I don't"
				+ "know anything about today's technology."};
		technologyResponses = temp7;
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
				} else {
					ZombieBotMain.print("That's not a choice.....Urrr..please pick rock, paper or scissors");
				}
			} else {
				if(isthereWord(goodbyeWords,response)) {
					chatting = false;
					ZombieBotMain.chatbot.startTalking();
				} else {
					if(isthereWord(topicWords,response)) {
						ZombieBotMain.print(getResponse(topicChosen));
					} else {
						if(ZombieBotMain.findKeyword(response, secretWord, 0) >= 0) {
							ZombieBotMain.print("I hate vampires! Zombies are much cooler.");
						} else {
							ZombieBotMain.print("Errrr I don't get it. Can you say something else?");
						}
					}
				}
			}
		}
	}
	
	
	
	public boolean isthereWord(String[] list, String response) {
		for(int i = 0; i < list.length; i++) {
			if(ZombieBotMain.findKeyword(response, list[i], 0) >= 0) {
				if(list == topicWords) {
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
			return socialResponses[(int) (Math.random()*socialResponses.length)];
		}
		if(keywordFound == 1 || keywordFound == 2) {
			return hobbyResponses[(int) (Math.random()*hobbyResponses.length)];
		}
		if(keywordFound == 3 || keywordFound == 4) {
			return peopleResponses[(int) (Math.random()*peopleResponses.length)];
		}
		if(keywordFound == 5) {
			gameStarted = true;
			return "I love games. Lets play rock, paper, scissors! Type in your choice";
		}
		if(keywordFound == 6) {
			return technologyResponses[(int) (Math.random()*technologyResponses.length)];
		}
		return "I don't get what you're saying.";
	}
	
	public String getHobby() {
		return this.favoriteHobby;
	}
}