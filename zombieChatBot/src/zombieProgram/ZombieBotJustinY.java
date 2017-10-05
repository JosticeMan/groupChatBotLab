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
	private String[] gameWelcome;
	private String[] gameQuestions;
	private String[][] gameAnswers;
	private String[] gameExit;
	private int gameScore;
	private int retries;
	private int questionNum;
	private boolean gamePlayed;
	
	private boolean switchTopic;
	private String[] switchTrigger;
	
	private boolean chatting;
	private boolean gaming;
	
	private String sunnyPH;
	private boolean sunnyQuestion;
	private boolean sunnyAsked;
	private String[] sunnyATrigger;
	private String[] sunnyNTrigger;
	
	private boolean zheHaoPH;
	
	public ZombieBotJustinY() {
		
		String[] temp = {"Brains", "Food", "Comida"};
		keywords = temp;
		
		String[] byeTemp = {"Bye", "Farewell", "Adios", "Cya", "Ciao", "Goodbye"};
		goodbyeWords = byeTemp; 
		String[] byePhraseTemp = {"BRAINZZ!", "Byezz", "See ya agur!", "Brin Brainzz nex time!"};
		goodbyePhrases = byePhraseTemp;
		
		favoriteWord = "Brain";
		String[] favoriteTemp = {"BRAINNZ! Le me eat yo brainz!! I WAN BRAINZZ!!!", "I very liek you! BRAINZZ!"};
		favoritePhrases = favoriteTemp;
		
		String[] ftriggerTemp = {"like", "prefer", "choose"};
		fquestionTriggers = ftriggerTemp;
		
		preferenceAnswer = "Onlyeh Brainz!";
		String[] nftriggerTemp = {"no like", "no prefer", "not choose", "not like", "no prefer", "not choose", "don't you like", "don't like"};
		nfquestionTriggers = nftriggerTemp;
		String[] negTemp = {"I no like everryythin but BRAINZ! Maybeh other orgaunz aswell.", "Hmm no liek this and this and tha. I luv brainz!"};
		negPreferenceAnswer = negTemp;
		
		String[] questionTemp = {"Yer wan talk abou zomthing else?", "Wha foo do yoou like?", "Yoou likee brainz too!?", "Is yo brainz ugh fressh?"};
		randomQuestions = questionTemp;
	
		String[] freshTemp = {"yes", "no", "maybe", "it is", "it isn't"};
		freshTrigger = freshTemp;
		freshQuestion = false;
		
		String[] brainTemp = {"no", "yes", "I do", "I don't", "maybe", "Aye", "Ew", "Brain", "No Brain"};
		brainTrigger = brainTemp;
		likeBrainz = false;
		
		String[] favTemp = {"nothing", "everything"};
		favoriteTrigger = favTemp;
		favoriteQuestion = false;
		
		String[] proTemp = {"you", "him", "her", "me", "myself"};
		pronouns = proTemp;
		
		String[] favoriteTriggerTemp = {"I like", "I prefer", "I love", "I desire", "I want"};
		favoriteFoodTrigger = favoriteTriggerTemp;
		
		String[] gametTemp = {"I want to play a game", "play game", "game", "entertainment", "trivia", "quiz", "play"};
		gameTrigger = gametTemp;
		String[] exitTemp = {"no", "I don't", "nope", "na", "stop", "leave", "exit", "I'm good"};
		gameExit = exitTemp;
		String[] gQuestTemp = {"Wha is squishy, pink, and loook like clump of intestines!?", "Wha e airy and yu have 2 of!?", "What e red and shape like heart?"};
		gameQuestions = gQuestTemp;
		String[][] gAnswerTemp = {{"BRAIN", "BRAINS", "BRAINZ", "BRAINZZ", "BRAINZZZ"}, {"LUNG", "LUNGS", "LUNGZ", "LUNGZZ", "LUNGZZ"}, {"HEART", "HEARTS", "HEARTZ", "HEARTZZ", "HEARTZZZ"}};
		gameAnswers = gAnswerTemp;
		gamePlayed = false;
		
		String[] switchTemp = {"Okay", "Sure", "Yes", "Ya", "Please do", "I want to"};
		switchTrigger = switchTemp;
		
		String[] sATemp = {"Yes", "I did", "I do", "Ye", "I loved it", "I liked it"};
		sunnyATrigger = sATemp;
		String[] sNTemp = {"No", "I hated it", "Na", "I didn't", "I did not like it", "maybe", "I didn't understand", "I don't know"};
		sunnyNTrigger = sNTemp;
		
		
		angryMeter = 0;
		String[] textTemp = {"Why yo say sam thing!? I doon't like!", "Raghh...  dis makes me angry!", "No want tooo taallk! Me pretende neve met you!"};
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
	
	public String getFavoriteFood()
	{
		return userFavoriteFood;
	}
	
	public void handleWelcome(String response)
	{
		if(ZombieBotMain.findKeyword(response, "Comida", 0) >= 0)
		{
			ZombieBotMain.print("Argh! No gusta spanish! Gustarrgh food!");
		}
		else if(response.equalsIgnoreCase("cameFromGame"))
		{
			ZombieBotMain.print("Gooood game! " + userName + ", bac talk abou food now!");
		}
		else if(response.equalsIgnoreCase("leftGame"))
		{
			ZombieBotMain.print("You no fun! Arghh! Talk foo again! LIKE BRAINZ OR NO BRAINZ?");
			likeBrainz = true;
		}
		else
		{
			ZombieBotMain.print("Yearr! Yo want talk about foo! Onleh onee thing is on my minde. ");
		}
	}
	
	public void angryOrNo(String response)
	{
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
	}
	
	public void handleQuestion(int rando)
	{
		if(rando == 0)
		{
			switchTopic = true;
		}
		else if(rando == 1)
		{
			favoriteQuestion = true;
		}
		else if(rando == 2)
		{
			likeBrainz = true;
		}
		else if(rando == 3)
		{
			freshQuestion = true;
		}
	}
	
	public void processFavorite(String response)
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
			String[] fOTemp = {"I no like yooou like " + userFavoriteFood + "! ONlYBRAINZ!", "Aghhh mind hurts! Only want BRAINZ! No " + userFavoriteFood + ".", userFavoriteFood + "!?? Hao irritatting!"};
			if(userFavoriteFood == "")
			{
				ZombieBotMain.print("Arghuh?");
			}
			else 
			{
				ZombieBotMain.randomText(fOTemp);
			}
		}
		if(sunnyPH != "" && Math.random() < .50 && !sunnyAsked)
		{
			ZombieBotMain.print("Ar! Liked my " + sunnyPH + " joke?");
			sunnyQuestion = true;
			sunnyAsked = true;
		}
	}
	
	public void startChatting(String response) {
		
		angryMeter = 0;
		userName = ZombieBotMain.chatbot.getUsername();
		String[] ftemp = {userName + ", are youuu sure you like?", "Ahhah! " + userName + " like othe peeps! I onleh liek thez brainz!"};
		fPhrase = ftemp;
		switchTopic = false;
		sunnyQuestion = false;
		sunnyAsked = false;
		sunnyPH = ZombieBotMain.chatbot.getPreviousJoke().getJoke();
		
		handleWelcome(response);
		
		chatting = true;
		while(chatting)
		{
			response = ZombieBotMain.getInput();
			angryOrNo(response);
			
			if(angryMeter > 0)
			{
				ZombieBotMain.print(annoyedText[angryMeter - 1]);
				if(angryMeter == 3)
				{
					chatting = false;
					ZombieBotMain.chatbot.startTalking();
				}
			}
			else if(response.equalsIgnoreCase(""))
			{
				ZombieBotMain.print("Suy somethang I am givin up on you!");
			}
			else if(ZombieBotMain.containsString(response, gameTrigger) != "")
			{
				if(gamePlayed)
				{
					ZombieBotMain.print("Yo already playz the game! Talk food!");
				}
				else
				{
					chatting = false;
					startGaming(ZombieBotMain.containsString(response, gameTrigger));
				}
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
			else if(sunnyQuestion)
			{
				sunnyQuestion = false;
				String elResponse = ZombieBotMain.containsString(response, sunnyATrigger);
				String elResponse1 = ZombieBotMain.containsString(response, sunnyNTrigger);
				if(elResponse1 != "")
				{
					ZombieBotMain.print("Awaar! Me no funn!?");
				}
				else if(elResponse != "")
				{
					ZombieBotMain.print("Yaar! I like buing funneh!");
				}
				else 
				{
					ZombieBotMain.print("Augugu? No understand. Yo like joke or no?");
					sunnyQuestion = true;
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
				if(elResponse.equalsIgnoreCase("yes") || elResponse.equalsIgnoreCase("it is"))
				{
					ZombieBotMain.print("Oohoho! Temppting to eat " + userName + ".");
				}
				else if(elResponse.equalsIgnoreCase("no") || elResponse.equalsIgnoreCase("it isn't"))
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
				if(elResponse.equalsIgnoreCase("yes") || elResponse.equalsIgnoreCase("I do") || elResponse.equalsIgnoreCase("Brain"))
				{
					ZombieBotMain.print("Alas! I foun anooother buing tha like BRAINZ! I loove you, " + userName);
				}
				else if(elResponse.equalsIgnoreCase("maybe"))
				{
					ZombieBotMain.print("Yooou! Mee no happy!");
				}
				else if(elResponse.equalsIgnoreCase("I don't") || elResponse.equalsIgnoreCase("no") || elResponse.equalsIgnoreCase("No Brain"))
				{
					ZombieBotMain.print("Cme her! I eatt you!");
				}
				else
				{
					ZombieBotMain.print("Arguhh? Whatch saay? LIKE BRAINZ OR NO BRAINZ!?");
					likeBrainz = true;
				}
			}
			else if(ZombieBotMain.containsString(response, favoriteFoodTrigger) != "" && ZombieBotMain.wordAfter(response, ZombieBotMain.containsString(response, favoriteFoodTrigger)) != "")
			{
				processFavorite(response);
			}
			else if(ZombieBotMain.containsString(response, nfquestionTriggers) != "")
			{
				ZombieBotMain.randomText(negPreferenceAnswer);
			}
			else if(ZombieBotMain.containsString(response, fquestionTriggers) != "")
			{
				if(userFavoriteFood != "" && userFavoriteFood != null)
				{
					String[] rTemp = {"I know " + userName + " likes " + userFavoriteFood + " but I ONLEY APPROV BRAINZ!!", preferenceAnswer};
					ZombieBotMain.randomText(rTemp);
				}
				else
				{
					ZombieBotMain.print(preferenceAnswer);
				}
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
			else if(switchTopic)
			{
				if(ZombieBotMain.containsString(response, switchTrigger) != "")
				{
					chatting = false;
					ZombieBotMain.chatbot.switchTopic("justin", (((int) (Math.random() * 4 - 2)) + 2));
				}
				else
				{
					ZombieBotMain.print("Auright! Continuez foo talk!");
				}
			}
			else if(Math.random() < 0.75)
			{
				int rando = (int) (Math.random() * randomQuestions.length);
				handleQuestion(rando);
				ZombieBotMain.print(randomQuestions[rando]);
			}
			else
			{
				ZombieBotMain.print("Arguhh? Whatch saay?");
			}
		}
			
	}
		
	public void startGaming(String response)
	{
		angryMeter = 0;
		gamePlayed = true;
		gaming = true;
		gameScore = 0;
		questionNum = -1;
		String[] welcomeTemp = {"UGHAL! Welcomez " + userName + " to a little foo game! Yo wan play?", "Let's plaay foo trivia!"};
		gameWelcome = welcomeTemp;
		retries = 0;
		zheHaoPH = ZombieBotMain.chatbot.getChatted().haschatted();
		if(zheHaoPH)
		{
			String[] gQuestTemp1 = {"Wha is squishy, pink, and loook like clump of intestines!?", "Wha e airy and yu have 2 of!?", "What e red and shape like heart?", "Wha was my role in mah past life?"};
			gameQuestions = gQuestTemp1;
			String[][] gAnswerTemp1 = {{"BRAIN", "BRAINS", "BRAINZ", "BRAINZZ", "BRAINZZZ"}, {"LUNG", "LUNGS", "LUNGZ", "LUNGZZ", "LUNGZZ"}, {"HEART", "HEARTS", "HEARTZ", "HEARTZZ", "HEARTZZZ"}, {"Dancing", "Dance", "Dancinz"}};
			gameAnswers = gAnswerTemp1;
		}
		
		if(response == "entertainment")
		{
			ZombieBotMain.print("You wan entertainment? Here's enterrrtaunment!");
		}
		else 
		{
			ZombieBotMain.randomText(gameWelcome);
		}
		
		while(gaming)
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
					gaming = false;
					ZombieBotMain.chatbot.startTalking();
				}
			}
			else if(ZombieBotMain.containsString(response, gameExit) != "")
			{
				gaming = false;
				ZombieBotMain.print("Awwrgh! Fine I stoop the game! You haz " + gameScore + " points from Game!");
				startChatting("leftGame");
			}
			else if(ZombieBotMain.containsString(response, goodbyeWords) != "")
			{
				gaming = false;
				ZombieBotMain.randomText(goodbyePhrases);
				ZombieBotMain.chatbot.startTalking();
			}
			else if(questionNum != -1)
			{
				if(ZombieBotMain.containsString(response, gameAnswers[questionNum]) != "")
				{
					String[] winTemp = {"ARghuhhu! Correct! Ansu was " + gameAnswers[questionNum][0] + "Z!", "Ding dinng! Correctughh!", "Yo very goo at this! Riggh answer!"};
					ZombieBotMain.randomText(winTemp);
					questionNum++;
					gameScore++;
					if(questionNum == gameQuestions.length)
					{
						ZombieBotMain.print("Graat! You beat teh game! BRAAIN for you!");
						gaming = false;
						startChatting("cameFromGame");
					}
					else
					{
						ZombieBotMain.print(gameQuestions[questionNum]);
					}
				}
				else
				{
					if(retries == 3)
					{
						ZombieBotMain.print("Losseeer! No moar guesses! Yo had " + gameScore + " points!");
						gaming = false;
						startChatting("cameFromGame");
					}
					else
					{
						ZombieBotMain.print("Mistak! Tra again! " + gameQuestions[questionNum]);
						retries++;
					}
				}
			}
			else
			{
				questionNum = 0;
				ZombieBotMain.print(gameQuestions[questionNum]);
			}
		}
	}
}
	
	
