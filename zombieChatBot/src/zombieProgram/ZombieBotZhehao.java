package zombieProgram;

//hi

public class ZombieBotZhehao implements Topic {
	private String[] keywords; 
	private String goodbyeWords;
	private String secretWord;
	private boolean chatting;
	
	public ZombieBotZhehao()
	{
		String[] temp = {"food","life","school"};
		keywords = temp;
		goodbyeWords = "bye";
		secretWord = "pubg";
	}
	public boolean isTriggered(String response) {
		for(int i=0; i<keywords.length;i++)
		{
			if(ZombieBotMain.findKeyword(response, keywords[i], 0) >=0)
			{
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ZombieBotMain.print("Hey! we have common interest!Let's talk");
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			if(ZombieBotMain.findKeyword(response, goodbyeWords, 0)>=0)
			{
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}else if (ZombieBotMain.findKeyword(response, secretWord, 0)>=0) {
				ZombieBotMain.print("OMG! yOu GuEsS mY kys");
			}else {
				ZombieBotMain.print("huh you ugly");
			}
		}
	}

}
