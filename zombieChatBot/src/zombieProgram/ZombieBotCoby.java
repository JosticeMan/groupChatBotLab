package zombieProgram;

public class ZombieBotCoby implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ZombieBotCoby() {
		String[] temp = {"social life","hobbies","person","people","games","technology"};
		keywords = temp;
		String[] gameChoice = {"rock","paper","scissors"};
		String goodbyeWord = "bye";
		secretWord = "the walking dead";
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
		ZombieBotMain.print("Hey. Let's have a conversation urrr! As you long as you feed me brainssssss afterwards.");
		chatting = true;
		while(chatting) {
			response = ZombieBotMain.getInput();
			if(ZombieBotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}else {
				for(int i = 0; i < keywords.length; i++) {
					if(ZombieBotMain.findKeyword(response,keywords[i], 0) >= 0) {
						ZombieBotMain.print(getResponse(i));
					}
				}
				if(ZombieBotMain.findKeyword(response, secretWord, 0) >= 0) {
					ZombieBotMain.print("I love that show! Durrrr my brothers eventually get what they want.");
				} else {
					ZombieBotMain.print("Errrr I don't get it. Can you say something that I can relate to?");
				}
			}
		}
	}
	
	public String playGame() {
		return "I won!";
	}
	public String getResponse(int keywordFound) {
		if(keywordFound == 0) {
			return "I don't...have a social life......all I do is sleepp.";
		}
		if(keywordFound == 1) {
			return "I like to eat BRAINS....durrrrr let me eat yours!";
		}
		if(keywordFound == 2 || keywordFound == 3) {
			return "My favorite people are smart people, their brains are more delicious. And you can assume my least favorite people are dumb people";
		}
		if(keywordFound == 4) {
			return "I love games! Lets play rock, paper, scissors! Type in your choice";
		}
		if(keywordFound == 5) {
			return "Technology? We don't use technology! When I was alive the only phone that was out was the first Nokia.";
		}
		return "I don't get what you're saying.";
	}
}