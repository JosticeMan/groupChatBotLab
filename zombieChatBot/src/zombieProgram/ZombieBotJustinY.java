package zombieProgram;

public class ZombieBotJustinY implements Topic {

	//This class is to be only changed by JUSTIN YAU
	//This section will manage the talks about food. 
	
	//Respond uniquely to last 2 random questions
	//Perhaps implement a food game?
	//AFTER: WORK WITH GROUP TO CONNECT MESSAGES SO IT ISN'T SO OBVIOUS THAT THE ZOMBIE PERSONALITY CHANGED WHEN TOPIC SWAPPED.
	
	private String[] keywords; 
	
	//Makes the bot get increasingly annoyed over the same consecutive responses. 
	private String previousResponse;
	private int angryMeter; 
	private String[] annoyedText;
	
	//private String userName;
	
	private String[] goodbyeWords;
	private String[] goodbyePhrases;
	
	private String[] fquestionTriggers;
	private String preferenceAnswer;
	private String[] nfquestionTriggers;
	private String[] negPreferenceAnswer;
	
	private String favoriteWord;
	private String[] favoritePhrases;
	
	private String[] randomQuestions;
	
	private String userName; 
	private String[] pronouns; 
	
	private String userFavoriteFood;
	private String[] favoriteFoodTrigger;
	private String[] fPhrase;
	
	private boolean freshQuestion;
	private String[] freshTrigger;
	
	private boolean likeBrainz;
	private String[] brainTrigger;
	
	private boolean favoriteQuestion;
	private String[] favoriteTrigger;
	
	private String[] gameTrigger;
	private String[] gameQuestions;
	private String[] gameAnswers;
	private String[] gameExit;
	
	private boolean chatting;
	private boolean gaming;
	
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
		
		String[] ftriggerTemp = {"like", "prefer", "choose"};
		fquestionTriggers = ftriggerTemp;
		
		preferenceAnswer = "Onlyeh Brainz!";
		String[] nftriggerTemp = {"no like", "no prefer", "not choose", "not like", "no prefer", "not choose"};
		nfquestionTriggers = nftriggerTemp;
		String[] negTemp = {"I no like everryythin but BRAINZ! Maybeh other orgaunz aswell.", "Hmm no liek this and this and tha. I luv brainz!"};
		negPreferenceAnswer = negTemp;
		
		String[] questionTemp = {"Yer wan talk abou zomthing else?", "Wha foo do yoou like?", "Yoou likee brainz too!?", "Is yo brainz ugh fressh?"};
		randomQuestions = questionTemp;
	
		String[] freshTemp = {"yes", "no", "maybe"};
		freshTrigger = freshTemp;
		freshQuestion = false;
		
		String[] brainTemp = {"no", "yes", "I do", "I don't", "maybe", "Aye", "Ew"};
		brainTrigger = brainTemp;
		likeBrainz = false;
		
		String[] favTemp = {"nothing", "everything"};
		favoriteTrigger = favTemp;
		favoriteQuestion = false;
		
		String[] proTemp = {"you", "him", "her", "me", "myself"};
		pronouns = proTemp;
		
