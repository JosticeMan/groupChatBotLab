package zombieProgram;

public class ZombieBot {

	private String userName;
	private Topic justin;
	private boolean chatting;
	
	public ZombieBot()
	{
		justin = new ZombieBotJustinY();
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
			if(justin.isTriggered(response))
			{
				chatting = false;
				justin.startChatting(response);
			}
			else
			{
				ZombieBotMain.print("I'm sorry, I don't understand");
			}
		}
		
	}

}
