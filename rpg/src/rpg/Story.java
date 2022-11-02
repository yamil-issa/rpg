package rpg;

public class Story {
	public static void printIntro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("HISTOIRE");
		GameLoop.printSeparator(30);
		System.out.println("Nous somme dans le royaume de sith, vous êtes le dernier survivant de l'attatque de votre village par une horde de creatures à la solde du nameless King. ");
		System.out.println("votre famille vos amis sont tous mort, mort vous l'etiez egalement mais une force obsucure vous a ramené dans le monde des vivant");
		System.out.println("Vous n'avez plus qu'un seul objectif defaire le nameless King et obtenir vore revanche ");
		GameLoop.toContinue();
	}
	
	public static void printFirstActIntro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE I - INTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("Vfsfjpgjehmrhmrmkmblabbla ");
		GameLoop.toContinue();
	}
	public static void printFirstActOutro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE I - OUTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("jsofpokfpkpkpzkpzkpzkpz");
		System.out.println("fkzpfkpzkgpzkgpkgkgpkp");
		GameLoop.toContinue();
	}
	public static void printSecondActIntro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE II - INTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("Vfsfjpgjehmrhmrmkmblabbla ");
		GameLoop.toContinue();
	}
	public static void printSecondActOutro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE II - OUTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("jsofpokfpkpkpzkpzkpzkpz");
		System.out.println("fkzpfkpzkgpzkgpkgkgpkp");
		GameLoop.toContinue();
	}
	public static void printThirdActIntro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE III - INTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("Vfsfjpgjehmrhmrmkmblabbla ");
		GameLoop.toContinue();
	}
	public static void printThirdActOutro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE III - OUTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("jsofpokfpkpkpzkpzkpzkpz");
		System.out.println("fkzpfkpzkgpzkgpkgkgpkp");
		GameLoop.toContinue();
	}
	public static void printFourthActIntro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE IV - INTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("Vfsfjpgjehmrhmrmkmblabbla ");
		GameLoop.toContinue();
	}
	public static void printFourthActOutro() {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("ACTE IV - OUTRO");
		GameLoop.printSeparator(30);
		System.out.println("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		System.out.println("jsofpokfpkpkpzkpzkpzkpz");
		System.out.println("fkzpfkpzkgpzkgpkgkgpkp");
		GameLoop.toContinue();
	}
	public static void printEnd(Player player) {
		GameLoop.clearConsole();
		GameLoop.printSeparator(30);
		System.out.println("Bravo," + player.getCharacterName() + "! Vous avez reussi à vaincre le nameless King, le mal ne rongera plus le royaume, vous pouvez desormais reposer en paix");
		GameLoop.printSeparator(30);
		System.out.println("Jeu developpé dans le cadre de la licence pro projet web et mobile");
		System.out.println("Merci d'avoir joué");
		GameLoop.toContinue();
	}
	

}
