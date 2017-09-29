package zombieProgram;

public class ZombieBotJustinY implements Topic {

	//This class is to be only changed by JUSTIN YAU
	//This section will manage the talks about food. 
	
	private String[] keywords; 
	private String goodbyeWord;
	private String secretWord; 
	private boolean chatting;
	
	public ZombieBotJustinY() {
		
		String[] temp = {"Zombies", "Vampires", "Internet"};
		keywords = temp;
		goodbyeWord = "Goodbye!"; 
		secretWord = "Cookies";
		
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
	
	public void startChatting(String response) {
		
		ZombieBotMain.print("Hey! It sounds like you and I have a common interest! Let's talk!");
		
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			if(ZombieBotMain.findKeyword(response, goodbyeWord, 0) >= 0)
			{
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
			else 
			{
				if(ZombieBotMain.findKeyword(response, secretWord, 0) >= 0)
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
	
}
	
