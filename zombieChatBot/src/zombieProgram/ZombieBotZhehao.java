package zombieProgram;



public class ZombieBotZhehao implements Topic {
	private String[] keywords; 
	private String[] goodbyeWords;
	private String[] talkingpoint;
	private String[] angerkeywords;
	private String[] angryresponse;
	private String[] happyresponse;
	private String[] suggesttopic;
	private String[] asktostop;
	private String[] confirm;// put keywords in
	private int questionasked=0;
	private boolean wanttochange = false;
	private boolean ischatted = false;
	private String secretWord;
	private int trackingnumber=0;
	private boolean chatting;
	private int angercount=-1;
	
	public ZombieBotZhehao()
	{
		String[] tempKeywords = {"past life","memory","alive","background information"};
		keywords= tempKeywords;
		String[] tempgoodbyeWords = {"bye","Goodbye","See you later","adios"};
		goodbyeWords= tempgoodbyeWords;
		String[] temptalkingpoint =  {"hobbies","school","age","background"};
		talkingpoint = temptalkingpoint;
		String[] tempangerkeywords = {"bad","ugly","dumb","stupid"};
		angerkeywords= tempangerkeywords;
		String[] tempangryresponse = {"ERR.... I'm not goin tWo tel u I like dancing.","School? YoU mEaN PrIsOn?","Derr..I m no telling u.DO TE mATH! 9*8-56+4*3.",
				""};
		angryresponse = tempangryresponse;
		String[] temphappyresponse = {"I love dansing! Derr.. I like vido game! ","ERRRR! I hate school! I know nothing, teacher bad!","Err I thnk I m 420 yers oldd.",
				"Errr They used to called me Carl Mike o Jack sin. I was tee bes dancer the worid had ever seen!"};
		happyresponse= temphappyresponse;
		String[] tempasktostop= {"That is not nice!Don't said that!","IM GOING TO GET MAD!","YOU BETTER SAID SORRY!","If You trash talk one more time Im goint to end u!",
			"hi"	};
		asktostop = tempasktostop;
		String[] tempsuggesttopic = {"I don't understand you. Let's talk about my hobbies.","ERR wat? I can't answer that. How about we talk about school?","Do you want to talk about something else?Maybe like my personal legacy.(hint: background)",
				"I don't understand! Say something else!"};
		suggesttopic=tempsuggesttopic;
		String[] tempothertopic= {"ok","sure","okay","yes"};
		confirm= tempothertopic;
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
	public boolean talkingpointisfound(String response)
	{
		for(int i=0;i<talkingpoint.length;i++)
		{
			if(ZombieBotMain.findKeyword(response,talkingpoint[i],0) >= 0)
			{
				trackingnumber = i;
				return true;
			}
			
		}
		return false;
	}
	public boolean triggerothertopic(String response)
	{
		for(int i=0;i<confirm.length;i++)
		{
			if(ZombieBotMain.findKeyword(response,confirm[i],0) >= 0)
			{
				return true;
			}
			
		}
		return false;
		
	}
	public boolean haschatted()
	{
		return ischatted;
		
	}
	public void startChatting(String response) {
		ZombieBotMain.print("UrHh! I dOn'T rEmEmBeR mUcH.... bUt I'Ll TrY mE bEsT tO aNsWeR yOuR qUeSiTiOnS!");
		chatting = true;
		while(chatting)
		{
			ischatted = true;
			response = ZombieBotMain.getInput();
			for(int i=0;i<goodbyeWords.length;i++)
			{
				if(ZombieBotMain.findKeyword(response, goodbyeWords[i], 0)>=0)
				{
					chatting = false;
					ZombieBotMain.chatbot.startTalking();
				}
			}
			if(wanttochange == true)
			{
				if(triggerothertopic(response) == true)
				{
					ZombieBotMain.chatbot.switchTopic(response,3);
				}
				ZombieBotMain.print("OK let talk more about my past life.");
			}
			
			if (ZombieBotMain.findKeyword(response, secretWord, 0)>=0) {
				ZombieBotMain.print("ERRR! DERRRRRRR! Me love Doraaaaa! DERRR! You can be me new bes friend!");
				angercount=0;
			}
			if(sademotiontriggered(response))
			{
				
				angercount+=1;
				questionasked +=1;
				ZombieBotMain.print(asktostop[angercount]);
				if(angercount == 9)
				{
					ZombieBotMain.print("ERRRRRRRRRR! That is it! I'm going to eat your brain!CARL DONT WANNA TALK YOU YOU ANYMORE! FORCE SHUTDOWN!");
					ZombieBotMain.chatbot.startTalking();
				}
			}else if(talkingpointisfound(response))
			{
				if(questionasked > 4)
				{
					ZombieBotMain.print("Do you want to talk about my zombie life?");
					wanttochange = true;
					
				}
				if(angercount<4)
				{
					questionasked +=1;
					ZombieBotMain.print(happyresponse[trackingnumber]);
					
				}
				else
					{
						questionasked +=1;
					 	ZombieBotMain.print(angryresponse[trackingnumber]);
					}
			}else {
				questionasked+=1;
				ZombieBotMain.randomText(suggesttopic);
				
			}
		
			
			
			
		
		}
	}

}
