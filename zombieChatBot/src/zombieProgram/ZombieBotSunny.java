package zombieProgram;

public class ZombieBotSunny implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private String[] Jokes;
	private String[] JokesAnswers;
	private boolean chatting;
	
	public ZombieBotSunny()
	{
		String[] temp = {"joke", "jokes", "funny", "puns"};
		keywords = temp;
		
		String[] rTemp = {"What kind of candy do zombies refuse to eat?", "Where do zombies go swimming?", "What does it take to become a zombie?"};
		Jokes = rTemp;
		
		String[] rTempAns = {"Life Savers!", "The Dead Sea!", "Deadication!"};
		JokesAnswers = rTempAns;
		
		goodbyeWord = "bye";
		secretWord = "grains";
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
	public void tellJoke(int stage, String userInput)
	{
		int randomInt = (int) Math.floor(Math.random()*Jokes.length);
		boolean possibilities = (userInput.toLowerCase() == "what?" || userInput.toLowerCase() == "what" ||userInput.toLowerCase() == "where?" || userInput.toLowerCase() == "where");
		if(stage == 0)
		{
			ZombieBotMain.print(Jokes[randomInt]);
		}
		else if(stage == 1 && possibilities)
		{
			ZombieBotMain.print(JokesAnswers[randomInt]);
		}
		else if(!possibilities && stage == 2)
		{
			ZombieBotMain.print("Urrrrh! You ruined thurr joke!");
		}
	}

	public void startChatting(String response) 
	{
		if(ZombieBotMain.findKeyword(response, secretWord, 0) > -1)
		{
			ZombieBotMain.print("Errhh! You like grains too? Urh!");
		}
		else 
		{
			ZombieBotMain.print("Urrh... I will tell... erh... joke.");
		}
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
				ZombieBotMain.print("Urrrrh! You like grains too?"); 
			}
			else
			{
				int stageNum = 0;
				while(stageNum < 2)
				{
					tellJoke(stageNum, response);
					stageNum += 1;
				}
			}
			
			/*
			else
			{
				ZombieBotMain.print("Huh. I don't really get you. Tell me something else?");
			}
			*/
			
		}
	}
}