package rpg;
import java.util.Scanner;

public class GameLoop {
	private static Scanner scanner = new Scanner(System.in);
	
	static Player player;
	
	private static boolean isRunning;
	
	private static String[] encounters = {"Combat", "Combat", "Combat", "Repos", "Repos"};
	
	private static String[] enemies = {"Ogre", "Ogre", "demon", "demon", "sorcier malefique"};
	
	private static int place = 0, act = 1;
	private static String[] places = {"cité d'Anor lando","montagne enneigé", "academie aria lucaria", "forêt sombre", "le chateau", "la salle du trône"};
	
	public static int readInt(String prompt, int userChoices) {
		int input;
		
		do {
			System.out.println(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			}catch(Exception e) {
				input = -1;
				System.out.println("entrez un nombre");
			}
		}while(input < 1 || input > userChoices);
		return input;
	}
	public static void clearConsole() {
		for(int i = 0; i < 100; i++) 
			System.out.println();
	}
	public static void printSeparator(int n) {
		for(int i = 0; i < n; i++) 
			System.out.print("-");
		System.out.println();
	}
	public static void printHeading(String title) {
		printSeparator(30);
		System.out.println(title);
		printSeparator(30);
		
	}
	
	public static void toContinue() {
		System.out.println("\ntaper \"commencer\" pour continuer...");
		scanner.next();
	}
	
	public static void startGame() {
		boolean nameSet = false;
		String name;
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("AGE OF DARKNESS");
		System.out.println("TEXT RPG BY YAMIL ISSA");
		printSeparator(30);
		printSeparator(40);
		toContinue();
		
		do {
			clearConsole();
			printHeading("entrez votre nom: ");
			name = scanner.next();
			clearConsole();
			printHeading("vous vous nommez" + " " + name + " " + ".\nc'est bien ça ?");
			System.out.println("(1) Oui!");
			System.out.println("(2) Non je veux modifier mon nom");
			int input = readInt("-> ", 2);
			if(input ==1) {
				nameSet = true;
			}
		}while(!nameSet);
		
		Story.printIntro();
		
		player = new Player(name);
		
		Story.printFirstActIntro();
		//isRunning
		isRunning = true;
		
		//start main game loop
		gameLoop();
	}
	
	public static void checkAct() {
		if(player.getCharacterXp() >= 10 && act == 1 ) {
			act = 2;
			place = 1;
			Story.printFirstActOutro();
			
			player.chooseTrait();
			
			Story.printSecondActIntro();
			enemies[0] = "Mercenaire";
			enemies[1] = "Goblin";
			enemies[2] = "loups";
			enemies[3] = "commandant de l'armée du nameless Kig";
			enemies[4] = "mysterieux etranger";
			
			encounters[0] = "Combat";
		    encounters[1] = "Combat";
		    encounters[2] = "Combat";
		    encounters[3] = "Repos";
		    encounters[4] = "Magasin";
			
		}else if(player.getCharacterXp() >= 50 && act ==2 ) {
			act = 3;
			place = 2;
			Story.printSecondActOutro();
			
			player.chooseTrait();
			
			Story.printThirdActIntro();
			
			enemies[0] = "Mercenaire";
			enemies[1] = "Mercenaire";
			enemies[2] = "commandant de l'armée du nameless Kig";
			enemies[3] = "commandant de l'armée du nameless Kig";
			enemies[4] = "commandant de l'armée du nameless Kig";
			
			encounters[0] = "Combat";
		    encounters[1] = "Combat";
		    encounters[2] = "Combat";
		    encounters[3] = "Repos";
		    encounters[4] = "Magasin";
		    player.setCharacterHp(player.getCharacterMaxHp());
			
		}else if(player.getCharacterXp() >= 100 && act == 3) {
			act = 4;
			place = 2;
			Story.printThirdActOutro();
			
			player.chooseTrait();
			
			Story.printFourthActIntro();
			
		    player.setCharacterHp(player.getCharacterMaxHp());
			
		}
	}
	
