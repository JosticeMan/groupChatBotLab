package zombieProgram;

public class ZombieBotSunny implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ZombieBotSunny()
	{
		String[] temp = {"food", "entertainment", "internet", "video games"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "sandwich";
	}

	@Override
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

	@Override
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
				ZombieBotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");
			}
			else
			{
				ZombieBotMain.print("Huh. I don't really get you. Tell me something else?");
			}
			
		}
	}
}