		String[] favoriteTriggerTemp = {"I like", "I prefer", "I love", "I desire", "I want"};
		favoriteFoodTrigger = favoriteTriggerTemp;
		
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
		userName = ZombieBotMain.chatbot.getUsername();
		String[] ftemp = {userName + ", are youuu sure you like?", "Ahhah! " + userName + " like othe peeps! I onleh liek thez brainz!"};
		fPhrase = ftemp;
		
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
			else if(favoriteQuestion)
			{
				favoriteQuestion = false;
				String elResponse = ZombieBotMain.containsString(response, favoriteTrigger);
				if(elResponse.equalsIgnoreCase("nothing"))
				{
					ZombieBotMain.print("I vant you like BRAINZ!");
					userFavoriteFood = "nothing";
				}
				else if(elResponse.equalsIgnoreCase("everything"))
				{
					ZombieBotMain.print("Yaay! " + userName + " loove BRAINZ!");	
					userFavoriteFood = "everything";
				}
				else
				{
					ZombieBotMain.print(userName + " loke that!?? Outraggebous!");
					userFavoriteFood = response;
				}
			}
			else if(freshQuestion)
			{
				freshQuestion = false;
				String elResponse = ZombieBotMain.containsString(response, freshTrigger);
				if(elResponse.equalsIgnoreCase("yes"))
				{
					ZombieBotMain.print("Oohoho! Temppting to eat " + userName + ".");
				}
				else if(elResponse.equalsIgnoreCase("no"))
				{
					ZombieBotMain.print("Bleh! No wantt eat yo brainz!");
				}
				else if(elResponse.equalsIgnoreCase("maybe"))
				{
					ZombieBotMain.print("Shoul I hallp yoou find out!?");
				}
				else
				{
					ZombieBotMain.print("Arguhh? Whatcha sayy? You FRUSH BRAINZ OR NO?");
					freshQuestion = true;
				}
			}
			else if(likeBrainz)
			{
				likeBrainz = false;
				String elResponse = ZombieBotMain.containsString(response, brainTrigger);
				if(elResponse.equalsIgnoreCase("yes") || elResponse.equalsIgnoreCase("I do"))
				{
					ZombieBotMain.print("Alas! I foun anooother buing tha like BRAINZ! I loove you, " + userName);
				}
				else if(elResponse.equalsIgnoreCase("maybe"))
				{
					ZombieBotMain.print("Yooou! Mee no happy!");
				}
				else
				{
					if(elResponse.equalsIgnoreCase("I don't") || elResponse.equalsIgnoreCase("no"))
					{
						ZombieBotMain.print("Cme her! I eatt you!");
					}
					else
					{
						ZombieBotMain.print("Arguhh? Whatch saay? BRAINZ OR NO BRAINZ!?");
						likeBrainz = true;
					}
				}
			}
			else if(ZombieBotMain.containsString(response, favoriteFoodTrigger) != "")
			{
				String responsePronoun = ZombieBotMain.containsString(ZombieBotMain.wordAfter(response, ZombieBotMain.containsString(response, favoriteFoodTrigger)), pronouns);
				if(responsePronoun != "")
				{
					if(responsePronoun.equalsIgnoreCase("you"))
					{
						userFavoriteFood = "me";
						ZombieBotMain.print("Ughleo! I thin " + userName + " lov me!");
					}
					else if(responsePronoun.equalsIgnoreCase("me") || responsePronoun.equalsIgnoreCase("myself"))
					{
						userFavoriteFood = "themseulves";
						ZombieBotMain.print(fPhrase[0]);
					}
					else
					{
						ZombieBotMain.randomText(fPhrase);
						userFavoriteFood = "otherr poople";
					}
				}
				else
				{
					userFavoriteFood = ZombieBotMain.wordAfter(response, ZombieBotMain.containsString(response, favoriteFoodTrigger)); 
					if(userFavoriteFood == "")
					{
						ZombieBotMain.print("Arghuh?");
					}
					else if(Math.random()  < .50)
					{
						ZombieBotMain.print("I no like yooou like " + userFavoriteFood + "! ONlYBRAINZ!");
					}
					else
					{
						ZombieBotMain.print("Aghhh mind hurts! Only want BRAINZ! No " + userFavoriteFood + ".");
					}
				}
			}
			else if(ZombieBotMain.containsString(response, fquestionTriggers) != "")
			{
				if(userFavoriteFood != "" && userFavoriteFood != null)
				{
					if(Math.random() < .50)
					{
						ZombieBotMain.print("I know " + userName + " likes " + userFavoriteFood + " but I ONLEY APPROV BRAINZ!!");
					}
					else
					{
						ZombieBotMain.print(preferenceAnswer);
					}
				}
				else
				{
					ZombieBotMain.print(preferenceAnswer);
				}
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
			else if(Math.random() < 0.75)
			{
				int rando = (int) (Math.random() * randomQuestions.length);
				if(rando == 2)
				{
					likeBrainz = true;
				}
				else if(rando == 3)
				{
					freshQuestion = true;
				}
				else if(rando == 1)
				{
					favoriteQuestion = true;
				}
				ZombieBotMain.print(randomQuestions[rando]);
			}
			else
			{
				ZombieBotMain.print("Arguhh? Whatch saay?");
			}
		}
			
	}
		
	public void startGaming()
	{
		gaming = true;
		while(gaming)
		{
			
		}
	}
}
	
	