	public static void randomEncounter() {
		int encounter = (int)(Math.random()* encounters.length);
		if(encounters[encounter].equals("Combat")){
			randomBattle();
			
		}else if(encounters[encounter].equals("Repos")){
			//repos
			
		}else {
			//shop
		}
	}
	public static void continueJourney() {
		checkAct();
		
		if(act != 4) {
			randomEncounter();
		}
		
	}
	
	public static void characterInfo() {
		clearConsole();
		printHeading("INFO PERSONNAGE");
		System.out.println(player.name + "\tHP: " + player.getCharacterHp() + "/" + player.getCharacterMaxHp());
		printSeparator(20);
		System.out.println("XP: " + player.getCharacterXp() + "\tGold:" + player.getGold());
		printSeparator(20);
		
		System.out.println("# de potions:" + " " + player.getPots());
		printSeparator(20);
		
		if(player.getNumAttackUpgrades() > 0) {
			System.out.println("capacités offensive " + player.getAttackUpgrades()[player.getNumAttackUpgrades() -1]);
			printSeparator(20);
		}
		if(player.getNumDefUpgrades() > 0) {
			System.out.println("capacités deffensive " + player.getDefUpgrades()[player.getNumDefUpgrades() - 1]);
		}
		toContinue();
	}
	
	public static void shop() {
		clearConsole();
		printHeading("vous rencontrez un mysterieux marchand");
		int price = (int) (Math.random()* (10 + player.getPots() * 3) + 10 + player.getPots());
		System.out.println("- Potion: " + " " + price + " " + "pièces d'or");
		printSeparator(20);
		
		System.out.println("Voulez-vous acheter une potion ?\n(1) Oui\n(2) Non.");
		int input = readInt("-> ", 2);
		
		if(input == 1) {
			clearConsole();
			if(player.getGold() >= price) {
				printHeading("Vous avez acheté la potion pour" + " " + price + " " + "pièces d'or" );
				player.setPots();
				player.buy(price);
			}else {
				printHeading("Vous n'avez pas assez de pièces d'or");
				toContinue();
			}
		}
	}
	
	public static void takeRet() {
		clearConsole();
		if(player.getRestsLeft() >= 1) {
			printHeading("voulez-vous vous reposer ? (" + player.getRestsLeft() + " " + "repos disponible).");
			System.out.println("(1) Oui\n(2) Non, pas maintenant");
			int input = readInt("-> ", 2);
			if(input == 1) {
				clearConsole();
				if(player.getCharacterHp() < player.getCharacterMaxHp()) {
					int hpRestored = (int) (Math.random() * (player.getCharacterXp()/4 + 1) + 10);
					player.restoreHp(hpRestored);
					if(player.getCharacterHp() > player.getCharacterMaxHp()){
						player.setCharacterHp(player.getCharacterMaxHp());
					} 
					System.out.println("vous vous etes reposer, vous avez restauré" + " " + hpRestored + "points de vie");
					System.out.println("Vous avez actuellement" + " " + player.getCharacterHp() + "/" + player.getCharacterMaxHp() + "points de vie");
					player.useRests();
					
				}
				
			}else {
				System.out.println("Vos points de vie sont dejà au maximum");
				toContinue();
				
			}
		}
	}
	
