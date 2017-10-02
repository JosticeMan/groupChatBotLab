package zombieProgram;

public class ZombieBotSunny implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private String[] kkJokes;
	private String[] rJokes;
	private String[] kkJokesAnswers;
	private String[] rJokesAnswers;
	private boolean chatting;
	private boolean kkJoke;
	
	public ZombieBotSunny()
	{
		String[] temp = {"joke", "jokes", "funny", "puns"};
		keywords = temp;
		
		String[] kkTemp = {"orange", "zombie"};
		kkJokes = kkTemp;
		
		String[] kkTempAns = {"orange you glad i didn't say zombie?", "Braaaaains!!"};
		kkJokesAnswers = kkTempAns;
		
		String[] rTemp = {"What kind of candy do zombies refuse to eat?", "Where do zombies go swimming?", "What does it take to become a zombie?"};
		rJokes = rTemp;
		
		String[] rTempAns = {"Life Savers!", "The Dead Sea!", "Deadication!"};
		rJokesAnswers = rTempAns;
		
		goodbyeWord = "bye";
		secretWord = "grains";
		kkJoke = true;
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
		if(ZombieBotMain.findKeyword(response, secretWord, 0))
		{
			
		}
		else 
		{
			ZombieBotMain.print("Urrh... You want to... erh... hear a joke?");
		}
		chatting = true;
		while(chatting)
		{
			if(Math.random() > 0.5)
			{
				kkJoke = true;
			}
			else 
			{
				kkJoke = false;
			}
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
			else if(kkJoke)
			{
				double currentJokeIndex = Math.floor(Math.random()*kkJokes.length);
				ZombieBotMain.print("...Knock knock errh!");
				if(response.toLowerCase() == "who's there?" || response.toLowerCase() == "whos there?")
				{
					ZombieBotMain.print(kkJokes[(int) currentJokeIndex]);
					if(response.toLowerCase() == kkJokesAnswers[(int) currentJokeIndex] + " who?")
					{
						ZombieBotMain.print(kkJokesAnswers[(int) currentJokeIndex]);
					}
				}
				else
				{
					ZombieBotMain.print("Errrh! You ruin thurrh joke!");
				}	
			}
			else if(!kkJoke)
			{
				
			}
			else
			{
				ZombieBotMain.print("Huh. I don't really get you. Tell me something else?");
			}
			
		}
	}
}
