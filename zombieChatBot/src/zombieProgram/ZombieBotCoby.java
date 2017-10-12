package zombieProgram;

public class ZombieBotCoby implements Topic {
	private String[] keywords;
	private String[] userOptions;
	private String[] goodbyeWords;
	private String[] topicWords;
	private String[] socialResponses;
	private String[] hobbyResponses;
	private String[] peopleResponses;
	private String[] technologyResponses;
	
	private String[] confirmation;
	private String[] denial;
	
	private String secretWord;
	private String playerChoice;
	private String playerWeapon;
	
	private boolean gameStarted = false;
	private boolean asktoSwitch = false;
	private boolean chatting;
	
	private int topicChosen;
	private int dialogues = 0;
	private int idkTime = 0;
	private int userWins = 0;
	private int botWins = 0;
	
	
	public ZombieBotCoby() {
		String[] temp = {"conversation","chat","smalltalk"};
		keywords = temp;
		String[] temp1 = {"social life","hobbies","hobby","person","people","games","game","technology"};
		topicWords = temp1;
		String[] temp2 = {"rock","paper","scissors"};
		userOptions = temp2;
		String[] temp3 = {"bye","goodbye","later","stop"};
		goodbyeWords = temp3;
		String[] temp4 = {"I don't...have a social life......all I do is sleepppp.","We always have parties..we're already dead so we party all night long without having to go to sleep.","Zerrrr I don't have.. any friends.",
				"Urrggg I haven't left my grave in urhh around 6 months..","I... urggh think I met a vampire yesterday.... or last uh week"};
		socialResponses = temp4;
		String[] temp5 = {"I like to eat BRAINS....durrrrr let me eat yours!","Zurrr I've been sleeping..using almost all my time.", "I like to win as zombies in Plants Vs Zombies.","I.. like to walk around.. even if a few limbs fall off...",
				"I liek to dance and dance...urgggg"};
		hobbyResponses = temp5;
		String[] temp6 = {"My favorite people are uh smart people.....their brains are rich and delicious.","Errrrr of course my least favorite people are....dumb people.","I was alive..when I think George....Wash Tin was president.."};
		peopleResponses = temp6;
		String[] temp7 = {"Technology....? What that.. we don't use technology... when me was alive the only phone that was out was the telegraph.", "I don't "
				+ "know anything about today's technology....","Do the new.. technology.. create good food?"};
		technologyResponses = temp7;
		String[] temp8 = {"yes","ok","sure","okay","yeah"};
		confirmation = temp8;
		String[] temp9 = {"no","nah","never","negative"};
		denial = temp9;
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
		ZombieBotMain.print("Hey. Let's have a conversation urrr... As you long as you feed me brainssssss afterwards. What do you want to talk about?");
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
								ZombieBotMain.print("I hate vampires.....Zombies are sooo much cooler.");
							} else {
								if(asktoSwitch && isthereWord(confirmation, response)) {
									ZombieBotMain.chatbot.switchTopic(response, 2);
								} else {
									if(asktoSwitch && isthereWord(denial, response)) {
										ZombieBotMain.print("Okay then..we keep talking.");
										dialogues = 0;
										asktoSwitch = false;
									} else {
										idkTime++;
										if(idkTime < 2) {	
											ZombieBotMain.print("Errrr I don't get it. Can you say something else?");
										} else {
											ZombieBotMain.print("I don't get what you're sayingit.....we talk about " + topicWords[(int) (Math.random()*topicWords.length)] + ". good?");
										}
									}
								}
							}
						}
						dialogues++;
						if(dialogues > 5) {
							ZombieBotMain.print("Now do you want...to talk urgggh about my past life?");
							asktoSwitch = true;
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
			userWins++;
			return "I picked rock....you won. The score is " + botWins + " me, " + userWins + " you.";
		}
		if(zombieChoice == 1 && playerChoice == "scissors") {
			botWins++;
			return "I picked rock. I win so let me EAT your brainnn.. The score is " + botWins + " me, " + userWins + " you.";
		}
		if(zombieChoice == 2 && playerChoice == "rock") {
			botWins++;
			return "I picked paper. I win! Now let me eat your brain! The score is hur" + botWins + " me, " + userWins + " you.";
		}
		if(zombieChoice == 2 && playerChoice == "scissors") {
			userWins++;
			return "I picked paper. You won zurrrrr. The score... is " + botWins + " me, " + userWins + " you.";
		}
		if(zombieChoice == 3 && playerChoice == "rock") {
			userWins++;
			return "I picked scissors. Ughhhh You won.... The.. score is " + botWins + " me, " + userWins + " you.";
		}
		if(zombieChoice == 3 && playerChoice == "paper") {
			botWins++;
			return "Urrrrr I picked scissors. I won! Now let me eat your brain! The score is " + botWins + " me, " + userWins + " you.";
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
		if(keywordFound == 5 || keywordFound == 6) {
			gameStarted = true;
			return "I LIKE GAMES. we play rock, paper, scissors? Uhhh type your choice";
		}
		if(keywordFound == 7) {
			return technologyResponses[(int) (Math.random()*technologyResponses.length)];
		}
		return "";
	}	
}
	
