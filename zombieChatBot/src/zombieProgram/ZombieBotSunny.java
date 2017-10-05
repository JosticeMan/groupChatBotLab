package zombieProgram;

public class ZombieBotSunny implements Topic {
	
	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private String[] Jokes;
	private String[] JokesAnswers;
	private String[] possibleResponses;
	
	private String[] kkJokes;
	private String[] kkJokesAnswers;
	private String[] possiblekkResponses;
	
	private String linkJoke = "";
	private boolean chatting;
	private int patience;
	
	public ZombieBotSunny()
	{
		String[] temp = {"joke", "jokes", "funny", "puns"};
		keywords = temp;
		
		String[] rTemp = {"What kind of candy do zombies refuse to eat?", "Where do zombies go swimming?", "What does it take to become a zombie?"};
		Jokes = rTemp;
		
		String[] rTempAns = {"Life Savers!", "The Dead Sea!", "Deadication!"};
		JokesAnswers = rTempAns;
		
		String[] tempResp = {"what?", "what", "where", "where?"};
		possibleResponses = tempResp;
		
		String[] kkTemp = {"orange", "zombie"};
		kkJokes = kkTemp;
		
		String[] kkTempAns = {"Orange you glad I didn't say zombie?", "ZomBEE queen here to eat you!"};
		kkJokesAnswers = kkTempAns;
		
		String[] kkTempResp = {"who's there", "whos there", "who's there?", "whos there?"};
		possiblekkResponses = kkTempResp;
		
		patience = 5;
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
	
	public String getJoke()
	{
		return linkJoke;
	}
	public void tellJoke(int stage, String userInput, int randomNum)
	{
		boolean possibilities = (ZombieBotMain.containsString(userInput, possibleResponses) != "");
		if(stage == 0)
		{
			ZombieBotMain.print(Jokes[randomNum]);
		}
		else if(stage == 1 && possibilities)
		{
			ZombieBotMain.print(JokesAnswers[randomNum]);
			linkJoke = JokesAnswers[randomNum];
		}
		else if(!possibilities && stage == 1)
		{
			if(patience == 5)
			{
				ZombieBotMain.print("Urrrrh! You ruined thurr joke!");
			}
			if(patience == 4)
			{
				ZombieBotMain.print("Stop ruining my joke! Urrrrh!");
			}
			if(patience == 3)
			{
				ZombieBotMain.print("Stop it... Urrrhh... I will eat your braaaaains!");
			}
			if(patience == 2)
			{
				ZombieBotMain.print("You are... killing me... again urrhhh!");
			}
			if(patience == 1)
			{
				ZombieBotMain.print("URRRHH! That's it! No more jokes! I'm going to uurrrhhh... pretend I nevuuurh... met you!");
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
			patience -= 1;
		}
	}
	 
	public void tellkkJoke(int stage, String userInput, int randomNum)
	{
		boolean possibilities = (ZombieBotMain.containsString(userInput, possiblekkResponses) != "");
		if(stage == 0)
		{
			ZombieBotMain.print("Urrrh... Knock knock!");
		}
		if(stage == 1 && possibilities)
		{
			ZombieBotMain.print(kkJokes[randomNum]);
		}
		if(stage == 1 && !possibilities)
		{
			if(patience == 5)
			{
				ZombieBotMain.print("Urrrrh! You ruined thurr joke!");
			}
			if(patience == 4)
			{
				ZombieBotMain.print("Stop ruining my joke! Urrrrh!");
			}
			if(patience == 3)
			{
				ZombieBotMain.print("Stop it... Urrrhh... I will eat your braaaaains!");
			}
			if(patience == 2)
			{
				ZombieBotMain.print("You are... killing me... again urrhhh!");
			}
			if(patience == 1)
			{
				ZombieBotMain.print("URRRHH! That's it! No more jokes! I'm going to uurrrhhh... pretend I nevuuurh... met you!");
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
			patience -= 1;	
		}
		if(stage == 2 && (userInput.equalsIgnoreCase(kkJokes[randomNum] + "who?") || userInput.equalsIgnoreCase(kkJokes[randomNum] + "who")))
		{
			
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
		int randomInt = (int) (Math.random()*Jokes.length);
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
			else if(response.equalsIgnoreCase("ok") || response.equalsIgnoreCase("okay") || response.equalsIgnoreCase("no") || response.equalsIgnoreCase("sure") || response.equalsIgnoreCase("go"))
			{
				if(response.equalsIgnoreCase("no"))
				{
					ZombieBotMain.print("Urrh too bad!");
				}
				tellJoke(stageNum, response, randomInt);
				stageNum += 1;
				if(stageNum == 2)
				{
					stageNum = 0;
					randomInt = (int) (Math.random()*Jokes.length);
				}
			}
			else
			{
				ZombieBotMain.print("Huh. I don't really get you. Tell me something else?");
			}
		}
	}
}