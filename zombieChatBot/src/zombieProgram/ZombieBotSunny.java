package zombieProgram;

public class ZombieBotSunny implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ZombieBotSunny()
	{
		String[] temp = {"food", "life", "jokes", "talk"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "brains";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++)
		{
			if(ZombieBotMain.findKeyword(response, keywords[i], 0) >= 0)
			{
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) 
	{
		ZombieBotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			if(ZombieBotMain.findKeyword(response, goodbyeWord, 0) >= 0)
			{
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
			else if(ZombieBotMain.findKeyword(response, secretWord, 0) >= 0)
			{
				ZombieBotMain.print("Urrrrh! You like brains too?");
			}
			else
			{
				ZombieBotMain.print("Huh. I don't really get you. Tell me something else?");
			}
			
		}
	}
}
