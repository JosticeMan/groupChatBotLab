package zombieProgram;



public class ZombieBotZhehao implements Topic {
	private String[] keywords; 
	private String[] goodbyeWords;
	private String[] talkingpoint;
	private String secretWord;
	private boolean chatting;
	private String emotion="happy";
	
	public ZombieBotZhehao()
	{
		String[] temp = {"past life","memory","alive"};
		keywords = temp;
		String[] temp2= {"bye","Goodbye","See you later","adios"};
		goodbyeWords = temp2;
		String[] temp3 = {"hobbies","school","age","background"," "};
		talkingpoint = temp3;
		secretWord = "Dora";
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
	public changeemtion(String response)
	{
		
		
	}
	public keywordlocation(String response)
	{
		for(i=0;i<keywords.length;i++)
		{
			if(ZombieBotMain.findKeyword(response, talkingpoint[i],0)>=0)
			{
				return i;
			}
		}
		
	}
	
	
	public void startChatting(String response) {
		ZombieBotMain.print("UrHh! I dOn'T rEmEmBeR mUcH.... bUt I'Ll TrY mE bEsT tO aNsWeR yOuR qUeSiTiOnS!");
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			if(ZombieBotMain.findKeyword(response, goodbyeWords, 0)>=0)
			{
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}else if (ZombieBotMain.findKeyword(response, secretWord, 0)>=0) {
				ZombieBotMain.print("ERRR! DERRRRRRR! Me love Doraaaaa! DERRR! You can be me new bes friend!");
			}else {
				
				
			}
		}
	}

}
