package zombieProgram;

public class ZombieBot {

	private String userName;
	private ZombieBotJustinY zombieFood;
	private ZombieBotZhehao pastLife;
	private ZombieBotCoby smallTalk;
	private ZombieBotSunny zombieJokes;
	private boolean chatting;
	
	public ZombieBot()
	{
		zombieFood = new ZombieBotJustinY();
		pastLife = new ZombieBotZhehao();
		smallTalk = new ZombieBotCoby();
		zombieJokes = new ZombieBotSunny();
		userName = "unknownUser";
		chatting = true;
	}
	
	public ZombieBotJustinY getFavorite()
	{
		//ZombieBotMain.chatbot.getFavorite().getFavoriteFood() returns what the user inputed in my class as his/her favorite food
		return zombieFood;
	}
	
	public ZombieBotSunny getPreviousJoke()
	{
		return zombieJokes;
	}
	
	public ZombieBotZhehao getChatted()
	{
		return pastLife;
	}

	public void startTalking() {

		ZombieBotMain.print("Hellur! I ar Carl.. you?");
		userName = ZombieBotMain.getInput();

		chatting = true;
		while(chatting)
		{
			ZombieBotMain.print("Zer.. Wha yu want?");
			String response = ZombieBotMain.getInput();
			if(zombieFood.isTriggered(response))
			{
				chatting = false;
				zombieFood.startChatting(response);
			}
			else if(pastLife.isTriggered(response))
			{
				chatting = false;
				pastLife.startChatting(response);
			}
			else if(smallTalk.isTriggered(response))
			{
				chatting = false;
				smallTalk.startChatting(response);
			}
			else if(zombieJokes.isTriggered(response))
			{
				chatting = false;
				zombieJokes.startChatting(response);
			}
			else
			{
				ZombieBotMain.print("Urr? Derr? No understurr. Try ager.");
			}
		}
	}
	
	public String getUsername()
	{
		return userName;
	}
	
	/**
	 * Function returns whether or not the user's input triggers another topic. 
	 * @param response - User's input to what the bot said.  
	 * @param trigger - Number between 1-4 corresponding to the topics defined above.  
	 * @return - A boolean, whether or not the topic (trigger) relates to the response. 
	 */
	public boolean differentTalkTrigger(String response, int trigger)
	{
		if(trigger == 1)
		{
			return zombieFood.isTriggered(response);
		}
		else if(trigger == 2)
		{
			return pastLife.isTriggered(response);
		}
		else if(trigger == 3)
		{
			return smallTalk.isTriggered(response);
		}
		else if(trigger == 4)
		{
			return zombieJokes.isTriggered(response);
		}
		return false;
	}
	
	/** 
	 * Function allows other classes to call this function and access a different topic
	 * @param response - User input to a previous query 
	 * @param topicNum - Number between 1-4 corresponding to the topics defined above.  
	 */
	public void switchTopic(String response, int topicNum)
	{
		if(topicNum == 1)
		{
			zombieFood.startChatting(response);
		}
		else if(topicNum == 2)
		{
			pastLife.startChatting(response);
		}
		else if(topicNum == 3)
		{
			smallTalk.startChatting(response);
		}
		else if(topicNum == 4)
		{
			zombieJokes.startChatting(response);
		}
	}
	
}
