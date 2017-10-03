package zombieProgram;

public class ZombieBotJustinY implements Topic {

	//This class is to be only changed by JUSTIN YAU
	//This section will manage the talks about food. 
	
	//SAVE USER FAVORITE FOOD AND REFERENCE LATER ON
	//Respond uniquely to last 2 random questions
	//Perhaps implement a food game?
	//AFTER: WORK WITH GROUP TO CONNECT MESSAGES SO IT ISN'T SO OBVIOUS THAT THE ZOMBIE PERSONALITY CHANGED WHEN TOPIC SWAPPED.
	
	private String[] keywords; 
	
	//Makes the bot get increasingly annoyed over the same consecutive responses. 
	private String previousResponse;
	private int angryMeter; 
	private String[] annoyedText;
	
	//private String userName;
	private int emotionalMeter; 
	
	private String[] goodbyeWords;
	private String[] goodbyePhrases;
	
	private String[] fquestionTriggers;
	private String preferenceAnswer;
	private String[] nfquestionTriggers;
	private String[] negPreferenceAnswer;
	
	private String favoriteWord;
	private String[] favoritePhrases;
	
	private String[] randomQuestions;
	
	private boolean chatting;
	
	public ZombieBotJustinY() {
		
		String[] temp = {"Brains", "Food", "Comida"};
		keywords = temp;
		
		String[] byeTemp = {"Bye", "Farewell", "Adios", "Cya", "Ciao"};
		goodbyeWords = byeTemp; 
		String[] byePhraseTemp = {"BRAINZZ!", "Byezz", "See ya agur!", "Brin Brainzz nex time!"};
		goodbyePhrases = byePhraseTemp;
		
		favoriteWord = "Brain";
		String[] favoriteTemp = {"BRAINNZ! Le me eat yo brainz!! I WAN BRAINZZ!!!", "I very liek you! BRAINZZ!"};
		favoritePhrases = favoriteTemp;
		
		String[] ftriggerTemp = {"like?", "prefer?", "choose?"};
		fquestionTriggers = ftriggerTemp;
		preferenceAnswer = "Onlyeh Brainz!";
		String[] nftriggerTemp = {"no like?", "no prefer?", "not choose?", "not like?", "no prefer?", "not choose?"};
		nfquestionTriggers = nftriggerTemp;
		String[] negTemp = {"I no like everryythin but BRAINZ! Maybeh other orgaunz aswell.", "Hmm no liek this and this and tha. I luv brainz!"};
		negPreferenceAnswer = negTemp;
		
		String[] questionTemp = {"Yer wan talk abou zomthing else?", "Wha do yoou like food?", "Yoou likee brainz too!?", "How fressh ugh yo brainz?"};
		randomQuestions = questionTemp;
		
		angryMeter = 0;
		previousResponse = "";
		String[] textTemp = {"Why yo say sam thing!? I doon't like!", "Raghh...  dis makes me angry!", "No want tooo taallk!"};
		annoyedText = textTemp;
		
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
	
	public void startChatting(String response) {
		
		angryMeter = 0;
		
		if(ZombieBotMain.findKeyword(response, "Comida", 0) >= 0)
		{
			ZombieBotMain.print("Argh! No gusta spanish! Gustarrgh food!");
		}
		else
		{
			ZombieBotMain.print("Yearr! Yo want talk about foo! Onleh onee thing is on my minde. ");
		}
		
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			if(response.equalsIgnoreCase(previousResponse))
			{
				angryMeter++;
				previousResponse = response;
			}
			else
			{
				angryMeter = 0;
				previousResponse = response;
			}
			
			if(angryMeter > 0)
			{
				ZombieBotMain.print(annoyedText[angryMeter - 1]);
				if(angryMeter == 3)
				{
					chatting = false;
					ZombieBotMain.chatbot.startTalking();
				}
			}
			else if(ZombieBotMain.containsString(response, fquestionTriggers) != "")
			{
				ZombieBotMain.print(preferenceAnswer);
			}
			else if(ZombieBotMain.containsString(response, nfquestionTriggers) != "")
			{
				ZombieBotMain.randomText(negPreferenceAnswer);
			}
			else if(ZombieBotMain.containsString(response, goodbyeWords) != "")
			{
				ZombieBotMain.randomText(goodbyePhrases);
				chatting = false;
				ZombieBotMain.chatbot.startTalking();
			}
			else if(ZombieBotMain.findKeyword(response, favoriteWord, 0) >= 0)
			{
				ZombieBotMain.randomText(favoritePhrases);
			}
			else if(ZombieBotMain.chatbot.differentTalkTrigger(response, 2))
			{
				chatting = false;
				ZombieBotMain.chatbot.switchTopic(response, 2);
			}
			else if(ZombieBotMain.chatbot.differentTalkTrigger(response, 3))
			{
				chatting = false;
				ZombieBotMain.chatbot.switchTopic(response, 3);
			}
			else if(ZombieBotMain.chatbot.differentTalkTrigger(response, 4))
			{
				chatting = false;
				ZombieBotMain.chatbot.switchTopic(response, 4);
			}
			else if(Math.random() > .24)
			{
				ZombieBotMain.randomText(randomQuestions);
			}
			else
			{
				ZombieBotMain.print("Arguhh? Whatch saay?");
			}
		}
			
	}
		
}
	
	
