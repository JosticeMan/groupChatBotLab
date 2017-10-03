package zombieProgram;



public class ZombieBotZhehao implements Topic {
	private String[] keywords; 
	private String[] goodbyeWords;
	private String[] talkingpoint;
	private String[] angerkeywords;
	private String[] angryresponse;
	private String[] happyresponse;
	private String[] asktostop;
	private String previousinput;
	private String secretWord;
	private boolean chatting;
	private String emotion="happy";
	private int angercount=0;
	
	public ZombieBotZhehao()
	{
		String[] tempKeywords = {"past life","memory","alive"};
		keywords= tempKeywords;
		String[] tempgoodbyeWords = {"bye","Goodbye","See you later","adios"};
		keywords= tempgoodbyeWords;
		String[] temptalkingpoint =  {"hobbies","school","age","background",""};
		talkingpoint = temptalkingpoint;
		String[] tempangerkeywords = {"bad","ugly","dumb","stupid",""};
		angerkeywords= tempangerkeywords;
		String[] tempangryresponse = {"ERR.... I'm not goin tWo tel u I like dancing.","School? YoU mEaN PrIsOn?","Derr..I m no telling u.DO TE mATH! 9*8-56+4*3.",
				"  "};
		angryresponse = tempangerkeywords;
		String[] tempasktostop= {"That is not nice!Don't said that!","IM GETTING MAD!","YOU BETTER SAID SORRY!"};
		asktostop = tempasktostop;
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
	public boolean sademotiontriggered(String response)
	{
		for(int x=0;x<angerkeywords.length;x++)
		{
			if(ZombieBotMain.findKeyword(response, angerkeywords[x],0)>=0)
			{
				return true;
			}
			
		}
		return false;
	}
	
	public void changeemtion(String response)
	{
		if(sademotiontriggered(response))
		{
			angercount+=10;
			ZombieBotMain.randomText(asktostop);
		}
		if(angercount == 100)
		{
			emotion = "angry";
			ZombieBotMain.print("ERRRRRRRRRR! That is it! I'm going to eat your brain!");
		}
	}
	public String checkallkeywords(String searchstring, String[] arr)
	{
		if(arr == goodbyeWords)
		{
			for(int i = 0; i<goodbyeWords.length;i++)
			{
				ZombieBotMain.findKeyword(searchstring, goodbyeWords[i], 0);
			}
		}
		
	}
	
	public String answerresponse()
	{
		if(emotion=="happy")
		{
			
			
		}
		else
		{
			
		}
			
		
	}
	public void startChatting(String response) {
		ZombieBotMain.print("UrHh! I dOn'T rEmEmBeR mUcH.... bUt I'Ll TrY mE bEsT tO aNsWeR yOuR qUeSiTiOnS!");
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			for(int i=0;i<goodbyeWords.length;i++)
			{
				if(ZombieBotMain.findKeyword(response, goodbyeWords[i], 0)>=0)
				{
					chatting = false;
					ZombieBotMain.chatbot.startTalking();
				}
			}
			
			if (ZombieBotMain.findKeyword(response, secretWord, 0)>=0) {
				ZombieBotMain.print("ERRR! DERRRRRRR! Me love Doraaaaa! DERRR! You can be me new bes friend!");
				angercount=0;
			}else {
				
				
			}
		}
	}

}