	public static void randomBattle() {
		clearConsole();
		printHeading("vous croisez un ennemie");
		toContinue();
		battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.getCharacterXp()));
	}
	public static void battle(Enemy enemy) {
		while(true) {
			clearConsole();
			printHeading(enemy.getCharacterName() + "\nHP: " + enemy.getCharacterHp() + "/" + enemy.getCharacterMaxHp());
			printHeading(player.getCharacterName() + "\nHP: " + player.getCharacterHp() + "/" + player.getCharacterMaxHp());
			System.out.println("choisissez une action: ");
			printSeparator(20);
			System.out.println("(1) Combattre\n(2) utliser une potion\n(3) Fuir");
			int input = readInt("-> ", 3);
			
			if(input == 1) {
				//FIGHT
				int damage = player.attack() - enemy.defend();
				int damageTook = enemy.attack() - player.defend();
				
				if(damageTook < 0) {
					damage -= damageTook/2;
					damageTook = 0;
				}
				if(damage < 0) 
					damage = 0;
				player.getDamage(damageTook);
				enemy.getDamage(damage);
				clearConsole();
				printHeading("COMBAT");
				System.out.println("vous avez innfligé" + " " + damage + " " + " " + " points de dégât  à l'ennemie" + enemy.getCharacterName() + ".");
				printSeparator(15);
				System.out.println("L'ennemie" + " " + enemy.getCharacterName() + " " +  "vous infligé" + " " + damageTook + " " + "points de dégât");
				toContinue();
				if(player.getCharacterHp() <= 0) {
					playerDied();
					break;
				}else if(enemy.getCharacterHp() <=0) {
					clearConsole();
					printHeading("vous avez vaincu l'ennemie" + " "  + enemy.getCharacterName());
					player.gainXp(enemy.getCharacterXp());
					System.out.println("vous avez gagné" + " " + enemy.getCharacterXp() + " " + "points d'éxperience ");
					boolean addRest = (Math.random()*5 + 1 <= 2.25);
					int goldEarned = (int) (Math.random()*enemy.getCharacterXp());
					if(addRest) {
						player.setRestsLeft();
						System.out.println("Vous avez gagner une chance d'obtenir un repos supplementaire");
					}
					if(goldEarned > 0) {
						player.setGold(goldEarned);
						System.out.println("vous avez obtenu" + " " + goldEarned + " " + "pièces d'or");
					}
					toContinue();
					break;
				}
			}else if(input == 2) {
				clearConsole();
				if(player.getPots() > 0 && player.getCharacterHp() < player.getCharacterMaxHp()) {
					printHeading("Vous voulez boire une potion ? (" + player.getPots() + " restant).");
					System.out.println("(1) Oui\n(2) No, plus tard");
					input = readInt("-> ", 2);
					if(input == 1) {
						player.setCharacterHp(player.getCharacterMaxHp());
						clearConsole();
						printHeading("Vous avez bu la potion votre santé a été réstauré");
						toContinue();
					}
					
				}else {
					printHeading("Vous n'avez pas assez de potions ou votre vie est deja pleine");
					toContinue();
				}
				
			}else {
				clearConsole();
				if(act != 4) {
					//chance 45%
					if(Math.random()*10 + 1 <= 4.5) {
						printHeading("Vous vous êtes enfuis ");
						break;
					}else {
						printHeading("vous n'avez pas reussi à vous enfuir ");
						int damageTook = enemy.attack();
						System.out.println("Vous avez pris" + " " + damageTook + " " + "point de dégât ");
						toContinue();
						if(player.getCharacterHp() <= 0) {
							playerDied();
						}
					}
				}else {
					printHeading("Vous ne pouvez pas fuir ce combat");
					toContinue();
				}
			}
		}
	}
	
	public static void printMenu() {
		clearConsole();
		printHeading(places[place]);
		System.out.println("choisissez une action");
		printSeparator(20);
		System.out.println("(1) Continuer");
		System.out.println("(2) info personnage");
		System.out.println("(1) quitter le jeu");
	}
	
	public static void playerDied() {
		clearConsole();
		printHeading("Vous avez péri");
		printHeading("Vous avez gagné" + player.getCharacterXp() + "durant votre periple");
		System.out.println("merci d'avoir joué");
		isRunning = false;
	}
	//main loop
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input = readInt("-> ", 3);
			if(input == 1) {
				continueJourney();
			}else if(input == 2) {
				characterInfo();
			}else {
				isRunning = false;
			}
		}
	}

}
