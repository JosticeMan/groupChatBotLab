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
	public void tellJoke(int stage, String userInput, int randomNum)
	{
		boolean possibilities = (userInput.equalsIgnoreCase("what?") || userInput.equalsIgnoreCase("what") ||userInput.equalsIgnoreCase("where?") || userInput.equalsIgnoreCase("where"));
		if(stage == 0)
		{
			ZombieBotMain.print(Jokes[randomNum]);
		}
		else if(stage == 1 && possibilities)
		{
			ZombieBotMain.print(JokesAnswers[randomNum]);
		}
		else if(!possibilities && stage == 1)
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
		int stageNum = 0;
		int randomInt = (int) Math.floor(Math.random()*Jokes.length);
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
				tellJoke(stageNum, response, randomInt);
				stageNum += 1;
				if(stageNum == 2)
				{
					stageNum = 0;
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