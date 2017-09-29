package zombieProgram;

public class ZombieBot {

	private String userName;
	private Topic zombieFood;
	private Topic pastLife;
	private Topic smallTalk;
	private Topic zombieJokes;
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

	public void startTalking() {

		ZombieBotMain.print("Welcome to our chatBot! What is your name?");
		userName = ZombieBotMain.getInput();

		chatting = true;
		while(chatting)
		{
			ZombieBotMain.print("What do you want to talk about?");
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

}
